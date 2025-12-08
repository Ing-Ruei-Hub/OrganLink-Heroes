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
import java.awt.CardLayout;
import javax.swing.JPanel;

/**
 *
 * @author jim.hsieh
 */
public class DoctorWorkAreaJPanel extends javax.swing.JPanel {
    private JPanel userProcessContainer;
    private UserAccount account;
    private Organization organization;
    private Enterprise enterprise;
    private EcoSystem business;
    private Network network;

    public DoctorWorkAreaJPanel(JPanel userProcessContainer, 
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
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();
        lblWelcome = new javax.swing.JLabel();
        btnEmergencyProtocol = new javax.swing.JButton();
        btnVerifyTestResults = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new java.awt.GridBagLayout());
        java.awt.GridBagConstraints gbc = new java.awt.GridBagConstraints();
        
        lblTitle.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(0, 102, 102));
        lblTitle.setText("Doctor Work Area");
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.insets = new java.awt.Insets(10, 10, 10, 10);
        add(lblTitle, gbc);

        
        lblWelcome.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblWelcome.setText("Welcome, Dr. ");
        gbc.gridy = 1;
        add(lblWelcome, gbc);

        btnVerifyTestResults.setBackground(new java.awt.Color(0, 120, 102));
        btnVerifyTestResults.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnVerifyTestResults.setForeground(new java.awt.Color(255, 255, 255));
        btnVerifyTestResults.setText("Verify Test Results");
        btnVerifyTestResults.setPreferredSize(new java.awt.Dimension(250, 40));
        btnVerifyTestResults.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerifyTestResultsActionPerformed(evt);
            }
        });
        gbc.gridy = 2;
        gbc.insets = new java.awt.Insets(20, 10, 10, 10);
        add(btnVerifyTestResults, gbc);

        btnEmergencyProtocol.setBackground(new java.awt.Color(204, 0, 0));
        btnEmergencyProtocol.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnEmergencyProtocol.setForeground(new java.awt.Color(255, 255, 255));
        btnEmergencyProtocol.setText("Emergency Protocol Activation");
        btnEmergencyProtocol.setPreferredSize(new java.awt.Dimension(250, 40));
        btnEmergencyProtocol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEmergencyProtocolActionPerformed(evt);
            }
        });
        gbc.gridy = 3;
        add(btnEmergencyProtocol, gbc);

        btnBack.setText("<< Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        gbc.gridy = 4;
        gbc.anchor = java.awt.GridBagConstraints.SOUTHWEST;
        gbc.weighty = 1.0;
        add(btnBack, gbc);
    }
        
            private void btnEmergencyProtocolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEmergencyProtocolActionPerformed
                DoctorEmergencyProtocolJPanel emergencyPanel = new DoctorEmergencyProtocolJPanel(
                    userProcessContainer, account, organization, enterprise, business, network);
                userProcessContainer.add("DoctorEmergencyProtocol", emergencyPanel);
                CardLayout layout = (CardLayout) userProcessContainer.getLayout();
                layout.next(userProcessContainer);
            }//GEN-LAST:event_btnEmergencyProtocolActionPerformed
        
            private void btnVerifyTestResultsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerifyTestResultsActionPerformed
                DoctorTestVerificationJPanel testVerificationPanel = new DoctorTestVerificationJPanel(
                    userProcessContainer, account, organization, enterprise, business, network);
                userProcessContainer.add("DoctorTestVerification", testVerificationPanel);
                CardLayout layout = (CardLayout) userProcessContainer.getLayout();
                layout.next(userProcessContainer);
            }//GEN-LAST:event_btnVerifyTestResultsActionPerformed
        
            private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
                userProcessContainer.remove(this);
                CardLayout layout = (CardLayout) userProcessContainer.getLayout();
                layout.previous(userProcessContainer);
            }//GEN-LAST:event_btnBackActionPerformed
        
            // Variables declaration - do not modify//GEN-BEGIN:variables
            private javax.swing.JButton btnBack;
            private javax.swing.JButton btnEmergencyProtocol;
            private javax.swing.JButton btnVerifyTestResults;
            private javax.swing.JPanel jPanel1;
            private javax.swing.JLabel lblTitle;
            private javax.swing.JLabel lblWelcome;
            // End of variables declaration//GEN-END:variables

}
