import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class EulerTotientFunction {
    private int start;
    private int end;
    private List<Integer> primes;

    public EulerTotientFunction(int start, int end) {
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

    public int generateRandomPrime() {
        if (primes.size() == 0) {
            throw new IllegalArgumentException("No prime numbers found in the given range.");
        }

        Random random = new Random();
        return primes.get(random.nextInt(primes.size()));
    }

    public int calculateEulerTotient(int p) {
        // For a prime number p, φ(p) = p - 1
        return p - 1;
    }

    public static void main(String[] args) {
        EulerTotientFunction etf = new EulerTotientFunction(10, 50);
        int p = etf.generateRandomPrime();
        int phi = etf.calculateEulerTotient(p);
        System.out.println("Randomly selected prime number: p = " + p);
        System.out.println("Euler's Totient Function value φ(p) = " + phi);
    }
}
