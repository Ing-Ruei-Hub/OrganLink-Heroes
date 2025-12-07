
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.HospitalOfficerOrganization;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import javax.swing.JPanel;

/**
 *
 * @author rrheg
 */
public class HospitalOfficerRole extends Role {

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, Network network,EcoSystem business) {
        //return new HospitalOfficerWorkAreaJPanel(userProcessContainer, account, (HospitalOfficerOrganization)organization, enterprise);
        return new JPanel();
    }
    
}
