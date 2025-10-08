package se.iths.johanna.webshop;

public class NewProduct extends Product {
    // Konstruktorn
    public NewProduct(String category, int articleNumber, String title, int price, String description) {
        super(articleNumber, title, price, description);
        this.category = category;
    }

    private String category;

    @Override
    public String category() {
        return category;
    }

    @Override
    public String toString() {
        return "[" + category() + "] ID: " + getArticleNumber() + " - " + getTitle() + " - " + getPrice() + " kr - " + getDescription();
    }
}
