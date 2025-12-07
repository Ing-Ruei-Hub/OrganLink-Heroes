/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package userinterface.SystemAdminWorkArea;
import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.WorkQueue.EmergencyProtocolRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import java.text.SimpleDateFormat;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author jim.hsieh
 */
public class SystemAdminEmergencyMonitorJPanel extends javax.swing.JPanel{
    private JPanel userProcessContainer;
    private EcoSystem business;

    public SystemAdminEmergencyMonitorJPanel(JPanel userProcessContainer, EcoSystem business) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.business = business;
        
        populateTable();
    }
    
    private void populateTable() {
        DefaultTableModel model = (DefaultTableModel) tblEmergencyProtocols.getModel();
        model.setRowCount(0);
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        
        // 遍历所有 Network, Enterprise, Organization 寻找 Emergency Protocols
        for (Network network : business.getNetworkList()) {
            for (Enterprise enterprise : network.getEnterpriseDirectory().getEnterpriseList()) {
                for (Organization org : enterprise.getOrganizationDirectory().getOrganizationList()) {
                    for (WorkRequest request : org.getWorkQueue().getWorkRequestList()) {
                        if (request instanceof EmergencyProtocolRequest) {
                            EmergencyProtocolRequest emergency = (EmergencyProtocolRequest) request;
                            
                            Object[] row = new Object[6];
                            row[0] = emergency.getMessage();
                            row[1] = emergency.getProtocolType();
                            row[2] = emergency.getSender().getEmployee().getName();
                            row[3] = emergency.getStatus();
                            row[4] = emergency.isIsApprovedByGovernment() ? "Yes" : "No";
                            row[5] = dateFormat.format(emergency.getRequestDate());
                            model.addRow(row);
                        }
                    }
                }
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
        btnRefresh = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(0, 153, 153));
        setMinimumSize(new java.awt.Dimension(1280, 720));
        setPreferredSize(new java.awt.Dimension(1280, 720));

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));

        lblTitle.setFont(new java.awt.Font("Arial", 1, 28));
        lblTitle.setForeground(new java.awt.Color(204, 255, 204));
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("System Admin - Emergency Protocol Monitor");

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
                "Request ID", "Protocol Type", "Activated By", "Status", "Gov Approved", "Activation Time"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblEmergencyProtocols);

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

        jLabel1.setFont(new java.awt.Font("Arial", 0, 16));
        jLabel1.setForeground(new java.awt.Color(204, 255, 204));
        jLabel1.setText("View all emergency protocols across the entire system (read-only monitoring):");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1000, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnBack)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnRefresh)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBack)
                    .addComponent(btnRefresh))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        populateTable();
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTable tblEmergencyProtocols;
    // End of variables declaration//GEN-END:variables
}
