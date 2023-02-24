package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Name of first person: ");
        String nameToInput = sc.nextLine();

        System.out.print("Age of first person: ");
        int ageToInput = sc.nextInt();

        Cuc obj1 = new Cuc("Ion", ageToInput);
        obj1.singAsMuchCuAsThePersonLivesTillHundred();
        obj1.presentHowMuchYearsLeft();

        Cuc obj2 = new Cuc("Vasea", 30);
        obj2.singAsMuchCuAsThePersonLivesTillHundred();
        obj2.presentHowMuchYearsLeft();
    }
}