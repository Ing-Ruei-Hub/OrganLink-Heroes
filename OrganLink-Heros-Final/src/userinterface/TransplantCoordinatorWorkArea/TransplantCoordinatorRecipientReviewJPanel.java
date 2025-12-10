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
            selectedRecipient = (Recipient) recipientJTable.getValueAt(selectedRecipientRow, 1);
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
            Donor selectedDonor = (Donor) compatibleDonorsJTable.getValueAt(selectedDonorRow, 1);

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
                                Object[] row = new Object[6]; // Increased to 6 for Recipient ID
                                row[0] = recipient.getRecipientId(); // Assuming Recipient class has getRecipientId()
                                row[1] = recipient; // toString of Recipient should return name
                                row[2] = recipient.getOrganNeeded();
                                row[3] = recipient.getBloodType();
                                row[4] = recipient.getUrgencyLevel();
                                row[5] = recipient.getStatus();
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
        this.setBackground(new java.awt.Color(255, 255, 255));
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

        setLayout(new java.awt.GridBagLayout());
        java.awt.GridBagConstraints gbc = new java.awt.GridBagConstraints();

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 102));
        jLabel1.setText("Manage Recipient Requests & Matches");
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 3; // Changed from 4 to 3
        gbc.insets = new java.awt.Insets(10, 10, 20, 10);
        add(jLabel1, gbc);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 16)); // Bold, size 16
        jLabel2.setForeground(new java.awt.Color(51, 51, 51)); // Dark grey
        jLabel2.setText("Recipient Requests:");
        gbc.gridy = 1;
        gbc.gridwidth = 3; // Changed from 4 to 3
        gbc.anchor = java.awt.GridBagConstraints.WEST;
        gbc.insets = new java.awt.Insets(10, 10, 5, 10);
        add(jLabel2, gbc);

        recipientJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Recipient ID", "Recipient Name", "Organ Needed", "Blood Type", "Urgency", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(recipientJTable);
        
        gbc.gridy = 2;
        gbc.gridwidth = 3; // Changed from 4 to 3
        gbc.fill = java.awt.GridBagConstraints.BOTH;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.insets = new java.awt.Insets(0, 10, 10, 10);
        add(jScrollPane1, gbc);

        // Buttons for recipient actions
        gbc.gridy = 3;
        gbc.gridx = 0; // Start at column 0
        gbc.gridwidth = 1; // Each button takes 1 column
        gbc.fill = java.awt.GridBagConstraints.HORIZONTAL; // Make buttons fill their horizontal space
        gbc.anchor = java.awt.GridBagConstraints.CENTER; // Center buttons horizontally
        gbc.weightx = 1.0; // Allow buttons to expand
        gbc.insets = new java.awt.Insets(10, 10, 10, 5); // Add some right padding

        btnFindMatches.setText("Find Initial Matches");
        btnFindMatches.setBackground(new java.awt.Color(0, 120, 102)); // Primary accent teal
        btnFindMatches.setForeground(new java.awt.Color(255, 255, 255)); // White text
        // btnFindMatches.setPreferredSize(new java.awt.Dimension(200, 40)); // Removed preferredSize
        btnFindMatches.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFindMatchesActionPerformed(evt);
            }
        });
        add(btnFindMatches, gbc);

        gbc.gridx = 1; // Move to next column
        gbc.insets = new java.awt.Insets(10, 5, 10, 5); // Equal padding
        btnSendMatchForDoctorVerification.setText("Send Match for Doctor Verification");
        btnSendMatchForDoctorVerification.setBackground(new java.awt.Color(0, 120, 102)); // Primary accent teal
        btnSendMatchForDoctorVerification.setForeground(new java.awt.Color(255, 255, 255)); // White text
        // btnSendMatchForDoctorVerification.setPreferredSize(new java.awt.Dimension(220, 40)); // Removed preferredSize
        btnSendMatchForDoctorVerification.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSendMatchForDoctorVerificationActionPerformed(evt);
            }
        });
        btnSendMatchForDoctorVerification.setEnabled(false); // Initially disabled
        add(btnSendMatchForDoctorVerification, gbc);

        gbc.gridx = 2; // Move to next column
        gbc.insets = new java.awt.Insets(10, 5, 10, 10); // Add some left padding
        btnRequestInternationalSearch.setText("Request International Search");
        btnRequestInternationalSearch.setBackground(new java.awt.Color(0, 120, 102)); // Primary accent teal
        btnRequestInternationalSearch.setForeground(new java.awt.Color(255, 255, 255)); // White text
        // btnRequestInternationalSearch.setPreferredSize(new java.awt.Dimension(220, 40)); // Removed preferredSize
        btnRequestInternationalSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRequestInternationalSearchActionPerformed(evt);
            }
        });
        add(btnRequestInternationalSearch, gbc);
        
        lblCompatibleDonors.setFont(new java.awt.Font("Tahoma", 1, 16)); // Bold, size 16
        lblCompatibleDonors.setForeground(new java.awt.Color(51, 51, 51)); // Dark grey
        lblCompatibleDonors.setText("Compatible Donors:");
        gbc.gridy = 4;
        gbc.gridx = 0;
        gbc.gridwidth = 3; // Changed from 4 to 3
        gbc.anchor = java.awt.GridBagConstraints.WEST;
        gbc.insets = new java.awt.Insets(20, 10, 5, 10);
        add(lblCompatibleDonors, gbc);

        compatibleDonorsJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Donor ID", "Donor Name", "Organ To Donate", "Blood Type", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(compatibleDonorsJTable);
        
        gbc.gridy = 5;
        gbc.gridx = 0;
        gbc.gridwidth = 3; // Changed from 4 to 3
        gbc.fill = java.awt.GridBagConstraints.BOTH;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.insets = new java.awt.Insets(0, 10, 10, 10);
        add(jScrollPane2, gbc);

        btnBack.setText("<< Back");
        btnBack.setBackground(new java.awt.Color(153, 153, 153)); // Neutral grey
        btnBack.setForeground(new java.awt.Color(255, 255, 255)); // White text
        btnBack.setPreferredSize(new java.awt.Dimension(100, 40));
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        gbc.gridy = 6;
        gbc.gridx = 0;
        gbc.gridwidth = 1;
        gbc.anchor = java.awt.GridBagConstraints.SOUTHWEST;
        add(btnBack, gbc);
    }// </editor-fold>                        

    private void btnFindMatchesActionPerformed(java.awt.event.ActionEvent evt) {                                               
        int selectedRow = recipientJTable.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(this, "Please select a Recipient from the table.", "Selection Error", JOptionPane.WARNING_MESSAGE);
            return;
        }

        Recipient selectedRecipient = (Recipient) recipientJTable.getValueAt(selectedRow, 1);

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
            Object[] row = new Object[5]; // Increased to 5 for Donor ID
            row[0] = donor.getDonorId(); // Assuming Donor class has getDonorId()
            row[1] = donor; // toString of Donor should return name
            row[2] = donor.getOrganToDonate();
            row[3] = donor.getBloodType();
            row[4] = donor.getStatus();
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

        Recipient selectedRecipient = (Recipient) recipientJTable.getValueAt(selectedRecipientRow, 1);
        Donor selectedDonor = (Donor) compatibleDonorsJTable.getValueAt(selectedDonorRow, 1);

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
        request.setTestResult("Passed");

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

        Recipient selectedRecipient = (Recipient) recipientJTable.getValueAt(selectedRecipientRow, 1);

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
