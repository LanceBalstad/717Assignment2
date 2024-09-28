package encryptionmachine;

import java.util.Scanner;

/**
 *
 * @author Balst
 */
public class EncryptionMachine 
{
    public static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
    public static final int SHIFT = 3;
    
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Welcome to the CSCI717 Encryption Machine Construction"
                + "\nThe program lets you encrypt a message"
                + "\nwith a key for your recipient to decrypt!");
        
        System.out.println("Enter key:");
        String key = scanner.next();
        System.out.println(key + " has been encrypted to: " + encryptWord(key) + "\n");
              
        System.out.println("How many words is your message?");
        int numWords = scanner.nextInt();
        
        for(int i = 0; i < numWords; i++)
        {
            System.out.println("Next word:");
            String word = scanner.next();
            System.out.println(word + " has been encrypted to: " + encryptWord(word) + "\n");
        }
        
        scanner.close();
        System.out.println("Message fully encrypted. Happy secret messaging!");
    }
    
    public static char encryptLetter(char letter) 
    {
        int letterPosition = ALPHABET.indexOf(letter);

        int encryptedLetterPosition = (letterPosition + SHIFT) % ALPHABET.length();

        char encryptedLetter = ALPHABET.charAt(encryptedLetterPosition);

        return encryptedLetter;
    }
    
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
    
}
