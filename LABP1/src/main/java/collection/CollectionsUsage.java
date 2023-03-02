package collection;
import java.io.*;
import java.text.*;
import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class CollectionsUsage {
    public static void main(String[] args) {
        //  Read clients from file and store in ArrayList
        ArrayList<String> clients = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("D:\\usarb\\OOP2\\OOP2-JavaLanguage\\LABP1\\src\\main\\resources\\Client-input.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                clients.add(line);
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
            System.exit(1);
        }

        // Read products from file and store in HashMap
        HashMap<String, String> products = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader("D:\\usarb\\OOP2\\OOP2-JavaLanguage\\LABP1\\src\\main\\resources\\products-input.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\\|");
                String code = parts[0];
                String name = parts[1];
                products.put(code, name);
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
            System.exit(1);
        }

        String newId;
        String newName;

        System.out.println("Laboratorul 3. Colectii by Smoleac Mihai IS21Z\n");
        Scanner sc = new Scanner(System.in);

        int option;
        do {
            System.out.println("\nAlegeti una din variantele urmatoare:\n");
            System.out.println("1. Show employes.");
            System.out.println("2. Sort employes.");
            System.out.println("3. Extract distinct first names using contains() method.");
            System.out.println("4. Extract distinct first names using HashSet.");
            System.out.println("5. Add age to clients and output to new file");
            System.out.println("6. Add new product to HashSet");
            System.out.println("7. Update a product name");
            System.out.println("8. Output products to a file");
            System.out.println("9. Show products");
            System.out.println("0. Exit");
            option = Integer.parseInt(sc.nextLine());
            switch (option) {
                case 1 -> System.out.println(clients);
                case 2 -> {
                    Collections.sort(clients);
                    System.out.println("Sorted Clients:");
                    for (String client : clients) {
                        System.out.println(client);
                    }
                }
                case 3 -> {
                    ArrayList<String> firstNames = new ArrayList<>();
                    for (String client : clients) {
                        String[] parts = client.split("\\|");
                        String firstName = parts[0];
                        if (!firstNames.contains(firstName)) {
                            firstNames.add(firstName);
                        }
                    }
                    System.out.println("Distinct First Names (using contains() method):");
                    for (String firstName : firstNames) {
                        System.out.println(firstName);
                    }
                }
                case 4 -> {
                    Set<String> firstNamesSet = new HashSet<>();
                    for (String client : clients) {
                        String[] parts = client.split("\\|");
                        String firstName = parts[0];
                        firstNamesSet.add(firstName);
                    }
                    System.out.println("Distinct First Names (using HashSet):");
                    for (String firstName : firstNamesSet) {
                        System.out.println(firstName);
                    }
                }
                case 5 -> {
                    LocalDate now = LocalDate.now();
                    try (BufferedWriter bw = new BufferedWriter(new FileWriter("D:\\usarb\\OOP2\\OOP2-JavaLanguage\\LABP1\\Client-final.txt"))) {
                        for (String client : clients) {
                            String[] parts = client.split("\\|");
                            String firstName = parts[0];
                            String lastName = parts[1];
                            LocalDate dateOfBirth = LocalDate.parse(parts[2], java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                            Period age = Period.between(dateOfBirth, now);
                            String line = String.format("%s | %s | %s | %d", firstName, lastName, parts[2], age.getYears());
                            bw.write(line);
                            bw.newLine();
                        }
                    } catch (IOException e) {
                        System.err.println("Error writing file: " + e.getMessage());
                        System.exit(1);
                    }
                }
                case 6 -> {
                    do {
                        System.out.println("Existing product keys: " + products.keySet());
                        System.out.print("Enter a new product ID: ");
                        newId = sc.nextLine();
                    } while (products.containsKey(newId) || Objects.equals(newId, "")); // Check if ID already exists in the HashMap
                    System.out.print("Enter the name of the new product: ");
                    newName = sc.nextLine();

                    // Add the new product to the HashMap
                    products.put(newId, newName);
                    System.out.println("New product added successfully!");
                }
                case 7 -> {
                    System.out.print("Enter the product code you want to update: ");
                    String code = sc.nextLine();

                    // Check if the product code exists
                    if (products.containsKey(code)) {
                        System.out.print("Enter the new product name: ");
                        newName = sc.nextLine();

                        // Update the product name
                        products.put(code, newName);
                        System.out.println("Product name updated successfully!");
                    } else {
                        System.out.println("Product code not found!");
                    }
                }
                case 8 -> {
                    try (BufferedWriter bw = new BufferedWriter(new FileWriter("D:\\usarb\\OOP2\\OOP2-JavaLanguage\\LABP1\\src\\main\\resources\\products-output.txt"))) {
                        for (Map.Entry<String, String> entry : products.entrySet()) {
                            String line = String.format("%s | %s", entry.getKey(), entry.getValue());
                            bw.write(line);
                            bw.newLine();
                        }
                    } catch (IOException e) {
                        System.err.println("Error writing file: " + e.getMessage());
                        System.exit(1);
                    }
                }
                case 9 -> System.out.println(products);
        }
        } while (option != 0);
    }
}
