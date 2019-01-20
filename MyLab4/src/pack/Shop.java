package pack;

import java.util.ArrayList;

public class Shop {
    private int ID;
    private String name;
    public ArrayList<Product> products = new ArrayList<>();

    public Shop()
    {

    }

    public Shop(int id, String n)
    {
        this.ID = id;
        this.name = n;
    }

    public void AddProd(Product k)
    {
        this.products.add(k);
    }

    public int getID()
    {
        return ID;
    }

    public String getName()
    {
        return name;
    }
}
