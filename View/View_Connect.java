/**
 * Data selection Frame
 * @author Adrien Claudel
 * @Date 11.09.2017
 */


package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import Controler.Controler_Connect;
import Ressources.Variable;


@SuppressWarnings("serial")
public class View_Connect extends JFrame implements ActionListener{
	
	private Controler_Connect controler;
	
	// Text field 
	private JTextField tfld_DataBase;
	private JTextField tfld_Password;

	// Button
	private JButton butt_DataPath, butt_PassPath, butt_Load;


	/**
 	 * Create the panel.
 	 * 
	 * @param controler
	 */
	public View_Connect(Controler_Connect controler) {
		initialize();
		setLayout(null);
		
		this.controler = controler;

		// Data finding 
		JLabel lbl_DataBase = new JLabel("Data Base :");
		lbl_DataBase.setVerticalAlignment(SwingConstants.TOP);
		lbl_DataBase.setBounds(12, 12, 90, 15);
		add(lbl_DataBase);
		
		tfld_DataBase = new JTextField();
		tfld_DataBase.setColumns(10);
		tfld_DataBase.setBounds(12, 39, 359, 25);
		add(tfld_DataBase);
		
		butt_DataPath = new JButton("...");
		butt_DataPath.setBounds(383, 39, 55, 25);
		butt_DataPath.addActionListener(this);
		add(butt_DataPath);

		// Password finding
		JLabel lbl_Password = new JLabel("Password :");
		lbl_Password.setVerticalAlignment(SwingConstants.TOP);
		lbl_Password.setBounds(12, 76, 90, 15);
		add(lbl_Password);
		
		tfld_Password = new JTextField();
		tfld_Password.setColumns(10);
		tfld_Password.setBounds(12, 103, 359, 25);
		add(tfld_Password);
		
		butt_PassPath = new JButton("...");
		butt_PassPath.setBounds(383, 103, 55, 25);
		butt_PassPath.addActionListener(this);
		add(butt_PassPath);

		// Validation button
		butt_Load = new JButton("Load");
		butt_Load.setBounds(166, 156, 117, 31);
		butt_Load.addActionListener(this);
		add(butt_Load);

	}


	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		this.setTitle("Connection");
		this.setResizable(false);
		this.setBounds(100, 100, 450, 250);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);
	}

	
	/**
	 * 
	 */
	public void setDataText(String text) {
		tfld_DataBase.setText(text);
	}
	
	
	/**
	 * 
	 */
	public void setPassText(String text) {
        tfld_Password.setText(text);
	}
	
	
	/**
	 * Loading of data and decryption files
	 */
	@Override
	public void actionPerformed(ActionEvent evt) {
		Object source = evt.getSource();

		// Data finding 
		if (source.equals(this.butt_DataPath)) {
			if(Variable.FC.showOpenDialog(butt_DataPath) == JFileChooser.APPROVE_OPTION) {
				controler.dataConnect(Variable.FC.getSelectedFile().getAbsolutePath());
			}
		}
		
		// Password finding
		if (source.equals(this.butt_PassPath)) {
			if(Variable.FC.showOpenDialog(butt_PassPath) == JFileChooser.APPROVE_OPTION) {
				controler.passwordConnect(Variable.FC.getSelectedFile().getAbsolutePath());
			}
		}
		
		// Validation button
		if (source.equals(this.butt_Load)) {
			controler.loadingData();
		}
	}

}