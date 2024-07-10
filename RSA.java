import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class RSA {

    public static void main(String[] args) {
        // Generate prime numbers
        PrimeKeyGenerator primeKeyGen = new PrimeKeyGenerator(10, 50);
        int[] keys = primeKeyGen.generateKeys();
        int p = keys[0];
        int q = keys[1];

        System.out.println("Randomly selected prime numbers: p = " + p + ", q = " + q);

        // Compute n = p * q
        BigInteger n = BigInteger.valueOf(p).multiply(BigInteger.valueOf(q));
        System.out.println("n (modulus) = p * q = " + n);

        // Compute phi = (p - 1) * (q - 1)
        BigInteger phi = BigInteger.valueOf(p - 1).multiply(BigInteger.valueOf(q - 1));
        System.out.println("phi (Euler's Totient) = (p - 1) * (q - 1) = " + phi);

        // Choose e such that 1 < e < phi and gcd(e, phi) = 1
        BigInteger e = BigInteger.valueOf(65537); // common choice for e
        if (phi.gcd(e).intValue() != 1) {
            e = BigInteger.valueOf(3); // fallback to a small prime
        }
        System.out.println("Public exponent (e) = " + e);

        // Compute d such that (e * d) % phi = 1
        BigInteger d = e.modInverse(phi);
        System.out.println("Private exponent (d) = " + d);

        System.out.println("Public key (e, n): (" + e + ", " + n + ")");
        System.out.println("Private key (d, n): (" + d + ", " + n + ")");

        // Input plaintext message from user
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the plaintext message: ");
        String plaintext = scanner.nextLine();
        System.out.println("Plaintext: " + plaintext);

        // Encrypt the plaintext message
        BigInteger encrypted = encrypt(plaintext, e, n);
        System.out.println("Encrypted: " + encrypted);

        // Decrypt the ciphertext message
        String decrypted = decrypt(encrypted, d, n);
        System.out.println("Decrypted: " + decrypted);
    }

    public static BigInteger encrypt(String plaintext, BigInteger e, BigInteger n) {
        return (new BigInteger(plaintext.getBytes())).modPow(e, n);
    }

    public static String decrypt(BigInteger ciphertext, BigInteger d, BigInteger n) {
        return new String(ciphertext.modPow(d, n).toByteArray());
    }

    static class PrimeKeyGenerator {
        private int start;
        private int end;
        private List<Integer> primes;

        public PrimeKeyGenerator(int start, int end) {
            this.start = start;
            this.end = end;
            this.primes = generatePrimes();
        }

        private boolean isPrime(int n) {
            if (n <= 1) return false;
            if (n <= 3) return true;
            if (n % 2 == 0 || n % 3 == 0) return false;
            for (int i = 5; i * i <= n; i += 6) {
                if (n % i == 0 || n % (i + 2) == 0) return false;
            }
            return true;
        }

        private List<Integer> generatePrimes() {
            List<Integer> primes = new ArrayList<>();
            for (int i = start; i <= end; i++) {
                if (isPrime(i)) {
                    primes.add(i);
                }
            }
            return primes;
        }

        public int[] generateKeys() {
            if (primes.size() < 2) {
                throw new IllegalArgumentException("Not enough prime numbers in the given range.");
            }

            Random random = new Random();
            int p = primes.get(random.nextInt(primes.size()));
            int q = primes.get(random.nextInt(primes.size()));
            while (p == q) {
                q = primes.get(random.nextInt(primes.size()));
            }

            return new int[]{p, q};
        }
    }
}
