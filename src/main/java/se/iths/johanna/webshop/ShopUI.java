package se.iths.johanna.webshop;

import java.util.List;
import java.util.Scanner;

public class ShopUI implements UI {

    private final Scanner scanner = new Scanner(System.in);

    @Override
    public void showMessage(String message) {
        System.out.println(message);
    }

    @Override
    public String getInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    @Override
    public void showMenu() {
        System.out.println("\n=== Administration ===");
        System.out.println("Välj 1-6\n");
        System.out.println("1  | Visa produktkatalog");
        System.out.println("2  | Lägg till produkt");
        System.out.println("3  | Ta bort produkt");
        System.out.println("4  | Spara produkter till fil");
        System.out.println("5  | Ladda produkter från fil");
        System.out.println("6  | Avsluta programmet\n");
        System.out.print("DITT VAL: ");
    }

    @Override
    public void showCatalog(List<Product> catalog) {
        System.out.println("\n\n---\n\n");
        System.out.println("=== Produktkatalog ===");
        System.out.println("Alla produkter - Skriv tillbaka för att återgå till menyn\n");
        System.out.println("---------------------------------------------------------\n");

        if (catalog.isEmpty()) {
            System.out.println("Produktkatalogen är tom.");
        } else {
            for (Product product : catalog) {
                System.out.println(product + "\n");
            }
        }

        System.out.println("\n<< | Tillbaka");
        getInput("DITT VAL:");
        System.out.println("\n\n---\n\n");
    }

    @Override
    public void addProduct(List<Product> catalog) {
        System.out.println("\n\n---\n\n");
        System.out.println("=== Lägg till produkt ===");
        System.out.println("Fyll i nedan för att skapa en produkt\n");
        System.out.println("-------------------------------------\n");

        System.out.print("Ange kategori: ");
        String category = scanner.nextLine();

        System.out.print("Ange artikelnummer: ");
        int articleNumber = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Titel: ");
        String title = scanner.nextLine();

        System.out.print("Pris: ");
        int price = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Ange en beskrivning: ");
        String description = scanner.nextLine();

        Product newProduct = new CustomProduct(category, articleNumber, title, price, description);
        catalog.add(newProduct);

        System.out.println("\nProdukten har lagts till!");
        System.out.println("\n<< | Tillbaka");
        getInput("DITT VAL: ");
        System.out.println("\n\n---\n\n");
    }

    @Override
    public void removeProduct(List<Product> catalog) {
        System.out.println("\n\n---\n\n");
        System.out.println("=== Ta bort produkt ===");
        System.out.println("Ange artikelnummer nedan på varan som du vill ta bort\n");
        System.out.println("-----------------------------------------------------\n");

        if (catalog.isEmpty()) {
            System.out.println("Produktkatalogen är tom.");
            System.out.println("\n<< | Tillbaka");
            getInput("DITT VAL: ");
            return;
        }

        for (Product product : catalog) {
            System.out.println(product);
        }

        System.out.print("\nDITT VAL: ");
        int removeChoice = scanner.nextInt();
        scanner.nextLine();

        boolean found = false;

        for (Product product : catalog) {
            if (product.getArticleNumber() == removeChoice) {
                catalog.remove(product);
                System.out.println("\nProdukten är borttagen!");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Finner inte produkten - Försök igen.");
        }

        System.out.println("\n<< | Tillbaka");
        getInput("DITT VAL: ");
        System.out.println("\n\n---\n\n");
    }

    @Override
    public void saveFromFile(List<Product> catalog) {
        ProductHandler.saveProducts(catalog);
        System.out.println("\nProdukter har sparats till fil!");
        System.out.println("\n<< | Tillbaka");
        getInput("DITT VAL: ");
    }

    @Override
    public List<Product> loadFromFile() {
        List<Product> products = ProductHandler.loadProducts();
        System.out.println("\nProdukter har laddats från fil!");
        System.out.println("\n<< | Tillbaka");
        getInput("DITT VAL: ");
        return products;
    }
}