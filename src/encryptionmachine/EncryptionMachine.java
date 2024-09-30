package encryptionmachine;

import java.util.Scanner;

/**
 * @author Lance Balstad
 * Date: September 30, 2024
 * 
 * Description:
 * This program takes and encrypts a message that the user inputs.
 * It shifts each letter from the input word(s) according to the SHIFT parameter
 */
public class EncryptionMachine 
{
    // Alphabet used to shift letters
    public static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
    
    //The number of times the letter will shift for the encryption
    public static final int SHIFT = 3;
    
    public static void main(String[] args) 
    {
        //Introduction
        System.out.println("Welcome to the CSCI717 Encryption Machine Construction"
            + "\nThe program lets you encrypt a message"
            + "\nwith a key for your recipient to decrypt!");
        
        Scanner scanner = new Scanner(System.in);
        
        processKey(scanner);
        
        processMessage(scanner);

        System.out.println("Message fully encrypted. Happy secret messaging!");
    }
    
    /**
     * Encrypts a given letter according to the SHIFT value in this file
     * 
     * @param letter The input letter that will be encrypted
     * @return The encrypted version of the input letter
     */
    public static char encryptLetter(char letter) 
    {
        int letterPosition = ALPHABET.indexOf(letter);

        int encryptedLetterPosition = (letterPosition + SHIFT) % ALPHABET.length();

        char encryptedLetter = ALPHABET.charAt(encryptedLetterPosition);

        return encryptedLetter;
    }
    
    /**
     * Encrypts a given word using the encryptLetter method
     * 
     * @param word The input word that will be encrypted
     * @return The encrypted version of the input word
     */
    public static String encryptWord(String word) 
    {
        StringBuilder encryptedWord = new StringBuilder();
        
        for (int i = 0; i < word.length(); i++)
        {
            char encryptedLetter = encryptLetter(word.charAt(i));
            encryptedWord.append(encryptedLetter);
        }
        
        return encryptedWord.toString();
    }

    /**
     * Takes user input key and encrypts it for them so that they can see the key
     * @param scanner Scanner to scan input value
     */
    public static void processKey(Scanner scanner) {      
        System.out.println("Enter key:");
        String key = scanner.next();
        System.out.println(key + " has been encrypted to: " + encryptWord(key) + "\n");
    }

    /**
     * Takes user input word and encrypts it for them
     * @param scanner Scanner to scan input value
     */
    public static void processMessage(Scanner scanner) {
        System.out.println("How many words is your message?");
        int numWords = scanner.nextInt();

        for(int i = 0; i < numWords; i++) {
            System.out.println("Next word:");
            String word = scanner.next();
            System.out.println(word + " has been encrypted to: " + encryptWord(word) + "\n");
        }
        scanner.close();
    }

    
}
