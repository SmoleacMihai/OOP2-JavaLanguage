package LABORATOR;

import java.util.Scanner;

public class ProblemThree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int intialNumeber = 0;
        int firstTwoNumber = 0;
        int lastTwoNumber = 0;

        System.out.println("Give a five digits number: ");
        intialNumeber= sc.nextInt();

        firstTwoNumber = intialNumeber / 1000;
        lastTwoNumber = intialNumeber % 100;

        System.out.println(Integer.toString(firstTwoNumber) + Integer.toString(lastTwoNumber));
    }
}