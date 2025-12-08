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
        jSplitPane1 = new javax.swing.JSplitPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblRecipients = new javax.swing.JTable();
        btnActivateForRecipient = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblDonors = new javax.swing.JTable();
        btnActivateForDonor = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new java.awt.GridBagLayout());
        java.awt.GridBagConstraints gbc = new java.awt.GridBagConstraints();
        
        lblTitle.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(0, 102, 102));
        lblTitle.setText("Emergency Protocol Activation");
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.insets = new java.awt.Insets(10, 10, 20, 10);
        add(lblTitle, gbc);

        jSplitPane1 = new javax.swing.JSplitPane();
        jSplitPane1.setDividerLocation(600);
        
        jPanel2 = new javax.swing.JPanel();
        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new java.awt.BorderLayout());
        
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18));
        jLabel1.setText("Recipients:");
        jPanel2.add(jLabel1, java.awt.BorderLayout.NORTH);
        
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
        jPanel2.add(jScrollPane1, java.awt.BorderLayout.CENTER);
        
        btnActivateForRecipient.setBackground(new java.awt.Color(204, 0, 0));
        btnActivateForRecipient.setFont(new java.awt.Font("Tahoma", 1, 14));
        btnActivateForRecipient.setForeground(new java.awt.Color(255, 255, 255));
        btnActivateForRecipient.setText("Activate Emergency for Selected Recipient");
        btnActivateForRecipient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActivateForRecipientActionPerformed(evt);
            }
        });
        jPanel2.add(btnActivateForRecipient, java.awt.BorderLayout.SOUTH);
        
        jSplitPane1.setLeftComponent(jPanel2);
        
        jPanel3 = new javax.swing.JPanel();
        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new java.awt.BorderLayout());
        
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18));
        jLabel2.setText("Donors:");
        jPanel3.add(jLabel2, java.awt.BorderLayout.NORTH);
        
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
        jPanel3.add(jScrollPane2, java.awt.BorderLayout.CENTER);
        
        btnActivateForDonor.setBackground(new java.awt.Color(204, 0, 0));
        btnActivateForDonor.setFont(new java.awt.Font("Tahoma", 1, 14));
        btnActivateForDonor.setForeground(new java.awt.Color(255, 255, 255));
        btnActivateForDonor.setText("Activate Emergency for Selected Donor");
        btnActivateForDonor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActivateForDonorActionPerformed(evt);
            }
        });
        jPanel3.add(btnActivateForDonor, java.awt.BorderLayout.SOUTH);
        
        jSplitPane1.setRightComponent(jPanel3);
        
        gbc.gridy = 1;
        gbc.gridx = 0;
        gbc.gridwidth = 2;
        gbc.fill = java.awt.GridBagConstraints.BOTH;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        add(jSplitPane1, gbc);

        btnBack.setText("<< Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        gbc.gridy = 2;
        gbc.gridx = 0;
        gbc.gridwidth = 1;
        gbc.anchor = java.awt.GridBagConstraints.SOUTHWEST;
        add(btnBack, gbc);
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
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    // End of variables declaration//GEN-END:variables}
}
