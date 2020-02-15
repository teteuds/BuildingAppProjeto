package buildingappprojeto;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class BuildingAppProjeto extends Application {

    public static Stage palco;

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/buildingappprojeto/view/TelaPrincipal.fxml"));

        Scene scene = new Scene(root);

        palco = stage;
        palco.setScene(scene);
        palco.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
