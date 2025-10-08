package se.iths.johanna.webshop;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

// Klass som hanterar produkter och filer
public class ProductHandler {

    // Sparar produkter till fil
    public static void saveProducts(List<Product> catalog) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("products.txt"))) {
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

    // Läser in produkter från fil
    public static List<Product> loadProducts() {
        List<Product> products = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("products.txt"))) {
            String line;
            // Läser rader från fil
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(";");

                String category = parts[4];
                int articleNumber = Integer.parseInt(parts[0]);
                String title = parts[1];
                int price = Integer.parseInt(parts[2]);
                String description = parts[3];

                // Lägger till en ny produkt i lista
                Product product = new CustomProduct(category, articleNumber, title, price, description);
                products.add(product);
            }

        } catch (IOException e) {
            System.out.println("Filen kunde inte läsas - Försök igen!");
        }
        return products;
    }
}
