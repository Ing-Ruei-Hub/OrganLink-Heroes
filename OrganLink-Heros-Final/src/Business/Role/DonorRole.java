
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.Network; // Added import for Network
import Business.Organization.DonorOrganization;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import javax.swing.JPanel;
import userinterface.DonorRole.DonorWorkAreaJPanel;

/**
 *
 * @author rrheg
 */
public class DonorRole extends Role{

    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, Network network, EcoSystem business) {
        return new DonorWorkAreaJPanel(userProcessContainer, account, (DonorOrganization) organization, enterprise);
    }
    
    @Override
    public String toString() {
        return "Donor";
    }
}
