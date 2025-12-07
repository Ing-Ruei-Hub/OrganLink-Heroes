
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
                Object[] row = new Object[7];
                row[0] = testRequest.getSender().getEmployee().getName(); // Lab Technician
                row[1] = testRequest.getRecipient().getName();
                row[2] = testRequest.getTestType();
                row[3] = testRequest.getTestResult();
                row[4] = testRequest; // The request object itself, for status and actions
                row[5] = testRequest.getRequestDate() != null ? dateFormat.format(testRequest.getRequestDate()) : "";
                row[6] = testRequest.getResolveDate() != null ? dateFormat.format(testRequest.getResolveDate()) : "";
                model.addRow(row);
            }
        }
    }

    @SuppressWarnings("unchecked")
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

        setBackground(new java.awt.Color(0, 153, 153));
        setMinimumSize(new java.awt.Dimension(1280, 720));
        setPreferredSize(new java.awt.Dimension(1280, 720));

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));

        lblTitle.setFont(new java.awt.Font("Arial", 1, 28)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(204, 255, 204));
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("Medical Test Verification");

        lblWelcome.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lblWelcome.setForeground(new java.awt.Color(204, 255, 204));
        lblWelcome.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblWelcome.setText("Welcome, Doctor");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lblWelcome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lblTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblWelcome)
                .addContainerGap(20, Short.MAX_VALUE))
        );

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

        btnVerify.setBackground(new java.awt.Color(0, 102, 102));
        btnVerify.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnVerify.setForeground(new java.awt.Color(204, 255, 204));
        btnVerify.setText("Verify Test Result");
        btnVerify.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerifyActionPerformed(evt);
            }
        });

        btnRequestRetest.setBackground(new java.awt.Color(0, 102, 102));
        btnRequestRetest.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnRequestRetest.setForeground(new java.awt.Color(204, 255, 204));
        btnRequestRetest.setText("Request Retest");
        btnRequestRetest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRequestRetestActionPerformed(evt);
            }
        });

        btnBack.setBackground(new java.awt.Color(0, 102, 102));
        btnBack.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnBack.setForeground(new java.awt.Color(204, 255, 204));
        btnBack.setText("<< Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        btnRefresh.setBackground(new java.awt.Color(0, 102, 102));
        btnRefresh.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnRefresh.setForeground(new java.awt.Color(204, 255, 204));
        btnRefresh.setText("Refresh");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnBack)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnRefresh))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1180, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnVerify, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnRequestRetest, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(50, 50, 50))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBack)
                    .addComponent(btnRefresh))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnVerify, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRequestRetest, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(193, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnVerifyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerifyActionPerformed
        int selectedRow = tblTestRequests.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(this, "Please select a test request to verify.", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        MedicalTestWorkRequest request = (MedicalTestWorkRequest) tblTestRequests.getValueAt(selectedRow, 4); // Assuming WorkRequest object is at index 4

        if (request.getStatus().equalsIgnoreCase("Completed")) {
            request.setStatus("Verified by Doctor");
            request.setResolveDate(new java.util.Date());
            JOptionPane.showMessageDialog(this, "Medical test result verified successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            populateTestRequestTable();
        } else {
            JOptionPane.showMessageDialog(this, "Test result cannot be verified as its status is not 'Completed'.", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnVerifyActionPerformed

    private void btnRequestRetestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRequestRetestActionPerformed
        int selectedRow = tblTestRequests.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(this, "Please select a test request to retest.", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        MedicalTestWorkRequest request = (MedicalTestWorkRequest) tblTestRequests.getValueAt(selectedRow, 4); // Assuming WorkRequest object is at index 4

        if (request.getStatus().equalsIgnoreCase("Completed") || request.getStatus().equalsIgnoreCase("Pending Doctor Verification")) {
            String retestReason = JOptionPane.showInputDialog(this, "Enter reason for retest:");
            if (retestReason != null && !retestReason.trim().isEmpty()) {
                request.setStatus("Retest Requested by Doctor");
                request.setMessage("Retest requested: " + retestReason); // Update message with retest reason
                request.setReceiver(findLabTechnician()); // Assign back to a Lab Technician
                request.setResolveDate(null); // Clear resolve date
                JOptionPane.showMessageDialog(this, "Retest requested successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                populateTestRequestTable();
            } else {
                JOptionPane.showMessageDialog(this, "Retest reason cannot be empty.", "Warning", JOptionPane.WARNING_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Retest can only be requested for 'Completed' or 'Pending Doctor Verification' results.", "Warning", JOptionPane.WARNING_MESSAGE);
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

    // Helper method to find a Lab Technician to assign the retest request to
    private UserAccount findLabTechnician() {
        for (Network net : business.getNetworkList()) {
            for (Enterprise ent : net.getEnterpriseDirectory().getEnterpriseList()) {
                for (Organization org : ent.getOrganizationDirectory().getOrganizationList()) {
                    if (org instanceof LabOrganization) {
                        if (!org.getUserAccountDirectory().getUserAccountList().isEmpty()) {
                            return org.getUserAccountDirectory().getUserAccountList().get(0); // Return the first Lab Technician found
                        }
                    }
                }
            }
        }
        return null; // No Lab Technician found
    }


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
