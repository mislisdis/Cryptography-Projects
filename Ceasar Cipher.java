import java.util.Scanner;

public class CaesarCipher {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // User input for plaintext
        System.out.print("Enter the plaintext message: ");
        String plaintext = scanner.nextLine();

        // User input for shift key
        System.out.print("Enter the shift key: ");
        int shift = scanner.nextInt();

        // Encrypt the plaintext
        String encryptedText = encrypt(plaintext, shift);
        System.out.println("Encrypted message: " + encryptedText);

        // Decrypt the ciphertext
        String decryptedText = decrypt(encryptedText, shift);
        System.out.println("Decrypted message: " + decryptedText);
    }

    public static String encrypt(String text, int shift) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);

            if (Character.isLetter(c)) {
                char base = Character.isLowerCase(c) ? 'a' : 'A';
                result.append((char) ((c - base + shift) % 26 + base));
            } else {
                result.append(c);
            }
        }

        return result.toString();
    }

    public static String decrypt(String text, int shift) {
        return encrypt(text, 26 - shift);
    }
}
