package se.iths.johanna.webshop;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {

    // Scanner som läser in användarens val
    private static final Scanner scanner = new Scanner(System.in);

    // Produktkatalog - Lista
    private static List<Product> catalog = new ArrayList<>();

    // Main-metod - Startar applikationen
    public static void main(String[] args) {

        // Produktkatalog - Alla produkter
        catalog.add(new Rose(1001, "Röd Ros", 60, "Klassisk ros"));
        catalog.add(new Rose(1002, "Rosa Ros", 55, "Romantisk ros"));
        catalog.add(new Tulip(2001, "Vår-tulpan", 20, "Fräsch tulpan"));
        catalog.add(new Tulip(2002, "Sommar-tulpan", 25, "Ljus blomma"));
        catalog.add(new Carnation(3001, "Liten nejlika", 15, "Kort stjälk"));
        catalog.add(new Carnation(3002, "Mellan nejlika", 20, "Standardstjälk"));

        // Huvudmeny
        boolean running = true;
        while (running) {
            System.out.println("\n\n---\n\n");
            System.out.println("=== ADMINISTRATION ===");
            System.out.println("1  | Visa produktkatalog");
            System.out.println("2  | Lägg till produkt");
            System.out.println("3  | Ta bort produkt");
            System.out.println("4  | Avsluta programmet\n");
            System.out.print("DITT VAL: ");

            String choice = scanner.nextLine().trim();

            switch (choice) {
                // Alternativ 1. Visa produkter
                case "1" -> {
                    boolean case1 = true;
                    while (case1) {
                        System.out.println("\n\n---\n\n");
                        System.out.println("=== PRODUKTKATALOG ===\n");

                        for (Product product : catalog) {
                            System.out.println(product);
                        }
                        System.out.println("\n<< | Tillbaka");
                        System.out.print("DITT VAL: ");
                        String choice = scanner.nextLine().trim();

                        switch (choice) {
                            case "Tillbaka", "tillbaka", "<<" -> {
                                case1 = false;
                                System.out.println("\n\n---\n\n");
                            }
                            default -> {
                                System.out.println("Ogiltigt val - Försök igen.");
                            }
                        }
                    }
                }

                // Alternativ 2. Lägg till produkt
                case "2" -> {
                    boolean case2 = true;
                    while (case2) {
                        System.out.println("\n\n---\n\n");
                        System.out.println("=== LÄGG TILL PRODUKT ===\n");

                        System.out.print("Ange artikelnummer: ");
                        int articleNumber = scanner.nextInt();
                        scanner.nextLine();

                        System.out.print("Title: ");
                        String name = scanner.nextLine();

                        System.out.print("Pris: ");
                        int price = scanner.nextInt();
                        scanner.nextLine();

                        System.out.print("Ange en beskrivning: ");
                        String description = scanner.nextLine();

                        // Skapa en ny produkt
                        Product newProduct = new Product(articleNumber, name, price, description);
                        catalog.add(newProduct);

                        System.out.println("Produkten har lagts till!");

                        System.out.println("\n<< | Tillbaka");
                        System.out.print("DITT VAL: ");
                        String input = scanner.nextLine().trim();

                        switch (input) {
                            case "Tillbaka", "tillbaka", "<<" -> {
                                case2 = false;
                                System.out.println("\n\n---\n\n");
                            }
                            default -> {
                                System.out.println("Ogiltigt val - Försök igen.");
                            }
                        }
                    }
                    break;
                }

                // Alternativ 3. Ta bort produkt
                case "3" -> {
                    boolean case3 = true;
                    while (case3) {
                        System.out.println("\n\n---\n\n");
                        System.out.println("=== TA BORT PRODUKT ===\n");
                        for (Product product : catalog) {
                            System.out.println(product);
                        }
                        System.out.print("\nAnge artikelnummer att ta bort - Eller skriv tillbaka");
                        String removeChoice = scanner.nextLine().trim();

                        switch (removeChoice) {
                            case "Tillbaka", "tillbaka", "<<" -> {
                                case3 = false;
                                System.out.println("\n\n---\n\n");
                            }
                            default -> {
                                boolean found = false;

                                for (Product product : catalog) {
                                    if (String.valueOf(product.getArticleNumber()).equals(removeChoice)) {
                                        catalog.remove(product);
                                        System.out.println("Produkt är bortagen.");
                                        found = true;
                                        break;
                                    }
                                }

                                if (!found) {
                                    System.out.println("Finner inte produkten - Försök igen.");
                                }
                            }
                        }
                    }
                    break;
                }

                // Alternativ 4. Avsluta
                case "4" -> {
                    System.out.println("\n\n---\n\n");
                    System.out.println("See you next time!");
                    running = false;
                }
                default -> {
                    System.out.println("Ogiltigt val - Välj mellan 1-4.");
                }
            }
        }
        scanner.close();
    }
}
