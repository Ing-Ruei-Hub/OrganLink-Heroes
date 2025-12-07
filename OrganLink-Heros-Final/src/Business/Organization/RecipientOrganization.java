
package Business.Organization;

import Business.Role.RecipientRole;
import Business.Role.Role;
import java.util.ArrayList;
import Business.Recipient.RecipientDirectory; // Import the new RecipientDirectory class

/**
 *
 * @author rrheg
 */
public class RecipientOrganization extends Organization{
    
    private RecipientDirectory recipientDirectory; // Declare RecipientDirectory
    
    public RecipientOrganization() {
        super(Type.Recipient.getValue());
        recipientDirectory = new RecipientDirectory(); // Initialize in constructor
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new RecipientRole());
        return roles;
    }
    
    // Getter for RecipientDirectory
    public RecipientDirectory getRecipientDirectory() {
        if(recipientDirectory == null){ // Defensive check for deserialization of old objects
            recipientDirectory = new RecipientDirectory();
        }
        return recipientDirectory;
    }
    
}
