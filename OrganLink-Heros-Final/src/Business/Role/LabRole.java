
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.LabOrganization;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import javax.swing.JPanel;
import userinterface.LabRoleWorkArea.LabTechnicianWorkAreaJPanel; // Added import

/**
 *
 * @author rrheg
 */
public class LabRole extends Role{

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, Network network, EcoSystem business) {
        return new LabTechnicianWorkAreaJPanel(userProcessContainer, account, organization, enterprise, network, business);
    }
    
}
