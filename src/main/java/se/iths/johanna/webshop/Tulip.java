package se.iths.johanna.webshop;

// Subklass - Tulpan
public class Tulip extends Product {

    // Konstruktor
    public Tulip(int articleNumber, String title, double price, String description) {
        super(articleNumber, title, price, description);
    }

    // Implementerar abstrakt metod
    @Override
    public String category() {
        return "Tulpan";
    }
}