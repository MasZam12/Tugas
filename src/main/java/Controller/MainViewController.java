package Controller;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class MainViewController implements Initializable {

    @FXML
    private Button loginAs;

    @FXML
    private StackPane MenuUtama;

    public void switchPage(ActionEvent event) throws IOException {
        try {
//            Parent root = FXMLLoader.load(getClass().getResource("MenuRegister.fxml"));
//            Stage stage = new Stage();
//            stage.setScene(new Scene(root));
//            stage.show();
//
//            Stage MenuUtamaStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//
//            MenuUtamaStage.close();
            URL url = new File ("src/main/java/view/MenuRegister.fxml").toURI().toURL();
            Parent root = FXMLLoader.load(url);
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Menu Register");
            stage.show();
            MenuUtama.getScene().getWindow().hide();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

}
