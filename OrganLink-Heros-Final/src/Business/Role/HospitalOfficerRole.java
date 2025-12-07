
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.HospitalOfficerOrganization;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import javax.swing.JPanel;
import userinterface.DonorRole.DonorWorkAreaJPanel;
import userinterface.HospitalRole.HospitalRoleWorkAreaJPanel;

/**
 *
 * @author rrheg
 */
public class HospitalOfficerRole extends Role {

    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, Network network, EcoSystem business) {
        return new HospitalRoleWorkAreaJPanel(userProcessContainer, account, organization, enterprise);
    }
    
    @Override
    public String toString() {
        return "Donor";
    }
    
}
