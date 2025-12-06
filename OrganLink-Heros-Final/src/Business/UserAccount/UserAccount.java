
package Business.UserAccount;

import Business.Employee.Employee;
import Business.Role.Role;

/**
 *
 * @author rrheg
 */
public class UserAccount {
    
    private String username;
    private String password;
    private Employee employee;
    private Role role;

    public UserAccount() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
    
     @Override
    public String toString() {
        return username;
    }
    
}
