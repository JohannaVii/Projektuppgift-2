package se.iths.johanna.webshop;

import java.io.BufferedWriter;
import java.io.IOException;

// Klass som hanterar produkter och filer
public class ProductHandler {

    public static void saveProducts(List<Product> catalog) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter())) {
            FileWriter writer = new FileWriter("products.txt");
            BufferedWriter bw = new BufferedWriter(writer);

            for (Product product : catalog) {
                String line = product.getArticleNumber() + ";" +
                        product.getTitle() + ";" +
                        product.getPrice() + ";" +
                        product.getDescription() + ";" +
                        product.category();

                bw.write(line);
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error - Fel uppstod vid sparning: " + e.getMessage());
        }
    }
}
