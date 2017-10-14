/**
 * Constant storage
 * @author Adrien Claudel
 * @Date 12.09.2017
 */


package Ressources;

import java.util.Random;

import javax.swing.JFileChooser;

public class Variable {
	
	public final static JFileChooser FC = new JFileChooser();
	
	public static RSA rsa = new RSA();
	
	public static Random random = new Random();

	public static String [] PUBLICKEY = {"", ""};

	public static String PRIVATEKEY = new String();
	
}