
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.LogisticsOrganization;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import javax.swing.JPanel;

/**
 *
 * @author rrheg
 */
public class LogisticsRole extends Role{

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business) {
        //return new LogisticsWorkAreaJPanel(userProcessContainer, account, (LogisticsOrganization)organization, enterprise);
        return new JPanel();
    }
    
}
