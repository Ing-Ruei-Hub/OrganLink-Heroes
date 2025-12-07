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
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();
        lblWelcome = new javax.swing.JLabel();
        btnEmergencyReview = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();

        setBackground(new java.awt.Color(0, 153, 153));
        setMinimumSize(new java.awt.Dimension(1280, 720));
        setPreferredSize(new java.awt.Dimension(1280, 720));

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));

        lblTitle.setFont(new java.awt.Font("Arial", 1, 28));
        lblTitle.setForeground(new java.awt.Color(204, 255, 204));
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("Government Official Work Area");

        lblWelcome.setFont(new java.awt.Font("Arial", 0, 18));
        lblWelcome.setForeground(new java.awt.Color(204, 255, 204));
        lblWelcome.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblWelcome.setText("Welcome, Government Official");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTitle, javax.swing.GroupLayout.DEFAULT_SIZE, 1280, Short.MAX_VALUE)
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

        btnEmergencyReview.setBackground(new java.awt.Color(204, 0, 0));
        btnEmergencyReview.setFont(new java.awt.Font("Arial", 1, 20));
        btnEmergencyReview.setForeground(new java.awt.Color(255, 255, 255));
        btnEmergencyReview.setText("Emergency Protocol Review");
        btnEmergencyReview.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEmergencyReviewActionPerformed(evt);
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
                .addGap(440, 440, 440)
                .addComponent(btnEmergencyReview, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addGap(150, 150, 150)
                .addComponent(btnEmergencyReview, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 250, Short.MAX_VALUE)
                .addComponent(btnBack)
                .addGap(30, 30, 30))
        );
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
