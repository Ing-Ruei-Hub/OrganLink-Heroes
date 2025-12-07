
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.LogisticsOrganization;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import javax.swing.JPanel;
import userinterface.LogisticsOfficerWorkArea.LogisticsOfficerWorkAreaJPanel;

/**
 *
 * @author eric
 */
public class LogisticsRole extends Role{

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, 
            Organization organization, Enterprise enterprise,Network network, EcoSystem business) {
        return new LogisticsOfficerWorkAreaJPanel(userProcessContainer, account, 
                (LogisticsOrganization) organization, enterprise, business);
    }
    
    @Override
    public String toString() {
        return RoleType.Logistics.getValue();
    }
}
