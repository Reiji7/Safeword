/**
 * File reader
 * @author Adrien Claudel
 * @Date 12.09.2017
 */


package Ressources;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ReadFile {

	public static String read(String reading) {
		String data = new String();
		Path path = Paths.get(reading);
		
		try(BufferedReader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8)){
		    String line = new String();
		    while((line = reader.readLine()) != null){
		        data += line;
		    }
		}
		catch(IOException ioe){
			System.out.println("Erreur lors de la lecture");
		}
		
		return data;
	}
	
}