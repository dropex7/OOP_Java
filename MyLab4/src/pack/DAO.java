package pack;

import java.sql.*;
import java.util.ArrayList;

public class DAO implements Idao {
    private String sql;
    private Connection connection()
    {
        String connectionUrl = "jdbc:sqlserver://localhost;user=sa;password=123456;database=Nova";
        try {
            Connection connect = DriverManager.getConnection(connectionUrl);
            return connect;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection();
    }

    @Override
    public void CreateShop(int id, String name)
    {
        sql = "INSERT INTO Shops_(ID, Name) VALUES (" + id + " , '" + name + "')";
       try(Connection conn = this.connection();
       Statement stmt = conn.createStatement())
       {
           stmt.execute(sql);
       } catch (SQLException e) {
           e.printStackTrace();
       }
    }

    @Override
    public void CreateProduct(int id, String name, int q, int p)
    {
        sql = "INSERT INTO Products_(ProductName, ID,  Quantity, Price) VALUES ('" + name + "' , " + id + ", " + q + ", " + p + ")";
        try(Connection conn = this.connection();
            Statement stmt = conn.createStatement())
        {
            stmt.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void UpdateProduct(int q, int p)
    {
        sql = "Update Products_ set Quantity = (Quantity + " + q + "),\n" +
                "Price = (Price + " + p + ")";
        try(Connection conn = this.connection();
            Statement stmt = conn.createStatement())
        {
            stmt.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<Product> AllProductsInShop(int id)
    {
        ArrayList<Product> products = new ArrayList<>();
        try(Connection conn = this.connection();
            Statement stmt = conn.createStatement())
        {
            ResultSet executeQuery = stmt.executeQuery("SELECT ProductName, Quantity, Price FROM Products_ \n Inner join Shops_ ON Products_.ID = Shops_.ID \n WHERE Shops_.ID = " + id + "\n" + "order by Products_.Price asc");
            while(executeQuery.next())
            {
                products.add(new Product(executeQuery.getString("ProductName"), executeQuery.getInt("Price"), executeQuery.getInt("Quantity")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    @Override
    public String profitShop(String name)
    {
        String result = new String();
        try(Connection conn = this.connection();
            Statement stmt = conn.createStatement())
        {
            ResultSet executeQuery = stmt.executeQuery("Select Shops_.Name from Shops_\n" +
                    "inner join Products_ ON Shops_.ID = Products_.ID\n" +
                    "where ProductName = '" + name + "'\n" +
                    "order by Products_.Price asc\n" +
                    "offset 0 rows\n" +
                    "fetch next 1 rows only");
            if(executeQuery.next()) {
                return (executeQuery.getString("Name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public ArrayList<Shop> AllShops()
    {
        ArrayList<Shop> currentShops = new ArrayList<>();
        try(Connection conn = this.connection();
            Statement stmt = conn.createStatement())
        {
            ResultSet executeQuery = stmt.executeQuery("Select ID, Name from Shops_");
                while (executeQuery.next())
                {
                    currentShops.add(new Shop(executeQuery.getInt("ID"), executeQuery.getString("Name")));
                }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return currentShops;
    }
}


