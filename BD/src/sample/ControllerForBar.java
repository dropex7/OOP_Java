package sample;

import java.sql.*;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

public class ControllerForBar {

    @FXML
    private CategoryAxis Xaxis;

    @FXML
    private NumberAxis Yaxis;

    @FXML
    private BarChart<String, Number> forBar;

    @FXML
    void initialize() {
        XYChart.Series<String, Number> dataSeries1 = new XYChart.Series<>();
        dataSeries1.setName("2019");
        String connectionUrl = "jdbc:sqlserver://localhost;user=sa;password=123456;database=MARKET";
        try (Connection con = DriverManager.getConnection(connectionUrl)) {
            Statement stmt = con.createStatement();
            ResultSet executeQuery = stmt.executeQuery("SELECT ProductName, SellingPrice FROM Product");
            // Обход результатов выборки
            while (executeQuery.next()) {
                String tempName;
                int tempPrice;
                tempName = executeQuery.getString("ProductName");
                tempPrice = executeQuery.getInt("SellingPrice");
                dataSeries1.getData().add(new XYChart.Data<>(tempName, tempPrice));
            }
            // Закрываем соединение
            executeQuery.close();
            stmt.close();
            forBar.getData().add(dataSeries1);

        }
        // Handle any errors that may have occurred.
        catch (SQLException e) {
            e.printStackTrace();
        }

    }
}

