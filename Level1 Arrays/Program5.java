import java.util.Scanner;

public class Program5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number: ");
        int number = sc.nextInt();
        int[] result = new int[4];

        for(int i = 0; i < 4; i++) {
            result[i] = number * (6 + i);
        }

        for(int i = 0; i < 4; i++) {
            System.out.println(number + " * " + (6 + i) + " = " + result[i]);
        }
        sc.close();
    }
}
