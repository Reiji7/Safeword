/**
 * RSA encryption
 * @author Adrien Claudel
 * @Date 12.09.2017
 */


package Ressources;

import java.math.*;
import java.security.*;


public class RSA {
	
    // Nombre 1 en BigInteger
    private final static BigInteger one = BigInteger.ONE;
    
    // Instance de création de nombre aleatoire
    private final static SecureRandom random = new SecureRandom();
    
    // Variable intermaidiaire utilisee pour la generation de cle
    private BigInteger phi0 = null;
    private BigInteger p1 = null;
    private BigInteger p2 = null;
    
    // Taille des cles 4096-bit
    private static int N = 128;

    
    /**
     * Generateur de cle RSA
     * 
     * @return Tableau de 3 chaine de caractere contenant les cle publique, modulus, cle prive
     */
    public String[] keyGen(){
        
        p1 = BigInteger.probablePrime(N / 2, random);
        p2 = BigInteger.probablePrime(N / 2, random);
        phi0 = (p1.subtract(one)).multiply(p2.subtract(one));
        
        BigInteger modulus = p1.multiply(p2);
        BigInteger privateKey = setPrivateKey(modulus);
        BigInteger publicKey = privateKey.modInverse(phi0);
        
        /* Retourne un tableau de 3 chaine de caractere contenant dans cette ordre */
        /* cle publique, modulus, cle prive */
        String tab[] = {publicKey + "", modulus + "", privateKey + ""};
        return tab;
        
    }
    

    /**
     * Generation de cles privee
     * 
     * @param modulus
     * 
     * @return La cles privee
     */
    private BigInteger setPrivateKey(BigInteger modulus){
        BigInteger privateKey = null;
        
        do {
        	privateKey = BigInteger.probablePrime(N / 2, random);
        }
        /* n'a aucun autre diviseur que 1 */
        while (privateKey.gcd(phi0).intValue() != 1 ||
                /* qu'il est plus grand que p1 et p2 */
               privateKey.compareTo(modulus) != -1 ||
                /* qu'il est plus petit que p1 * p2 */
               privateKey.compareTo(p1.max(p2)) == -1);
        
        return privateKey;
    }
    
    
    /**
     * Chiffre un caractere avec les clees public
     * pour le chiffrement les clees public doivent etre initialisees
     * le message doit être divise en packet de N / 8 octects ou bytes
     * 
     * @param message
     * @param publicKey
     * @param modulus
     * 
     * @return caractere chiffree
     */
    public String encrypt(BigInteger message, BigInteger publicKey, BigInteger modulus)
    {
        BigInteger rep = null;
        String str_message = new String(message.toByteArray());
        
        if (str_message.length() <= (N / 8))
        {
            if (publicKey != null && modulus != null &&
                message.toByteArray().length < Integer.MAX_VALUE){
                rep = message.modPow(publicKey, modulus);
            }
        }
        
        return "" + rep;
    }
    
    
    /**
     * Chiffre une phrase complete caractere par caractere
     * 
     * @param message
     * @param publicKey
     * @param modulus
     * 
     * @return chaine de caractere chiffree
     */
    public String encrypt(String message, String publicKey, String modulus){
        char a;
        BigInteger b;
        String c = "";
        
        for(int i = 0; i < message.length(); i++){
            a = message.charAt(i);
            b = new BigInteger("" + (int)a);
            c += "" + encrypt(b, new BigInteger(publicKey), new BigInteger(modulus)) + (char)29;
        }
        
        return c;
    }
    
    
    /**
     * Decrypte un caractere avec les clees prive
     * 
     * @param encrypted
     * @param privateKey
     * @param modulus
     * 
     * @return Chaine de caractere dechiffree
     */
    private BigInteger decrypt(BigInteger encrypted, BigInteger privateKey, BigInteger modulus){
        return encrypted.modPow(privateKey, modulus);
    }
    
    
    /**
     * Dechiffre une phrase complete caractere par caractere
     * 
     * @param p
     * @param pv
     * @param md
     * 
     * @return
     */
    public String decrypt(String p, String pv, String md){
        char a;
        BigInteger b;
        String c = "", d = "";
        
        for(int i = 0; i < p.length(); i++){
            if((int)p.charAt(i) != 29)
                c += p.charAt(i);
            else{
                b = new BigInteger(c);
                a = (char)decrypt(b, new BigInteger(pv), new BigInteger(md)).intValue();
                d += a;
                c = "";
            }
        }
        return d;
    }
}