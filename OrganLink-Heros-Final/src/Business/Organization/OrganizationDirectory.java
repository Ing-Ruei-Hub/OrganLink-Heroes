
package Business.Organization;

import Business.Organization.Organization.Type;
import java.util.ArrayList;

/**
 *
 * @author rrheg
 */
public class OrganizationDirectory {
    
    private ArrayList<Organization> organizationList;

    public OrganizationDirectory() {
        organizationList = new ArrayList<>();
    }

    public ArrayList<Organization> getOrganizationList() {
        return organizationList;
    }
    
    public Organization createOrganization(Type type){
        Organization organization = null;
        if (type.getValue().equals(Type.Doctor.getValue())){
            organization = new DoctorOrganization();
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Type.Lab.getValue())){
            organization = new LabOrganization();
            organizationList.add(organization);
        }
         else if (type.getValue().equals(Type.Donor.getValue())){
            organization = new DonorOrganization();
            organizationList.add(organization);
        }
         else if (type.getValue().equals(Type.Recipient.getValue())){
            organization = new RecipientOrganization();
            organizationList.add(organization);
        }
         else if (type.getValue().equals(Type.HospitalOfficer.getValue())){
            organization = new HospitalOfficerOrganization();
            organizationList.add(organization);
        }
          else if (type.getValue().equals(Type.CaseManager.getValue())){
            organization = new CaseManagerOrganization();
            organizationList.add(organization);
        }
          else if (type.getValue().equals(Type.TransplantCoordinator.getValue())){
            organization = new TransplantCoordinatorOrganization();
            organizationList.add(organization);
        }
         else if (type.getValue().equals(Type.Government.getValue())){
            organization = new GovernmentOrganization();
            organizationList.add(organization);
        }
           else if (type.getValue().equals(Type.Logistics.getValue())){
            organization = new LogisticsOrganization();
            organizationList.add(organization);
        }
           else if (type.getValue().equals(Type.International.getValue())){
            organization = new InternationalOrganization();
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Type.Admin.getValue())){
            organization = new AdminOrganization();
            organizationList.add(organization);
        }
        return organization;
    }
    
    public void deleteOrganization(Organization org){
        organizationList.remove(org);
    }
    
}
