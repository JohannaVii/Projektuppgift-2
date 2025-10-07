package se.iths.johanna.webshop;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Huvudklass - Administrationsapp för webshop
public class Application {

    // Scanner som läser in användarens val
    private static final Scanner scanner = new Scanner(System.in);

    // Produktkatalog - Listan med alla produkter
    private static List<Product> catalog = new ArrayList<>();

    // Main-metod - Här startar applikationen
    public static void main(String[] args) {

        boolean running = true;
        while (running) {

            // Huvudmeny
            System.out.println("=== Webshop ===");
            System.out.println("1  |  Lägg till produkt");
            System.out.println("2  |  Lista alla produkter");
            System.out.println("3  |  Visa produktinformation");
            System.out.println("4  |  Avsluta\n");
            System.out.print("DITT VAL: ");

            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1" -> addProduct();
                case "2" -> listProducts();
                case "3" -> showProductInfo();
                case "4" -> {
                    System.out.println("\nAvslutar applikationen...");
                    running = false;
                }
                default -> System.out.println("Ogiltigt val, försök igen.");
            }
        }
    }

    // Metod för att lägga till ny produkt
    private static void addProduct() {
        System.out.println("\n--- Lägg till ny produkt ---");
        System.out.println("Välj typ: 1. Ros | 2. Tulpan | 3. Nejlika");
        String type = scanner.nextLine().trim();

        System.out.print("Artikelnummer: ");
        int articleNumber = Integer.parseInt(scanner.nextLine());
        System.out.print("Titel: ");
        String title = scanner.nextLine();
        System.out.print("Pris: ");
        double price = Double.parseDouble(scanner.nextLine());
        System.out.print("Beskrivning: ");
        String description = scanner.nextLine();

        Product product = null;

        // Skapar rätt typ av produkt baserat på användarens val
        switch (type) {
            case "1" -> product = new Rose(articleNumber, title, price, description);
            case "2" -> product = new Tulip(articleNumber, title, price, description);
            case "3" -> product = new Carnation(articleNumber, title, price, description);
            default -> System.out.println("Ogiltig typ.");
        }

        // Lägger till i katalogen
        if (product != null) {
            catalog.add(product);
            System.out.println("\nProdukten har lagts till i katalogen!");
        }
    }

    // Metod för att lista alla produkter
    private static void listProducts() {
        System.out.println("\n--- Alla produkter ---");
        if (catalog.isEmpty()) {
            System.out.println("Inga produkter registrerade ännu.");
        } else {
            for (Product p : catalog) {
                System.out.println(p);
            }
        }
    }

    // Metod för att visa info om en specifik produkt via artikelnummer
    private static void showProductInfo() {
        System.out.print("\nAnge artikelnummer: ");
        int articleNumber = Integer.parseInt(scanner.nextLine());

        Product found = null;
        for (Product p : catalog) {
            if (p.getArticleNumber() == articleNumber) {
                found = p;
                break;
            }
        }

        if (found != null) {
            System.out.println("\n--- Produktinformation ---");
            System.out.println(found);
        } else {
            System.out.println("Ingen produkt hittades med det artikelnumret.");
        }
    }
}