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
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblEmergencyProtocols = new javax.swing.JTable();
        btnApprove = new javax.swing.JButton();
        btnReject = new javax.swing.JButton();
        btnRefresh = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();

        setBackground(new java.awt.Color(0, 153, 153));
        setMinimumSize(new java.awt.Dimension(1280, 720));
        setPreferredSize(new java.awt.Dimension(1280, 720));

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));

        lblTitle.setFont(new java.awt.Font("Arial", 1, 28));
        lblTitle.setForeground(new java.awt.Color(204, 255, 204));
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("Emergency Protocol Review");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTitle, javax.swing.GroupLayout.DEFAULT_SIZE, 1280, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lblTitle)
                .addContainerGap(20, Short.MAX_VALUE))
        );

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

        btnApprove.setBackground(new java.awt.Color(0, 153, 0));
        btnApprove.setFont(new java.awt.Font("Arial", 1, 16));
        btnApprove.setForeground(new java.awt.Color(255, 255, 255));
        btnApprove.setText("Approve Protocol");
        btnApprove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnApproveActionPerformed(evt);
            }
        });

        btnReject.setBackground(new java.awt.Color(204, 0, 0));
        btnReject.setFont(new java.awt.Font("Arial", 1, 16));
        btnReject.setForeground(new java.awt.Color(255, 255, 255));
        btnReject.setText("Reject Protocol");
        btnReject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRejectActionPerformed(evt);
            }
        });

        btnRefresh.setBackground(new java.awt.Color(0, 102, 102));
        btnRefresh.setFont(new java.awt.Font("Arial", 1, 14));
        btnRefresh.setForeground(new java.awt.Color(204, 255, 204));
        btnRefresh.setText("Refresh");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        btnBack.setBackground(new java.awt.Color(0, 102, 102));
        btnBack.setFont(new java.awt.Font("Arial", 1, 14));
        btnBack.setForeground(new java.awt.Color(204, 255, 204));
        btnBack.setText("<< Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1000, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnApprove, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnReject, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnRefresh))
                    .addComponent(btnBack))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnApprove, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnReject, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRefresh))
                .addGap(18, 18, 18)
                .addComponent(btnBack)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
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
