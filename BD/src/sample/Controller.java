package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.event.EventHandler;


public class Controller {

    @FXML
    private Button ButtonForStock;

    @FXML
    private Button ButtonForPrices;

    @FXML
    private Button ButtonForExit;

    @FXML
    void initialize() {
        ButtonForExit.setOnAction(event -> System.exit(0));

        ButtonForStock.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    FXMLLoader fxmlLoader;
                    fxmlLoader = new FXMLLoader(getClass().getResource("ForStock.fxml"));
                    Parent root1 = fxmlLoader.load();
                    Stage stage = new Stage();
                    stage.setScene(new Scene(root1));
                    stage.show();
                } catch(Exception e) {
                    e.printStackTrace();
                }
            }
            });

        ButtonForPrices.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    FXMLLoader fxmlLoader1;
                    fxmlLoader1 = new FXMLLoader(getClass().getResource("../sample/forBar.fxml"));
                    try {
                        Parent root2 = fxmlLoader1.load();
                        Stage stage2 = new Stage();
                        stage2.setScene(new Scene(root2));
                        stage2.show();
                    }catch (Exception ex)
                    {
                        System.out.println("Error:" + ex.getMessage());
                    }


                } catch(Exception e) {
                    e.printStackTrace();
                }
            }
        });
        }
}





