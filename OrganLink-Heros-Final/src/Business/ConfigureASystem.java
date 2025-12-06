
package Business;

import Business.Employee.Employee;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.AdminOrganization;
import Business.Organization.CaseManagerOrganization;
import Business.Organization.DoctorOrganization;
import Business.Organization.DonorOrganization;
import Business.Organization.GovernmentOrganization;
import Business.Organization.HospitalOfficerOrganization;
import Business.Organization.InternationalOrganization;
import Business.Organization.LabOrganization;
import Business.Organization.LogisticsOrganization;
import Business.Organization.Organization;
import Business.Organization.RecipientOrganization;
import Business.Organization.TransplantCoordinatorOrganization;
import Business.Role.AdminRole;
import Business.Role.CaseManagerRole;
import Business.Role.DoctorRole;
import Business.Role.DonorRole;
import Business.Role.GovernmentRole;
import Business.Role.HospitalOfficerRole;
import Business.Role.InternationalRole;
import Business.Role.LabRole;
import Business.Role.LogisticsRole;
import Business.Role.RecipientRole;
import Business.Role.SystemAdminRole;
import Business.Role.TransplantCoordinatorRole;
import Business.UserAccount.UserAccount;
import com.github.javafaker.Faker;

public class ConfigureASystem {
    
    public static EcoSystem configure(){
        
        EcoSystem system = EcoSystem.getInstance();
        Faker faker = new Faker();
        
        // Create a default system admin
        Employee employee = system.getEmployeeDirectory().createEmployee("sysadmin");
        system.getUserAccountDirectory().createUserAccount("sysadmin", "sysadmin", employee, new SystemAdminRole());
        
        // Create 2 Networks
        for (int i = 0; i < 1; i++) {
            Network network = system.createAndAddNetwork();
            network.setName(faker.address().city());

            // Create 4 Enterprises per Network
            for (int j = 0; j < 4; j++) {
                Enterprise enterprise;
                Enterprise.EnterpriseType enterpriseType;
                
                if (j == 0) {
                    enterpriseType = Enterprise.EnterpriseType.Hospital;
                } else if (j == 1) {
                    enterpriseType = Enterprise.EnterpriseType.Government;
                } else if (j == 2) {
                    enterpriseType = Enterprise.EnterpriseType.Logistics;
                } else {
                    enterpriseType = Enterprise.EnterpriseType.International;
                }
                
                enterprise = network.getEnterpriseDirectory().createAndAddEnterprise(enterpriseType.getValue(), enterpriseType);

                // Create 2-3 Organizations per Enterprise
                for (int k = 0; k < (enterpriseType == Enterprise.EnterpriseType.Hospital ? 4 : 3); k++) { // 2 for even, 3 for odd enterprise index
                    Organization organization;
                    Organization.Type organizationType;

                    if (k == 0) {
                        organizationType = Organization.Type.Admin;
                        organization = enterprise.getOrganizationDirectory().createOrganization(organizationType);
                        employee = organization.getEmployeeDirectory().createEmployee(faker.name().fullName());
                        organization.getUserAccountDirectory().createUserAccount(faker.name().username(), "admin", employee, new AdminRole());

                    } else if (enterpriseType == Enterprise.EnterpriseType.Hospital) {
                        if (k == 1) {
                            organizationType = Organization.Type.Doctor;
                            organization = enterprise.getOrganizationDirectory().createOrganization(organizationType);
                            employee = organization.getEmployeeDirectory().createEmployee(faker.name().fullName());
                            organization.getUserAccountDirectory().createUserAccount(faker.name().username(), "doctor", employee, new DoctorRole());
                        } else if (k == 2) { // Add Recipient here
                            organizationType = Organization.Type.Recipient;
                            organization = enterprise.getOrganizationDirectory().createOrganization(organizationType);
                            employee = organization.getEmployeeDirectory().createEmployee(faker.name().fullName());
                            organization.getUserAccountDirectory().createUserAccount(faker.name().username(), "recipient", employee, new RecipientRole());
                        } else if (k == 3) { // New condition for Donor
                            organizationType = Organization.Type.Donor;
                            organization = enterprise.getOrganizationDirectory().createOrganization(organizationType);
                            employee = organization.getEmployeeDirectory().createEmployee(faker.name().fullName());
                            organization.getUserAccountDirectory().createUserAccount(faker.name().username(), "donor", employee, new DonorRole());
                        }
                    } else if (enterpriseType == Enterprise.EnterpriseType.Government) {
                        if (k == 1) {
                            organizationType = Organization.Type.Government;
                            organization = enterprise.getOrganizationDirectory().createOrganization(organizationType);
                            employee = organization.getEmployeeDirectory().createEmployee(faker.name().fullName());
                            organization.getUserAccountDirectory().createUserAccount(faker.name().username(), "gov", employee, new GovernmentRole());
                        }
                    } else if (enterpriseType == Enterprise.EnterpriseType.Logistics) {
                        if (k == 1) {
                            organizationType = Organization.Type.Logistics;
                            organization = enterprise.getOrganizationDirectory().createOrganization(organizationType);
                            employee = organization.getEmployeeDirectory().createEmployee(faker.name().fullName());
                            organization.getUserAccountDirectory().createUserAccount(faker.name().username(), "logistics", employee, new LogisticsRole());
                        } else {
                            organizationType = Organization.Type.CaseManager;
                            organization = enterprise.getOrganizationDirectory().createOrganization(organizationType);
                            employee = organization.getEmployeeDirectory().createEmployee(faker.name().fullName());
                            organization.getUserAccountDirectory().createUserAccount(faker.name().username(), "case", employee, new CaseManagerRole());
                        }
                    } else if (enterpriseType == Enterprise.EnterpriseType.International) {
                        if (k == 1) {
                            organizationType = Organization.Type.International;
                            organization = enterprise.getOrganizationDirectory().createOrganization(organizationType);
                            employee = organization.getEmployeeDirectory().createEmployee(faker.name().fullName());
                            organization.getUserAccountDirectory().createUserAccount(faker.name().username(), "inter", employee, new InternationalRole());
                        } else {
                            organizationType = Organization.Type.TransplantCoordinator;
                            organization = enterprise.getOrganizationDirectory().createOrganization(organizationType);
                            employee = organization.getEmployeeDirectory().createEmployee(faker.name().fullName());
                            organization.getUserAccountDirectory().createUserAccount(faker.name().username(), "transplant", employee, new TransplantCoordinatorRole());
                        }
                    }
                }
            }
        }
        
        return system;
    }
}

