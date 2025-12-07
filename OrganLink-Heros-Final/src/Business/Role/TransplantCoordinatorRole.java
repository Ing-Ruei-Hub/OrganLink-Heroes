
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.Network; // Import Network
import Business.Organization.Organization;
import Business.Organization.TransplantCoordinatorOrganization;
import Business.UserAccount.UserAccount;
import javax.swing.JPanel;
import userinterface.TransplantCoordinatorWorkArea.TransplantCoordinatorWorkAreaJPanel; // Import the correct JPanel

/**
 *
 * @author rrheg
 */
public class TransplantCoordinatorRole extends Role{

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, Network network, EcoSystem business) {
        return new TransplantCoordinatorWorkAreaJPanel(userProcessContainer, account, organization, enterprise, network, business);
    }
    
}
