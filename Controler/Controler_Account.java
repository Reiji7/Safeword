package Controler;


import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

import Ressources.ExtractFile;
import Ressources.Password;
import View.View_Account;


public class Controler_Account {

	private View_Account view;	
	private Object[][] data;
	
	public Controler_Account(String data) {
		this.data = ExtractFile.extractData(data);
		this.view = new View_Account(this, this.data);
		view.run();
	}


	/**
	 * @return the view
	 */
	public View_Account getView() {
		return view;
	}
	
	
	/**
	 * Password generator
	 * 
	 * @param size Size of password
	 * @param upper Include uppercase
	 * @param numbers Include numbers
	 * @param spec Include special carachteres
	 * @param dash Structure by dash
	 */
	public void keyGen(int size, boolean upper, boolean numbers, boolean spec, boolean dash) {
		String newPass = Password.keyGen(size, upper, numbers, spec, dash);
		view.getTfld_Password().setText(newPass);
	}
	
	
	/**
	 * Copy password to clipboard
	 */
	public void copy() {
		StringSelection stringSelection = new StringSelection(view.getTfld_Password().getText());
		Clipboard clpbrd = Toolkit.getDefaultToolkit().getSystemClipboard();
		clpbrd.setContents(stringSelection, null);
	}


	/**
	 * Clear system mofication
	 */
	public void clear() {
		view.getTfld_Site().setText(null);
		view.getTfld_Login().setText(null);
		view.getTfld_Password().setText(null);
		view.getTfld_Size().setText(null);

		view.getChbx_Maj().setSelected(false);
		view.getChbx_Numbers().setSelected(false);
		view.getChbx_SP().setSelected(false);
		view.getChbx_Dash().setSelected(false);
	}


	public void modify(int selectedRow, String site, String login, String pass) {
		this.data[selectedRow][0] = site;
		this.data[selectedRow][1] = login;
		this.data[selectedRow][2] = pass;
	}
	
	
	public void selectedRow(int row) {
		view.getTfld_Site().setText((String) data[row][0]);
		view.getTfld_Login().setText((String) data[row][1]);
		view.getTfld_Password().setText((String) data[row][2]);
	}

}