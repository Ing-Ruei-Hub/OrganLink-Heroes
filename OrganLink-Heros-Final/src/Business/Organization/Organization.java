
package Business.Organization;

import Business.WorkQueue.WorkQueue;
import Business.Employee.EmployeeDirectory;
import Business.Role.Role;
import Business.UserAccount.UserAccountDirectory;
import java.util.ArrayList;

/**
 *
 * @author rrheg
 */
public abstract class Organization {
     private String name;
    private UserAccountDirectory userAccountDirectory;
    private EmployeeDirectory employeeDirectory;
    private WorkQueue workQueue;
    private int organizationID;
    private static int counter=0;
    
    public enum Type{
        Admin("Admin Organization"),
        Doctor("Doctor Organization"),
        Lab("Lab Organization"),
        HospitalOfficer("Hospital Officer Organization"),
        CaseManager("Case Manager Organization"),
        TransplantCoordinator("Transplant Coordinator Organization"),
        Donor("Donor Organization"),
        Recipient("Recipient Organization"),
        Government("Government Organization"),
        Logistics("Logistics Organization"),
        International("International Affairs Organization");
        
        private String value;
        private Type(String value) {
            this.value = value;
        }
        public String getValue() {
            return value;
        }
    }
    
    public Organization(String name){
        this.name = name;
        userAccountDirectory = new UserAccountDirectory();
        employeeDirectory = new EmployeeDirectory();
        workQueue = new WorkQueue();
        organizationID = counter;
        ++counter;
    }
    
    public abstract ArrayList<Role> getSupportedRole();

    public WorkQueue getWorkQueue() {
        return workQueue;
    }

    public UserAccountDirectory getUserAccountDirectory() {
        return userAccountDirectory;
    }

    public int getOrganizationID() {
        return organizationID;
    }

    public EmployeeDirectory getEmployeeDirectory() {
        return employeeDirectory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    @Override
    public String toString() {
        return name;
    }
    
}
