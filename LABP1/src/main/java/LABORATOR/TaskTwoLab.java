package LABORATOR;

import java.util.*;

public class TaskTwoLab {
    public static void countFreq(int[] arr, int n)
    {
        boolean[] visited = new boolean[n];
        Arrays.fill(visited, false);
        for (int i = 0; i < n; i++) {
            if (visited[i])
                continue;
            int count = 1;
            for (int j = i + 1; j < n; j++) {
                if (arr[i] == arr[j]) {
                    visited[j] = true;
                    count++;
                }
            }
            System.out.println(arr[i] + " " + count);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean isPresent = false;

        System.out.print("Enter the number of numbers: ");
        int n = sc.nextInt();
        int[] numbers = new int[n];

        System.out.print("Give a value to check if this will be in array: ");
        int presentInArray = sc.nextInt();

        double min = Double.MAX_VALUE;
        double max = Double.MIN_VALUE;
        int num;

        for (int i = 0; i < n; i++) {
            System.out.print("Enter number " + (i + 1) + ": ");
            num = sc.nextInt();
            numbers[i] = num;
        }

        for (int i = 0; i < n; i++) {
            if (numbers[i] < min) {
                min = numbers[i];
            }
            if (numbers[i] > max) {
                max = numbers[i];
            }
            if (numbers[i] == presentInArray) {
                isPresent = true;
            }
        }

        System.out.println("The number of occurances of each element:");
        countFreq(numbers, numbers.length);

        System.out.println("");
        System.out.println("Minimum value: " + min);
        System.out.println("The number to check is " + (isPresent ? "present" : "not present"));
        System.out.println("Minimum / Maximum = " + min / max);
        sc.close();
    }
}
