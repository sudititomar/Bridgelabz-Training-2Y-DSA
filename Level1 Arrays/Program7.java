import java.util.Scanner;

public class Program7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number: ");
        int number = sc.nextInt();

        if(number <= 0) {
            System.out.println("Enter natural number");
            sc.close();
            return;
        }

        int size = number / 2 + 1;
        int[] odd = new int[size];
        int[] even = new int[size];
        int oddIndex = 0, evenIndex = 0;

        for(int i = 1; i <= number; i++) {
            if(i % 2 == 0) {
                even[evenIndex++] = i;
            } else {
                odd[oddIndex++] = i;
            }
        }

        System.out.print("Odd: ");
        for(int i = 0; i < oddIndex; i++) {
            System.out.print(odd[i] + " ");
        }
        System.out.print("\nEven: ");
        for(int i = 0; i < evenIndex; i++) {
            System.out.print(even[i] + " ");
        }
        System.out.println();
        sc.close();
    }
}
