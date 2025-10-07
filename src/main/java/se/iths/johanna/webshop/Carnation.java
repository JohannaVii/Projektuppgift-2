package se.iths.johanna.webshop;

// Subklass - Nejlika
public class Carnation extends Product {

    // Konstruktor
    public Carnation(int articleNumber, String title, int price, String description) {
        super(articleNumber, title, price, description);
    }

    // Implementerar abstrakt metod
    @Override
    public String category() {
        return "Nejlika";
    }
}
