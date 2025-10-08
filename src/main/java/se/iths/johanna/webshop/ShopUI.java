package se.iths.johanna.webshop;

import java.util.Scanner;

public class ShopUI implements UI {

    private final Scanner scanner = new Scanner(System.in);

    @Override
    public void showMessage(String message) {
        System.out.println(message);
    }

    @Override
    public String getInput(String prompt) {
        System.out.println(prompt);
        return scanner.nextLine();
    }

    @Override
    public void showMenu() {
        System.out.println("\n=== ADMINISTRATION ===");
        System.out.println("Välj 1-6\n");
        System.out.println("1  | Visa produktkatalog");
        System.out.println("2  | Lägg till produkt");
        System.out.println("3  | Ta bort produkt");
        System.out.println("4  | Spara produkter till fil");
        System.out.println("5  | Ladda produkter från fil");
        System.out.println("6  | Avsluta programmet\n");
        System.out.print("DITT VAL: ");
    }
}

