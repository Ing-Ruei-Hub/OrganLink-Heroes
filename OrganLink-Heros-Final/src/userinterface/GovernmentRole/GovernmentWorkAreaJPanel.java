/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package userinterface.GovernmentRole;
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
public class GovernmentWorkAreaJPanel extends javax.swing.JPanel{
     private JPanel userProcessContainer;
    private UserAccount account;
    private Organization organization;
    private Enterprise enterprise;
    private EcoSystem business;
    private Network network;

    public GovernmentWorkAreaJPanel(JPanel userProcessContainer, 
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
        
        lblWelcome.setText("Welcome, " + account.getEmployee().getName());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();
        lblWelcome = new javax.swing.JLabel();
        btnEmergencyReview = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new java.awt.GridBagLayout());
        java.awt.GridBagConstraints gbc = new java.awt.GridBagConstraints();

        lblTitle.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(0, 102, 102));
        lblTitle.setText("Government Official Work Area");
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.insets = new java.awt.Insets(10, 10, 10, 10);
        add(lblTitle, gbc);

        lblWelcome.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblWelcome.setText("Welcome, Government Official");
        gbc.gridy = 1;
        add(lblWelcome, gbc);

        btnEmergencyReview.setBackground(new java.awt.Color(204, 0, 0));
        btnEmergencyReview.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnEmergencyReview.setForeground(new java.awt.Color(255, 255, 255));
        btnEmergencyReview.setText("Emergency Protocol Review");
        btnEmergencyReview.setPreferredSize(new java.awt.Dimension(250, 40));
        btnEmergencyReview.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEmergencyReviewActionPerformed(evt);
            }
        });
        gbc.gridy = 2;
        gbc.insets = new java.awt.Insets(20, 10, 10, 10);
        add(btnEmergencyReview, gbc);

        btnBack.setText("<< Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        gbc.gridy = 3;
        gbc.anchor = java.awt.GridBagConstraints.SOUTHWEST;
        gbc.weighty = 1.0;
        add(btnBack, gbc);
    }// </editor-fold>//GEN-END:initComponents

    private void btnEmergencyReviewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEmergencyReviewActionPerformed
        GovernmentOfficialEmergencyReviewJPanel reviewPanel = new GovernmentOfficialEmergencyReviewJPanel(
            userProcessContainer, account, organization, enterprise, business);
        userProcessContainer.add("GovernmentEmergencyReview", reviewPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnEmergencyReviewActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnEmergencyReview;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblWelcome;
    // End of variables declaration//GEN-END:variables
}
