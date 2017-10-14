package Controler;

import View.View_Connect;
import Ressources.*;


public class Controler_Connect {

	private View_Connect view;
	private String data, password;

	
	public Controler_Connect() {
		this.view = new View_Connect(this);
	}

	
	public void dataConnect(String data) {
		this.data = data;
		view.setDataText(data);
	}
	
	
	public void passwordConnect(String pass) {
		this.password = pass;
		view.setPassText(password);
	}
	
	
	public void loadingData() {
		
		// Temporaire 
		this.data = "/home/adrien/SafeWord Test/data";
		this.password = "/home/adrien/SafeWord Test/pass";
		// Temporaire
		
		this.data = ReadFile.read(this.data);
		String password = ReadFile.read(this.password);
		try {
			this.decryption(password);
			new Controler_Account(data);
			view.dispose();
		}
		catch(java.lang.ArrayIndexOutOfBoundsException e) {}
	}

	
	/**
	 * File decryption
	 * 
	 * @param key
	 */
	public void decryption(String key) {
		extractkey(key);
		this.data = Variable.rsa.decrypt(this.data, Variable.PRIVATEKEY, Variable.PUBLICKEY[1]);
	}

	
	/**
	 * Extract key
	 * 
	 * @param key
	 */
	private void extractkey(String key) {
        char a;
        int index = 0;
        String [] str = {"", "", ""};
        
        for(int i = 0; i < key.length(); i++){
            a = key.charAt(i);
            if((int)a == 29) {
            	index++;
            }
            else {
                str[index] += "" + a;
            }
        }

        Variable.PUBLICKEY[0] = str[0];
        Variable.PUBLICKEY[1] = str[1];
        Variable.PRIVATEKEY = str[2];
	}
	

	public View_Connect getView() {
		return view;
	}
}