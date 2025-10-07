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
        catalog.add(new Rose(1002, "Rosa ros", 55, "Romantisk ros"));
        catalog.add(new Rose(1003, "Gul ros", 55, "Somrig ros"));
        catalog.add(new Rose(1004, "Vit ros", 60, "Elegant ros"));

        catalog.add(new Tulip(2001, "Vår-tulpan", 20, "Fräsh tulpan i pastell"));
        catalog.add(new Tulip(2002, "Sommar-tulpan", 25, "Ljus blomma med varm ton"));
        catalog.add(new Tulip(2003, "Höst-tulpan", 25, "Rustik blomma med jord"));
        catalog.add(new Tulip(2004, "Vinter-tulpan", 30, "Enkel tulpan i sval nyans"));

        catalog.add(new Carnation(3001, "Liten nejlika", 15, "Kort stjälk, 20-30 cm"));
        catalog.add(new Carnation(3002, "Mellan nejlika", 20, "Standard stjälk, 30-40 cm"));
        catalog.add(new Carnation(3003, "Stor nejlika", 25, "Ståtlig stjälk, 40-50 cm"));
        catalog.add(new Carnation(3004, "Extra stor nejlika", 30, "Lång stjälk, 50-60 cm"));

        // Huvudmeny
        boolean running = true;
        while (running) {
            System.out.println("\n=== ADMINISTRATION ===");
            System.out.println("Välj 1-4\n");
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
                        System.out.println("=== PRODUKTKATALOG ===");
                        System.out.println("Alla produkter - Skriv tillbaka för att återgå till menyn\n");

                        if (catalog.isEmpty()) {
                            System.out.println("Produktkatalogen är tom.");
                        } else {
                            for (Product product : catalog) {
                                System.out.println(product + "\n");
                            }
                        }

                        System.out.println("\n<< | Tillbaka");
                        System.out.print("DITT VAL: ");
                        String input = scanner.nextLine().trim();

                        switch (input) {
                            case "Tillbaka", "tillbaka", "<<" -> {
                                case1 = false;
                                System.out.println("\n\n---\n\n");
                            }
                            default -> {
                                System.out.println("Ogiltigt val - Försök igen.");
                            }
                        }
                    }
                    break;
                }

                // Alternativ 2. Lägg till produkt
                case "2" -> {
                    boolean case2 = true;
                    while (case2) {
                        System.out.println("\n\n---\n\n");
                        System.out.println("=== LÄGG TILL PRODUKT ===");
                        System.out.println("Fyll i nedan för att skapa en produkt");


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
                        Product newProduct = new NewProduct(articleNumber, name, price, description);
                        catalog.add(newProduct);

                        System.out.println("\nProdukten har lagts till!");

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
                        System.out.println("=== TA BORT PRODUKT ===");
                        System.out.println("Ange artikelnummer nedan på varan som du vill ta bort\n");
                        for (Product product : catalog) {
                            System.out.println(product);
                        }
                        System.out.print("\nDITT VAL: ");
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
