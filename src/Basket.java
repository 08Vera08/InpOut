import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;

class Basket implements Serializable {
    ArrayList<Product> product;
    private int amount;
    private static final long serialVersionUID = 1L;

    Basket(ArrayList<Product> products) {
        amount = products.size();
        product = new ArrayList<>();
        for (int i = 0; i < amount; ++i) {
            product.add(products.get(i));
        }
    }

    public void addProduct(Product p) {
        product.add(p);
    }

    public void printCart() {
        for (int i = 0; i < product.size(); ++i) {
            System.out.println(product.get(i));
        }
    }


    public static Basket loadFromTxtFile(File textFile) {
        ArrayList<Product> products = new ArrayList<>();
        try (FileInputStream fin = new FileInputStream(textFile)) {
            ObjectInputStream myReader = new ObjectInputStream(fin);
            for (int i = 0; i < Files.lines(textFile.toPath()).count(); ++i) {
                products.add((Product) myReader.readObject());
            }
            myReader.close();
            System.out.println("Saved!");
        } catch (StreamCorruptedException e) {
            System.out.println("An error occurred.");
        } catch (UncheckedIOException e) {
            System.out.println("An error occurred.");
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new Basket(products);
    }

    public void saveTxt(File textFile) {
        try (FileOutputStream fos = new FileOutputStream(textFile)) {
            ObjectOutputStream out = new ObjectOutputStream(fos);
            for (int i = 0; i < product.size(); ++i) {
                out.writeObject(product.get(i));
            }
            out.close();
            System.out.println("Saved!");
        } catch (Exception e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void saveBin(File file) {
        try (FileOutputStream fos = new FileOutputStream(file)) {
            ObjectOutputStream out = new ObjectOutputStream(fos);
            for (int i = 0; i < product.size(); ++i) {
                out.writeObject(product.get(i));
            }
            out.close();
            System.out.println("Saved!");
        } catch (Exception e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static Basket loadFromBinFile(File file) {
        ArrayList<Product> products = new ArrayList<>();
        try (FileInputStream fin = new FileInputStream(file)) {
            ObjectInputStream myReader = new ObjectInputStream(fin);
            for (int i = 0; i < Files.lines(file.toPath()).count(); ++i) {
                products.add((Product) myReader.readObject());
            }
            myReader.close();
            System.out.println("Saved!");
        } catch (UncheckedIOException e) {
            System.out.println("An error occurred.");
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new Basket(products);
    }
}