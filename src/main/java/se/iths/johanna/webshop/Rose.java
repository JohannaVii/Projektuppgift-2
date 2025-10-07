package se.iths.johanna.webshop;

// Subklass - Rose
public class Rose extends Product {

    // Konstruktor
    public Rose(int articleNumber, String title, int price, String description) {
        super(articleNumber, title, price, description);
    }

    // Implementerar abstrakta metoden
    @Override
    public String category() {
        return "Ros";
    }
}
