package userinterface.GovernmentRole;
import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.Organization.DonorOrganization; // Import DonorOrganization
import Business.Organization.RecipientOrganization; // Import RecipientOrganization
import Business.Donor.Donor; // Import Donor
import Business.Recipient.Recipient; // Import Recipient
import Business.UserAccount.UserAccount;
import Business.WorkQueue.DonorRegistrationRequest; // Keep for now
import Business.WorkQueue.RecipientOrganRequest;   // Keep for now
import Business.WorkQueue.WorkRequest;             // Keep for now
import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel; // Add this import for JTable
import java.awt.GridBagConstraints; // Ensure GridBagConstraints is imported
import java.awt.Insets; // Ensure Insets is imported

/**
 *
 * @author jim.hsieh
 */
public class GovernmentWorkAreaJPanel extends javax.swing.JPanel{
     private JPanel userProcessContainer;
    private UserAccount account;
    private Organization organization;
    private Enterprise enterprise;
    private EcoSystem business;
    private Network network;

    public GovernmentWorkAreaJPanel(JPanel userProcessContainer, 
                                    UserAccount account, 
                                    Organization organization, 
                                    Enterprise enterprise, 
                                    EcoSystem business,
                                    Network network) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.account = account;
        this.organization = organization;
        this.enterprise = enterprise;
        this.business = business;
        this.network = network;
        
        lblWelcome.setText("Welcome, " + account.getEmployee().getName());
        
