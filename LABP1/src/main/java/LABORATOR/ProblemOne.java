package LABORATOR;
import java.util.Scanner;
public class ProblemOne {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of elements: ");
        int n = sc.nextInt();

        double min = Double.MAX_VALUE;
        double num;
        for (int i = 0; i < n; i++) {
            System.out.print("Enter number " + (i + 1) + ": ");
            num = sc.nextDouble();
            if (num < min) {
                min = num;
            }
        }

        System.out.println("Minimum value: " + min);
        sc.close();
    }
}
