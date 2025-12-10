/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package userinterface.InternationalRole;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.InternationalCollaborationRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

public class InternationalOfficerWorkAreaJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private UserAccount account;
    private Organization organization;
    private Enterprise enterprise;
    private EcoSystem business;
    private Network network; // Added Network instance variable

    public InternationalOfficerWorkAreaJPanel(JPanel userProcessContainer, 
                                              UserAccount account, 
                                              Organization organization, 
                                              Enterprise enterprise, 
                                              Network network, // Added Network parameter
                                              EcoSystem business) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.account = account;
        this.organization = organization;
        this.enterprise = enterprise;
        this.business = business;
        this.network = network; // Initialize Network
        
        lblWelcome.setText("Welcome, " + account.getEmployee().getName());
        populateRequestTable();
        updateStatistics();
    }
    
    private void populateRequestTable() {
        DefaultTableModel model = (DefaultTableModel) tblRequests.getModel();
        model.setRowCount(0);
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        
        for (WorkRequest request : organization.getWorkQueue().getWorkRequestList()) {
            if (request instanceof InternationalCollaborationRequest) {
                InternationalCollaborationRequest intlRequest = (InternationalCollaborationRequest) request;
                
                Object[] row = new Object[7]; // Increased size for new columns
                row[0] = intlRequest; // Display the request object, its toString should provide a unique ID
                row[1] = intlRequest.getRecipient() != null ? intlRequest.getRecipient().getName() : "Unknown";
                row[2] = intlRequest.getOrganRequired();
                row[3] = intlRequest.getRecipient() != null ? intlRequest.getRecipient().getBloodType() : "Unknown"; // Blood Type
                row[4] = intlRequest.getRecipient() != null ? intlRequest.getRecipient().getUrgencyLevel() : "Unknown"; // Urgency
                row[5] = intlRequest.getStatus();
                row[6] = dateFormat.format(intlRequest.getRequestDate());
                model.addRow(row);
            }
        }
    }
    
    private void updateStatistics() {
        int totalRequests = 0;
        int pendingRequests = 0;
        int matchesFound = 0;
        
        for (WorkRequest request : organization.getWorkQueue().getWorkRequestList()) {
            if (request instanceof InternationalCollaborationRequest) {
                InternationalCollaborationRequest intlRequest = (InternationalCollaborationRequest) request;
                totalRequests++;
                if (intlRequest.getStatus().equals("Pending International Review")) {
                    pendingRequests++;
                }
                if (intlRequest.isInternationalMatchFound()) {
                    matchesFound++;
                }
            }
        }
        
        lblTotalRequests.setText(String.valueOf(totalRequests));
        lblPendingRequests.setText(String.valueOf(pendingRequests));
        lblMatchesFound.setText(String.valueOf(matchesFound));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();
        lblWelcome = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        lblTotalRequests = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        lblPendingRequests = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        lblMatchesFound = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblRequests = new javax.swing.JTable();
        btnInitiateSearch = new javax.swing.JButton();
        btnMatchFound = new javax.swing.JButton();
        btnNoMatch = new javax.swing.JButton();
        btnRefresh = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new java.awt.GridBagLayout());
        java.awt.GridBagConstraints gbc = new java.awt.GridBagConstraints();

        lblTitle.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(0, 102, 102));
        lblTitle.setText("International Collaboration Center");
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 3; // Adjusted gridwidth
        gbc.fill = java.awt.GridBagConstraints.HORIZONTAL; // Fill horizontally
        gbc.insets = new java.awt.Insets(10, 10, 10, 10);
        add(lblTitle, gbc);
        
        lblWelcome.setFont(new java.awt.Font("Tahoma", 1, 18));
        gbc.gridy = 1;
        gbc.fill = java.awt.GridBagConstraints.HORIZONTAL; // Fill horizontally
        add(lblWelcome, gbc);

        // Stats panels directly in GridBagLayout, sharing horizontal space
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.weightx = 0.33; // Share horizontal space evenly
        gbc.fill = java.awt.GridBagConstraints.BOTH; // Fill both
        gbc.insets = new java.awt.Insets(20, 10, 10, 10);

        jPanel2.setBackground(new java.awt.Color(0, 102, 102));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 255, 204), 2));
        jPanel2.setLayout(new java.awt.BorderLayout());
        jLabel2.setFont(new java.awt.Font("Arial", 0, 14));
        jLabel2.setForeground(new java.awt.Color(204, 255, 204));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Total Requests");
        lblTotalRequests.setFont(new java.awt.Font("Arial", 1, 36));
        lblTotalRequests.setForeground(new java.awt.Color(255, 255, 255));
        lblTotalRequests.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTotalRequests.setText("0");
        jPanel2.add(jLabel2, java.awt.BorderLayout.NORTH);
        jPanel2.add(lblTotalRequests, java.awt.BorderLayout.CENTER);
        gbc.gridx = 0;
        add(jPanel2, gbc);

        jPanel3.setBackground(new java.awt.Color(0, 102, 102));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 255, 204), 2));
        jPanel3.setLayout(new java.awt.BorderLayout());
        jLabel4.setFont(new java.awt.Font("Arial", 0, 14));
        jLabel4.setForeground(new java.awt.Color(204, 255, 204));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Pending Review");
        lblPendingRequests.setFont(new java.awt.Font("Arial", 1, 36));
        lblPendingRequests.setForeground(new java.awt.Color(255, 255, 255));
        lblPendingRequests.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPendingRequests.setText("0");
        jPanel3.add(jLabel4, java.awt.BorderLayout.NORTH);
        jPanel3.add(lblPendingRequests, java.awt.BorderLayout.CENTER);
        gbc.gridx = 1;
        add(jPanel3, gbc);

        jPanel4.setBackground(new java.awt.Color(0, 102, 102));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 255, 204), 2));
        jPanel4.setLayout(new java.awt.BorderLayout());
        jLabel6.setFont(new java.awt.Font("Arial", 0, 14));
        jLabel6.setForeground(new java.awt.Color(204, 255, 204));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Matches Found");
        lblMatchesFound.setFont(new java.awt.Font("Arial", 1, 36));
        lblMatchesFound.setForeground(new java.awt.Color(255, 255, 255));
        lblMatchesFound.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMatchesFound.setText("0");
        jPanel4.add(jLabel6, java.awt.BorderLayout.NORTH);
        jPanel4.add(lblMatchesFound, java.awt.BorderLayout.CENTER);
        gbc.gridx = 2;
        add(jPanel4, gbc);

        tblRequests.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Request ID", "Patient Name", "Organ Required", "Blood Type", "Urgency", "Status", "Request Date"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblRequests);

        gbc.gridy = 3;
        gbc.gridx = 0;
        gbc.gridwidth = 3; // Span across all 3 columns
        gbc.fill = java.awt.GridBagConstraints.BOTH;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.insets = new java.awt.Insets(10, 10, 10, 10);
        add(jScrollPane1, gbc);

        JPanel buttonPanel = new JPanel(new java.awt.GridBagLayout()); // Changed to GridBagLayout for internal buttons
        java.awt.GridBagConstraints btnGbc = new java.awt.GridBagConstraints();
        btnGbc.insets = new java.awt.Insets(5, 5, 5, 5);
        btnGbc.fill = java.awt.GridBagConstraints.HORIZONTAL; // Fill horizontally
        btnGbc.weightx = 1.0; // Distribute horizontal space evenly

        btnInitiateSearch.setText("Initiate International Search");
        btnInitiateSearch.setBackground(new java.awt.Color(0, 120, 102));
        btnInitiateSearch.setForeground(java.awt.Color.WHITE);
        btnInitiateSearch.addActionListener(this::btnInitiateSearchActionPerformed);
        btnGbc.gridx = 0;
        btnGbc.gridy = 0;
        buttonPanel.add(btnInitiateSearch, btnGbc);

        btnMatchFound.setText("Match Found");
        btnMatchFound.setBackground(new java.awt.Color(0, 120, 102));
        btnMatchFound.setForeground(java.awt.Color.WHITE);
        btnMatchFound.addActionListener(this::btnMatchFoundActionPerformed);
        btnGbc.gridx = 1;
        btnGbc.gridy = 0;
        buttonPanel.add(btnMatchFound, btnGbc);
        
        btnNoMatch.setText("No Match Found");
        btnNoMatch.setBackground(new java.awt.Color(0, 120, 102));
        btnNoMatch.setForeground(java.awt.Color.WHITE);
        btnNoMatch.addActionListener(this::btnNoMatchActionPerformed);
        btnGbc.gridx = 2;
        btnGbc.gridy = 0;
        buttonPanel.add(btnNoMatch, btnGbc);

        gbc.gridy = 4;
        gbc.gridx = 0;
        gbc.gridwidth = 3;
        gbc.fill = java.awt.GridBagConstraints.HORIZONTAL; // Fill horizontally
        gbc.weightx = 1.0;
        gbc.weighty = 0;
        add(buttonPanel, gbc);

        JPanel bottomPanel = new JPanel(new java.awt.BorderLayout());
        btnBack.setText("<< Back");
        btnBack.addActionListener(this::btnBackActionPerformed);
        bottomPanel.add(btnBack, java.awt.BorderLayout.WEST);
        
        btnRefresh.setText("Refresh");
        btnRefresh.addActionListener(this::btnRefreshActionPerformed);
        bottomPanel.add(btnRefresh, java.awt.BorderLayout.EAST);
        
        gbc.gridy = 5;
        gbc.gridx = 0;
        gbc.gridwidth = 3;
        gbc.fill = java.awt.GridBagConstraints.HORIZONTAL;
        add(bottomPanel, gbc);
    }// </editor-fold>//GEN-END:initComponents

    private void btnInitiateSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInitiateSearchActionPerformed
        int selectedRow = tblRequests.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(this, "Please select a request to initiate search.", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        InternationalCollaborationRequest intlRequest = (InternationalCollaborationRequest) tblRequests.getValueAt(selectedRow, 0); // Get the request object
        
        if (!intlRequest.getStatus().equals("Pending International Review")) {
            JOptionPane.showMessageDialog(this, "This request is not in 'Pending International Review' status.", "Information", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        
        intlRequest.setStatus("Searching Internationally");
        JOptionPane.showMessageDialog(this, 
            "International search initiated for:\n" +
            "Patient: " + intlRequest.getRecipient().getName() + "\n" +
            "Organ: " + intlRequest.getOrganRequired() + "\n" +
            "Blood Type: " + intlRequest.getRecipient().getBloodType(),
            "Search Initiated",
            JOptionPane.INFORMATION_MESSAGE);
        
        populateRequestTable();
        updateStatistics();
    }//GEN-LAST:event_btnInitiateSearchActionPerformed

    private void btnMatchFoundActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMatchFoundActionPerformed
        int selectedRow = tblRequests.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(this, "Please select a request to mark as matched.", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        InternationalCollaborationRequest intlRequest = (InternationalCollaborationRequest) tblRequests.getValueAt(selectedRow, 0); // Get the request object
        
        if (!intlRequest.getStatus().equals("Searching Internationally")) {
            JOptionPane.showMessageDialog(this, "This request is not currently searching internationally.", "Information", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        String matchDetails = JOptionPane.showInputDialog(this, "Enter international match details (e.g., Donor country, hospital):");
        if (matchDetails != null && !matchDetails.trim().isEmpty()) {
            intlRequest.setStatus("International Match Found");
            intlRequest.setInternationalMatchFound(true);
            intlRequest.setInternationalMatchDetails(matchDetails);
            
            // Set receiver back to the original sender (Transplant Coordinator)
            intlRequest.setReceiver(intlRequest.getSender());
            
            // Update Recipient status
            if (intlRequest.getRecipient() != null) {
                intlRequest.getRecipient().setStatus("International Match Found");
            }

            JOptionPane.showMessageDialog(this, 
                "Match found and recorded!\n" +
                "Request: " + intlRequest.getMessage() + "\n" +
                "Details: " + matchDetails + "\n" +
                "Request sent back to Transplant Coordinator.",
                "Success",
                JOptionPane.INFORMATION_MESSAGE);
        }
        
        populateRequestTable();
        updateStatistics();
    }//GEN-LAST:event_btnMatchFoundActionPerformed

    private void btnNoMatchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNoMatchActionPerformed
        int selectedRow = tblRequests.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(this, "Please select a request to close.", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        InternationalCollaborationRequest intlRequest = (InternationalCollaborationRequest) tblRequests.getValueAt(selectedRow, 0); // Get the request object

        if (!intlRequest.getStatus().equals("Searching Internationally")) {
            JOptionPane.showMessageDialog(this, "This request is not currently searching internationally.", "Information", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        intlRequest.setStatus("No International Match - Request Closed");
        intlRequest.setInternationalMatchFound(false);
        
        // Set receiver back to the original sender (Transplant Coordinator)
        intlRequest.setReceiver(intlRequest.getSender());
        
        // Update Recipient status
        if (intlRequest.getRecipient() != null) {
            intlRequest.getRecipient().setStatus("No International Match Found");
        }
        
        JOptionPane.showMessageDialog(this, 
            "Request closed - No international match found\n" +
            "Request: " + intlRequest.getMessage() + "\n" +
            "Request sent back to Transplant Coordinator.",
            "Request Closed",
            JOptionPane.INFORMATION_MESSAGE);
        
        populateRequestTable();
        updateStatistics();
    }//GEN-LAST:event_btnNoMatchActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        populateRequestTable();
        updateStatistics();
        JOptionPane.showMessageDialog(this, "Data refreshed!", "Info", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnInitiateSearch;
    private javax.swing.JButton btnMatchFound;
    private javax.swing.JButton btnNoMatch;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblMatchesFound;
    private javax.swing.JLabel lblPendingRequests;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblTotalRequests;
    private javax.swing.JLabel lblWelcome;
    private javax.swing.JTable tblRequests;
    // End of variables declaration//GEN-END:variables
}
