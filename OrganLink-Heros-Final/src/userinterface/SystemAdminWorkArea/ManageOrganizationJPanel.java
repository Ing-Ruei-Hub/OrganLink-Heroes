
package userinterface.SystemAdminWorkArea;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.Organization.Organization.Type;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

public class ManageOrganizationJPanel extends JPanel {

    private JPanel userProcessContainer;
    private EcoSystem system;

    public ManageOrganizationJPanel(JPanel userProcessContainer, EcoSystem system) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.system = system;

        populateEnterpriseComboBox();
        populateOrganizationTypeComboBox();
    }

    private void populateEnterpriseComboBox() {
        enterpriseJComboBox.removeAllItems();
        for (Network network : system.getNetworkList()) {
            for (Enterprise enterprise : network.getEnterpriseDirectory().getEnterpriseList()) {
                enterpriseJComboBox.addItem(enterprise);
            }
        }
    }

    private void populateOrganizationTypeComboBox() {
        organizationTypeJComboBox.removeAllItems();
        for (Type type : Organization.Type.values()) {
            if (!type.getValue().equals(Type.Admin.getValue())) {
                organizationTypeJComboBox.addItem(type);
            }
        }
    }

    private void populateTable() {
        DefaultTableModel model = (DefaultTableModel) organizationJTable.getModel();
        model.setRowCount(0);
        Enterprise enterprise = (Enterprise) enterpriseJComboBox.getSelectedItem();
        if (enterprise != null) {
            for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
                Object[] row = new Object[2];
                row[0] = organization.getOrganizationID();
                row[1] = organization; // toString will be called
                model.addRow(row);
            }
        }
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        jScrollPane1 = new javax.swing.JScrollPane();
        organizationJTable = new javax.swing.JTable();
        enterpriseJComboBox = new javax.swing.JComboBox();
        organizationTypeJComboBox = new javax.swing.JComboBox();
        addJButton = new javax.swing.JButton();
        deleteJButton = new javax.swing.JButton();
        backJButton = new javax.swing.JButton();
        
        javax.swing.JLabel titleLabel = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new java.awt.GridBagLayout());
        java.awt.GridBagConstraints gbc = new java.awt.GridBagConstraints();

        titleLabel.setFont(new java.awt.Font("Tahoma", 1, 24));
        titleLabel.setForeground(new java.awt.Color(0, 102, 102));
        titleLabel.setText("Manage Organization");
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.insets = new java.awt.Insets(10, 10, 20, 10);
        add(titleLabel, gbc);

        organizationJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {},
            new String [] {
                "ID", "Name"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(organizationJTable);
        gbc.gridy = 1;
        gbc.gridx = 0;
        gbc.gridwidth = 2;
        gbc.fill = java.awt.GridBagConstraints.BOTH;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.insets = new java.awt.Insets(10, 10, 10, 10);
        add(jScrollPane1, gbc);

        JPanel formPanel = new JPanel(new java.awt.GridBagLayout());
        java.awt.GridBagConstraints formGbc = new java.awt.GridBagConstraints();
        formGbc.anchor = java.awt.GridBagConstraints.WEST;
        formGbc.insets = new java.awt.Insets(5, 5, 5, 5);

        formGbc.gridx = 0;
        formGbc.gridy = 0;
        formPanel.add(new javax.swing.JLabel("Enterprise"), formGbc);
        formGbc.gridx = 1;
        enterpriseJComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enterpriseJComboBoxActionPerformed(evt);
            }
        });
        formPanel.add(enterpriseJComboBox, formGbc);

        formGbc.gridy = 1;
        formGbc.gridx = 0;
        formPanel.add(new javax.swing.JLabel("Organization Type"), formGbc);
        formGbc.gridx = 1;
        formPanel.add(organizationTypeJComboBox, formGbc);
        
        gbc.gridy = 2;
        gbc.gridx = 0;
        gbc.gridwidth = 2;
        gbc.weighty = 0;
        add(formPanel, gbc);
        
        JPanel buttonPanel = new JPanel(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 10, 10));
        addJButton.setText("Add Organization");
        addJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addJButtonActionPerformed(evt);
            }
        });
        buttonPanel.add(addJButton);

        deleteJButton.setText("Delete");
        deleteJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteJButtonActionPerformed(evt);
            }
        });
        buttonPanel.add(deleteJButton);
        
        gbc.gridy = 3;
        gbc.gridx = 0;
        gbc.gridwidth = 2;
        add(buttonPanel, gbc);

        backJButton.setText("<< Back");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });
        gbc.gridy = 4;
        gbc.gridx = 0;
        gbc.anchor = java.awt.GridBagConstraints.SOUTHWEST;
        add(backJButton, gbc);
    }

    private void addJButtonActionPerformed(java.awt.event.ActionEvent evt) {
        Enterprise enterprise = (Enterprise) enterpriseJComboBox.getSelectedItem();
        Type type = (Type) organizationTypeJComboBox.getSelectedItem();
        
        if (enterprise == null || type == null) {
            JOptionPane.showMessageDialog(null, "Invalid Input!");
            return;
        }
        
        for(Organization org : enterprise.getOrganizationDirectory().getOrganizationList()){
            if(org.getName().equals(type.getValue())){
                 JOptionPane.showMessageDialog(null, "Organization already exists!");
                 return;
            }
        }
        
        enterprise.getOrganizationDirectory().createOrganization(type);
        populateTable();
    }

    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }
    
    private void enterpriseJComboBoxActionPerformed(java.awt.event.ActionEvent evt) {
        populateTable();
    }
    
    private void deleteJButtonActionPerformed(java.awt.event.ActionEvent evt) {
        int selectedRow = organizationJTable.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select a row to delete!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        Organization org = (Organization) organizationJTable.getValueAt(selectedRow, 1);
        Enterprise enterprise = (Enterprise) enterpriseJComboBox.getSelectedItem();
        
        int dialogResult = JOptionPane.showConfirmDialog(null, "Would you like to delete the organization?", "Warning", JOptionPane.YES_NO_OPTION);
        if (dialogResult == JOptionPane.YES_OPTION) {
            enterprise.getOrganizationDirectory().deleteOrganization(org);
            populateTable();
        }
    }
    
    private javax.swing.JButton addJButton;
    private javax.swing.JButton backJButton;
    private javax.swing.JButton deleteJButton;
    private javax.swing.JComboBox enterpriseJComboBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable organizationJTable;
    private javax.swing.JComboBox organizationTypeJComboBox;
}
