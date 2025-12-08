/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package userinterface.GovernmentRole;
import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.EmergencyProtocolRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author jim.hsieh
 */
public class GovernmentOfficialEmergencyReviewJPanel extends javax.swing.JPanel{
    private JPanel userProcessContainer;
    private UserAccount account;
    private Organization organization;
    private Enterprise enterprise;
    private EcoSystem business;

    public GovernmentOfficialEmergencyReviewJPanel(JPanel userProcessContainer, 
                                                   UserAccount account, 
                                                   Organization organization, 
                                                   Enterprise enterprise, 
                                                   EcoSystem business) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.account = account;
        this.organization = organization;
        this.enterprise = enterprise;
        this.business = business;
        
        populateTable();
    }
    
    private void populateTable() {
        DefaultTableModel model = (DefaultTableModel) tblEmergencyProtocols.getModel();
        model.setRowCount(0);
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        
        for (WorkRequest request : organization.getWorkQueue().getWorkRequestList()) {
            if (request instanceof EmergencyProtocolRequest) {
                EmergencyProtocolRequest emergency = (EmergencyProtocolRequest) request;
                
                Object[] row = new Object[5];
                row[0] = emergency.getMessage();
                row[1] = emergency.getProtocolType();
                row[2] = emergency.getReason();
                row[3] = emergency.getStatus();
                row[4] = dateFormat.format(emergency.getRequestDate());
                model.addRow(row);
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblEmergencyProtocols = new javax.swing.JTable();
        btnApprove = new javax.swing.JButton();
        btnReject = new javax.swing.JButton();
        btnRefresh = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new java.awt.GridBagLayout());
        java.awt.GridBagConstraints gbc = new java.awt.GridBagConstraints();

        lblTitle.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(0, 102, 102));
        lblTitle.setText("Emergency Protocol Review");
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 4;
        gbc.insets = new java.awt.Insets(10, 10, 20, 10);
        add(lblTitle, gbc);

        tblEmergencyProtocols.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Request ID", "Protocol Type", "Reason", "Status", "Activation Time"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblEmergencyProtocols);
        
        gbc.gridy = 1;
        gbc.gridx = 0;
        gbc.gridwidth = 4;
        gbc.fill = java.awt.GridBagConstraints.BOTH;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.insets = new java.awt.Insets(10, 10, 10, 10);
        add(jScrollPane1, gbc);

        JPanel buttonPanel = new JPanel(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 20, 10));
        btnApprove.setText("Approve Protocol");
        btnApprove.setBackground(new java.awt.Color(0, 120, 102));
        btnApprove.setForeground(java.awt.Color.WHITE);
        btnApprove.addActionListener(this::btnApproveActionPerformed);
        buttonPanel.add(btnApprove);

        btnReject.setText("Reject Protocol");
        btnReject.setBackground(new java.awt.Color(204, 0, 0));
        btnReject.setForeground(java.awt.Color.WHITE);
        btnReject.addActionListener(this::btnRejectActionPerformed);
        buttonPanel.add(btnReject);

        btnRefresh.setText("Refresh");
        btnRefresh.addActionListener(this::btnRefreshActionPerformed);
        buttonPanel.add(btnRefresh);

        gbc.gridy = 2;
        gbc.gridx = 0;
        gbc.gridwidth = 4;
        gbc.weighty = 0;
        add(buttonPanel, gbc);
        
        btnBack.setText("<< Back");
        btnBack.addActionListener(this::btnBackActionPerformed);
        gbc.gridy = 3;
        gbc.gridx = 0;
        gbc.gridwidth = 1;
        gbc.anchor = java.awt.GridBagConstraints.SOUTHWEST;
        add(btnBack, gbc);
        
    }// </editor-fold>//GEN-END:initComponents

    private void btnApproveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnApproveActionPerformed
        int selectedRow = tblEmergencyProtocols.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(this, "Please select an emergency protocol to approve.", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        String requestId = (String) tblEmergencyProtocols.getValueAt(selectedRow, 0);
        
        String notes = JOptionPane.showInputDialog(this, "Enter approval notes:");
        if (notes != null) {
            for (WorkRequest request : organization.getWorkQueue().getWorkRequestList()) {
                if (request instanceof EmergencyProtocolRequest) {
                    EmergencyProtocolRequest emergency = (EmergencyProtocolRequest) request;
                    if (emergency.getMessage().equals(requestId)) {
                        emergency.setIsApprovedByGovernment(true);
                        emergency.setGovernmentApprover(account);
                        emergency.setStatus("Approved by Government");
                        
                        JOptionPane.showMessageDialog(this, 
                            "Emergency Protocol Approved!\n" +
                            "Request: " + requestId + "\n" +
                            "Approved by: " + account.getEmployee().getName(),
                            "Success",
                            JOptionPane.INFORMATION_MESSAGE);
                        break;
                    }
                }
            }
            populateTable();
        }
    }//GEN-LAST:event_btnApproveActionPerformed

    private void btnRejectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRejectActionPerformed
        int selectedRow = tblEmergencyProtocols.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(this, "Please select an emergency protocol to reject.", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        String requestId = (String) tblEmergencyProtocols.getValueAt(selectedRow, 0);
        
        String reason = JOptionPane.showInputDialog(this, "Enter rejection reason:");
        if (reason != null && !reason.trim().isEmpty()) {
            for (WorkRequest request : organization.getWorkQueue().getWorkRequestList()) {
                if (request instanceof EmergencyProtocolRequest) {
                    EmergencyProtocolRequest emergency = (EmergencyProtocolRequest) request;
                    if (emergency.getMessage().equals(requestId)) {
                        emergency.setIsApprovedByGovernment(false);
                        emergency.setStatus("Rejected by Government");
                        
                        JOptionPane.showMessageDialog(this, 
                            "Emergency Protocol Rejected\n" +
                            "Request: " + requestId + "\n" +
                            "Reason: " + reason,
                            "Rejected",
                            JOptionPane.WARNING_MESSAGE);
                        break;
                    }
                }
            }
            populateTable();
        }
    }//GEN-LAST:event_btnRejectActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        populateTable();
        JOptionPane.showMessageDialog(this, "Data refreshed!", "Info", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnApprove;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnReject;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTable tblEmergencyProtocols;
    // End of variables declaration//GEN-END:variables
}
