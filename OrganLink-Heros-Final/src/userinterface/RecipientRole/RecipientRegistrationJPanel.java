/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package userinterface.RecipientRole;

import Business.Enterprise.Enterprise;
import Business.Organization.RecipientOrganization;
import Business.Recipient.Recipient;
import Business.UserAccount.UserAccount;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * 
 * @author eric
 */

public class RecipientRegistrationJPanel extends javax.swing.JPanel {

    /**
     * Creates new form RecipientRegistrationJPanel
     */
    
    private JPanel userProcessContainer;
    private UserAccount userAccount;
    private RecipientOrganization recipientOrganization;
    private Enterprise enterprise;
    private RecipientWorkAreaJPanel workAreaPanel;

    // GUI Components - Declared as class members
    private javax.swing.JComboBox<String> ComboBoxBloodType;
    private javax.swing.JComboBox<String> ComboBoxOrganNeeded;
    private javax.swing.JComboBox<String> ComboBoxStates;
    private javax.swing.JComboBox<String> ComboBoxUrgency;
    private javax.swing.JButton btnBack;
    private javax.swing.JRadioButton btnNoQ1;
    private javax.swing.JRadioButton btnNoQ2;
    private javax.swing.JRadioButton btnNoQ3;
    private javax.swing.JButton btnSubmit;
    private javax.swing.JRadioButton btnYesQ1;
    private javax.swing.JRadioButton btnYesQ2;
    private javax.swing.JRadioButton btnYesQ3;
    private javax.swing.JComboBox<String> genderJComboBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator1; // Not used in new layout, but declared for consistency
    private javax.swing.JTextField txtAge;
    private javax.swing.JTextField txtCity;
    private javax.swing.JTextField txtDOB;
    private javax.swing.JTextField txtEmails;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPhoneNumber;
    private javax.swing.JTextField txtStreetAddress;
    private javax.swing.JTextField txtZipCode;

    
    public RecipientRegistrationJPanel(JPanel userProcessContainer, UserAccount account,
        RecipientOrganization organization, Enterprise enterprise, 
        RecipientWorkAreaJPanel workAreaPanel) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.userAccount = account;
        this.recipientOrganization = organization;
        this.enterprise = enterprise;
        this.workAreaPanel = workAreaPanel;
        // Initialize data
        populateComboBoxes();
        setupRadioButtonGroups();
    }

    private void populateComboBoxes() {
        // Gender options
        genderJComboBox.removeAllItems();
        genderJComboBox.addItem("Male");
        genderJComboBox.addItem("Female");
        genderJComboBox.addItem("Other");
        
        // Blood type options
        ComboBoxBloodType.removeAllItems();
        ComboBoxBloodType.addItem("A+");
        ComboBoxBloodType.addItem("A-");
        ComboBoxBloodType.addItem("B+");
        ComboBoxBloodType.addItem("B-");
        ComboBoxBloodType.addItem("AB+");
        ComboBoxBloodType.addItem("AB-");
        ComboBoxBloodType.addItem("O+");
        ComboBoxBloodType.addItem("O-");
        
        // Organ needed options (different from Donor - this is what recipient NEEDS)
        ComboBoxOrganNeeded.removeAllItems();
        ComboBoxOrganNeeded.addItem("Heart");
        ComboBoxOrganNeeded.addItem("Liver");
        ComboBoxOrganNeeded.addItem("Kidney");
        ComboBoxOrganNeeded.addItem("Lung");
        ComboBoxOrganNeeded.addItem("Pancreas");
        ComboBoxOrganNeeded.addItem("Cornea");
        
        // Urgency level options (Recipient specific)
        ComboBoxUrgency.removeAllItems();
        ComboBoxUrgency.addItem("High");
        ComboBoxUrgency.addItem("Medium");
        ComboBoxUrgency.addItem("Low");
        
        // State options
        ComboBoxStates.removeAllItems();
        String[] states = {"AL", "AK", "AZ", "AR", "CA", "CO", "CT", "DE", "FL", "GA",
                          "HI", "ID", "IL", "IN", "IA", "KS", "KY", "LA", "ME", "MD",
                          "MA", "MI", "MN", "MS", "MO", "MT", "NE", "NV", "NH", "NJ",
                          "NM", "NY", "NC", "ND", "OH", "OK", "OR", "PA", "RI", "SC",
                          "SD", "TN", "TX", "UT", "VT", "VA", "WA", "WV", "WI", "WY"};
        for (String state : states) {
            ComboBoxStates.addItem(state);
        }
    }
    
    private void setupRadioButtonGroups() {
        ButtonGroup group1 = new ButtonGroup();
        group1.add(btnYesQ1);
        group1.add(btnNoQ1);
        
        ButtonGroup group2 = new ButtonGroup();
        group2.add(btnYesQ2);
        group2.add(btnNoQ2);
        
        ButtonGroup group3 = new ButtonGroup();
        group3.add(btnYesQ3);
        group3.add(btnNoQ3);
    }
    
    /**
     * Calculate age from date of birth
     */
    private int calculateAge(Date dateOfBirth) {
        Calendar dob = Calendar.getInstance();
        dob.setTime(dateOfBirth);
        Calendar today = Calendar.getInstance();
        
        int age = today.get(Calendar.YEAR) - dob.get(Calendar.YEAR);
        
        // Adjust if birthday hasn't occurred yet this year
        if (today.get(Calendar.DAY_OF_YEAR) < dob.get(Calendar.DAY_OF_YEAR)) {
            age--;
        }
        
        return age;
    }
    
    /**
     * Validate all form fields
     */
    private boolean validateForm() {
        // Validate name
        if (txtName.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter your name!", 
                "Validation Error", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        
        // Validate name doesn't contain numbers
        if (containsDigit(txtName.getText().trim())) {
            JOptionPane.showMessageDialog(this, "Name cannot contain numbers!", 
                "Validation Error", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        
        // Validate DOB
        if (txtDOB.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter your date of birth!", 
                "Validation Error", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        
        // Validate DOB format and parse
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
            sdf.setLenient(false);
            Date dob = sdf.parse(txtDOB.getText().trim());
            
            // Check if date is in the future
            if (dob.after(new Date())) {
                JOptionPane.showMessageDialog(this, "Date of birth cannot be in the future!", 
                    "Validation Error", JOptionPane.WARNING_MESSAGE);
                return false;
            }
            
            // Check age is reasonable (0-120)
            int age = calculateAge(dob);
            if (age < 0 || age > 120) {
                JOptionPane.showMessageDialog(this, "Please enter a valid date of birth!", 
                    "Validation Error", JOptionPane.WARNING_MESSAGE);
                return false;
            }
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(this, "Invalid date format! Please use MM/DD/YYYY", 
                "Validation Error", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        
        // Validate email
        if (txtEmails.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter your email!", 
                "Validation Error", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        
        if (!txtEmails.getText().trim().contains("@")) {
            JOptionPane.showMessageDialog(this, "Please enter a valid email address!", 
                "Validation Error", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        
        // Validate phone number
        if (txtPhoneNumber.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter your phone number!", 
                "Validation Error", JOptionPane.WARNING_MESSAGE);
            return false;
        }

        String phoneDigits = txtPhoneNumber.getText().trim().replaceAll("[^0-9]", ""); // Remove non-digits
        if (phoneDigits.length() != 10) {
            JOptionPane.showMessageDialog(this, "Phone number must be exactly 10 digits!", 
                "Validation Error", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        
        // Validate blood type
        if (ComboBoxBloodType.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(this, "Please select your blood type!", 
                "Validation Error", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        
        // Validate organ needed
        if (ComboBoxOrganNeeded.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(this, "Please select the organ you need!", 
                "Validation Error", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        
        // Validate urgency level
        if (ComboBoxUrgency.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(this, "Please select urgency level!", 
                "Validation Error", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        
        // Validate address
        if (txtStreetAddress.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter your street address!", 
                "Validation Error", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        
        if (isAllDigits(txtStreetAddress.getText().trim())) {
            JOptionPane.showMessageDialog(this, "Street address cannot be only numbers!", 
                "Validation Error", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        
        if (txtCity.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter your city!", 
                "Validation Error", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        
        if (containsDigit(txtCity.getText().trim())) {
            JOptionPane.showMessageDialog(this, "City name cannot contain numbers!", 
                "Validation Error", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        
        // Validate zip code - must be exactly 5 digits
        if (txtZipCode.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter your zip code!", 
                "Validation Error", JOptionPane.WARNING_MESSAGE);
            return false;
        }

        String zipDigits = txtZipCode.getText().trim().replaceAll("[^0-9]", ""); // Remove non-digits
        if (zipDigits.length() != 5) {
            JOptionPane.showMessageDialog(this, "Zip code must be exactly 5 digits!", 
                "Validation Error", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        
        // Validate health questions
        if (!btnYesQ1.isSelected() && !btnNoQ1.isSelected()) {
            JOptionPane.showMessageDialog(this, 
                "Please answer: Do you have any chronic conditions?", 
                "Health Screening Required", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        
        if (!btnYesQ2.isSelected() && !btnNoQ2.isSelected()) {
            JOptionPane.showMessageDialog(this, 
                "Please answer: Are you currently on any medication?", 
                "Health Screening Required", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        
        if (!btnYesQ3.isSelected() && !btnNoQ3.isSelected()) {
            JOptionPane.showMessageDialog(this, 
                "Please answer: Have you had a previous organ transplant?", 
                "Health Screening Required", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        
        return true;
    }
    
    /**
     * Check health eligibility - all questions must be answered "No"
     */
    private boolean checkEligibility() {
        // If any question is answered "Yes", recipient is not eligible
        if (btnYesQ1.isSelected() || btnYesQ2.isSelected() || btnYesQ3.isSelected()) {
            return false;
        }
        return true;
    }
    
    
    /**
     * Build medical history string
     */
    private String buildMedicalHistory() {
        StringBuilder history = new StringBuilder();
        history.append("=== RECIPIENT REGISTRATION ===\n\n");
        history.append("Date of Birth: ").append(txtDOB.getText().trim()).append("\n");
        history.append("Age: ").append(txtAge.getText().trim()).append("\n");
        history.append("Gender: ").append((String) genderJComboBox.getSelectedItem()).append("\n");
        history.append("Address: ").append(txtStreetAddress.getText().trim())
               .append(", ").append(txtCity.getText().trim())
               .append(", ").append((String) ComboBoxStates.getSelectedItem())
               .append(" ").append(txtZipCode.getText().trim()).append("\n\n");
        history.append("Medical Information:\n");
        history.append("  Blood Type: ").append((String) ComboBoxBloodType.getSelectedItem()).append("\n");
        history.append("  Organ Needed: ").append((String) ComboBoxOrganNeeded.getSelectedItem()).append("\n");
        history.append("  Urgency Level: ").append((String) ComboBoxUrgency.getSelectedItem()).append("\n\n");
        history.append("Health Screening:\n");
        history.append("  Chronic conditions: ").append(btnYesQ1.isSelected() ? "Yes" : "No").append("\n");
        history.append("  Currently on medication: ").append(btnYesQ2.isSelected() ? "Yes" : "No").append("\n");
        history.append("  Previous organ transplant: ").append(btnYesQ3.isSelected() ? "Yes" : "No").append("\n");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        history.append("\nRegistered: ").append(sdf.format(new Date()));
        return history.toString();
    }
    
    /**
     * Clear all form fields
     */
    private void clearForm() {
        txtName.setText("");
        txtDOB.setText("");
        txtAge.setText("");
        txtEmails.setText("");
        txtPhoneNumber.setText("");
        txtStreetAddress.setText("");
        txtCity.setText("");
        txtZipCode.setText("");
        
        if (genderJComboBox.getItemCount() > 0) {
            genderJComboBox.setSelectedIndex(0);
        }
        if (ComboBoxBloodType.getItemCount() > 0) {
            ComboBoxBloodType.setSelectedIndex(0);
        }
        if (ComboBoxOrganNeeded.getItemCount() > 0) {
            ComboBoxOrganNeeded.setSelectedIndex(0);
        }
        if (ComboBoxUrgency.getItemCount() > 0) {
            ComboBoxUrgency.setSelectedIndex(0);
        }
        if (ComboBoxStates.getItemCount() > 0) {
            ComboBoxStates.setSelectedIndex(0);
        }
        
        btnYesQ1.setSelected(false);
        btnNoQ1.setSelected(false);
        btnYesQ2.setSelected(false);
        btnNoQ2.setSelected(false);
        btnYesQ3.setSelected(false);
        btnNoQ3.setSelected(false);
    }
    
    /**
     * Check if string contains digit
     */
    private boolean containsDigit(String str) {
        for (char c : str.toCharArray()) {
            if (Character.isDigit(c)) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Check if string is all digits
     */
    private boolean isAllDigits(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        for (char c : str.toCharArray()) {
            if (!Character.isDigit(c) && c != ' ') {
                return false;
            }
        }
        return true;
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        // --- Local variable declarations removed, now using class members ---
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator(); // Not used in new layout
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtDOB = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtAge = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        genderJComboBox = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        txtEmails = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtPhoneNumber = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        ComboBoxBloodType = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtStreetAddress = new javax.swing.JTextField();
        txtCity = new javax.swing.JTextField();
        ComboBoxStates = new javax.swing.JComboBox<>();
        txtZipCode = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        ComboBoxOrganNeeded = new javax.swing.JComboBox<>();
        ComboBoxUrgency = new javax.swing.JComboBox<>();
        jLabel16 = new javax.swing.JLabel();
        btnYesQ1 = new javax.swing.JRadioButton();
        btnNoQ1 = new javax.swing.JRadioButton();
        jLabel18 = new javax.swing.JLabel();
        btnYesQ2 = new javax.swing.JRadioButton();
        btnNoQ2 = new javax.swing.JRadioButton();
        jLabel19 = new javax.swing.JLabel();
        btnYesQ3 = new javax.swing.JRadioButton();
        btnNoQ3 = new javax.swing.JRadioButton();
        btnSubmit = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new java.awt.GridBagLayout());
        java.awt.GridBagConstraints gbc = new java.awt.GridBagConstraints();

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 102));
        jLabel1.setText("Recipient Registration Form");
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 4;
        gbc.insets = new java.awt.Insets(10, 10, 20, 10);
        add(jLabel1, gbc);

        gbc.gridwidth = 1;
        gbc.anchor = java.awt.GridBagConstraints.WEST;
        gbc.insets = new java.awt.Insets(5, 10, 5, 10);

        // Personal Information
        gbc.gridy = 1;
        gbc.gridx = 0;
        add(new javax.swing.JLabel("Name:"), gbc);
        gbc.gridx = 1;
        txtName.setColumns(15);
        add(txtName, gbc);
        gbc.gridx = 2;
        add(new javax.swing.JLabel("DOB (MM/DD/YYYY):"), gbc);
        gbc.gridx = 3;
        txtDOB.setColumns(15);
        txtDOB.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtDOBFocusLost(evt);
            }
        });
        add(txtDOB, gbc);

        gbc.gridy = 2;
        gbc.gridx = 0;
        add(new javax.swing.JLabel("Age:"), gbc);
        gbc.gridx = 1;
        txtAge.setEditable(false);
        txtAge.setEnabled(false);
        add(txtAge, gbc);
        gbc.gridx = 2;
        add(new javax.swing.JLabel("Gender:"), gbc);
        gbc.gridx = 3;
        genderJComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female", "Other" }));
        add(genderJComboBox, gbc);

        gbc.gridy = 3;
        gbc.gridx = 0;
        add(new javax.swing.JLabel("Email:"), gbc);
        gbc.gridx = 1;
        txtEmails.setColumns(15);
        add(txtEmails, gbc);
        gbc.gridx = 2;
        add(new javax.swing.JLabel("Phone Number:"), gbc);
        gbc.gridx = 3;
        txtPhoneNumber.setColumns(15);
        add(txtPhoneNumber, gbc);

        // Address Information
        gbc.gridy = 4;
        gbc.gridx = 0;
        gbc.gridwidth = 4;
        gbc.insets = new java.awt.Insets(20, 10, 5, 10);
        add(new javax.swing.JLabel("Address Details"), gbc);
        gbc.gridwidth = 1;
        gbc.insets = new java.awt.Insets(5, 10, 5, 10);

        gbc.gridy = 5;
        gbc.gridx = 0;
        add(new javax.swing.JLabel("Street Address:"), gbc);
        gbc.gridx = 1;
        txtStreetAddress.setColumns(15);
        add(txtStreetAddress, gbc);
        gbc.gridx = 2;
        add(new javax.swing.JLabel("City:"), gbc);
        gbc.gridx = 3;
        txtCity.setColumns(15);
        add(txtCity, gbc);

        gbc.gridy = 6;
        gbc.gridx = 0;
        add(new javax.swing.JLabel("State:"), gbc);
        gbc.gridx = 1;
        ComboBoxStates.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "AL", "AK", "AZ", "AR", "CA", "CO", "CT", "DE", "FL", "GA", "HI", "ID", "IL", "IN", "IA", "KS", "KY", "LA", "ME", "MD", "MA", "MI", "MN", "MS", "MO", "MT", "NE", "NV", "NH", "NJ", "NM", "NY", "NC", "ND", "OH", "OK", "OR", "PA", "RI", "SC", "SD", "TN", "TX", "UT", "VT", "VA", "WA", "WV", "WI", "WY" }));
        add(ComboBoxStates, gbc);
        gbc.gridx = 2;
        add(new javax.swing.JLabel("Zip Code:"), gbc);
        gbc.gridx = 3;
        txtZipCode.setColumns(15);
        add(txtZipCode, gbc);

        // Medical Needs Information
        gbc.gridy = 7;
        gbc.gridx = 0;
        gbc.gridwidth = 4;
        gbc.insets = new java.awt.Insets(20, 10, 5, 10);
        add(new javax.swing.JLabel("Medical Needs Information"), gbc);
        gbc.gridwidth = 1;
        gbc.insets = new java.awt.Insets(5, 10, 5, 10);
        
        gbc.gridy = 8;
        gbc.gridx = 0;
        add(new javax.swing.JLabel("Blood Type:"), gbc);
        gbc.gridx = 1;
        ComboBoxBloodType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "A+", "A-", "B+", "B-", "AB+", "AB-", "O+", "O-" }));
        add(ComboBoxBloodType, gbc);
        gbc.gridx = 2;
        add(new javax.swing.JLabel("Organ Needed:"), gbc);
        gbc.gridx = 3;
        ComboBoxOrganNeeded.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Heart", "Liver", "Kidney", "Lung", "Pancreas", "Cornea" }));
        add(ComboBoxOrganNeeded, gbc);

        gbc.gridy = 9;
        gbc.gridx = 0;
        add(new javax.swing.JLabel("Urgency Level:"), gbc);
        gbc.gridx = 1;
        ComboBoxUrgency.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "High", "Medium", "Low" }));
        add(ComboBoxUrgency, gbc);
        
        // Health Questions
        gbc.gridy = 10;
        gbc.gridx = 0;
        gbc.gridwidth = 4;
        gbc.insets = new java.awt.Insets(20, 10, 5, 10);
        add(new javax.swing.JLabel("Health Questions"), gbc);
        gbc.gridwidth = 1;
        gbc.insets = new java.awt.Insets(5, 10, 5, 10);

        gbc.gridy = 11;
        gbc.gridx = 0;
        add(new javax.swing.JLabel("Do you have any chronic conditions?"), gbc);
        gbc.gridx = 1;
        JPanel q1Panel = new JPanel();
        btnYesQ1.setText("Yes");
        q1Panel.add(btnYesQ1);
        btnNoQ1.setText("No");
        q1Panel.add(btnNoQ1);
        add(q1Panel, gbc);

        gbc.gridy = 12;
        gbc.gridx = 0;
        add(new javax.swing.JLabel("Are you currently on any medication?"), gbc);
        gbc.gridx = 1;
        JPanel q2Panel = new JPanel();
        btnYesQ2.setText("Yes");
        q2Panel.add(btnYesQ2);
        btnNoQ2.setText("No");
        q2Panel.add(btnNoQ2);
        add(q2Panel, gbc);

        gbc.gridy = 13;
        gbc.gridx = 0;
        add(new javax.swing.JLabel("Have you had a previous organ transplant?"), gbc);
        gbc.gridx = 1;
        JPanel q3Panel = new JPanel();
        btnYesQ3.setText("Yes");
        q3Panel.add(btnYesQ3);
        btnNoQ3.setText("No");
        q3Panel.add(btnNoQ3);
        add(q3Panel, gbc);

        // Buttons
        gbc.gridy = 14;
        gbc.gridx = 0;
        gbc.gridwidth = 4;
        gbc.anchor = java.awt.GridBagConstraints.CENTER;
        gbc.insets = new java.awt.Insets(20, 10, 10, 10);
        JPanel buttonPanel = new JPanel(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 20, 10));
        btnSubmit.setText("Submit");
        btnSubmit.setBackground(new java.awt.Color(0, 120, 102));
        btnSubmit.setForeground(java.awt.Color.WHITE);
        btnSubmit.addActionListener(this::btnSubmitActionPerformed);
        buttonPanel.add(btnSubmit);
        
        btnBack.setText("Back");
        btnBack.addActionListener(this::btnBackActionPerformed);
        buttonPanel.add(btnBack);
        add(buttonPanel, gbc);
    }

    private void txtDOBFocusLost(java.awt.event.FocusEvent evt) {
        // Auto-calculate age when user finishes entering DOB
        String dobText = txtDOB.getText().trim();
        if (!dobText.isEmpty()) {
            try {
                SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
                sdf.setLenient(false);
                Date dob = sdf.parse(dobText);
                int age = calculateAge(dob);
                if (age >= 0 && age <= 120) {
                    txtAge.setText(String.valueOf(age));
                } else {
                    txtAge.setText("");
                }
            } catch (ParseException e) {
                txtAge.setText("");
            }
        } else {
            txtAge.setText("");
        }
    }

    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {
        // Validate form
        if (!validateForm()) {
            return;
        }
        
        // Check health eligibility - all health questions must be "No"
        if (!checkEligibility()) {
            JOptionPane.showMessageDialog(this,
                "Unfortunately, you are not eligible for organ recipient registration at this time.\n\n" +
                "Eligibility requires:\n" +
                "• No chronic conditions\n" +
                "• Not currently on medication\n" +
                "• No previous organ transplant\n\n" +
                "Please consult with your healthcare provider for more information.",
                "Eligibility Check Failed",
                JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        // Create new Recipient object
        Recipient recipient = new Recipient(txtName.getText().trim());
        
        // Set date of birth
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
            recipient.setDateOfBirth(sdf.parse(txtDOB.getText().trim()));
        } catch (ParseException e) {
            // Should not happen since we validated
        }
        
        // Set contact information
        recipient.setContactNumber(txtPhoneNumber.getText().trim());
        recipient.setEmail(txtEmails.getText().trim());
        
        // Set medical information - CRITICAL for organ matching!
        recipient.setBloodType((String) ComboBoxBloodType.getSelectedItem());
        recipient.setOrganNeeded((String) ComboBoxOrganNeeded.getSelectedItem());
        recipient.setUrgencyLevel((String) ComboBoxUrgency.getSelectedItem());
        
        // Set status as per Workflow 2 requirement
        recipient.setStatus("Pending Coordinator Review");
        
        // Build and set medical history
        recipient.setMedicalHistory(buildMedicalHistory());
        
        // Add to RecipientDirectory
        recipientOrganization.getRecipientDirectory().addRecipient(recipient);
        
        // Show success message
        JOptionPane.showMessageDialog(this,
                "Registration submitted successfully!\n\n" +
                "Recipient ID: " + recipient.getRecipientId() + "\n" +
                "Organ Needed: " + recipient.getOrganNeeded() + "\n" +
                "Blood Type: " + recipient.getBloodType() + "\n" +
                "Urgency: " + recipient.getUrgencyLevel() + "\n" +
                "Status: " + recipient.getStatus() + "\n\n" +
                "A Transplant Coordinator will review your request.",
                "Registration Complete",
                JOptionPane.INFORMATION_MESSAGE);
        
        // Clear form for next entry
        clearForm();
    }

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {
        // Refresh the work area table before going back
        if (workAreaPanel != null) {
            workAreaPanel.populateTable();
        }
    
        userProcessContainer.remove(this);
        java.awt.CardLayout layout = (java.awt.CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }
}