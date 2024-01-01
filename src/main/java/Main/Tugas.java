package Main;

import java.io.File;
import java.net.URL;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Tugas extends Application{
    
    @Override
    public void start(Stage stage) throws Exception{
        URL url = new File("src/main/java/view/MainView.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Tugas");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
