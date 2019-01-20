package sample;

public class Products {
    private String Name;
    private int Quantity;


    public Products(String N, int Q) {
        this.Name = N;
        this.Quantity = Q;
    }

    public Products(){}

    public String getName() {
        return Name;
    }

    public void setName(String N) {
        this.Name = N;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int Q) {
        this.Quantity = Q;
    }




}
