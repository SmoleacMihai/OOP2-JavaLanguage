package string;
import org.example.CounterClass;

import java.io.*;
import java.util.Objects;

public class StringUsage {
    private static CounterClass countVowelsConsonants(String str) {
        int vowels = 0, consonants = 0;
        str = str.toLowerCase();
        for (int i = 0; i < str.length(); ++i)
        {
            char ch = str.charAt(i);
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u')
            {
                ++vowels;
            }
            else if ((ch >= 'a' && ch <= 'z'))
            {
                ++consonants;
            }
        }

        return new CounterClass(vowels, consonants);
    }

    private static String returnMaxWordFromPhrase(String str) {
        String[] words = str.split("\\s");
        int max;
        String maxWord = "";
        for(String w:words) {
            max = maxWord.length();
            int mightBeNewMax = w.length();
            if(max<mightBeNewMax) {
                maxWord = w;
            }
        }
        return maxWord;
    }

    private static String returnMinWordFromPhrase(String str) {
        String[] words = str.split("\\s");
        int min;
        String minWord = words[0];
        for(String w:words) {
            min = minWord.length();
            int mightBeNewMin = w.length();
            if(min>mightBeNewMin) {
                minWord = w;
            }
        }
        return minWord;
    }

    private static void printDuplicateWords(String str) throws IOException {
        File file = new File("D:\\usarb\\OOP2\\pooJavaLabs\\LABP1\\src\\main\\resources\\output.txt");
        FileWriter writer = new FileWriter(file, true);
        str = str.toLowerCase();
        int count;
        String[] words = str.split(" ");

        writer.write("Duplicate words in a given string: ");
        for(int i = 0; i < words.length; i++) {
            count = 1;
            for(int j = i+1; j < words.length; j++) {
                if(words[i].equals(words[j])) {
                    count++;
                    words[j] = "0";
                }
            }
            if(count > 1 && !Objects.equals(words[i], "0")){
                writer.write(words[i]);
            }
        }
        writer.close();
    }

    public static void main(String[] args) throws IOException {
        File file = new File("D:\\usarb\\OOP2\\pooJavaLabs\\LABP1\\src\\main\\resources\\input.txt");
        File fileOutput = new File("D:\\usarb\\OOP2\\pooJavaLabs\\LABP1\\src\\main\\resources\\output.txt");
        FileReader fileReader = new FileReader(file);
        FileWriter writer = new FileWriter(fileOutput);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
        StringBuilder phrase = new StringBuilder();

        while ((line = bufferedReader.readLine()) != null) {
            phrase.append(line);
        }

        int vowels = countVowelsConsonants(phrase.toString()).getNrVowels();
        int consonants = countVowelsConsonants(phrase.toString()).getNrConsonants();

        writer.write("\nYour phrase to uppercase: " + phrase.toString().toLowerCase());
        writer.write("\nYour phrase to lowercase: " + phrase.toString().toLowerCase());
        writer.write("\nYour phrase length: " + phrase.length());
        writer.write("\nNumber of vowels in your phrase: " + vowels);
        writer.write("\nNumber of consonants in your phrase: " + consonants);
        writer.write("\nThe word with max length from phrase is: " + returnMaxWordFromPhrase(phrase.toString()));
        writer.write("\nThe word with min length from phrase is: " + returnMinWordFromPhrase(phrase.toString()));
        printDuplicateWords(phrase.toString());
        writer.close();
    }
}
