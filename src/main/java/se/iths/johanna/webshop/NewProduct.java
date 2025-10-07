package se.iths.johanna.webshop;

public class NewProduct extends Product {

    public NewProduct(int articleNumber, String title, int price, String description) {
        super(articleNumber, title, price, description);
    }

    @Override
    public String category() {
        return "Ny produkt";
    }
}
