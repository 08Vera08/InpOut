import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;

class Product implements Serializable
{
    private int price;
    private int count;
    private String name;

    Product(String name, int price, int count)
    {
        this.name = name;
        this.price = price;
        this.count = count;
    }
    String getName()
    {
        return name;
    }
    int getCount()
    {
        return count;
    }
    int getPrice()
    {
        return price;
    }

    @Override
    public String toString() {
        return "Product:: " + "Name = " + name + " " + ", Price = " + String.valueOf(price) + " " + ", Count = " + String.valueOf(count);
    }
}
