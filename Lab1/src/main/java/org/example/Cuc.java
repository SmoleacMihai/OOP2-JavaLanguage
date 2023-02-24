package org.example;

public class Cuc {
      public static String name;
      public static int age;

    public Cuc(String _name, int _age) {
        name = _name;
        age = _age;
    }

    public void presentHowMuchYearsLeft() {
        System.out.println("Persoana " + name + " are " + (100 - age) + " ani inainte.");
    }

    public void singAsMuchCuAsThePersonLivesTillHundred(){
        for (int i = age; i < 100; ++i) {
            System.out.print("Cu ");
        }
        System.out.println("");
    }
}
