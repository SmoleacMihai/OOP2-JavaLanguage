package LABORATOR;
import java.util.Scanner;
import java.util.Vector;

public class ProblemFour {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Vector<Integer> arr = new Vector<>(n);
        for (int i = 0; i < n; i++) {
            arr.add(sc.nextInt());
        }
        int numerator = 0;
        int denominator = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                int num = arr.get(i);
                int den = arr.get(j);
                if (num < den && (double) num / den < 1 && (double) num / den > (double) numerator / denominator) {
                    numerator = num;
                    denominator = den;
                }
            }
        }
        System.out.println(numerator + "/" + denominator);
    }
}