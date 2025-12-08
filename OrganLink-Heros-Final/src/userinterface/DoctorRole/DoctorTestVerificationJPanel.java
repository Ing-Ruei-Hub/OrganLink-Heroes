
package userinterface.DoctorRole;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.DoctorOrganization;
import Business.Organization.LabOrganization;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.MedicalTestWorkRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

public class DoctorTestVerificationJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private UserAccount account;
    private Organization organization;
    private Enterprise enterprise;
    private EcoSystem business;
    private Network network;

    public DoctorTestVerificationJPanel(JPanel userProcessContainer, 
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
        
        lblWelcome.setText("Welcome, Dr. " + account.getEmployee().getName());
        populateTestRequestTable();
    }
    
    private void populateTestRequestTable() {
        DefaultTableModel model = (DefaultTableModel) tblTestRequests.getModel();
        model.setRowCount(0);
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");

        // Iterate through the work queue of the DoctorOrganization
        // A doctor should only see requests relevant to them, e.g., medical test requests assigned to them
        // or requests they need to verify.
        
        // This example assumes MedicalTestWorkRequest are sent to doctors for verification
        // You might need to adjust the logic based on how MedicalTestWorkRequest are routed in your system
        for (WorkRequest request : organization.getWorkQueue().getWorkRequestList()) {
            if (request instanceof MedicalTestWorkRequest) {
                MedicalTestWorkRequest testRequest = (MedicalTestWorkRequest) request;
                // Filter: Only show requests where this doctor is the receiver AND it's a matched pair
                if (testRequest.getReceiver() == account && testRequest.getDonor() != null && testRequest.getRecipient() != null) {
                    Object[] row = new Object[7];
                    row[0] = testRequest.getSender().getEmployee().getName(); // Lab Technician
                    
                    String patientName = "";
                    if(testRequest.getDonor() != null && testRequest.getRecipient() != null) {
                        patientName = testRequest.getDonor().getName() + " (D) / " + testRequest.getRecipient().getName() + " (R)";
                    } else if(testRequest.getDonor() != null) {
                        patientName = testRequest.getDonor().getName() + " (D)";
                    } else if (testRequest.getRecipient() != null) {
                        patientName = testRequest.getRecipient().getName() + " (R)";
                    }
                    row[1] = patientName; // Patient Name from Donor or Recipient
                    row[2] = testRequest.getTestType();
                    row[3] = testRequest.getTestResult();
                    row[4] = testRequest; // The request object itself, for status and actions
                    row[5] = testRequest.getRequestDate() != null ? dateFormat.format(testRequest.getRequestDate()) : "";
                    row[6] = testRequest.getResolveDate() != null ? dateFormat.format(testRequest.getResolveDate()) : "";
                    model.addRow(row);
                }
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();
        lblWelcome = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTestRequests = new javax.swing.JTable();
        btnVerify = new javax.swing.JButton();
        btnRequestRetest = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        btnRefresh = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new java.awt.GridBagLayout());
        java.awt.GridBagConstraints gbc = new java.awt.GridBagConstraints();

        lblTitle.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(0, 102, 102));
        lblTitle.setText("Medical Test Verification");
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 4;
        gbc.insets = new java.awt.Insets(10, 10, 10, 10);
        add(lblTitle, gbc);
        
        lblWelcome.setFont(new java.awt.Font("Tahoma", 1, 18));
        gbc.gridy = 1;
        add(lblWelcome, gbc);

        tblTestRequests.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Lab Technician", "Patient Name", "Test Name", "Result", "Status", "Request Date", "Resolve Date"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblTestRequests);
        
        gbc.gridy = 2;
        gbc.gridx = 0;
        gbc.gridwidth = 4;
        gbc.fill = java.awt.GridBagConstraints.BOTH;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.insets = new java.awt.Insets(10, 10, 10, 10);
        add(jScrollPane1, gbc);

        JPanel buttonPanel = new JPanel(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 20, 10));
        btnVerify.setText("Verify Test Result");
        btnVerify.setBackground(new java.awt.Color(0, 120, 102));
        btnVerify.setForeground(java.awt.Color.WHITE);
        btnVerify.addActionListener(this::btnVerifyActionPerformed);
        buttonPanel.add(btnVerify);

        btnRequestRetest.setText("Request Retest");
        btnRequestRetest.addActionListener(this::btnRequestRetestActionPerformed);
        buttonPanel.add(btnRequestRetest);
        
        gbc.gridy = 3;
        gbc.gridx = 0;
        gbc.gridwidth = 4;
        gbc.weighty = 0;
        add(buttonPanel, gbc);
        
        JPanel bottomPanel = new JPanel(new java.awt.BorderLayout());
        btnBack.setText("<< Back");
        btnBack.addActionListener(this::btnBackActionPerformed);
        bottomPanel.add(btnBack, java.awt.BorderLayout.WEST);
        
        btnRefresh.setText("Refresh");
        btnRefresh.addActionListener(this::btnRefreshActionPerformed);
        bottomPanel.add(btnRefresh, java.awt.BorderLayout.EAST);
        
        gbc.gridy = 4;
        gbc.gridx = 0;
        gbc.gridwidth = 4;
        gbc.fill = java.awt.GridBagConstraints.HORIZONTAL;
        add(bottomPanel, gbc);
        
    }// </editor-fold>//GEN-END:initComponents

    private void btnVerifyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerifyActionPerformed
        int selectedRow = tblTestRequests.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(this, "Please select a test request to verify.", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        MedicalTestWorkRequest request = (MedicalTestWorkRequest) tblTestRequests.getValueAt(selectedRow, 4); // Assuming WorkRequest object is at index 4

        // Ensure the request is not already processed and is for a matched pair
        if (request.getDonor() == null || request.getRecipient() == null) {
            JOptionPane.showMessageDialog(this, "This request is not for a matched pair and cannot be verified here.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (request.getStatus().equalsIgnoreCase("Verified, Ready for Transport Coordination") || request.getStatus().equalsIgnoreCase("Retest Required by Doctor - Match")) {
            JOptionPane.showMessageDialog(this, "This matched pair test request has already been processed or retest was requested.", "Information", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        
        request.setStatus("Verified, Ready for Transport Coordination");
        request.setResolveDate(new java.util.Date());
        request.setVerifier(account); // Doctor who verified

        // Assign the request back to the original sender (Transplant Coordinator)
        UserAccount originalSender = request.getSender();
        request.setReceiver(originalSender);

        // Update Donor and Recipient status
        request.getDonor().setStatus("Verified, Ready for Transport Coordination");
        request.getRecipient().setStatus("Verified, Ready for Transport Coordination");

        JOptionPane.showMessageDialog(this, "Medical test result for matched pair verified and sent to Transplant Coordinator!", "Success", JOptionPane.INFORMATION_MESSAGE);
        populateTestRequestTable();
    }//GEN-LAST:event_btnVerifyActionPerformed

    private void btnRequestRetestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRequestRetestActionPerformed
        int selectedRow = tblTestRequests.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(this, "Please select a test request to retest.", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        MedicalTestWorkRequest request = (MedicalTestWorkRequest) tblTestRequests.getValueAt(selectedRow, 4); // Assuming WorkRequest object is at index 4

        // Ensure it's a matched pair request
        if (request.getDonor() == null || request.getRecipient() == null) {
            JOptionPane.showMessageDialog(this, "This request is not for a matched pair and retest cannot be requested here.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (request.getStatus().equalsIgnoreCase("Pending Final Doctor Verification") || request.getStatus().equalsIgnoreCase("Verified, Ready for Transport Coordination") || request.getStatus().equalsIgnoreCase("Retest Required by Doctor - Match")) {
            String retestReason = JOptionPane.showInputDialog(this, "Enter reason for retest:");
            if (retestReason != null && !retestReason.trim().isEmpty()) {
                request.setStatus("Retest Required by Doctor - Match");
                request.setMessage("Retest requested by Doctor for Match: " + retestReason); // Update message with retest reason
                request.setReceiver(request.getSender()); // Assign back to the original sender (Transplant Coordinator)
                request.setResolveDate(null); // Clear resolve date

                // Update Donor and Recipient status
                request.getDonor().setStatus("Retest Required by Doctor - Match");
                request.getRecipient().setStatus("Retest Required by Doctor - Match");

                JOptionPane.showMessageDialog(this, "Retest for matched pair requested successfully and sent back to Transplant Coordinator!", "Success", JOptionPane.INFORMATION_MESSAGE);
                populateTestRequestTable();
            } else {
                JOptionPane.showMessageDialog(this, "Retest reason cannot be empty.", "Warning", JOptionPane.WARNING_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Retest can only be requested for 'Pending Final Doctor Verification' or 'Verified, Ready for Transport Coordination' results.", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnRequestRetestActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        populateTestRequestTable();
        JOptionPane.showMessageDialog(this, "Table refreshed!", "Info", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btnRefreshActionPerformed




    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnRequestRetest;
    private javax.swing.JButton btnVerify;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblWelcome;
    private javax.swing.JTable tblTestRequests;
    // End of variables declaration//GEN-END:variables
}
