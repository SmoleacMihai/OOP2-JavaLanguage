package basiic;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("a = ");
        int a = sc.nextInt();

        System.out.print("b = ");
        int b = sc.nextInt();

        System.out.print("op = ");
        String op = sc.next();

        switch (op) {
            case "+" -> {
                System.out.println("a + b = " + ((double) a + b));
            }
            case "-" -> {
                System.out.println("a - b = " + ((double) a - b));
            }
            case "*" -> {
                System.out.println("a * b = " + ((double) a * b));
            }
            case "/" -> {
                System.out.println("a / b = " + ((double) a / b));
            }
        }

    }
}
