package LABORATOR;

import java.util.Scanner;
import java.util.Vector;

public class ProblemFive {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Dati numarul de numere al vectorului: ");
        int n = sc.nextInt();
        Vector<Integer> vect = new Vector<>(n);

        for (int i = 0; i < n; i++) {
            vect.add(sc.nextInt());
        }

        for (int i = 0; i < n; i++) {
            int temp = vect.get(n - 1);

            for (int j = n - 1; j > 0; j--) {
                vect.set(j, vect.get(j - 1));
            }
            vect.set(0, temp);

            System.out.println(vect);
        }
    }
}
