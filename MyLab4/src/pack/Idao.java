package pack;

import java.util.ArrayList;

public interface Idao {
    void CreateShop(int id, String name);
    void CreateProduct(int id, String name, int q, int p);
    void UpdateProduct(int q, int p);
    ArrayList<Product> AllProductsInShop(int id);
    String profitShop(String name);
    ArrayList<Shop> AllShops();

}
