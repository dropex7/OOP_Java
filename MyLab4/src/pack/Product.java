package pack;

public class Product {
    private String name;
    public int quantity;
    private int price;
    public Product(String n, int p)
    {
        this.quantity = 0;
        this.name = n;
        this.price = p;
    }

    public Product(String n, int p, int q)
    {
        this.quantity = q;
        this.name = n;
        this.price = p;
    }

    public Product(int q, String name)
    {
        this.quantity = q;
        this.name = name;
    }

    public Product()
    {
    }

    public void addQ(int k)
    {
        this.quantity += k;
    }

    public void setName(String n)
    {
        this.name = n;
    }


    public void setPrice(int p)
    {
        this.price = p;
    }


    public void setQuantity(int q)
    {
        this.quantity = q;
    }

    public int getPrice()
    {
        return price;
    }

    public int getQuantity()
    {
        return quantity;
    }

    public String getName()
    {
        return name;
    }
}
