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
import Business.Organization.GovernmentOrganization;
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
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();
        btnActivateForRecipient = new javax.swing.JButton();
        btnActivateForDonor = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

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

        btnActivateForRecipient.setBackground(new java.awt.Color(204, 0, 0));
        btnActivateForRecipient.setFont(new java.awt.Font("Arial", 1, 18));
        btnActivateForRecipient.setForeground(new java.awt.Color(255, 255, 255));
        btnActivateForRecipient.setText("Activate Emergency for Recipient");
        btnActivateForRecipient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActivateForRecipientActionPerformed(evt);
            }
        });

        btnActivateForDonor.setBackground(new java.awt.Color(204, 0, 0));
        btnActivateForDonor.setFont(new java.awt.Font("Arial", 1, 18));
        btnActivateForDonor.setForeground(new java.awt.Color(255, 255, 255));
        btnActivateForDonor.setText("Activate Emergency for Donor");
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

        jLabel1.setFont(new java.awt.Font("Arial", 0, 16));
        jLabel1.setForeground(new java.awt.Color(204, 255, 204));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Activate emergency protocol for critical situations:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(340, 340, 340)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
                    .addComponent(btnActivateForRecipient, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnActivateForDonor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(340, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(btnBack)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(150, 150, 150)
                .addComponent(jLabel1)
                .addGap(50, 50, 50)
                .addComponent(btnActivateForRecipient, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(btnActivateForDonor, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 150, Short.MAX_VALUE)
                .addComponent(btnBack)
                .addGap(30, 30, 30))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnActivateForRecipientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActivateForRecipientActionPerformed
        String recipientName = JOptionPane.showInputDialog(this, "Enter Recipient Name:");
        if (recipientName == null || recipientName.trim().isEmpty()) {
            return;
        }
        
        String[] protocolTypes = {"Urgent Transplant", "Critical Condition", "Organ Failure", "Other"};
        String protocolType = (String) JOptionPane.showInputDialog(
            this,
            "Select Emergency Protocol Type:",
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
                    
                    Recipient tempRecipient = new Recipient(recipientName);
                    
                    EmergencyProtocolRequest emergencyRequest = new EmergencyProtocolRequest(
                        "EMG-REC-" + System.currentTimeMillis(),
                        account,
                        governmentReceiver,
                        reason,
                        protocolType,
                        null,
                        tempRecipient
                    );
                    
                    governmentOrg.getWorkQueue().addWorkRequest(emergencyRequest);
                    
                    JOptionPane.showMessageDialog(this, 
                        "Emergency Protocol Activated!\n" +
                        "Recipient: " + recipientName + "\n" +
                        "Type: " + protocolType + "\n" +
                        "Submitted to Government for approval.",
                        "Success",
                        JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "Government Organization not found or no government users!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_btnActivateForRecipientActionPerformed

    private void btnActivateForDonorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActivateForDonorActionPerformed
        String donorName = JOptionPane.showInputDialog(this, "Enter Donor Name:");
        if (donorName == null || donorName.trim().isEmpty()) {
            return;
        }
        
        String[] protocolTypes = {"Organ Quality Issue", "Medical Complication", "Critical Condition", "Other"};
        String protocolType = (String) JOptionPane.showInputDialog(
            this,
            "Select Emergency Protocol Type:",
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
                    
                    Donor tempDonor = new Donor(donorName);
                    
                    EmergencyProtocolRequest emergencyRequest = new EmergencyProtocolRequest(
                        "EMG-DON-" + System.currentTimeMillis(),
                        account,
                        governmentReceiver,
                        reason,
                        protocolType,
                        tempDonor,
                        null
                    );
                    
                    governmentOrg.getWorkQueue().addWorkRequest(emergencyRequest);
                    
                    JOptionPane.showMessageDialog(this, 
                        "Emergency Protocol Activated!\n" +
                        "Donor: " + donorName + "\n" +
                        "Type: " + protocolType + "\n" +
                        "Submitted to Government for approval.",
                        "Success",
                        JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "Government Organization not found or no government users!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_btnActivateForDonorActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed

    private Organization findGovernmentOrganization() {
    for (Network net : business.getNetworkList()) {
        for (Enterprise ent : net.getEnterpriseDirectory().getEnterpriseList()) {
            if (ent.getEnterpriseType() == Enterprise.EnterpriseType.Government) {
                for (Organization org : ent.getOrganizationDirectory().getOrganizationList()) {
                    if (org instanceof GovernmentOrganization) {
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblTitle;
    // End of variables declaration//GEN-END:variables
}
