package userinterface;

import Business.EcoSystem;
import Business.DB4OUtil.DB4OUtil;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import com.formdev.flatlaf.FlatLightLaf; // FlatLaf import
import javax.swing.UIManager; // UIManager import

import java.awt.CardLayout;
import java.awt.BorderLayout; // Added for BorderLayout
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSplitPane; // Re-introduced

/**
 *
 * @author rrheg
 */
public class MainJFrame extends javax.swing.JFrame {

    private EcoSystem system;
    private DB4OUtil dB4OUtil = DB4OUtil.getInstance();

    // --- Class Member Variables ---
    private JPanel mainContentPanel; // Will be used for the centralized login background
    private javax.swing.JPanel container; // Original container for work areas
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1; // Login panel content
    private javax.swing.JButton loginJButton;
    private javax.swing.JLabel loginJLabel;
    private javax.swing.JButton logoutJButton;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JTextField userNameJTextField;

    // NEW MEMBERS
    private javax.swing.JLabel lblLoggedInUser; // To display logged-in username
    private javax.swing.JPanel headerPanel;     // Top panel for user info and logout
    private javax.swing.JPanel cardSwapPanel;   // Panel with CardLayout to swap login/work area
    private javax.swing.JLabel lblAppName; // New JLabel for the application title
    // --- End Class Member Variables ---

