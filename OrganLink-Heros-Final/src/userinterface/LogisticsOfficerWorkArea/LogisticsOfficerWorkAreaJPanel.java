/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package userinterface.LogisticsOfficerWorkArea;

import Business.EcoSystem;
import Business.Enterprise.*;
import Business.Logistics.LogisticsTeam;
import Business.Logistics.TransportVehicle;
import Business.Network.Network;
import Business.Organization.*;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.OrganTransportRequest;
import Business.WorkQueue.WorkRequest;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import java.util.Date;

/**
 *
 * @author eric
 */
public class LogisticsOfficerWorkAreaJPanel extends javax.swing.JPanel {

    /**
     * Creates new form LogisticsOfficerWorkAreaJPanel
     */
    
    private JPanel userProcessContainer;
    private UserAccount userAccount;
    private LogisticsOrganization logisticsOrganization;
    private Enterprise enterprise;
    private EcoSystem business;
    private ArrayList<TransportVehicle> vehicleList = new ArrayList<>();
    private ArrayList<LogisticsTeam> teamList = new ArrayList<>();
    
    public LogisticsOfficerWorkAreaJPanel(JPanel userProcessContainer, UserAccount account,
            LogisticsOrganization organization, Enterprise enterprise, EcoSystem business) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.userAccount = account;
        this.logisticsOrganization = organization;
        this.enterprise = enterprise;
        this.business = business;
        
