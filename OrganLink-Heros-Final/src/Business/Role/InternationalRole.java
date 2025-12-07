
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import javax.swing.JPanel;
import userinterface.InternationalRole.InternationalOfficerWorkAreaJPanel;

public class InternationalRole extends Role {
    
    
    public JPanel createWorkArea(JPanel userProcessContainer, 
                                 UserAccount account, 
                                 Organization organization, 
                                 Enterprise enterprise,
                                 Network network,
                                 EcoSystem business) {
        return new InternationalOfficerWorkAreaJPanel(
            userProcessContainer, account, organization, enterprise, network, business);
    }
    
    @Override
    public String toString() {
        return "International Officer";
    }
}