    public MainJFrame() {
        initComponents();
        system = dB4OUtil.retrieveSystem();
        this.setSize(1680, 1050); // Keep original size
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        // Initialize class members
        this.jPanel1 = new javax.swing.JPanel();
        this.jLabel1 = new javax.swing.JLabel();
        this.userNameJTextField = new javax.swing.JTextField();
        this.jLabel2 = new javax.swing.JLabel();
        this.passwordField = new javax.swing.JPasswordField();
        this.loginJButton = new javax.swing.JButton();
        this.logoutJButton = new javax.swing.JButton();
        this.loginJLabel = new javax.swing.JLabel();
        this.container = new javax.swing.JPanel(); // The container for work areas
        this.lblLoggedInUser = new javax.swing.JLabel(); // New JLabel for logged-in user
        this.headerPanel = new javax.swing.JPanel(); // New header panel
        this.cardSwapPanel = new javax.swing.JPanel(); // New panel to hold login/work area via CardLayout

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("OrganLink-Heroes"); // Set title
        setPreferredSize(new java.awt.Dimension(1200, 750)); // Set preferred size for the frame

        // --- Styling for headerPanel ---
        headerPanel.setBackground(new java.awt.Color(0, 102, 102)); // Darker teal for header
        headerPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT)); // Align content to right
        headerPanel.setPreferredSize(new java.awt.Dimension(0, 50)); // Fixed height for header

        lblLoggedInUser.setFont(new java.awt.Font("Tahoma", 1, 14));
        lblLoggedInUser.setForeground(new java.awt.Color(255, 255, 255)); // White text
        lblLoggedInUser.setText(""); // Initially empty
        headerPanel.add(lblLoggedInUser); // Add to header

        logoutJButton.setText("Logout");
        logoutJButton.setFont(new java.awt.Font("Tahoma", 1, 12));
        logoutJButton.setBackground(new java.awt.Color(153, 153, 153)); // Lighter gray for logout
        logoutJButton.setForeground(new java.awt.Color(255, 255, 255)); // White text
        logoutJButton.setPreferredSize(new java.awt.Dimension(120, 35)); // Consistent size for buttons
        logoutJButton.setEnabled(false);
        logoutJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutJButtonActionPerformed(evt);
            }
        });
        headerPanel.add(logoutJButton); // Add to header
        headerPanel.setVisible(false); // Initially hide the header panel


        // --- Main panel for centering login and holding work area (mainContentPanel now holds login) ---
        this.mainContentPanel = new JPanel(new java.awt.GridBagLayout());
        mainContentPanel.setBackground(new java.awt.Color(176, 196, 222)); // Light Steel Blue background

        // --- Styling for jPanel1 (Login Panel) ---
        jPanel1.setBackground(new java.awt.Color(240, 242, 245)); // Light gray/off-white for login panel
        
        // Initialize and style lblAppName for the login page
        lblAppName = new javax.swing.JLabel();
        lblAppName.setFont(new java.awt.Font("Segoe UI", 1, 24)); // Larger, bold font
        lblAppName.setForeground(new java.awt.Color(0, 102, 102)); // Darker teal color
        lblAppName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER); // Center text
        lblAppName.setText("OrganLink-Heroes"); // Set the application title
        lblAppName.setPreferredSize(new java.awt.Dimension(200, 40)); // Increased width to ensure full text display

        jLabel1.setText("User Name");
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // Bold, size 12
        jLabel1.setForeground(new java.awt.Color(51, 51, 51)); // Dark Gray for visibility

        userNameJTextField.setFont(new java.awt.Font("Tahoma", 0, 12)); // Consistent font size
        userNameJTextField.setColumns(10); // Default columns

        jLabel2.setText("Password");
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // Bold, size 12
        jLabel2.setForeground(new java.awt.Color(51, 51, 51)); // Dark Gray for visibility

        passwordField.setFont(new java.awt.Font("Tahoma", 0, 12)); // Consistent font size
        passwordField.setColumns(10); // Default columns

        loginJButton.setText("Login");
        loginJButton.setFont(new java.awt.Font("Tahoma", 1, 12));
        loginJButton.setBackground(new java.awt.Color(0, 150, 136)); // Primary accent teal
        loginJButton.setForeground(new java.awt.Color(255, 255, 255)); // White text
        loginJButton.setPreferredSize(new java.awt.Dimension(120, 35)); // Consistent size for buttons
        loginJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginJButtonActionPerformed(evt);
            }
        });
        
        loginJLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER); // Center any message
        loginJLabel.setForeground(new java.awt.Color(204, 0, 0)); // Darker Red for visibility

        // --- Layout for jPanel1 (Login Form Content) ---
        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblAppName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE) // Add lblAppName
                    .addComponent(loginJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(loginJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(userNameJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20) // Adjusted top padding
                .addComponent(lblAppName, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE) // Add lblAppName
                .addGap(18, 18, 18) // Space between app name and user name field
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(userNameJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(loginJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(loginJLabel)
                .addContainerGap(40, Short.MAX_VALUE))
        );
        
        // Add jPanel1 to mainContentPanel (centered)
        gridBagConstraints = new java.awt.GridBagConstraints();
        mainContentPanel.add(jPanel1, gridBagConstraints);

        // --- Setup cardSwapPanel ---
        cardSwapPanel.setLayout(new CardLayout());
        cardSwapPanel.add(mainContentPanel, "loginCard"); // Login screen
        
        container.setBackground(new java.awt.Color(255, 255, 255)); // White background for work areas
        container.setLayout(new java.awt.CardLayout()); // Ensure it has a layout
        cardSwapPanel.add(container, "workAreaCard"); // Work area screen

        // --- Add components to JFrame's content pane ---
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(headerPanel, java.awt.BorderLayout.NORTH);
        getContentPane().add(cardSwapPanel, java.awt.BorderLayout.CENTER);

        pack();
    }

    private void loginJButtonActionPerformed(java.awt.event.ActionEvent evt) {                                             
        // Get user name
        String userName = userNameJTextField.getText();
        // Get Password
        char[] passwordCharArray = passwordField.getPassword();
        String password = String.valueOf(passwordCharArray);
        
        //Step1: Check in the system admin user account directory if you have the user
        UserAccount userAccount=system.getUserAccountDirectory().authenticateUser(userName, password);
        
        Enterprise inEnterprise=null;
        Organization inOrganization=null;
        Network inNetwork = null; // Introduce inNetwork variable
        
        if(userAccount==null){
            //Step 2: Go inside each network and check each enterprise
            for(Network network:system.getNetworkList()){
                //Step 2.a: check against each enterprise
                for(Enterprise enterprise:network.getEnterpriseDirectory().getEnterpriseList()){
                    userAccount=enterprise.getUserAccountDirectory().authenticateUser(userName, password);
                    if(userAccount==null){
                       //Step 3:check against each organization for each enterprise
                       for(Organization organization:enterprise.getOrganizationDirectory().getOrganizationList()){
                           userAccount=organization.getUserAccountDirectory().authenticateUser(userName, password);
                           if(userAccount!=null){
                               inNetwork = network; // Store network
                               inEnterprise=enterprise;
                               inOrganization=organization;
                               break;
                           }
                       }
                        
                    }
                    else{
                       inNetwork = network; // Store network
                       inEnterprise=enterprise;
                       break;
                    }
                    if(inOrganization!=null){
                        break;
                    }  
                }
                if(inEnterprise!=null){
                    break;
                }
            }
        }
        
        if(userAccount==null){
            JOptionPane.showMessageDialog(null, "Invalid credentials");
            return;
        }
        else{
            // Set logged-in username in header
            lblLoggedInUser.setText("Welcome, " + userAccount.getUsername() + "!");
            headerPanel.setVisible(true); // Make header visible

            // Add the work area to the container
            container.add("workArea",userAccount.getRole().createWorkArea(container, userAccount, inOrganization, inEnterprise, inNetwork, system)); // Pass inNetwork
            
            // Show the work area card
            CardLayout cl = (CardLayout)(cardSwapPanel.getLayout());
            cl.show(cardSwapPanel, "workAreaCard");
            
            // Revalidate and repaint the frame
            revalidate();
            repaint();
        }
        
        loginJButton.setEnabled(false);
        logoutJButton.setEnabled(true); // Enable logout button in header
        userNameJTextField.setEnabled(false);
        passwordField.setEnabled(false);
    }                                            

    private void logoutJButtonActionPerformed(java.awt.event.ActionEvent evt) {                                              
        logoutJButton.setEnabled(false); // Disable logout button in header
        userNameJTextField.setEnabled(true);
        passwordField.setEnabled(true);
        loginJButton.setEnabled(true);

        userNameJTextField.setText("");
        passwordField.setText("");

        container.removeAll(); // Clear work area content
        
        // Hide header (or clear content)
        lblLoggedInUser.setText("");
        headerPanel.setVisible(false); // Hide header panel if not needed on login screen

        // Show the login card
        CardLayout cl = (CardLayout)(cardSwapPanel.getLayout());
        cl.show(cardSwapPanel, "loginCard");
        
        // Revalidate and repaint the frame
        revalidate();
        repaint();
        
        dB4OUtil.storeSystem(system);
    }                                             

    public static void main(String args[]) {
        try {
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (Exception ex) {
            System.err.println( "Failed to initialize FlatLaf: " + ex );
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainJFrame().setVisible(true);
            }
        });
    }

} // Closing brace for MainJFrame class