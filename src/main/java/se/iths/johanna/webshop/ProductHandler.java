package se.iths.johanna.webshop;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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

    public static List<Product> loadProducts() {
        List<Product> products = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("products.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(";");

                String category = parts[4];
                int articleNumber = Integer.parseInt(parts[0]);
                String description = part[3];

                Product product = new CustomProduct(category, articleNumber, title, price, description);
                products.add(product);
            }

        } catch (IOException e) {
            System.out.println("Filen kunde inte läsas - Försök igen!");
        }
    }
}
