import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.util.LinkedList;
public class MainExeFile extends JFrame{


    JFrame frame = new JFrame();
    Container c = frame.getContentPane();
    
    String firstname = "", lastname="", number="";

    CardLayout cardLayout;
    JPanel cardPanel;
    
    JPanel contentPane = new JPanel();
    JPanel panel23 = new JPanel();

    MainExeFile() {
  
    	
    	frame.setLocation(514, 118);
        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);
        cardPanel.setBackground(Color.LIGHT_GRAY);

        // Create different pages
        cardPanel.add(HomePage(), "Home Page");

        c.add(cardPanel);
        frame.setResizable(false);

        frame.setSize(341, 492);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    
    void showNewContact() {
    	
    	JDialog dialog = new JDialog();
        
        JPanel contentPane1 = new JPanel();
        contentPane1.setBorder(new EmptyBorder(0, 0, 5, 5));
        frame.setContentPane(contentPane1);
        contentPane1.setLayout(null);

        JPanel panel_3_1 = new JPanel();
        panel_3_1.setLayout(null);
        panel_3_1.setBounds(0,0, 326, 453);
        contentPane1.add(panel_3_1);
        
        JPanel panel_4_1 = new JPanel();
        panel_4_1.setLayout(null);
        panel_4_1.setBackground(SystemColor.scrollbar);
        panel_4_1.setBounds(0, 0, 325, 55);
        panel_3_1.add(panel_4_1);
        
        JLabel lblNewLabel_4_1 = new JLabel("ChatCodeX");
        lblNewLabel_4_1.setForeground(new Color(0, 139, 139));
        lblNewLabel_4_1.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 40));
        lblNewLabel_4_1.setBounds(10, 11, 221, 38);
        panel_4_1.add(lblNewLabel_4_1);
        
        JLabel lblNewLabel_3_1_1 = new JLabel("Geo Life, Geo");
        lblNewLabel_3_1_1.setBounds(218, 34, 77, 14);
        panel_4_1.add(lblNewLabel_3_1_1);
        
        JPanel panel_1_1 = new JPanel();
        panel_1_1.setLayout(null);
        panel_1_1.setBackground(SystemColor.activeCaption);
        panel_1_1.setBounds(0, 417, 325, 36);
        panel_3_1.add(panel_1_1);
        
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(0, 55, 325, 362);
        panel_3_1.add(panel);
        
        JToggleButton btnNewButton_2_1_1_1 = new JToggleButton("New Contact");
        btnNewButton_2_1_1_1.setBounds(48, 66, 238, 36);
        panel.add(btnNewButton_2_1_1_1);
        btnNewButton_2_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 28));
        
        JLabel lblNewLabel_1 = new JLabel("First Name");
        lblNewLabel_1.setForeground(new Color(120, 32, 255));
        lblNewLabel_1.setBounds(48, 124, 100, 14);
        panel.add(lblNewLabel_1);
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
        
        JTextField textField = new JTextField();
        textField.setBounds(156, 124, 130, 20);
        panel.add(textField);
        textField.setColumns(10);
        
        
        JLabel lblNewLabel_1_1 = new JLabel("Last Name");
        lblNewLabel_1_1.setForeground(new Color(120, 32, 255));
        lblNewLabel_1_1.setBounds(48, 157, 100, 14);
        panel.add(lblNewLabel_1_1);
        lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 18));
        
        JTextField textField_1 = new JTextField();
        textField_1.setBounds(156, 157, 130, 20);
        panel.add(textField_1);
        textField_1.setColumns(10);
        
        JLabel lblNewLabel_1_1_1 = new JLabel("Number");
        lblNewLabel_1_1_1.setForeground(new Color(120, 32, 255));
        lblNewLabel_1_1_1.setBounds(48, 192, 77, 14);
        panel.add(lblNewLabel_1_1_1);
        lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 18));
        
        JTextField textField_2 = new JTextField();
        textField_2.setBounds(126, 192, 160, 20);
        panel.add(textField_2);
        textField_2.setColumns(10);
        
        JTextField textField_3 = new JTextField();
        textField_3.setBounds(126, 234, 160, 20);
        panel.add(textField_3);
        textField_3.setColumns(10);
        
        JLabel lblNewLabel_1_1_1_1 = new JLabel("Email");
        lblNewLabel_1_1_1_1.setForeground(new Color(120, 32, 255));
        lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblNewLabel_1_1_1_1.setBounds(64, 234, 67, 14);
        panel.add(lblNewLabel_1_1_1_1);
        
        JToggleButton btnDiscard = new JToggleButton("Clear");
        btnDiscard.setBounds(64, 287, 91, 23);
        panel.add(btnDiscard);
        btnDiscard.setFont(new Font("Tahoma", Font.PLAIN, 18));
        
        JToggleButton btnSave = new JToggleButton("Save");
        btnSave.setBounds(180, 287, 91, 23);
        panel.add(btnSave);
        btnSave.setFont(new Font("Tahoma", Font.PLAIN, 18));
       
        
        // Add action listeners to buttons
        btnSave.addActionListener(new ActionListener() {
        	
            @Override
            public void actionPerformed(ActionEvent e) {

            	firstname = textField.getText();  //----------------------------First Name
                lastname = textField_1.getText();  //---------------------------last name
            	number = textField_2.getText(); //------------------------------number
            	
				frame.setVisible(false);
				if (!firstname.isEmpty() && !number.isEmpty()) {
                    
                    LinkedList<String> sharedChatHistory = new LinkedList<>();

                    HelperFile frame1 = new HelperFile(sharedChatHistory, true);  
                    frame1.setLocation(100, 100);
                    frame1.setVisible(true);
                    frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame1.setResizable(false);
            
                    HelperFile frame2 = new HelperFile(sharedChatHistory, false); 
                    frame2.setLocation(600, 100);
                    frame2.setVisible(true);
                    frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame2.setResizable(false);
            
            
                    Timer timer = new Timer(1000, ee -> {
                        frame1.updateChatDisplay();
                        frame2.updateChatDisplay();
                    });
                    timer.start();            

					dialog.setVisible(false);
                }
				else if(firstname.isEmpty()){
					dialog.setVisible(true);
                    JOptionPane.showMessageDialog(frame, "Please Enter First Name");
                }
				else{
					dialog.setVisible(true);
                    JOptionPane.showMessageDialog(frame, "Please Enter Number");
                }
            }
        });
        
        btnDiscard.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField.setText("");
                textField_1.setText("");
                textField_2.setText("");
                textField_3.setText("");
            }
        });

        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Abdul Sattar\\eclipse-workspace\\MobileChat\\src\\background-2529714_1280.jpg"));
        lblNewLabel.setBounds(0, 0, 325, 362);
        panel.add(lblNewLabel);

        dialog.setContentPane(contentPane1);
        dialog.setSize(341, 492); // Set the desired size
        dialog.setLocationRelativeTo(null); // Center the dialog
        dialog.setVisible(true);
    }

    public JPanel HomePage () {
		setTitle("MobileChat");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 895, 503);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		contentPane.setLayout(null);
		
		JPanel panel_3_1 = new JPanel();
		panel_3_1.setBounds(0, 0, 326, 453);
		contentPane.add(panel_3_1);
		panel_3_1.setLayout(null);
		
		JPanel panel_4_1 = new JPanel();
		panel_4_1.setLayout(null);
		panel_4_1.setBackground(SystemColor.scrollbar);
		panel_4_1.setBounds(0, 0, 325, 55);
		panel_3_1.add(panel_4_1);
		
		JLabel lblNewLabel_4_1 = new JLabel("ChatCodeX");
		lblNewLabel_4_1.setForeground(new Color(0, 139, 139));
		lblNewLabel_4_1.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 40));
		lblNewLabel_4_1.setBounds(10, 11, 221, 38);
		panel_4_1.add(lblNewLabel_4_1);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("Geo Life, Geo");
		lblNewLabel_3_1_1.setBounds(218, 34, 77, 14);
		panel_4_1.add(lblNewLabel_3_1_1);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBackground(SystemColor.activeCaption);
		panel_1_1.setBounds(0, 417, 325, 36);
		panel_3_1.add(panel_1_1);
		
		
		panel23.setBounds(0, 55, 325, 362);
		panel_3_1.add(panel23);
		panel23.setLayout(null);
		
		JToggleButton btnNewButton_2_1 = new JToggleButton("Let's Start");
		btnNewButton_2_1.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e) {
				showNewContact();
			}
		});
		btnNewButton_2_1.setBounds(61, 149, 203, 52);
		panel23.add(btnNewButton_2_1);
		btnNewButton_2_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, 0, 325, 362);
		panel23.add(lblNewLabel);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Abdul Sattar\\eclipse-workspace\\MobileChat\\src\\fantasy-art-texture-computer-wallpaper-preview.jpg"));
		
		return contentPane;
	}      
    public static void main(String[] args) {
         new MainExeFile();
    }
}