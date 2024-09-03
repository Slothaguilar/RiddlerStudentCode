import static java.lang.Character.isLowerCase;
import static java.lang.Character.isUpperCase;

/**
 * The Riddler:
 * A puzzle by Zach Blick
 * for Adventures in Algorithms
 * At Menlo School in Atherton, CA
 *
 * Completed by: Sofia Aguilar
 */
public class Riddler {

    public String decryptOne(String encrypted) {
        String decrypted = "";

        // TODO: Complete the decryptOne() function.
        for (int i = 0; i < encrypted.length(); i++){
            char current = encrypted.charAt(i);
            if (isUpperCase(current)){
                // Shift the letter by 9 and wrap around if needed
                char shifted = (char)((encrypted.charAt(i)-'A'+9) % 26 + 'A');
                decrypted += shifted;
            }
            else if (isLowerCase(current)) {
                // Shift the letter by 9 and wrap around if needed
                char shifted = (char) ((encrypted.charAt(i) - 'a' + 9) % 26 + 'a');
                decrypted += shifted;
            }
            else {
                decrypted += current;
            }
        }
        return decrypted;
    }

    public String decryptTwo(String encrypted) {
        String decrypted = "";

        // TODO: Complete the decryptTwo() function.
        // Split the string into parts using spaces
        String[] values = encrypted.split(" ");
        for (int i = 0; i < values.length; i++) {
            // Current value
            String value = values[i];
            int asciiValue = 0;

            // Convert each value to an integer
            for (int j = 0; j < value.length(); j++) {
                asciiValue += (int) ((value.charAt(j) - '0') * Math.pow(10, value.length() - j - 1));
            }

            // Convert the integer to its character
            char character = (char) asciiValue;

            decrypted += character;
        }

        return decrypted;
    }

    public String decryptThree(String encrypted) {
        String decrypted = "";

        // TODO: Complete the decryptThree() function.
        for (int i = 0; i < encrypted.length(); i+=8) {
            // The binary code has the length of 8 so get that chunk
            String string = encrypted.substring(i, i + 8);
            int val = 0;

            // Convert the string to an integer
            for (int j = 0; j < 8; j++) {
                val += (string.charAt(j) - '0') << (8 - j - 1);
            }
            // Convert the integer to a character
            char current = (char) val;

            decrypted += current;
        }

        return decrypted;
    }

    public String decryptFour(String encrypted) {
        String decrypted = "";

        // TODO: Complete the decryptFour() function.
        for (int i = 0; i < encrypted.length(); i++) {
            // Get current dingbat character
            char dingbatChar = encrypted.charAt(i);

            // Get the code point of the dingbat character
            int codePoint = dingbatChar;

            // Subtract the base dingbat and add the shift
            int original = codePoint - 0x2700 + 45;

            // Convert the code point to character
            char current = (char) original;

            decrypted += current;
        }

        return decrypted;
    }
}