        populateStatusComboBox(); // Populate the combo box
        populateTable("All"); // Populate table with all statuses initially
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();
        lblWelcome = new javax.swing.JLabel();
        btnEmergencyReview = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        
        workflowJTable = new javax.swing.JTable(); // Initialize JTable
        workflowScrollPane = new javax.swing.JScrollPane(); // Initialize JScrollPane
        statusFilterJComboBox = new javax.swing.JComboBox<>(); // Initialize JComboBox
        lblFilterStatus = new javax.swing.JLabel(); // Initialize JLabel

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new java.awt.GridBagLayout());
        java.awt.GridBagConstraints gbc = new java.awt.GridBagConstraints();

        lblTitle.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(0, 102, 102));
        lblTitle.setText("Government Official Work Area");
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.insets = new java.awt.Insets(10, 10, 10, 10);
        add(lblTitle, gbc);

        lblWelcome.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblWelcome.setText("Welcome, Government Official");
        gbc.gridy = 1;
        add(lblWelcome, gbc);

        btnEmergencyReview.setBackground(new java.awt.Color(204, 0, 0));
        btnEmergencyReview.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnEmergencyReview.setForeground(new java.awt.Color(255, 255, 255));
        btnEmergencyReview.setText("Emergency Protocol Review");
        btnEmergencyReview.setPreferredSize(new java.awt.Dimension(250, 40));
        btnEmergencyReview.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEmergencyReviewActionPerformed(evt);
            }
        });
        gbc.gridy = 2;
        gbc.insets = new java.awt.Insets(20, 10, 10, 10);
        add(btnEmergencyReview, gbc);

        // --- New UI Components for Workflow Monitoring ---
        lblFilterStatus.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblFilterStatus.setText("Filter by Status:");
        gbc.gridx = 0;
        gbc.gridy = 3; // Shifted below btnEmergencyReview
        gbc.gridwidth = 1;
        gbc.anchor = java.awt.GridBagConstraints.WEST;
        gbc.insets = new java.awt.Insets(20, 10, 5, 5);
        add(lblFilterStatus, gbc);

        statusFilterJComboBox.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        statusFilterJComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                statusFilterJComboBoxActionPerformed(evt);
            }
        });
        gbc.gridx = 1;
        gbc.gridy = 3; // Same row as label
        gbc.anchor = java.awt.GridBagConstraints.WEST;
        gbc.insets = new java.awt.Insets(20, 5, 5, 10);
        add(statusFilterJComboBox, gbc);

        workflowJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Type", "ID", "Name", "Blood Type", "Organ/Organ Needed", "Status", "Contact/Urgency"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        workflowJTable.setRowSelectionAllowed(true);
        workflowJTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        workflowScrollPane.setViewportView(workflowJTable);
        if (workflowJTable.getColumnModel().getColumnCount() > 0) {
            workflowJTable.getColumnModel().getColumn(0).setResizable(false);
            workflowJTable.getColumnModel().getColumn(1).setResizable(false);
            workflowJTable.getColumnModel().getColumn(2).setResizable(false);
            workflowJTable.getColumnModel().getColumn(3).setResizable(false);
            workflowJTable.getColumnModel().getColumn(4).setResizable(false);
            workflowJTable.getColumnModel().getColumn(5).setResizable(false);
            workflowJTable.getColumnModel().getColumn(6).setResizable(false);
        }
        
        gbc.gridx = 0;
        gbc.gridy = 4; // Below filter
        gbc.gridwidth = 2;
        gbc.fill = java.awt.GridBagConstraints.BOTH;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.insets = new java.awt.Insets(10, 10, 10, 10);
        add(workflowScrollPane, gbc);

        btnBack.setText("<< Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        gbc.gridx = 0;
        gbc.gridy = 5; // Below table
        gbc.gridwidth = 1;
        gbc.fill = java.awt.GridBagConstraints.NONE;
        gbc.anchor = java.awt.GridBagConstraints.SOUTHWEST;
        gbc.weightx = 0.0;
        gbc.weighty = 0.0;
        gbc.insets = new java.awt.Insets(10, 10, 10, 10);
        add(btnBack, gbc);
    }// </editor-fold>//GEN-END:initComponents

    private void btnEmergencyReviewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEmergencyReviewActionPerformed
        GovernmentOfficialEmergencyReviewJPanel reviewPanel = new GovernmentOfficialEmergencyReviewJPanel(
            userProcessContainer, account, organization, enterprise, business);
        userProcessContainer.add("GovernmentEmergencyReview", reviewPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnEmergencyReviewActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed

    private void statusFilterJComboBoxActionPerformed(java.awt.event.ActionEvent evt) {                                                  
        String selectedStatus = (String) statusFilterJComboBox.getSelectedItem();
        populateTable(selectedStatus);
    } 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEmergencyReview;
    private javax.swing.JButton btnBack;
    private javax.swing.JTable workflowJTable; // New JTable
    private javax.swing.JScrollPane workflowScrollPane; // New JScrollPane for the table
    private javax.swing.JComboBox<String> statusFilterJComboBox; // New JComboBox for status filtering
    private javax.swing.JLabel lblFilterStatus; // New JLabel for the combo box
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblWelcome;
    // End of variables declaration//GEN-END:variables

    private void populateStatusComboBox() {
        statusFilterJComboBox.removeAllItems();
        statusFilterJComboBox.addItem("All");
        // Add more specific statuses relevant to Donor and Recipient objects
        statusFilterJComboBox.addItem("Registered"); // Initial status for both
        statusFilterJComboBox.addItem("Pending Hospital Review");
        statusFilterJComboBox.addItem("Approved by Hospital");
        statusFilterJComboBox.addItem("Rejected");
        statusFilterJComboBox.addItem("Tests Verified"); // Example
        statusFilterJComboBox.addItem("Ready for Transplant"); // Example
        statusFilterJComboBox.addItem("Pending Final Doctor Verification"); // Example for Recipient
        statusFilterJComboBox.addItem("Retest Required"); // Example for Recipient
        statusFilterJComboBox.addItem("Transplant Scheduled"); // Example
        statusFilterJComboBox.addItem("Completed");
        statusFilterJComboBox.addItem("Deceased");
        // Ensure these statuses align with actual statuses used in Donor/Recipient objects
    }

    private void populateTable(String statusFilter) {
        DefaultTableModel model = (DefaultTableModel) workflowJTable.getModel();
        model.setRowCount(0); // Clear existing rows

        // Iterate through all networks, enterprises, and organizations to find Donor and Recipient objects
        for (Network network : business.getNetworkList()) {
            for (Enterprise enterprise : network.getEnterpriseDirectory().getEnterpriseList()) {
                for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
                    if (organization instanceof DonorOrganization) {
                        DonorOrganization donorOrg = (DonorOrganization) organization;
                        for (Donor donor : donorOrg.getDonorDirectory().getDonorList()) {
                            if (statusFilter.equals("All") || donor.getStatus().equals(statusFilter)) {
                                Object[] row = new Object[7];
                                row[0] = "Donor";
                                row[1] = donor.getDonorId();
                                row[2] = donor.getName();
                                row[3] = donor.getBloodType();
                                row[4] = donor.getOrganToDonate();
                                row[5] = donor.getStatus();
                                row[6] = donor.getContactNumber(); // Or email
                                model.addRow(row);
                            }
                        }
                    } else if (organization instanceof RecipientOrganization) {
                        RecipientOrganization recipientOrg = (RecipientOrganization) organization;
                        for (Recipient recipient : recipientOrg.getRecipientDirectory().getRecipientList()) {
                            if (statusFilter.equals("All") || recipient.getStatus().equals(statusFilter)) {
                                Object[] row = new Object[7];
                                row[0] = "Recipient";
                                row[1] = recipient.getRecipientId();
                                row[2] = recipient.getName();
                                row[3] = recipient.getBloodType();
                                row[4] = recipient.getOrganNeeded();
                                row[5] = recipient.getStatus();
                                row[6] = recipient.getUrgencyLevel(); // Or contact number
                                model.addRow(row);
                            }
                        }
                    }
                }
            }
        }
    }
}