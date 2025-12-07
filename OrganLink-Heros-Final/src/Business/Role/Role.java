
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.Network; // Added import for Network
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import javax.swing.JPanel;

/**
 *
 * @author rrheg
 */
public abstract class Role {
    
    public enum RoleType{
        Admin("Admin"),
        Doctor("Doctor"),
        LabTechnician("Lab Technician"),
        HospitalOfficer("Hospital Officer"),
        CaseManager("Case Manager"),
        TransplantCoordinator("Transplant Coordinator"),
        Donor("Donor"),
        Recipient("Recipient"),
        Government("Government Officer"),
        Logistics("Logistics Officer"),
        International("International Affairs Officer");
        
        private String value;
        private RoleType(String value){
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return value;
        }
    }
    
    public abstract JPanel createWorkArea(JPanel userProcessContainer, 
            UserAccount account, 
            Organization organization, 
            Enterprise enterprise, 
            Network network, // Added Network parameter
            EcoSystem business);

    @Override
    public String toString() {
        return this.getClass().getName();
    }
    
}
