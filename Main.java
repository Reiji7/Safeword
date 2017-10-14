/**
 * Constant storage
 * @author Adrien Claudel
 * @Date 12.09.2017
 */


import java.awt.EventQueue;
import Controler.*;
import View.*;


public class Main {

	public static void main(String[] args) {

		final Controler_Connect connect = new Controler_Connect();
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					View_Connect window = connect.getView();
					window.setVisible(true);
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}	
}