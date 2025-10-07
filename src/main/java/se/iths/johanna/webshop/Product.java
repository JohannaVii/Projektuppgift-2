package se.iths.johanna.webshop;

public abstract class Product {

    // Gemensamma attribut
    private int articleNumber;
    private String title;
    private double price;
    private String description;

    // Konstruktor
    public Product(int articleNumber, String title, double price, String description) {
        this.articleNumber = articleNumber;
        this.title = title;
        this.price = price;
        this.description = description;
    }

    // Getters
    public int getArticleNumber() {
        return articleNumber;
    }

    public String getTitle() {
        return title;
    }

    public double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    // Abstrakt metod
    public abstract String category();

    // toString - Skriver ut produktens information
    @Override
    public String toString() {
        return "[" + category() + "] " + title + " (" + articleNumber + ") - " + price + " kr\n" + description;
    }
}
