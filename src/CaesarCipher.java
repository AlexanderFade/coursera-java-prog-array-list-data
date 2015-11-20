import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * Created by Alexander Kovalevsky on 19.11.2015.
 */
public class CaesarCipher {
    public String encrypt(String input, int key) {
        StringBuilder encrypted = new StringBuilder(input);

        //String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890abcdefghijklmnopqrstuvwxyz";
        String alphabetUC = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String alphabetLC = "abcdefghijklmnopqrstuvwxyz";
        String shiftedAlphabetUC = alphabetUC.substring(key) + alphabetUC.substring(0, key);
        String shiftedAlphabetLC = alphabetLC.substring(key) + alphabetLC.substring(0, key);


        for (int i = 0; i < encrypted.length(); i++) {
            char currChar = encrypted.charAt(i);
            /* */
            int index = 0;
            boolean upperCaseChar = false;
            if (Character.isUpperCase(currChar)) {
                index = alphabetUC.indexOf(currChar);
                upperCaseChar = true;
            } else index = alphabetLC.indexOf(currChar);

            if (index != -1) {
                if (upperCaseChar) {
                    char newChar = shiftedAlphabetUC.charAt(index);
                    encrypted.setCharAt(i, newChar);
                } else {
                    char newChar = shiftedAlphabetLC.charAt(index);
                    encrypted.setCharAt(i, newChar);
                }
            }
            /* */


//            int idx = alphabetUC.indexOf(currChar);

//            if (idx != -1) {
//                char newChar = shiftedAlphabetUC.charAt(idx);
//                encrypted.setCharAt(i, newChar);
//            }
            // Otherwise: do nothing
        }
        return encrypted.toString();
    }

    public String encryptTwoKeys(String input, int key1, int key2) {
        StringBuilder encrypted = new StringBuilder(input);

        //String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890abcdefghijklmnopqrstuvwxyz";
        String alphabetUC = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String alphabetLC = "abcdefghijklmnopqrstuvwxyz";
//        String shiftedAlphabetUC = alphabetUC.substring(key) + alphabetUC.substring(0, key);
//        String shiftedAlphabetLC = alphabetLC.substring(key) + alphabetLC.substring(0, key);


        for (int i = 0; i < encrypted.length(); i++) {
            if (i%2 == 0) {
                String shiftedAlphabetUC = alphabetUC.substring(key1) + alphabetUC.substring(0, key1);
                String shiftedAlphabetLC = alphabetLC.substring(key1) + alphabetLC.substring(0, key1);

                char currChar = encrypted.charAt(i);
                /* */
                int index = 0;
                boolean upperCaseChar = false;
                if (Character.isUpperCase(currChar)) {
                    index = alphabetUC.indexOf(currChar);
                    upperCaseChar = true;
                } else index = alphabetLC.indexOf(currChar);

                if (index != -1) {
                    if (upperCaseChar) {
                        char newChar = shiftedAlphabetUC.charAt(index);
                        encrypted.setCharAt(i, newChar);
                    } else {
                        char newChar = shiftedAlphabetLC.charAt(index);
                        encrypted.setCharAt(i, newChar);
                    }
                }
            } else {
                String shiftedAlphabetUC = alphabetUC.substring(key2) + alphabetUC.substring(0, key2);
                String shiftedAlphabetLC = alphabetLC.substring(key2) + alphabetLC.substring(0, key2);

                char currChar = encrypted.charAt(i);
                /* */
                int index = 0;
                boolean upperCaseChar = false;
                if (Character.isUpperCase(currChar)) {
                    index = alphabetUC.indexOf(currChar);
                    upperCaseChar = true;
                } else index = alphabetLC.indexOf(currChar);

                if (index != -1) {
                    if (upperCaseChar) {
                        char newChar = shiftedAlphabetUC.charAt(index);
                        encrypted.setCharAt(i, newChar);
                    } else {
                        char newChar = shiftedAlphabetLC.charAt(index);
                        encrypted.setCharAt(i, newChar);
                    }
                }
            }
        }

        return encrypted.toString();
    }

    public void testCaesar() {
        int key = 15;
        String message = "Can you imagine life WITHOUT the internet AND computers in your pocket?";
        String encrypted = encrypt(message, key);
        System.out.println(encrypted);
        String decrypted = encrypt(encrypted, 26-key);
        System.out.println(decrypted);

    }

    public void testCaesarTwoKeys(){
        int key1 = 21;
        int key2 = 8;
        String message = "Can you imagine life WITHOUT the internet AND computers in your pocket?";
        String encrypted = encryptTwoKeys(message, key1, key2);
        System.out.println(encrypted);
//        String decrypted = encrypt(encrypted, 26-key1, 26-key2);
//        System.out.println(decrypted);

    }

    public static void main(String[] args) throws FileNotFoundException {
        CaesarCipher cc = new CaesarCipher();
        cc.testCaesar();
        cc.testCaesarTwoKeys();
    }

}
