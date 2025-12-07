/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package userinterface.InternationalRole;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.InternationalCollaborationRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

public class InternationalOfficerWorkAreaJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private UserAccount account;
    private Organization organization;
    private Enterprise enterprise;
    private EcoSystem business;
    private Network network; // Added Network instance variable

    public InternationalOfficerWorkAreaJPanel(JPanel userProcessContainer, 
                                              UserAccount account, 
                                              Organization organization, 
                                              Enterprise enterprise, 
                                              Network network, // Added Network parameter
                                              EcoSystem business) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.account = account;
        this.organization = organization;
        this.enterprise = enterprise;
        this.business = business;
        this.network = network; // Initialize Network
        
        lblWelcome.setText("Welcome, " + account.getEmployee().getName());
        populateRequestTable();
        updateStatistics();
    }
    
    private void populateRequestTable() {
        DefaultTableModel model = (DefaultTableModel) tblRequests.getModel();
        model.setRowCount(0);
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        
        for (WorkRequest request : organization.getWorkQueue().getWorkRequestList()) {
            if (request instanceof InternationalCollaborationRequest) {
                InternationalCollaborationRequest intlRequest = (InternationalCollaborationRequest) request;
                
                Object[] row = new Object[5];
                row[0] = intlRequest.getMessage();
                row[1] = intlRequest.getRecipient() != null ? intlRequest.getRecipient().getName() : "Unknown";
                row[2] = intlRequest.getOrganRequired();
                row[3] = intlRequest.getStatus();
                row[4] = dateFormat.format(intlRequest.getRequestDate());
                model.addRow(row);
            }
        }
    }
    
    private void updateStatistics() {
        int totalRequests = 0;
        int pendingRequests = 0;
        int matchesFound = 0;
        
        for (WorkRequest request : organization.getWorkQueue().getWorkRequestList()) {
            if (request instanceof InternationalCollaborationRequest) {
                InternationalCollaborationRequest intlRequest = (InternationalCollaborationRequest) request;
                totalRequests++;
                if (intlRequest.getStatus().equals("Pending International Review")) {
                    pendingRequests++;
                }
                if (intlRequest.isInternationalMatchFound()) {
                    matchesFound++;
                }
            }
        }
        
        lblTotalRequests.setText(String.valueOf(totalRequests));
        lblPendingRequests.setText(String.valueOf(pendingRequests));
        lblMatchesFound.setText(String.valueOf(matchesFound));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();
        lblWelcome = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        lblTotalRequests = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        lblPendingRequests = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        lblMatchesFound = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblRequests = new javax.swing.JTable();
        btnInitiateSearch = new javax.swing.JButton();
        btnMatchFound = new javax.swing.JButton();
        btnNoMatch = new javax.swing.JButton();
        btnRefresh = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();

        setBackground(new java.awt.Color(0, 153, 153));
        setMinimumSize(new java.awt.Dimension(1280, 720));
        setPreferredSize(new java.awt.Dimension(1280, 720));

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));

        lblTitle.setFont(new java.awt.Font("Arial", 1, 28));
        lblTitle.setForeground(new java.awt.Color(204, 255, 204));
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("International Collaboration Center");

        lblWelcome.setFont(new java.awt.Font("Arial", 0, 18));
        lblWelcome.setForeground(new java.awt.Color(204, 255, 204));
        lblWelcome.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblWelcome.setText("Welcome, International Officer");

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
                .addGap(15, 15, 15)
                .addComponent(lblTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblWelcome)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(0, 102, 102));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 255, 204), 2));

        jLabel2.setFont(new java.awt.Font("Arial", 0, 14));
        jLabel2.setForeground(new java.awt.Color(204, 255, 204));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Total Requests");

        lblTotalRequests.setFont(new java.awt.Font("Arial", 1, 36));
        lblTotalRequests.setForeground(new java.awt.Color(255, 255, 255));
        lblTotalRequests.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTotalRequests.setText("0");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
                    .addComponent(lblTotalRequests, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTotalRequests)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(0, 102, 102));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 255, 204), 2));

        jLabel4.setFont(new java.awt.Font("Arial", 0, 14));
        jLabel4.setForeground(new java.awt.Color(204, 255, 204));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Pending Review");

        lblPendingRequests.setFont(new java.awt.Font("Arial", 1, 36));
        lblPendingRequests.setForeground(new java.awt.Color(255, 255, 255));
        lblPendingRequests.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPendingRequests.setText("0");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
                    .addComponent(lblPendingRequests, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblPendingRequests)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(0, 102, 102));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 255, 204), 2));

        jLabel6.setFont(new java.awt.Font("Arial", 0, 14));
        jLabel6.setForeground(new java.awt.Color(204, 255, 204));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Matches Found");

        lblMatchesFound.setFont(new java.awt.Font("Arial", 1, 36));
        lblMatchesFound.setForeground(new java.awt.Color(255, 255, 255));
        lblMatchesFound.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMatchesFound.setText("0");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
                    .addComponent(lblMatchesFound, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblMatchesFound)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        tblRequests.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Request ID", "Patient Name", "Organ Required", "Status", "Request Date"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblRequests);

        btnInitiateSearch.setBackground(new java.awt.Color(0, 102, 102));
        btnInitiateSearch.setFont(new java.awt.Font("Arial", 1, 14));
        btnInitiateSearch.setForeground(new java.awt.Color(204, 255, 204));
        btnInitiateSearch.setText("Initiate International Search");
        btnInitiateSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInitiateSearchActionPerformed(evt);
            }
        });

        btnMatchFound.setBackground(new java.awt.Color(0, 102, 102));
        btnMatchFound.setFont(new java.awt.Font("Arial", 1, 14));
        btnMatchFound.setForeground(new java.awt.Color(204, 255, 204));
        btnMatchFound.setText("Match Found");
        btnMatchFound.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMatchFoundActionPerformed(evt);
            }
        });

        btnNoMatch.setBackground(new java.awt.Color(0, 102, 102));
        btnNoMatch.setFont(new java.awt.Font("Arial", 1, 14));
        btnNoMatch.setForeground(new java.awt.Color(204, 255, 204));
        btnNoMatch.setText("No Match Found");
        btnNoMatch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNoMatchActionPerformed(evt);
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
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnInitiateSearch)
                        .addGap(18, 18, 18)
                        .addComponent(btnMatchFound)
                        .addGap(18, 18, 18)
                        .addComponent(btnNoMatch)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnRefresh))
                    .addComponent(btnBack))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(30, 30, 30)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnInitiateSearch)
                    .addComponent(btnMatchFound)
                    .addComponent(btnNoMatch)
                    .addComponent(btnRefresh))
                .addGap(18, 18, 18)
                .addComponent(btnBack)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnInitiateSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInitiateSearchActionPerformed
        int selectedRow = tblRequests.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(this, "Please select a request to initiate search.", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        String requestId = (String) tblRequests.getValueAt(selectedRow, 0);
        
        for (WorkRequest request : organization.getWorkQueue().getWorkRequestList()) {
            if (request instanceof InternationalCollaborationRequest) {
                InternationalCollaborationRequest intlRequest = (InternationalCollaborationRequest) request;
                if (intlRequest.getMessage().equals(requestId)) {
                    intlRequest.setStatus("Searching Internationally");
                    JOptionPane.showMessageDialog(this, 
                        "International search initiated for:\n" +
                        "Patient: " + intlRequest.getRecipient().getName() + "\n" +
                        "Organ: " + intlRequest.getOrganRequired() + "\n" +
                        "Blood Type: " + intlRequest.getBloodType(),
                        "Search Initiated",
                        JOptionPane.INFORMATION_MESSAGE);
                    break;
                }
            }
        }
        
        populateRequestTable();
        updateStatistics();
    }//GEN-LAST:event_btnInitiateSearchActionPerformed

    private void btnMatchFoundActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMatchFoundActionPerformed
        int selectedRow = tblRequests.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(this, "Please select a request to mark as matched.", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        String requestId = (String) tblRequests.getValueAt(selectedRow, 0);
        
        String matchDetails = JOptionPane.showInputDialog(this, "Enter international match details (e.g., Donor country, hospital):");
        if (matchDetails != null && !matchDetails.trim().isEmpty()) {
            for (WorkRequest request : organization.getWorkQueue().getWorkRequestList()) {
                if (request instanceof InternationalCollaborationRequest) {
                    InternationalCollaborationRequest intlRequest = (InternationalCollaborationRequest) request;
                    if (intlRequest.getMessage().equals(requestId)) {
                        intlRequest.setStatus("International Match Found");
                        intlRequest.setInternationalMatchFound(true);
                        intlRequest.setInternationalMatchDetails(matchDetails);
                        JOptionPane.showMessageDialog(this, 
                            "Match found and recorded!\n" +
                            "Request: " + requestId + "\n" +
                            "Details: " + matchDetails,
                            "Success",
                            JOptionPane.INFORMATION_MESSAGE);
                        break;
                    }
                }
            }
        }
        
        populateRequestTable();
        updateStatistics();
    }//GEN-LAST:event_btnMatchFoundActionPerformed

    private void btnNoMatchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNoMatchActionPerformed
        int selectedRow = tblRequests.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(this, "Please select a request to close.", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        String requestId = (String) tblRequests.getValueAt(selectedRow, 0);
        
        for (WorkRequest request : organization.getWorkQueue().getWorkRequestList()) {
            if (request instanceof InternationalCollaborationRequest) {
                InternationalCollaborationRequest intlRequest = (InternationalCollaborationRequest) request;
                if (intlRequest.getMessage().equals(requestId)) {
                    intlRequest.setStatus("No International Match - Request Closed");
                    intlRequest.setInternationalMatchFound(false);
                    JOptionPane.showMessageDialog(this, 
                        "Request closed - No international match found\n" +
                        "Request: " + requestId,
                        "Request Closed",
                        JOptionPane.INFORMATION_MESSAGE);
                    break;
                }
            }
        }
        
        populateRequestTable();
        updateStatistics();
    }//GEN-LAST:event_btnNoMatchActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        populateRequestTable();
        updateStatistics();
        JOptionPane.showMessageDialog(this, "Data refreshed!", "Info", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnInitiateSearch;
    private javax.swing.JButton btnMatchFound;
    private javax.swing.JButton btnNoMatch;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblMatchesFound;
    private javax.swing.JLabel lblPendingRequests;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblTotalRequests;
    private javax.swing.JLabel lblWelcome;
    private javax.swing.JTable tblRequests;
    // End of variables declaration//GEN-END:variables
}