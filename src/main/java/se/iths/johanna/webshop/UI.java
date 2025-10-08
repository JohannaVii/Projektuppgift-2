package se.iths.johanna.webshop;

import java.util.List;

public interface UI {

    void showMessage(String message);

    String getInput(String prompt);

    void showMenu();

    void showCatalog(List<Product> catalog);

    void addProduct(List<Product> catalog);

    void removeProduct(List<Product> catalog);

    void saveFromFile(List<Product> catalog);

    List<Product> loadFromFile();
}
