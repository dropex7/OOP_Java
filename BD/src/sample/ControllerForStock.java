package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ControllerForStock {

    private ObservableList<Products> ProductData = FXCollections.observableArrayList();

    @FXML
    private TableView<Products> tableProduct;

    @FXML
    private TableColumn<Products, String> NameOfProd;

    @FXML
    private TableColumn<Products, Integer> QuanOfProd;

    @FXML
    void initialize() {
        String connectionUrl = "jdbc:sqlserver://localhost;user=sa;password=123456;database=MARKET";
        try (Connection con = DriverManager.getConnection(connectionUrl)) {
            Statement stmt = con.createStatement();
            ResultSet executeQuery = stmt.executeQuery("SELECT ProductName, Quantity FROM Product");
            // Обход результатов выборки
            while (executeQuery.next()) {
                String tempName;
                int tempQ;
                tempName = executeQuery.getString("ProductName");
                tempQ = executeQuery.getInt("Quantity");
                ProductData.add(new Products(tempName, tempQ));
            }
            // Закрываем соединение
            executeQuery.close();
            stmt.close();
            NameOfProd.setCellValueFactory(new PropertyValueFactory<Products, String>("Name"));
            QuanOfProd.setCellValueFactory(new PropertyValueFactory<Products, Integer>("Quantity"));
            tableProduct.setItems(ProductData);
        }
        // Handle any errors that may have occurred.
        catch (SQLException e) {
            e.printStackTrace();
        }

    }
}


