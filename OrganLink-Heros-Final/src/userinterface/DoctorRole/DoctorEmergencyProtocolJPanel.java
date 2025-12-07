/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package userinterface.DoctorRole;
import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import Business.Donor.Donor;
import Business.Organization.DonorOrganization;
import Business.Organization.GovernmentOrganization;
import Business.Organization.RecipientOrganization;
import Business.Recipient.Recipient;
import Business.WorkQueue.EmergencyProtocolRequest;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author jim.hsieh
 */
public class DoctorEmergencyProtocolJPanel extends javax.swing.JPanel{
    private JPanel userProcessContainer;
    private UserAccount account;
    private Organization organization;
    private Enterprise enterprise;
    private EcoSystem business;
    private Network network;

    public DoctorEmergencyProtocolJPanel(JPanel userProcessContainer, 
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
        
        populateRecipientTable();
        populateDonorTable();
    }
    
    private void populateRecipientTable() {
        DefaultTableModel model = (DefaultTableModel) tblRecipients.getModel();
        model.setRowCount(0);
        
        // 遍历所有 RecipientOrganization 获取 Recipient 列表
        for (Network net : business.getNetworkList()) {
            for (Enterprise ent : net.getEnterpriseDirectory().getEnterpriseList()) {
                for (Organization org : ent.getOrganizationDirectory().getOrganizationList()) {
                    if (org instanceof RecipientOrganization) {
                        RecipientOrganization recOrg = (RecipientOrganization) org;
                        for (Recipient recipient : recOrg.getRecipientDirectory().getRecipientList()) {
                            Object[] row = new Object[4];
                            row[0] = recipient.getRecipientId();
                            row[1] = recipient.getName();
                            row[2] = recipient.getOrganNeeded();
                            row[3] = recipient.getBloodType();
                            model.addRow(row);
                        }
                    }
                }
            }
        }
    }
    
