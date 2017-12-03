package Ressources;

import java.util.ArrayList;

public class ExtractFile {

	public static Object[][] extractData(String data){

        ArrayList<String[]> liste = extractColumns(data);
        Object[][] accountListe = new Object[liste.size()][3];
        int index = 0;
        
        for(String[] line : liste) {
        	accountListe[index][0] = line[0];
        	accountListe[index][1] = line[1];
        	accountListe[index][2] = line[2];

        	index++;
        }

		return accountListe;
	}
	
	
	private static ArrayList<String[]> extractColumns(String data) {
        char cara;
        ArrayList<String[]> liste = new ArrayList<>();
        String str = "";

        for(int i = 0; i < data.length(); i++){

        	cara = data.charAt(i);

        	if ((int)cara == 10) {
        		liste.add(extractLine(str));
        		str = "";
        	}
        	else {
                str += "" + cara;        	
        	}
        }

		return liste;
	}
	
	
	private static String[] extractLine(String line) {
		
        char cara;
        int index = 0;
        String str = "";
		String[] liste = {"", "", ""};
		
        for(int i = 0; i < line.length(); i++){
        	
        	cara = line.charAt(i);
        	
    		if((int)cara == 32) {
    			liste[index] = str;
    			index++;
            	str = "";
            }
    		else {
                str += "" + cara;
    		}
        }

		return liste;
	}
	
}
