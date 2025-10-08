package se.iths.johanna.webshop;

import java.util.ArrayList;
import java.util.List;

// Klass som kör applikationen
public class Application {

    // UI - Visar meny och hanterar användarval
    private static ShopUI ui = new ShopUI();

    // Produktkatalog - Lista
    private static List<Product> catalog = new ArrayList<>();

    // Main-metod - Startar applikationen
    public static void main(String[] args) {

        boolean running = true;
        while (running) {
            // Huvudmeny
            ui.showMenu();
            String choice = ui.getInput("");

            switch (choice) {

                // Alternativ 1. Visa produkter
                case "1" -> {
                    ui.showCatalog(catalog);
                }

                // Alternativ 2. Lägg till produkt
                case "2" -> {
                    ui.addProduct(catalog);
                }

                // Alternativ 3. Ta bort produkt
                case "3" -> {
                    ui.removeProduct(catalog);
                }

                // Alternativ 4. Spara produkter till fil
                case "4" -> {
                    ui.saveFromFile(catalog);
                }

                // Alternativ 5. Ladda produkter från fil
                case "5" -> {
                    catalog = ui.loadFromFile();
                }

                // Alternativ 6. Avsluta
                case "6" -> {
                    ui.showMessage("\n\n---\n\n");
                    ui.showMessage("See you next time!");
                    running = false;
                }

                // Vid fel input
                default -> {
                    ui.showMessage("Ogiltigt val - Försök igen!");
                }
            }
        }
    }
}
