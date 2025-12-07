
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.DoctorOrganization;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import javax.swing.JPanel;
import userinterface.DoctorRole.DoctorWorkAreaJPanel;


/**
 *
 * @author rrheg
 */
public class DoctorRole extends Role{

     @Override
    public JPanel createWorkArea(JPanel userProcessContainer, 
                                 UserAccount account, 
                                 Organization organization, 
                                 Enterprise enterprise, 
                                 EcoSystem business) {
        return new DoctorWorkAreaJPanel(
            userProcessContainer, account, organization, enterprise, business, null);
    }
    
    @Override
    public String toString() {
        return "Doctor";
    }
    
}
