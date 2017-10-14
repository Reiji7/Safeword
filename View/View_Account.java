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
	private JPanel pane_setting;
	
	private JTextField tfld_search;
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
	
	private JButton butt_search;
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
	public View_Account(Controler_Account controler, Object[][] data) {
		
		this.controler = controler;
		
		initialize(data);
	}

	
	private void initializeTable(Object[][] data) {
        String[] entetes = {"Sites / Software", "Login", "Password"};
        tableau = new JTable(data, entetes);
        
        tableau.addMouseListener(new java.awt.event.MouseAdapter() {
        	
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
            	
            	if(tableau.getSelectedRow() != -1) {
                	controler.selectedRow(tableau.getSelectedRow());
            	}
            	
            }
        });		
	}
	
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Object[][] data) {
		this.setTitle("Safe-Word");
		this.setResizable(false);
		this.setBounds(100, 100, 900, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);
		
		Liste = new JPanel();
		Liste.setBounds(0, 0, 650, 570);
		this.getContentPane().add(Liste);
		Liste.setLayout(null);
		
		tfld_search = new JTextField();
		tfld_search.setBounds(10, 20, 500, 25);
		Liste.add(tfld_search);
		tfld_search.setColumns(10);
		
		butt_search = new JButton("Recherche");
		butt_search.setBounds(520, 20, 120, 25);
		butt_search.addActionListener(this);
		Liste.add(butt_search);
		
		initializeTable(data);
        
		scrollPane = new JScrollPane(tableau);
		scrollPane.setBounds(10, 60, 630, 500);
		Liste.add(scrollPane);

		pane_setting = new JPanel();
		pane_setting.setBounds(650, 0, 250, 570);
		this.getContentPane().add(pane_setting);
		pane_setting.setLayout(null);
		
		lbl_Sites = new JLabel("Sites / Software");
		lbl_Sites.setBounds(40, 40, 150, 15);
		pane_setting.add(lbl_Sites);
		
		tfld_Site = new JTextField();
		tfld_Site.setBounds(20, 60, 200, 20);
		pane_setting.add(tfld_Site);
		tfld_Site.setColumns(10);
		
		lbl_Login = new JLabel("Login");
		lbl_Login.setBounds(40, 100, 110, 15);
		pane_setting.add(lbl_Login);
		
		tfld_Login = new JTextField();
		tfld_Login.setColumns(10);
		tfld_Login.setBounds(20, 120, 200, 20);
		pane_setting.add(tfld_Login);
		
		lbl_Password = new JLabel("Password");
		lbl_Password.setBounds(40, 160, 110, 15);
		pane_setting.add(lbl_Password);
		
		tfld_Password = new JTextField();
		tfld_Password.setColumns(10);
		tfld_Password.setBounds(20, 180, 200, 20);
		pane_setting.add(tfld_Password);
		
		lbl_Size = new JLabel("Size : ");
		lbl_Size.setBounds(50, 220, 110, 15);
		pane_setting.add(lbl_Size);
		
		tfld_Size = new JTextField();
		tfld_Size.setColumns(2);
		tfld_Size.setBounds(100, 220, 50, 20);
		pane_setting.add(tfld_Size);
		
		chbx_Maj = new JCheckBox("Majuscules");
		chbx_Maj.setBounds(25, 250, 200, 25);
		pane_setting.add(chbx_Maj);
		
		chbx_Numbers = new JCheckBox("Chiffres      ");
		chbx_Numbers.setBounds(25, 280, 200, 25);
		pane_setting.add(chbx_Numbers);
		
		chbx_SP = new JCheckBox("Special Caractere");
		chbx_SP.setBounds(25, 310, 200, 25);
		pane_setting.add(chbx_SP);
		
		chbx_Dash = new JCheckBox("Dash         ");
		chbx_Dash.setBounds(25, 340, 200, 25);
		pane_setting.add(chbx_Dash);
		
		butt_Generate = new JButton("Generate");
		butt_Generate.setActionCommand("");
		butt_Generate.setBounds(55, 375, 120, 25);
		butt_Generate.addActionListener(this);
		pane_setting.add(butt_Generate);
		
		butt_Copy = new JButton("Copy");
		butt_Copy.setBounds(55, 410, 120, 25);
		butt_Copy.addActionListener(this);
		pane_setting.add(butt_Copy);
		
		butt_Clear = new JButton("Clear");
		butt_Clear.setBounds(40, 450, 150, 25);
		butt_Clear.addActionListener(this);
		pane_setting.add(butt_Clear);
		
		butt_Modify = new JButton("Modify");
		butt_Modify.setBounds(40, 490, 150, 25);
		butt_Modify.addActionListener(this);
		pane_setting.add(butt_Modify);
		
		butt_Add = new JButton("Add");
		butt_Add.setBounds(40, 530, 150, 25);
		butt_Add.addActionListener(this);
		pane_setting.add(butt_Add);
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
		
		if (source.equals(this.butt_Modify) && tableau.getSelectedRow() != -1){
			controler.modify(tableau.getSelectedRow(), tfld_Site.getText(), tfld_Login.getText(), tfld_Password.getText());
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