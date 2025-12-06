
package Business;

import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.Role.Role;
import Business.Role.SystemAdminRole;
import Business.UserAccount.UserAccount;
import java.util.ArrayList;

/**
 *
 * @author rrheg
 */
public class EcoSystem extends Organization{
    
    private static EcoSystem business;
    private ArrayList<Network> networkList;
    public static EcoSystem getInstance(){
        if(business==null){
            business=new EcoSystem();
        }
        return business;
    }
    
    public Network createAndAddNetwork(){
        Network network=new Network();
        networkList.add(network);
        return network;
    }
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roleList=new ArrayList<Role>();
        roleList.add(new SystemAdminRole());
        return roleList;
    }
    private EcoSystem(){
        super(null);
        networkList=new ArrayList<Network>();
    }

    public ArrayList<Network> getNetworkList() {
        return networkList;
    }

    public void setNetworkList(ArrayList<Network> networkList) {
        this.networkList = networkList;
    }
    
    public boolean checkIfUserIsUnique(String userName){
        if(!this.getUserAccountDirectory().checkIfUsernameIsUnique(userName)){
            return false;
        }
        for(Network network:networkList){
            for(Enterprise enterprise: network.getEnterpriseDirectory().getEnterpriseList()){
                for(UserAccount ua: enterprise.getUserAccountDirectory().getUserAccountList()){
                    if(ua.getUsername().equals(userName)){
                        return false;
                    }
                }
                for(Organization organization: enterprise.getOrganizationDirectory().getOrganizationList()){
                    for(UserAccount ua: organization.getUserAccountDirectory().getUserAccountList()){
                        if(ua.getUsername().equals(userName)){
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}
