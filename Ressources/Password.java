package Ressources;

public class Password {

	
	/**
	 * Password generator
	 * 
	 * @param size Size of password
	 * @param upper Include uppercase
	 * @param numbers Include numbers
	 * @param spec Include special characters
	 * @param dash Structure by dash
	 * 
	 * @return password
	 */
	public static String keyGen(int size, boolean upper, boolean numbers, boolean spec, boolean dash) {
		String password = new String();
		char tampon = (char)00;
		
		for(int i = 0; i < size; i++) {

			if(dash && i % 4 == 3 && i != 0) {
				password += "-";
			}
			else {
				
				switch(1 + Variable.random.nextInt(4)) {
				
					// lettre de en minuscule
					case 1:
						tampon = (char) ((char)97 + Variable.random.nextInt(122 - 97));
					break;
					
					// lettre en majuscule
					case 2:
						if(upper)
							tampon = (char) ((char)65 + Variable.random.nextInt(90 - 65));
					break;
					
					// numeros de 0 a 9
					case 3:
						if(numbers)
							tampon = (char) ((char)48 + Variable.random.nextInt(57 - 48));
					break;
					
					// caractere spécial
					case 4:
						if(spec)
							tampon = (char) ((char)33 + Variable.random.nextInt(47 - 33));
					break;
					
				}

				if(i >= 1) {
					if(password.charAt(i-1) != tampon) {
						password += tampon;
					}
					else {
						i--;
					}
				}
				else {
					password += tampon;
				}

			}
		}
		
		return password;
	}
}