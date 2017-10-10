/**
 * Main frame
 * @author Adrien Claudel
 * @Date 12.09.2017
 */

package View;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import Controler.Controler_Account;



@SuppressWarnings("serial")
public class View_Account extends JFrame implements ActionListener{

	private Controler_Account controler;
	private JScrollPane scrollPane;
	private JTable tableau;
	
	private JPanel Liste;
	private JPanel panel;
	
	private JTextField textField;
	private JTextField tfld_Site;
	private JTextField tfld_Login;
	private JTextField tfld_Password;
	private JTextField tfld_Size;

	private JLabel lbl_Login;
	private JLabel lbl_Sites;
	private JLabel lbl_Password;
	private JLabel lbl_Size;
	
	private JCheckBox chbx_Maj;
	private JCheckBox chbx_Numbers;
	private JCheckBox chbx_SP;
	private JCheckBox chbx_Dash;
	
	private JButton butt_recherche;
	private JButton butt_Generate;
	private JButton butt_Copy;
	private JButton butt_Clear;
	private JButton butt_Modify;
	private JButton butt_Add;
	
	
	/**
	 * Launch the application.
	 */
	public void run() {
		try {
			this.setVisible(true);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}


	/**
	 * Create the application.
	 * @param objects 
	 * @param entetes 
	 */
	public View_Account(Controler_Account controler, Object[][] objects) {
		
		this.controler = controler;
		
        String[] entetes = {"Sites / Software", "Login", "Password"};
		initialize(entetes, objects);
	}

	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String[] entetes, Object[][] donnees) {
		this.setTitle("Safe-Word");
		this.setResizable(false);
		this.setBounds(100, 100, 800, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);
		
		Liste = new JPanel();
		Liste.setBounds(0, 0, 627, 570);
		this.getContentPane().add(Liste);
		Liste.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(12, 12, 489, 20);
		Liste.add(textField);
		textField.setColumns(10);
		
		butt_recherche = new JButton("Recherche");
		butt_recherche.setBounds(507, 10, 102, 23);
		butt_recherche.addActionListener(this);
		Liste.add(butt_recherche);
		
        tableau = new JTable(donnees, entetes);
        
		scrollPane = new JScrollPane(tableau);
		scrollPane.setBounds(12, 43, 598, 515);
		Liste.add(scrollPane);
		        		
		panel = new JPanel();
		panel.setBounds(628, 0, 168, 570);
		this.getContentPane().add(panel);
		panel.setLayout(null);
		
		lbl_Sites = new JLabel("Sites / Software");
		lbl_Sites.setBounds(25, 40, 150, 15);
		panel.add(lbl_Sites);
		
		tfld_Site = new JTextField();
		tfld_Site.setBounds(10, 60, 145, 20);
		panel.add(tfld_Site);
		tfld_Site.setColumns(10);
		
		lbl_Login = new JLabel("Login");
		lbl_Login.setBounds(25, 100, 110, 15);
		panel.add(lbl_Login);
		
		tfld_Login = new JTextField();
		tfld_Login.setColumns(10);
		tfld_Login.setBounds(10, 120, 145, 20);
		panel.add(tfld_Login);
		
		lbl_Password = new JLabel("Password");
		lbl_Password.setBounds(25, 160, 110, 15);
		panel.add(lbl_Password);
		
		tfld_Password = new JTextField();
		tfld_Password.setColumns(10);
		tfld_Password.setBounds(10, 180, 145, 20);
		panel.add(tfld_Password);
		
		lbl_Size = new JLabel("Size : ");
		lbl_Size.setBounds(25, 220, 110, 15);
		panel.add(lbl_Size);
		
		tfld_Size = new JTextField();
		tfld_Size.setColumns(2);
		tfld_Size.setBounds(75, 220, 50, 20);
		panel.add(tfld_Size);
		
		chbx_Maj = new JCheckBox("Majuscules");
		chbx_Maj.setBounds(10, 250, 115, 25);
		panel.add(chbx_Maj);
		
		chbx_Numbers = new JCheckBox("Chiffres      ");
		chbx_Numbers.setBounds(10, 280, 115, 25);
		panel.add(chbx_Numbers);
		
		chbx_SP = new JCheckBox("Special Caractere");
		chbx_SP.setBounds(10, 310, 146, 25);
		panel.add(chbx_SP);
		
		chbx_Dash = new JCheckBox("Dash         ");
		chbx_Dash.setBounds(10, 340, 115, 25);
		panel.add(chbx_Dash);
		
		butt_Generate = new JButton("Generate");
		butt_Generate.setActionCommand("");
		butt_Generate.setBounds(20, 375, 120, 25);
		butt_Generate.addActionListener(this);
		panel.add(butt_Generate);
		
		butt_Copy = new JButton("Copy");
		butt_Copy.setBounds(20, 410, 120, 25);
		butt_Copy.addActionListener(this);
		panel.add(butt_Copy);
		
		butt_Clear = new JButton("Clear");
		butt_Clear.setBounds(10, 450, 145, 25);
		butt_Clear.addActionListener(this);
		panel.add(butt_Clear);
		
		butt_Modify = new JButton("Modify");
		butt_Modify.setBounds(10, 490, 145, 25);
		butt_Modify.addActionListener(this);
		panel.add(butt_Modify);
		
		butt_Add = new JButton("Add");
		butt_Add.setBounds(10, 530, 145, 25);
		butt_Add.addActionListener(this);
		panel.add(butt_Add);
	}
	
	
	public void actionPerformed(ActionEvent evt) {
		Object source = evt.getSource();

		// Password generate
		if (source.equals(this.butt_Generate)) {
			try {
				int size = Integer.parseInt(tfld_Size.getText());
				controler.keyGen(size, chbx_Maj.isSelected(), chbx_Numbers.isSelected(), chbx_SP.isSelected(), chbx_Dash.isSelected());
			}
			catch(java.lang.NumberFormatException e) {}
		}
		
		// Copy password to clipboard
		if (source.equals(this.butt_Copy)) {
			controler.copy();
		}
		
		// Clear modifcation
		if (source.equals(this.butt_Clear)) {
			controler.clear();
		}

	}
	
	
	public JTextField getTfld_Password() {
		return tfld_Password;
	}
	
	
	public JTextField getTfld_Site() {
		return tfld_Site;
	}


	public JTextField getTfld_Login() {
		return tfld_Login;
	}


	public JTextField getTfld_Size() {
		return tfld_Size;
	}


	public JCheckBox getChbx_Maj() {
		return chbx_Maj;
	}


	public JCheckBox getChbx_Numbers() {
		return chbx_Numbers;
	}


	public JCheckBox getChbx_SP() {
		return chbx_SP;
	}


	public JCheckBox getChbx_Dash() {
		return chbx_Dash;
	}

}