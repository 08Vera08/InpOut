import java.io.*;
import java.util.ArrayList;


public class Main {
    public static void main(String[] args) {
        int N = 9;
        Product product1 = new Product("Meat", 350, 2);
        Product product2 = new Product("Sugar", 100, 5);
        Product product3 = new Product("Banana", 150, 10);
        Product product4 = new Product("Apple", 150, 10);
        Product product5 = new Product("Cheese", 350, 5);
        ArrayList<Product> products = new ArrayList<>();
        products.add(product1);
        products.add(product2);
        products.add(product3);
        products.add(product4);
        products.add(product5);
        File textFile = new File("basket.bin");
        Basket basket = null;


        if (textFile.exists()) {
            System.out.println("Exist!");
            basket = basket.loadFromTxtFile(textFile);
            for (int i = 0; i < products.size(); ++i) {
                basket.addProduct(products.get(i));
            }
            basket.saveTxt(textFile);
        } else {
            System.out.println("Not exist!");
            basket = new Basket(products);
            basket.saveTxt(textFile);
        }
        basket.printCart();

    }
}