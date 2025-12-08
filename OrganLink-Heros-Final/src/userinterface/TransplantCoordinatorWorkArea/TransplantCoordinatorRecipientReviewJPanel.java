package userinterface.TransplantCoordinatorWorkArea;

import Business.Donor.Donor;
import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.Recipient.Recipient;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.MedicalTestWorkRequest;
import Business.Organization.LabOrganization;
import Business.Organization.InternationalOrganization;
import Business.Organization.DoctorOrganization;
import Business.WorkQueue.InternationalCollaborationRequest;
import Business.Util.MatchingService;
import java.awt.CardLayout;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class TransplantCoordinatorRecipientReviewJPanel extends JPanel {

    private JPanel userProcessContainer;
    private UserAccount userAccount;
    private Organization organization;
    private Enterprise enterprise;
    private EcoSystem system;
    private Network network;

    /**
     * Creates new form TransplantCoordinatorRecipientReviewJPanel
     */
    public TransplantCoordinatorRecipientReviewJPanel(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, Network network, EcoSystem system) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.userAccount = account;
        this.organization = organization;
        this.enterprise = enterprise;
        this.network = network;
        this.system = system;
        
        populateRecipientTable();
        checkButtonStates(); // Initial call

        recipientJTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    checkButtonStates();
                }
            }
        });

        compatibleDonorsJTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    checkButtonStates();
                }
            }
        });
    }

    private void checkButtonStates() {
        int selectedRecipientRow = recipientJTable.getSelectedRow();
        int selectedDonorRow = compatibleDonorsJTable.getSelectedRow();

        boolean recipientIsInProgress = false;
        Recipient selectedRecipient = null;

        if (selectedRecipientRow >= 0) {
            selectedRecipient = (Recipient) recipientJTable.getValueAt(selectedRecipientRow, 0);
            String status = selectedRecipient.getStatus();
            if (status.equalsIgnoreCase("Pending Match Doctor Verification") ||
                status.equalsIgnoreCase("Retest Required by Doctor - Match") ||
                status.equalsIgnoreCase("Verified, Ready for Transport Coordination") ||
                status.equalsIgnoreCase("Organ Transport Requested") ||
                status.equalsIgnoreCase("Pending International Search") ||
                status.equalsIgnoreCase("International Match Found") ||
                status.equalsIgnoreCase("No International Match Found")
            ) {
                recipientIsInProgress = true;
            }
        }

        // Handle btnFindMatches
        if (selectedRecipientRow >= 0 && !recipientIsInProgress) {
            btnFindMatches.setEnabled(true);
        } else {
            btnFindMatches.setEnabled(false);
        }

        // Handle btnRequestInternationalSearch button
        if (selectedRecipientRow >= 0 && !recipientIsInProgress && selectedRecipient.getStatus().equalsIgnoreCase("No Matches Found")) {
            btnRequestInternationalSearch.setEnabled(true);
        } else {
            btnRequestInternationalSearch.setEnabled(false);
        }

        // Handle btnSendMatchForDoctorVerification button
        if (selectedRecipientRow >= 0 && selectedDonorRow >= 0 && !recipientIsInProgress) {
            Donor selectedDonor = (Donor) compatibleDonorsJTable.getValueAt(selectedDonorRow, 0);

            boolean isCompatible = false;
            if (selectedDonor.getOrganToDonate() != null && selectedDonor.getOrganToDonate().equalsIgnoreCase(selectedRecipient.getOrganNeeded())) {
                if (selectedDonor.getBloodType() != null && selectedDonor.getBloodType().equalsIgnoreCase(selectedRecipient.getBloodType())) {
                    isCompatible = true;
                }
            }

            if (selectedDonor.getStatus().equalsIgnoreCase("Tests Verified") && isCompatible) {
                btnSendMatchForDoctorVerification.setEnabled(true);
            } else {
                btnSendMatchForDoctorVerification.setEnabled(false);
            }
        } else {
            btnSendMatchForDoctorVerification.setEnabled(false);
        }
    }

    private void populateRecipientTable() {
        DefaultTableModel model = (DefaultTableModel) recipientJTable.getModel();
        model.setRowCount(0);

        int recipientCount = 0;
        // Assuming organization is TransplantCoordinatorOrganization,
        // it needs to access RecipientOrganization's RecipientDirectory
        // This is a placeholder logic. Real implementation might involve traversing EcoSystem or a shared RecipientDirectory
        // For simplicity, let's assume we can get recipients from the system level or a specific RecipientOrganization
        
        // This part needs refinement based on how Recipients are truly managed and made accessible to TC
        // Currently, it iterates through all networks/enterprises to find RecipientOrganizations and their recipients
        for (Network net : system.getNetworkList()) {
            for (Enterprise ent : net.getEnterpriseDirectory().getEnterpriseList()) {
                for (Organization org : ent.getOrganizationDirectory().getOrganizationList()) {
                    if (org instanceof Business.Organization.RecipientOrganization) {
                        Business.Organization.RecipientOrganization recipientOrg = (Business.Organization.RecipientOrganization) org;
                        for (Recipient recipient : recipientOrg.getRecipientDirectory().getRecipientList()) {
                            // Only show recipients that are available for matching or international search
                            if (!recipient.getStatus().equalsIgnoreCase("Pending Match Doctor Verification") &&
                                !recipient.getStatus().equalsIgnoreCase("Retest Required by Doctor - Match") &&
                                !recipient.getStatus().equalsIgnoreCase("Verified, Ready for Transport Coordination") &&
                                !recipient.getStatus().equalsIgnoreCase("Organ Transport Requested") &&
                                !recipient.getStatus().equalsIgnoreCase("Pending International Search")) {
                                Object[] row = new Object[5];
                                row[0] = recipient; // toString of Recipient should return name
                                row[1] = recipient.getOrganNeeded();
                                row[2] = recipient.getBloodType();
                                row[3] = recipient.getUrgencyLevel();
                                row[4] = recipient.getStatus();
                                model.addRow(row);
                                recipientCount++;
                            }
                        }
                    }
                }
            }
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        recipientJTable = new javax.swing.JTable();
        btnFindMatches = new javax.swing.JButton();
        btnSendMatchForDoctorVerification = new javax.swing.JButton();
        btnRequestInternationalSearch = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        compatibleDonorsJTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblCompatibleDonors = new javax.swing.JLabel();

        recipientJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Recipient Name", "Organ Needed", "Blood Type", "Urgency", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(recipientJTable);

        btnFindMatches.setText("Find Initial Matches");
        btnFindMatches.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFindMatchesActionPerformed(evt);
            }
        });

        btnBack.setText("<< Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        btnSendMatchForDoctorVerification.setText("Send Match for Doctor Verification");
        btnSendMatchForDoctorVerification.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSendMatchForDoctorVerificationActionPerformed(evt);
            }
        });
        btnSendMatchForDoctorVerification.setEnabled(false); // Initially disabled

        btnRequestInternationalSearch.setText("Request International Search");
        btnRequestInternationalSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRequestInternationalSearchActionPerformed(evt);
            }
        });

        compatibleDonorsJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Donor Name", "Organ To Donate", "Blood Type", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(compatibleDonorsJTable);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Manage Recipient Requests & Matches");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Recipient List:");

        lblCompatibleDonors.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblCompatibleDonors.setText("Compatible Donors:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(btnBack))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(103, 103, 103)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblCompatibleDonors)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(150, 150, 150)
                                            .addComponent(btnFindMatches, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(btnSendMatchForDoctorVerification, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(btnRequestInternationalSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))                            .addComponent(jScrollPane2))))
                .addContainerGap(114, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(btnBack)
                .addGap(25, 25, 25)
                .addComponent(jLabel1)
                .addGap(30, 30, 30)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnFindMatches)
                    .addComponent(btnSendMatchForDoctorVerification)
                    .addComponent(btnRequestInternationalSearch))
                .addGap(28, 28, 28)
                .addComponent(lblCompatibleDonors)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(81, Short.MAX_VALUE))
        );
    }// </editor-fold>                        

    private void btnFindMatchesActionPerformed(java.awt.event.ActionEvent evt) {                                               
        int selectedRow = recipientJTable.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(this, "Please select a Recipient from the table.", "Selection Error", JOptionPane.WARNING_MESSAGE);
            return;
        }

        Recipient selectedRecipient = (Recipient) recipientJTable.getValueAt(selectedRow, 0);

        MatchingService matchingService = new MatchingService();
        List<Donor> compatibleDonors = matchingService.findCompatibleDonors(system, selectedRecipient);
        
        populateCompatibleDonorsTable(compatibleDonors);
        
        if (compatibleDonors.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No compatible donors found for " + selectedRecipient.getName() + ".", "No Matches", JOptionPane.INFORMATION_MESSAGE);
            selectedRecipient.setStatus("No Matches Found");
        } else {
            JOptionPane.showMessageDialog(this, compatibleDonors.size() + " compatible donor(s) found for " + selectedRecipient.getName() + ".", "Matches Found", JOptionPane.INFORMATION_MESSAGE);
            selectedRecipient.setStatus("Matches Found"); // Or "Matches Found"
        }
        
        // Refresh the recipient table to reflect status change
        populateRecipientTable();
        checkButtonStates(); // Update button states
    }                                              

    private void populateCompatibleDonorsTable(List<Donor> compatibleDonors) {
        DefaultTableModel model = (DefaultTableModel) compatibleDonorsJTable.getModel();
        model.setRowCount(0); // Always clear the table

        if (compatibleDonors == null || compatibleDonors.isEmpty()) {
            return; // If list is null or empty, just clear and return
        }

        for (Donor donor : compatibleDonors) {
            Object[] row = new Object[4];
            row[0] = donor; // toString of Donor should return name
            row[1] = donor.getOrganToDonate();
            row[2] = donor.getBloodType();
            row[3] = donor.getStatus();
            model.addRow(row);
        }
        checkButtonStates(); // Update button states after table population
    }
    
    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {                                        
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }                                       

    private void btnSendMatchForDoctorVerificationActionPerformed(java.awt.event.ActionEvent evt) {                                                  
        int selectedRecipientRow = recipientJTable.getSelectedRow();
        if (selectedRecipientRow < 0) {
            JOptionPane.showMessageDialog(this, "Please select a Recipient from the Recipient List.", "Selection Error", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int selectedDonorRow = compatibleDonorsJTable.getSelectedRow();
        if (selectedDonorRow < 0) {
            JOptionPane.showMessageDialog(this, "Please select a compatible Donor from the Compatible Donors list.", "Selection Error", JOptionPane.WARNING_MESSAGE);
            return;
        }

        Recipient selectedRecipient = (Recipient) recipientJTable.getValueAt(selectedRecipientRow, 0);
        Donor selectedDonor = (Donor) compatibleDonorsJTable.getValueAt(selectedDonorRow, 0);

        // Validate Donor status for verification by Doctor
        if (!selectedDonor.getStatus().equalsIgnoreCase("Tests Verified")) {
            JOptionPane.showMessageDialog(this, "The selected Donor's tests must be completed and verified by the Lab before sending for match verification.", "Validation Error", JOptionPane.WARNING_MESSAGE);
            return;
        }
        // Validate Recipient status if necessary, e.g., if recipient also underwent individual tests
        // For now, assuming recipient status is fine as long as donor is verified.

        // Check if a request for this match has already been sent
        if (selectedRecipient.getStatus().equalsIgnoreCase("Pending Final Doctor Verification") || 
            selectedDonor.getStatus().equalsIgnoreCase("Pending Final Doctor Verification")) {
            JOptionPane.showMessageDialog(this, "This match is already pending final doctor verification.", "Information", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        // Find a Doctor Organization to send the request to
        Organization orgToReceive = null;
        UserAccount doctorAccount = null; 
        for (Network net : system.getNetworkList()) {
            for (Enterprise ent : net.getEnterpriseDirectory().getEnterpriseList()) {
                for (Organization org : ent.getOrganizationDirectory().getOrganizationList()) {
                    if (org instanceof DoctorOrganization) {
                        orgToReceive = org;
                        if (!org.getUserAccountDirectory().getUserAccountList().isEmpty()) {
                            doctorAccount = org.getUserAccountDirectory().getUserAccountList().get(0); // Assign to the first doctor found
                            break; 
                        }
                    }
                }
                if (orgToReceive != null && doctorAccount != null) break; 
            }
            if (orgToReceive != null && doctorAccount != null) break; 
        }
        
        if (doctorAccount == null || orgToReceive == null) { 
            JOptionPane.showMessageDialog(this, "No Doctor User Accounts or Doctor Organization found to send the request for final verification.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Create the MedicalTestWorkRequest for the matched pair
        MedicalTestWorkRequest request = new MedicalTestWorkRequest(
            "Final Match Verification for: " + selectedDonor.getName() + " and " + selectedRecipient.getName(),
            userAccount, // Sender: Transplant Coordinator
            doctorAccount, // Receiver: Doctor
            "Match Verification", // Test Type (specific to this stage)
            selectedDonor,
            selectedRecipient
        );
        request.setRequestDate(new Date());
        request.setStatus("Pending Final Doctor Verification"); // New status

        // Add to work queue of Transplant Coordinator's organization
        organization.getWorkQueue().getWorkRequestList().add(request);
        
        // Add to work queue of the Doctor Organization
        orgToReceive.getWorkQueue().getWorkRequestList().add(request);

        // Update Donor/Recipient status
        selectedDonor.setStatus("Pending Final Doctor Verification");
        selectedRecipient.setStatus("Pending Final Doctor Verification");
        
        JOptionPane.showMessageDialog(this, "Match sent to Doctor for final verification. Status updated.", "Success", JOptionPane.INFORMATION_MESSAGE);
        populateRecipientTable(); // Refresh recipient table to show status change
        populateCompatibleDonorsTable(null); // Clear compatible donors table or refresh
    }                                                 

    private void btnRequestInternationalSearchActionPerformed(java.awt.event.ActionEvent evt) {                                                              
        int selectedRecipientRow = recipientJTable.getSelectedRow();
        if (selectedRecipientRow < 0) {
            JOptionPane.showMessageDialog(this, "Please select a Recipient from the Recipient List.", "Selection Error", JOptionPane.WARNING_MESSAGE);
            return;
        }

        Recipient selectedRecipient = (Recipient) recipientJTable.getValueAt(selectedRecipientRow, 0);

        if (!selectedRecipient.getStatus().equalsIgnoreCase("No Matches Found")) {
            JOptionPane.showMessageDialog(this, "International search can only be requested for recipients with 'No Matches Found' status.", "Validation Error", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        // Check if a request has already been sent
        if (selectedRecipient.getStatus().equalsIgnoreCase("Pending International Search")) {
            JOptionPane.showMessageDialog(this, "An international search has already been requested for this recipient.", "Information", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        // Find an International Organization to send the request to
        InternationalOrganization intlOrg = null;
        for (Network net : system.getNetworkList()) {
            for (Enterprise ent : net.getEnterpriseDirectory().getEnterpriseList()) {
                for (Organization org : ent.getOrganizationDirectory().getOrganizationList()) {
                    if (org instanceof InternationalOrganization) {
                        intlOrg = (InternationalOrganization) org;
                        break;
                    }
                }
                if (intlOrg != null) break;
            }
            if (intlOrg != null) break;
        }

        if (intlOrg == null || intlOrg.getUserAccountDirectory().getUserAccountList().isEmpty()) {
            JOptionPane.showMessageDialog(this, "No International Organization or International Officer User Accounts found to send the request to.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        // Assuming we send to the first available International Officer
        UserAccount intlOfficerAccount = intlOrg.getUserAccountDirectory().getUserAccountList().get(0);

        // Create the InternationalCollaborationRequest
        InternationalCollaborationRequest request = new InternationalCollaborationRequest(
            "International search for " + selectedRecipient.getName() + " (" + selectedRecipient.getOrganNeeded() + ")",
            userAccount, // Sender: Transplant Coordinator
            intlOfficerAccount, // Receiver: International Officer
            selectedRecipient
        );
        request.setRequestDate(new Date());
        request.setStatus("Pending International Review");

        // Add to work queue of Transplant Coordinator's organization
        organization.getWorkQueue().getWorkRequestList().add(request);
        
        // Add to work queue of the International Organization
        intlOrg.getWorkQueue().getWorkRequestList().add(request);

        // Update Recipient status
        selectedRecipient.setStatus("Pending International Search");
        
        JOptionPane.showMessageDialog(this, "International search request sent successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
        populateRecipientTable(); // Refresh recipient table to show status change
    }


    // Variables declaration - do not modify                     
    private javax.swing.JButton btnSendMatchForDoctorVerification;
    private javax.swing.JButton btnRequestInternationalSearch;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnFindMatches;
    private javax.swing.JTable compatibleDonorsJTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblCompatibleDonors;
    private javax.swing.JTable recipientJTable;
    // End of variables declaration                   
}
