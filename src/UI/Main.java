package UI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("UI/Board.fxml"));
        primaryStage.setTitle("PlantGuide");
        primaryStage.setScene(new Scene(root, 900, 900));
        primaryStage.show();
    }

}
