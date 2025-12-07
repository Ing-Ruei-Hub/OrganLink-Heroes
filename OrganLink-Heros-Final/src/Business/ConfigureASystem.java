
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
import Business.Recipient.Recipient;
import Business.Recipient.RecipientDirectory;
import Business.Donor.Donor;
import Business.Donor.DonorDirectory;
import Business.Medical.MedicalTestResult;
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
                for (int k = 0; k < (enterpriseType == Enterprise.EnterpriseType.Hospital ? 5 : 3); k++) { // 2 for even, 3 for odd enterprise index
                    Organization organization;
                    Organization.Type organizationType;

                    if (k == 0) {
                        organizationType = Organization.Type.Admin;
                        organization = enterprise.getOrganizationDirectory().createOrganization(organizationType);
                        employee = organization.getEmployeeDirectory().createEmployee(faker.name().fullName());
                        organization.getUserAccountDirectory().createUserAccount("admin", "admin", employee, new AdminRole());

                    } else if (enterpriseType == Enterprise.EnterpriseType.Hospital) {
                        if (k == 1) {
                            organizationType = Organization.Type.Doctor;
                            organization = enterprise.getOrganizationDirectory().createOrganization(organizationType);
                            employee = organization.getEmployeeDirectory().createEmployee(faker.name().fullName());
                            organization.getUserAccountDirectory().createUserAccount("doctor", "doctor", employee, new DoctorRole());
                        } else if (k == 2) { // Add Recipient here
                            organizationType = Organization.Type.Recipient;
                            RecipientOrganization recipientOrganization = (RecipientOrganization)enterprise.getOrganizationDirectory().createOrganization(organizationType);
                            employee = recipientOrganization.getEmployeeDirectory().createEmployee(faker.name().fullName());
                            recipientOrganization.getUserAccountDirectory().createUserAccount("recipient", "recipient", employee, new RecipientRole());

                            // Generate and add some recipients
                            for (int r = 0; r < 3; r++) { // Create 3 recipients
                                Recipient recipient = new Recipient(faker.name().fullName());
                                recipient.setBloodType(faker.options().option("A+"));
                                recipient.setOrganNeeded(faker.options().option("Kidney"));
                                recipient.setDateOfBirth(faker.date().birthday());
                                recipient.setContactNumber(faker.phoneNumber().phoneNumber());
                                recipient.setEmail(faker.internet().emailAddress());
                                recipient.setMedicalHistory(faker.lorem().sentence());
                                recipient.setStatus("Registered"); // Set initial status
                                recipient.setUrgencyLevel(faker.options().option("High", "Medium", "Low"));
                                recipientOrganization.getRecipientDirectory().addRecipient(recipient);
                            }
                        } else if (k == 3) { // New condition for Donor
                            organizationType = Organization.Type.Donor;
                            DonorOrganization donorOrganization = (DonorOrganization)enterprise.getOrganizationDirectory().createOrganization(organizationType);
                            employee = donorOrganization.getEmployeeDirectory().createEmployee(faker.name().fullName());
                            donorOrganization.getUserAccountDirectory().createUserAccount("donor", "donor", employee, new DonorRole());
                            System.out.print('a');
                            // Generate and add some donors
                            for (int d = 0; d < 3; d++) { // Create 3 donors
                                Donor donor = new Donor(faker.name().fullName());
                                donor.setBloodType(faker.options().option("A+"));
                                donor.setOrganToDonate(faker.options().option("Kidney"));
                                donor.setDateOfBirth(faker.date().birthday());
                                donor.setContactNumber(faker.phoneNumber().phoneNumber());
                                donor.setEmail(faker.internet().emailAddress());
                                donor.setMedicalHistory(faker.lorem().sentence());
                                donor.setStatus("Tests Verified"); // Set initial status
                                donorOrganization.getDonorDirectory().addDonor(donor);
                            }
                        } else if (k == 4) { // New condition for Lab
                            organizationType = Organization.Type.Lab;
                            organization = enterprise.getOrganizationDirectory().createOrganization(organizationType);
                            employee = organization.getEmployeeDirectory().createEmployee(faker.name().fullName());
                            organization.getUserAccountDirectory().createUserAccount("lab", "lab", employee, new LabRole());
                            
                            // Generate some sample medical test results
                            // For simplicity, associating with the last created donor/recipient, if any
                            if (system.getNetworkList().get(0).getEnterpriseDirectory().getEnterpriseList().get(0).getOrganizationDirectory().getOrganizationList().size() > 2) {
                                RecipientOrganization recOrg = (RecipientOrganization) system.getNetworkList().get(0).getEnterpriseDirectory().getEnterpriseList().get(0).getOrganizationDirectory().getOrganizationList().get(2);
                                if (!recOrg.getRecipientDirectory().getRecipientList().isEmpty()) {
                                    Recipient sampleRecipient = recOrg.getRecipientDirectory().getRecipientList().get(0); // Get first recipient
                                    MedicalTestResult result1 = new MedicalTestResult("Blood Test", null, sampleRecipient);
                                    result1.setResultDetails("Recipient blood type: A+");
                                    result1.setIsVerified(true);
                                    sampleRecipient.getMedicalTestResultList().add(result1);
                                }
                            }
                            if (system.getNetworkList().get(0).getEnterpriseDirectory().getEnterpriseList().get(0).getOrganizationDirectory().getOrganizationList().size() > 3) {
                                DonorOrganization donOrg = (DonorOrganization) system.getNetworkList().get(0).getEnterpriseDirectory().getEnterpriseList().get(0).getOrganizationDirectory().getOrganizationList().get(3);
                                if (!donOrg.getDonorDirectory().getDonorList().isEmpty()) {
                                    Donor sampleDonor = donOrg.getDonorDirectory().getDonorList().get(0); // Get first donor
                                    MedicalTestResult result2 = new MedicalTestResult("Tissue Typing", sampleDonor, null);
                                    result2.setResultDetails("Donor tissue match: 6/6 HLA");
                                    result2.setIsVerified(true);
                                    sampleDonor.getMedicalTestResultList().add(result2);
                                }
                            }
                        }
                    } else if (enterpriseType == Enterprise.EnterpriseType.Government) {
                        if (k == 1) {
                            organizationType = Organization.Type.Government;
                            organization = enterprise.getOrganizationDirectory().createOrganization(organizationType);
                            employee = organization.getEmployeeDirectory().createEmployee(faker.name().fullName());
                            organization.getUserAccountDirectory().createUserAccount("gov", "gov", employee, new GovernmentRole());
                        }
                    } else if (enterpriseType == Enterprise.EnterpriseType.Logistics) {
                        if (k == 1) {
                            organizationType = Organization.Type.Logistics;
                            organization = enterprise.getOrganizationDirectory().createOrganization(organizationType);
                            employee = organization.getEmployeeDirectory().createEmployee(faker.name().fullName());
                            organization.getUserAccountDirectory().createUserAccount("logistics", "logistics", employee, new LogisticsRole());
                            
                            // ========== INITIALIZE LOGISTICS RESOURCES ==========
                            LogisticsOrganization logOrg = (LogisticsOrganization) organization;
        
                            // Create test transport vehicles
                            logOrg.getVehicleDirectory().createVehicle("Mercedes Sprinter", "ABC-1234");
                            logOrg.getVehicleDirectory().createVehicle("Ford Transit", "XYZ-5678");
                            logOrg.getVehicleDirectory().createVehicle("Helicopter H145", "HELI-001");
                            logOrg.getVehicleDirectory().createVehicle("Toyota HiAce", "DEF-9012");
        
                            // Create test logistics teams
                            logOrg.getTeamDirectory().createTeam("Alpha Team");
                            logOrg.getTeamDirectory().createTeam("Beta Team");
                            logOrg.getTeamDirectory().createTeam("Emergency Response");
                            logOrg.getTeamDirectory().createTeam("Night Shift Team");
                            
                        } else {
                            organizationType = Organization.Type.CaseManager;
                            organization = enterprise.getOrganizationDirectory().createOrganization(organizationType);
                            employee = organization.getEmployeeDirectory().createEmployee(faker.name().fullName());
                            organization.getUserAccountDirectory().createUserAccount("case", "case", employee, new CaseManagerRole());
                        }
                    } else if (enterpriseType == Enterprise.EnterpriseType.International) {
                        if (k == 1) {
                            organizationType = Organization.Type.International;
                            organization = enterprise.getOrganizationDirectory().createOrganization(organizationType);
                            employee = organization.getEmployeeDirectory().createEmployee(faker.name().fullName());
                            organization.getUserAccountDirectory().createUserAccount("inter", "inter", employee, new InternationalRole());
                        } else {
                            organizationType = Organization.Type.TransplantCoordinator;
                            organization = enterprise.getOrganizationDirectory().createOrganization(organizationType);
                            employee = organization.getEmployeeDirectory().createEmployee(faker.name().fullName());
                            organization.getUserAccountDirectory().createUserAccount("transplant", "transplant", employee, new TransplantCoordinatorRole());
                        }
                    }
                }
            }
        }
        
        return system;
    }
}

