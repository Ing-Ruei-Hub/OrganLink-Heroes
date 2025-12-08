
package userinterface.SystemAdminWorkArea;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.Organization;
import java.awt.CardLayout;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

/**
 *
 * @author rrheg
 */
public class SystemAdminWorkAreaJPanel extends JPanel {

    /**
     * Creates new form SystemAdminWorkAreaJPanel
     */
    JPanel userProcessContainer;
    EcoSystem ecosystem;

    public SystemAdminWorkAreaJPanel(JPanel userProcessContainer, EcoSystem ecosystem) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.ecosystem = ecosystem;
        populateTree();
    }

    public void populateTree() {
        
        DefaultTreeModel model = (DefaultTreeModel) jTree.getModel();
        
        ArrayList<Network> networkList = ecosystem.getNetworkList();
        ArrayList<Enterprise> enterpriseList;
        ArrayList<Organization> organizationList;
        
        DefaultMutableTreeNode networks = new DefaultMutableTreeNode("Networks");
        DefaultMutableTreeNode root = (DefaultMutableTreeNode) model.getRoot();
        root.removeAllChildren();
        root.insert(networks, 0);
        
        DefaultMutableTreeNode networkNode;
        DefaultMutableTreeNode enterpriseNode;
        DefaultMutableTreeNode organizationNode;
        
        for (int i = 0; i < networkList.size(); i++) {
            Network network = networkList.get(i);
            networkNode = new DefaultMutableTreeNode(network.getName());
            networks.insert(networkNode, i);
            
            enterpriseList = network.getEnterpriseDirectory().getEnterpriseList();
            for (int j = 0; j < enterpriseList.size(); j++) {
                Enterprise enterprise = enterpriseList.get(j);
                enterpriseNode = new DefaultMutableTreeNode(enterprise.getName());
                networkNode.insert(enterpriseNode, j);
                
                organizationList = enterprise.getOrganizationDirectory().getOrganizationList();
                for (int k = 0; k < organizationList.size(); k++) {
                    Organization organization = organizationList.get(k);
                    organizationNode = new DefaultMutableTreeNode(organization.getName());
                    enterpriseNode.insert(organizationNode, k);
                }
            }
        }
        
        model.reload();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSplitPane = new javax.swing.JSplitPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTree = new javax.swing.JTree();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblSelectedNode = new javax.swing.JLabel();
        btnManageNetwork = new javax.swing.JButton();
        btnManageEnterprise = new javax.swing.JButton();
        btnManageAdmin = new javax.swing.JButton();
        btnMonitorEmergency = new javax.swing.JButton();

        setLayout(new java.awt.BorderLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new java.awt.BorderLayout());

        jTree.addTreeSelectionListener(new javax.swing.event.TreeSelectionListener() {
            public void valueChanged(javax.swing.event.TreeSelectionEvent evt) {
                jTreeValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(jTree);
        jPanel1.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jSplitPane.setLeftComponent(jPanel1);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        java.awt.GridBagLayout jPanel2Layout = new java.awt.GridBagLayout();
        jPanel2Layout.columnWidths = new int[] {0, 5, 0, 5, 0, 5, 0};
        jPanel2Layout.rowHeights = new int[] {0, 5, 0, 5, 0, 5, 0, 5, 0};
        jPanel2.setLayout(jPanel2Layout);

        jLabel1.setText("Selected Node:");
        java.awt.GridBagConstraints gbc = new java.awt.GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = java.awt.GridBagConstraints.WEST;
        gbc.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel2.add(jLabel1, gbc);

        lblSelectedNode.setText("<View_selected_node>");
        gbc = new java.awt.GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.anchor = java.awt.GridBagConstraints.WEST;
        gbc.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel2.add(lblSelectedNode, gbc);

        btnManageNetwork.setText("Manage Network");
        btnManageNetwork.setBackground(new java.awt.Color(0, 120, 102));
        btnManageNetwork.setForeground(java.awt.Color.WHITE);
        btnManageNetwork.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManageNetworkActionPerformed(evt);
            }
        });
        gbc = new java.awt.GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gbc.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel2.add(btnManageNetwork, gbc);

        btnManageEnterprise.setText("Manage Enterprise");
        btnManageEnterprise.setBackground(new java.awt.Color(0, 120, 102));
        btnManageEnterprise.setForeground(java.awt.Color.WHITE);
        btnManageEnterprise.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManageEnterpriseActionPerformed(evt);
            }
        });
        gbc = new java.awt.GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 2;
        gbc.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gbc.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel2.add(btnManageEnterprise, gbc);

        btnManageAdmin.setText("Manage Enterprise Admin");
        btnManageAdmin.setBackground(new java.awt.Color(0, 120, 102));
        btnManageAdmin.setForeground(java.awt.Color.WHITE);
        btnManageAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManageAdminActionPerformed(evt);
            }
        });
        gbc = new java.awt.GridBagConstraints();
        gbc.gridx = 4;
        gbc.gridy = 2;
        gbc.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gbc.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel2.add(btnManageAdmin, gbc);

        btnMonitorEmergency.setBackground(new java.awt.Color(204, 0, 0));
        btnMonitorEmergency.setFont(new java.awt.Font("Arial", 1, 14));
        btnMonitorEmergency.setForeground(new java.awt.Color(255, 255, 255));
        btnMonitorEmergency.setText("Monitor Emergency Protocols");
        btnMonitorEmergency.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMonitorEmergencyActionPerformed(evt);
            }
        });
        gbc = new java.awt.GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 5;
        gbc.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gbc.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel2.add(btnMonitorEmergency, gbc);

        jSplitPane.setRightComponent(jPanel2);
        
        javax.swing.JLabel titleLabel = new javax.swing.JLabel("System Admin Work Area");
        titleLabel.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        titleLabel.setForeground(new java.awt.Color(0, 102, 102));
        titleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        
        JPanel titlePanel = new JPanel(new java.awt.BorderLayout());
        titlePanel.add(titleLabel, java.awt.BorderLayout.CENTER);
        
        add(titlePanel, java.awt.BorderLayout.NORTH);
        add(jSplitPane, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents// </editor-fold>//GEN-END:initComponents

    private void btnManageNetworkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManageNetworkActionPerformed
        ManageNetworkJPanel manageNetworkJPanel = new ManageNetworkJPanel(userProcessContainer, ecosystem);
        userProcessContainer.add("manageNetworkJPanel", manageNetworkJPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnManageNetworkActionPerformed

    private void btnManageEnterpriseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManageEnterpriseActionPerformed
        ManageEnterpriseJPanel manageEnterpriseJPanel = new ManageEnterpriseJPanel(userProcessContainer, ecosystem);
        userProcessContainer.add("manageEnterpriseJPanel", manageEnterpriseJPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnManageEnterpriseActionPerformed

    private void btnManageAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManageAdminActionPerformed
        ManageEnterpriseAdminJPanel manageEnterpriseAdminJPanel = new ManageEnterpriseAdminJPanel(userProcessContainer, ecosystem);
        userProcessContainer.add("manageEnterpriseAdminJPanel", manageEnterpriseAdminJPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnManageAdminActionPerformed

    private void btnMonitorEmergencyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMonitorEmergencyActionPerformed
        SystemAdminEmergencyMonitorJPanel monitorPanel = new SystemAdminEmergencyMonitorJPanel(userProcessContainer, ecosystem);
        userProcessContainer.add("SystemAdminEmergencyMonitor", monitorPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnMonitorEmergencyActionPerformed

    private void jTreeValueChanged(javax.swing.event.TreeSelectionEvent evt) {//GEN-FIRST:event_jTreeValueChanged
        DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) jTree.getLastSelectedPathComponent();
        if (selectedNode != null) {
            lblSelectedNode.setText(selectedNode.toString());
        }
    }//GEN-LAST:event_jTreeValueChanged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnManageAdmin;
    private javax.swing.JButton btnManageEnterprise;
    private javax.swing.JButton btnManageNetwork;
    private javax.swing.JButton btnMonitorEmergency;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSplitPane jSplitPane;
    private javax.swing.JTree jTree;
    private javax.swing.JLabel lblSelectedNode;
    // End of variables declaration//GEN-END:variables
}
