
package Business.DB4OUtil;

import Business.ConfigureASystem;
import Business.Donor.Donor;
import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.DonorOrganization;
import Business.Organization.Organization;
import Business.Organization.RecipientOrganization;
import Business.Recipient.Recipient;
import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.config.EmbeddedConfiguration;
import com.db4o.ta.TransparentPersistenceSupport;
import java.nio.file.Paths;

/**
 *
 * @author rrheg
 */
public class DB4OUtil {

    private static final String FILENAME = Paths.get("Databank.db4o").toAbsolutePath().toString();// path to the data store
    private static DB4OUtil dB4OUtil;
    
    public synchronized static DB4OUtil getInstance(){
        if (dB4OUtil == null){
            dB4OUtil = new DB4OUtil();
        }
        return dB4OUtil;
    }

    protected synchronized static void shutdown(ObjectContainer conn) {
        if (conn != null) {
            conn.close();
        }
    }

    private ObjectContainer createConnection() {
        try {

            EmbeddedConfiguration config = Db4oEmbedded.newConfiguration();
            config.common().add(new TransparentPersistenceSupport());
            //Controls the number of objects in memory
            config.common().activationDepth(Integer.MAX_VALUE);
            //Controls the depth of objects when storing
            config.common().updateDepth(Integer.MAX_VALUE);

            //Register your top most Class here
            config.common().objectClass(EcoSystem.class).cascadeOnUpdate(true); // Change to the object you want to save

            ObjectContainer db = Db4oEmbedded.openFile(config, FILENAME);
            return db;
        } catch (Exception ex) {
            throw new RuntimeException("Failed to create DB4O connection", ex);
        }

    }

    public synchronized void storeSystem(EcoSystem system) {
        ObjectContainer conn = createConnection();
        conn.store(system);
        conn.commit();
        conn.close();
    }
    
    public EcoSystem retrieveSystem(){
        ObjectContainer conn = createConnection();
        ObjectSet<EcoSystem> systems = conn.query(EcoSystem.class); // Change to the object you want to save
        EcoSystem system;
        if (systems.size() == 0){
            system = ConfigureASystem.configure();  // If there's no system in the record, create a new one
        }
        else{
            system = systems.get(systems.size() - 1);
        }
        conn.close();
        
        // ========== SYNC ALL COUNTERS ==========
        syncAllCounters(system);
        
        return system;
    }

    /**
     * Synchronize all static counters after loading from database.
     * This ensures new IDs don't conflict with existing ones.
     */
    private void syncAllCounters(EcoSystem system) {
        for (Network network : system.getNetworkList()) {
            for (Enterprise enterprise : network.getEnterpriseDirectory().getEnterpriseList()) {
                for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
                    
                    // Sync Recipient counter
                    if (organization instanceof RecipientOrganization) {
                        RecipientOrganization recOrg = (RecipientOrganization) organization;
                        for (Recipient recipient : recOrg.getRecipientDirectory().getRecipientList()) {
                            Recipient.syncCounter(recipient.getRecipientId());
                        }
                    }
                    
                    // Sync Donor counter
                    if (organization instanceof DonorOrganization) {
                        DonorOrganization donorOrg = (DonorOrganization) organization;
                        for (Donor donor : donorOrg.getDonorDirectory().getDonorList()) {
                            Donor.syncCounter(donor.getDonorId());
                        }
                    }
                }
            }
        }
        
        System.out.println("DEBUG: Counters synced. Recipient counter = " + Recipient.getCounter() + ", Donor counter = " + Donor.getCounter());
    }
    
    
    public void deleteDatabaseFile() {
        try {
            java.nio.file.Files.deleteIfExists(java.nio.file.Paths.get(FILENAME));
            System.out.println("DEBUG: Databank.db4o file deleted successfully.");
        } catch (java.io.IOException e) {
            System.err.println("ERROR: Could not delete Databank.db4o file: " + e.getMessage());
        }
    }
}
