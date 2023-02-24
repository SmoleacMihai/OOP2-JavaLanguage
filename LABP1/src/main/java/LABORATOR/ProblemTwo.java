package LABORATOR;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProblemTwo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = new ArrayList<Integer>();
        int num = 0;
        int sum = 0;

        while (scanner.hasNextInt()) {
            num = scanner.nextInt();
            if (num != 0) {
                numbers.add(num);
            } else {
                break;
            }
        }
        for (Integer number : numbers) {
            sum += number;
        }

        int length = numbers.size();
        double average = sum / length;

        System.out.println("Average of array : " + average);
    }
}