    private void populateDonorTable() {
        DefaultTableModel model = (DefaultTableModel) tblDonors.getModel();
        model.setRowCount(0);
        
        // 遍历所有 DonorOrganization 获取 Donor 列表
        for (Network net : business.getNetworkList()) {
            for (Enterprise ent : net.getEnterpriseDirectory().getEnterpriseList()) {
                for (Organization org : ent.getOrganizationDirectory().getOrganizationList()) {
                    if (org instanceof DonorOrganization) {
                        DonorOrganization donorOrg = (DonorOrganization) org;
                        for (Donor donor : donorOrg.getDonorDirectory().getDonorList()) {
                            Object[] row = new Object[4];
                            row[0] = donor.getDonorId();
                            row[1] = donor.getName();
                            row[2] = donor.getOrganToDonate();
                            row[3] = donor.getBloodType();
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
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblRecipients = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblDonors = new javax.swing.JTable();
        btnActivateForRecipient = new javax.swing.JButton();
        btnActivateForDonor = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();

        setBackground(new java.awt.Color(0, 153, 153));
        setMinimumSize(new java.awt.Dimension(1280, 720));
        setPreferredSize(new java.awt.Dimension(1280, 720));

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));

        lblTitle.setFont(new java.awt.Font("Arial", 1, 28));
        lblTitle.setForeground(new java.awt.Color(204, 255, 204));
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("Emergency Protocol Activation");

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

        jLabel1.setFont(new java.awt.Font("Arial", 1, 18));
        jLabel1.setForeground(new java.awt.Color(204, 255, 204));
        jLabel1.setText("Recipients:");

        tblRecipients.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Recipient ID", "Name", "Organ Needed", "Blood Type"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblRecipients);

        jLabel2.setFont(new java.awt.Font("Arial", 1, 18));
        jLabel2.setForeground(new java.awt.Color(204, 255, 204));
        jLabel2.setText("Donors:");

        tblDonors.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Donor ID", "Name", "Organ Offered", "Blood Type"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblDonors);

        btnActivateForRecipient.setBackground(new java.awt.Color(204, 0, 0));
        btnActivateForRecipient.setFont(new java.awt.Font("Arial", 1, 16));
        btnActivateForRecipient.setForeground(new java.awt.Color(255, 255, 255));
        btnActivateForRecipient.setText("Activate Emergency for Selected Recipient");
        btnActivateForRecipient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActivateForRecipientActionPerformed(evt);
            }
        });

        btnActivateForDonor.setBackground(new java.awt.Color(204, 0, 0));
        btnActivateForDonor.setFont(new java.awt.Font("Arial", 1, 16));
        btnActivateForDonor.setForeground(new java.awt.Color(255, 255, 255));
        btnActivateForDonor.setText("Activate Emergency for Selected Donor");
        btnActivateForDonor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActivateForDonorActionPerformed(evt);
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
                    .addComponent(jLabel1)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 550, Short.MAX_VALUE)
                    .addComponent(btnActivateForRecipient, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 550, Short.MAX_VALUE)
                    .addComponent(btnActivateForDonor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(btnBack)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnActivateForRecipient, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnActivateForDonor, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnBack)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnActivateForRecipientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActivateForRecipientActionPerformed
        int selectedRow = tblRecipients.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(this, "Please select a recipient from the table.", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        String recipientId = (String) tblRecipients.getValueAt(selectedRow, 0);
        String recipientName = (String) tblRecipients.getValueAt(selectedRow, 1);
        
        // 找到实际的 Recipient 对象
        Recipient selectedRecipient = findRecipientById(recipientId);
        
        if (selectedRecipient != null) {
            String[] protocolTypes = {"Urgent Transplant", "Critical Condition", "Organ Failure", "Other"};
            String protocolType = (String) JOptionPane.showInputDialog(
                this,
                "Select Emergency Protocol Type for " + recipientName + ":",
                "Emergency Protocol",
                JOptionPane.QUESTION_MESSAGE,
                null,
                protocolTypes,
                protocolTypes[0]
            );
            
            if (protocolType != null) {
                String reason = JOptionPane.showInputDialog(this, "Enter reason/justification:");
                if (reason != null && !reason.trim().isEmpty()) {
                    Organization governmentOrg = findGovernmentOrganization();
                    if (governmentOrg != null && governmentOrg.getUserAccountDirectory().getUserAccountList().size() > 0) {
                        UserAccount governmentReceiver = governmentOrg.getUserAccountDirectory().getUserAccountList().get(0);
                        
                        EmergencyProtocolRequest emergencyRequest = new EmergencyProtocolRequest(
                            "EMG-REC-" + recipientId,
                            account,
                            governmentReceiver,
                            reason,
                            protocolType,
                            null,
                            selectedRecipient
                        );
                        
                        governmentOrg.getWorkQueue().addWorkRequest(emergencyRequest);
                        
                        JOptionPane.showMessageDialog(this, 
                            "Emergency Protocol Activated!\n" +
                            "Recipient: " + recipientName + " (" + recipientId + ")\n" +
                            "Type: " + protocolType + "\n" +
                            "Submitted to Government for approval.",
                            "Success",
                            JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(this, "Government Organization not found!", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        }
    }//GEN-LAST:event_btnActivateForRecipientActionPerformed

    private void btnActivateForDonorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActivateForDonorActionPerformed
        int selectedRow = tblDonors.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(this, "Please select a donor from the table.", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        String donorId = (String) tblDonors.getValueAt(selectedRow, 0);
        String donorName = (String) tblDonors.getValueAt(selectedRow, 1);
        
        // 找到实际的 Donor 对象
        Donor selectedDonor = findDonorById(donorId);
        
        if (selectedDonor != null) {
            String[] protocolTypes = {"Organ Quality Issue", "Medical Complication", "Critical Condition", "Other"};
            String protocolType = (String) JOptionPane.showInputDialog(
                this,
                "Select Emergency Protocol Type for " + donorName + ":",
                "Emergency Protocol",
                JOptionPane.QUESTION_MESSAGE,
                null,
                protocolTypes,
                protocolTypes[0]
            );
            
            if (protocolType != null) {
                String reason = JOptionPane.showInputDialog(this, "Enter reason/justification:");
                if (reason != null && !reason.trim().isEmpty()) {
                    Organization governmentOrg = findGovernmentOrganization();
                    if (governmentOrg != null && governmentOrg.getUserAccountDirectory().getUserAccountList().size() > 0) {
                        UserAccount governmentReceiver = governmentOrg.getUserAccountDirectory().getUserAccountList().get(0);
                        
                        EmergencyProtocolRequest emergencyRequest = new EmergencyProtocolRequest(
                            "EMG-DON-" + donorId,
                            account,
                            governmentReceiver,
                            reason,
                            protocolType,
                            selectedDonor,
                            null
                        );
                        
                        governmentOrg.getWorkQueue().addWorkRequest(emergencyRequest);
                        
                        JOptionPane.showMessageDialog(this, 
                            "Emergency Protocol Activated!\n" +
                            "Donor: " + donorName + " (" + donorId + ")\n" +
                            "Type: " + protocolType + "\n" +
                            "Submitted to Government for approval.",
                            "Success",
                            JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(this, "Government Organization not found!", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        }
    }//GEN-LAST:event_btnActivateForDonorActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed

    private Recipient findRecipientById(String recipientId) {
        for (Network net : business.getNetworkList()) {
            for (Enterprise ent : net.getEnterpriseDirectory().getEnterpriseList()) {
                for (Organization org : ent.getOrganizationDirectory().getOrganizationList()) {
                    if (org instanceof RecipientOrganization) {
                        RecipientOrganization recOrg = (RecipientOrganization) org;
                        for (Recipient recipient : recOrg.getRecipientDirectory().getRecipientList()) {
                            if (recipient.getRecipientId().equals(recipientId)) {
                                return recipient;
                            }
                        }
                    }
                }
            }
        }
        return null;
    }
    
    private Donor findDonorById(String donorId) {
        for (Network net : business.getNetworkList()) {
            for (Enterprise ent : net.getEnterpriseDirectory().getEnterpriseList()) {
                for (Organization org : ent.getOrganizationDirectory().getOrganizationList()) {
                    if (org instanceof DonorOrganization) {
                        DonorOrganization donorOrg = (DonorOrganization) org;
                        for (Donor donor : donorOrg.getDonorDirectory().getDonorList()) {
                            if (donor.getDonorId().equals(donorId)) {
                                return donor;
                            }
                        }
                    }
                }
            }
        }
        return null;
    }
    
    private Organization findGovernmentOrganization() {
        for (Network net : business.getNetworkList()) {
            for (Enterprise ent : net.getEnterpriseDirectory().getEnterpriseList()) {
                if (ent.getEnterpriseType() == Enterprise.EnterpriseType.Government) {
                    for (Organization org : ent.getOrganizationDirectory().getOrganizationList()) {
                        if (org.getName().contains("Government")) {
                            return org;
                        }
                    }
                }
            }
        }
        return null;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActivateForDonor;
    private javax.swing.JButton btnActivateForRecipient;
    private javax.swing.JButton btnBack;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTable tblDonors;
    private javax.swing.JTable tblRecipients;
    // End of variables declaration//GEN-END:variables}
}