        // Initialize the panel
        populateTable();
        populateVehicleComboBox();
        populateTeamComboBox();
    }

    // Populate the table with pending transport requests from ALL organizations across the system
    private void populateTable() {
        DefaultTableModel model = (DefaultTableModel) tblTransportRequests.getModel();
        model.setRowCount(0); // Clear existing rows

        // Search through all networks, enterprises, and organizations for OrganTransportRequests
        for (Network network : business.getNetworkList()) {
            for (Enterprise ent : network.getEnterpriseDirectory().getEnterpriseList()) {
                for (Organization org : ent.getOrganizationDirectory().getOrganizationList()) {
                    for (WorkRequest request : org.getWorkQueue().getWorkRequestList()) {
                        if (request instanceof OrganTransportRequest) {
                            OrganTransportRequest transportRequest = (OrganTransportRequest) request;
                            
                            // Show all logistics-related requests (including delivered)
                            String status = transportRequest.getStatus();
                            if (status.equals("Pending Logistics Assignment") || 
                                status.equals("Assigned, In Transit") ||
                                status.equals("Delivered")) {
                                
                                String donorName = transportRequest.getDonor() != null ? 
                                        transportRequest.getDonor().getName() : "N/A";
                                String recipientName = transportRequest.getRecipient() != null ? 
                                        transportRequest.getRecipient().getName() : "N/A";
                                
                                Object[] row = new Object[7];
                                row[0] = transportRequest;
                                row[1] = donorName;
                                row[2] = recipientName;
                                row[3] = transportRequest.getPickupLocation();
                                row[4] = transportRequest.getDeliveryLocation();
                                row[5] = transportRequest.getUrgency();
                                row[6] = status;
                                
                                model.addRow(row);
                            }
                        }
                    }
                }
            }
        }
    }

    // Populate vehicle combo box with available vehicles
    private void populateVehicleComboBox() {
        cmbVehicles.removeAllItems();
        vehicleList.clear();
    
        cmbVehicles.addItem("-- Select Vehicle --");
        vehicleList.add(null); // Index 0 maps to null (no selection)
    
        ArrayList<TransportVehicle> availableVehicles = logisticsOrganization.getVehicleDirectory().getAvailableVehicles();
        for (TransportVehicle vehicle : availableVehicles) {
            cmbVehicles.addItem(vehicle.toString()); // Add display string to combo box
            vehicleList.add(vehicle); // Add object reference to mapping list
        }
    }

    // Populate team combo box with available teams
    private void populateTeamComboBox() {
        cmbTeams.removeAllItems();
        teamList.clear();
    
        cmbTeams.addItem("-- Select Team --");
        teamList.add(null); // Index 0 maps to null (no selection)
    
        ArrayList<LogisticsTeam> availableTeams = logisticsOrganization.getTeamDirectory().getAvailableTeams();
        for (LogisticsTeam team : availableTeams) {
            cmbTeams.addItem(team.toString()); // Add display string to combo box
            teamList.add(team); // Add object reference to mapping list
        }
    }
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTransportRequests = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        cmbVehicles = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        cmbTeams = new javax.swing.JComboBox<>();
        btnViewDetails = new javax.swing.JButton();
        btnAssign = new javax.swing.JButton();
        btnMarkDelivered = new javax.swing.JButton();
        btnRefresh = new javax.swing.JButton();
        pnlDetails = new javax.swing.JPanel();
        lblDetailsTitle = new javax.swing.JLabel();
        lblDonorInfo = new javax.swing.JLabel();
        lblRecipientInfo = new javax.swing.JLabel();
        lblRouteInfo = new javax.swing.JLabel();
        lblAssignedInfo = new javax.swing.JLabel();

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 1, 24)); // NOI18N
        jLabel1.setText("Logistics Officer Work Area");

        tblTransportRequests.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Request", "Donor", "Recipient", "Pickup", "Delivery", "Urgency", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblTransportRequests);

        jLabel2.setText("Select Vehicle:");

        cmbVehicles.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel3.setText("Select Team:");

        cmbTeams.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnViewDetails.setText("View Details");
        btnViewDetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewDetailsActionPerformed(evt);
            }
        });

        btnAssign.setText("Assign Resources");
        btnAssign.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAssignActionPerformed(evt);
            }
        });

        btnMarkDelivered.setText("Mark as Delivered");
        btnMarkDelivered.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMarkDeliveredActionPerformed(evt);
            }
        });

        btnRefresh.setText("Refresh");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        pnlDetails.setBackground(new java.awt.Color(204, 255, 255));
        pnlDetails.setLayout(new java.awt.GridLayout(5, 1));

        lblDetailsTitle.setText("Select a request to view details");
        lblDetailsTitle.setToolTipText("");
        pnlDetails.add(lblDetailsTitle);

        lblDonorInfo.setText("Donor: ");
        pnlDetails.add(lblDonorInfo);

        lblRecipientInfo.setText("Recipient: ");
        pnlDetails.add(lblRecipientInfo);

        lblRouteInfo.setText("Route: ");
        pnlDetails.add(lblRouteInfo);

        lblAssignedInfo.setText("Assigned: ");
        pnlDetails.add(lblAssignedInfo);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 721, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbVehicles, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(56, 56, 56))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnViewDetails, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnAssign, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(cmbTeams, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(44, 44, 44)
                                .addComponent(btnMarkDelivered, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(49, 49, 49)
                                .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(269, 269, 269)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(89, 89, 89)
                        .addComponent(pnlDetails, javax.swing.GroupLayout.PREFERRED_SIZE, 648, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(123, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel1)
                .addGap(46, 46, 46)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cmbVehicles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(cmbTeams, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnViewDetails)
                    .addComponent(btnAssign)
                    .addComponent(btnMarkDelivered)
                    .addComponent(btnRefresh))
                .addGap(39, 39, 39)
                .addComponent(pnlDetails, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(69, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAssignActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAssignActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblTransportRequests.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(this, "Please select a transport request first.", 
                    "No Selection", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        // Check if vehicle is selected
        if (cmbVehicles.getSelectedIndex() <= 0) {
            JOptionPane.showMessageDialog(this, "Please select a vehicle.", 
                    "No Vehicle Selected", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        // Check if team is selected
        if (cmbTeams.getSelectedIndex() <= 0) {
            JOptionPane.showMessageDialog(this, "Please select a team.", 
                    "No Team Selected", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        OrganTransportRequest request = (OrganTransportRequest) tblTransportRequests.getValueAt(selectedRow, 0);
        
        // Check if already assigned
        if (request.getStatus().equals("Assigned, In Transit")) {
            JOptionPane.showMessageDialog(this, "This request has already been assigned.", 
                    "Already Assigned", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        if (request.getStatus().equals("Delivered")) {
            JOptionPane.showMessageDialog(this, "This request has already been delivered. No further changes allowed.", 
                    "Already Delivered", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        int vehicleIndex = cmbVehicles.getSelectedIndex();
        int teamIndex = cmbTeams.getSelectedIndex();
        TransportVehicle selectedVehicle = vehicleList.get(vehicleIndex);
        LogisticsTeam selectedTeam = teamList.get(teamIndex);
        
        // Assign resources to the request
        request.setAssignedVehicle(selectedVehicle.toString());
        request.setAssignedTeam(selectedTeam.toString());
        request.setStatus("Assigned, In Transit");
        request.setReceiver(userAccount);
        
        // Update vehicle and team availability
        selectedVehicle.setIsAvailable(false);
        selectedVehicle.setCurrentStatus("In Transit");
        
        selectedTeam.setIsAvailable(false);
        selectedTeam.setCurrentAssignment("Transport: " + request.getDonor().getName() + " → " + request.getRecipient().getName());
        
        JOptionPane.showMessageDialog(this, 
                "Resources assigned successfully!\n" +
                "Vehicle: " + selectedVehicle.toString() + "\n" +
                "Team: " + selectedTeam.toString(), 
                "Assignment Complete", JOptionPane.INFORMATION_MESSAGE);
        
        // Refresh the UI
        populateTable();
        populateVehicleComboBox();
        populateTeamComboBox();
        btnViewDetailsActionPerformed(evt);
        
    }//GEN-LAST:event_btnAssignActionPerformed

    private void btnViewDetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewDetailsActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblTransportRequests.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(this, "Please select a transport request first.", 
                    "No Selection", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        OrganTransportRequest request = (OrganTransportRequest) tblTransportRequests.getValueAt(selectedRow, 0);
        
        // Update details panel
        lblDetailsTitle.setText("Transport Request Details");
        
        String donorInfo = "N/A";
        if (request.getDonor() != null) {
            donorInfo = request.getDonor().getName() + " (Blood Type: " + 
                    request.getDonor().getBloodType() + ", Organ: " + 
                    request.getDonor().getOrganToDonate() + ")";
        }
        lblDonorInfo.setText("Donor: " + donorInfo);
        
        String recipientInfo = "N/A";
        if (request.getRecipient() != null) {
            recipientInfo = request.getRecipient().getName() + " (Blood Type: " + 
                    request.getRecipient().getBloodType() + ", Needs: " + 
                    request.getRecipient().getOrganNeeded() + ")";
        }
        lblRecipientInfo.setText("Recipient: " + recipientInfo);
        
        lblRouteInfo.setText("Route: " + request.getPickupLocation() + " → " + request.getDeliveryLocation());
        
        String assignedInfo = "Not yet assigned";
        if (request.getAssignedVehicle() != null && !request.getAssignedVehicle().isEmpty()) {
            assignedInfo = "Vehicle: " + request.getAssignedVehicle() + ", Team: " + request.getAssignedTeam();
        }
        lblAssignedInfo.setText("Assigned: " + assignedInfo);
        
    }//GEN-LAST:event_btnViewDetailsActionPerformed

    private void btnMarkDeliveredActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMarkDeliveredActionPerformed
        // TODO add your handling code here:
        
        int selectedRow = tblTransportRequests.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(this, "Please select a transport request first.", 
                    "No Selection", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        OrganTransportRequest request = (OrganTransportRequest) tblTransportRequests.getValueAt(selectedRow, 0);
        
        // Check if the request is in transit
        if (!request.getStatus().equals("Assigned, In Transit")) {
            JOptionPane.showMessageDialog(this, "Only requests that are 'In Transit' can be marked as delivered.", 
                    "Invalid Status", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        if (request.getStatus().equals("Delivered")) {
            JOptionPane.showMessageDialog(this, "This request has already been delivered. No further changes allowed.", 
                    "Already Delivered", JOptionPane.WARNING_MESSAGE);
            return;
        }   
        
        int confirm = JOptionPane.showConfirmDialog(this, 
                "Mark this transport as delivered?\n" +
                "Donor: " + request.getDonor().getName() + "\n" +
                "Recipient: " + request.getRecipient().getName(), 
                "Confirm Delivery", JOptionPane.YES_NO_OPTION);
        
        if (confirm == JOptionPane.YES_OPTION) {
            // Update request status
            request.setStatus("Delivered");
            request.setResolveDate(new Date());
            
            // Release the vehicle and team
            String vehicleInfo = request.getAssignedVehicle();
            String teamInfo = request.getAssignedTeam();
            
            // Find and release vehicle
            for (TransportVehicle v : logisticsOrganization.getVehicleDirectory().getVehicleList()) {
                if (v.toString().equals(vehicleInfo)) {
                    v.setIsAvailable(true);
                    v.setCurrentStatus("Parked");
                    break;
                }
            }
            
            // Find and release team
            for (LogisticsTeam t : logisticsOrganization.getTeamDirectory().getTeamList()) {
                if (t.toString().equals(teamInfo)) {
                    t.setIsAvailable(true);
                    t.setCurrentAssignment("None");
                    break;
                }
            }
            
            JOptionPane.showMessageDialog(this, "Transport marked as delivered successfully!", 
                    "Delivery Complete", JOptionPane.INFORMATION_MESSAGE);
            
            // Refresh UI
            populateTable();
            populateVehicleComboBox();
            populateTeamComboBox();
        }
    }//GEN-LAST:event_btnMarkDeliveredActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        // TODO add your handling code here:
        populateTable();
        populateVehicleComboBox();
        populateTeamComboBox();
        
        // Reset details panel
        lblDetailsTitle.setText("Select a request to view details");
        lblDonorInfo.setText("Donor: ");
        lblRecipientInfo.setText("Recipient: ");
        lblRouteInfo.setText("Route: ");
        lblAssignedInfo.setText("Assigned: ");
    }//GEN-LAST:event_btnRefreshActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAssign;
    private javax.swing.JButton btnMarkDelivered;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnViewDetails;
    private javax.swing.JComboBox<String> cmbTeams;
    private javax.swing.JComboBox<String> cmbVehicles;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAssignedInfo;
    private javax.swing.JLabel lblDetailsTitle;
    private javax.swing.JLabel lblDonorInfo;
    private javax.swing.JLabel lblRecipientInfo;
    private javax.swing.JLabel lblRouteInfo;
    private javax.swing.JPanel pnlDetails;
    private javax.swing.JTable tblTransportRequests;
    // End of variables declaration//GEN-END:variables
}
