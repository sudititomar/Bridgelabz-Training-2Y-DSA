import java.util.*;

public class Problem1 {
    public static double algorithmA(double[] temperatures, int n) {
        double total = 0;
        for (int i = 0; i < n; i++) {
            total += temperatures[i];
        }
        return total / n;
    }

    public static double algorithmB(double[] temperatures, int n) {
        if (n == 0) return 0;
        double sum = temperatures[0];
        for (int i = 1; i < n; i++) {
            sum += temperatures[i];
        }
        for (int i = 0; i < n; i++) {
            sum = sum / n;
        }
        return sum;
    }

    public static void testProblem1() {
        double[][] testCases = {{20,25,22,24,21}, {10}, {-5,0,5,10}, {100,100,100}};
        int[] ns = {5,1,4,3};

        System.out.println("Problem 1 Results:");
        for (int i = 0; i < testCases.length; i++) {
            double[] temps = testCases[i];
            int n = ns[i];
            double expected = Arrays.stream(temps).sum() / n;
            double resA = algorithmA(temps, n);
            double resB = algorithmB(temps, n);
            System.out.printf("n=%d: A=%.2f B=%.2f Expected=%.2f%n", n, resA, resB, expected);
        }
    }
}
