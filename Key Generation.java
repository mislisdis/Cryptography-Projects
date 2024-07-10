import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PrimeKeyGenerator {
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

    public static void main(String[] args) {
        PrimeKeyGenerator primeKeyGen = new PrimeKeyGenerator(10, 50);
        int[] keys = primeKeyGen.generateKeys();
        System.out.println("Randomly selected prime numbers: p = " + keys[0] + ", q = " + keys[1]);
    }
}
