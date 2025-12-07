
package Business.Organization;

import Business.Logistics.LogisticsTeamDirectory;
import Business.Logistics.TransportVehicleDirectory;
import Business.Role.LogisticsRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author eric
 */
public class LogisticsOrganization extends Organization {
    
    // add TransportVehicleDirectory and LogisticsTeamDirectory
    private TransportVehicleDirectory vehicleDirectory;
    private LogisticsTeamDirectory teamDirectory;
    
    public LogisticsOrganization() {
        super(Type.Logistics.getValue());
        vehicleDirectory = new TransportVehicleDirectory();
        teamDirectory = new LogisticsTeamDirectory();
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new LogisticsRole());
        return roles;
    }
    
    // Getter for vehicle directory
    public TransportVehicleDirectory getVehicleDirectory() {
        return vehicleDirectory;
    }
    
    // Getter for team directory
    public LogisticsTeamDirectory getTeamDirectory() {
        return teamDirectory;
    }
}
