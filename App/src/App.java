
/*
    Angel Israel Hernández Testa
    2022630048
    Paradigmas de Programación 3BV1
    Ingeniería en Inteligencia Artificial
    Ultima modificación: 2023-06-20
 */
import java.io.IOException;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Manejar el evento de cerrar la ventana
        primaryStage.setOnCloseRequest(event -> {
            if (Cart.getInstance().getCart().size() > 0) { // Verificar si hay elementos en el carrito
                event.consume(); // Consume el evento para evitar que la aplicación se cierre automáticamente

                // Mostrar mensaje de alerta
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Confirm exit");
                alert.setHeaderText(null);
                alert.setContentText("There are items left in the cart \nAre you sure you want to exit?");

                // Personalizar los botones del mensaje de alerta
                ButtonType exitBtn = new ButtonType("Exit");
                ButtonType cancelbtn = new ButtonType("Cancel");
                alert.getButtonTypes().setAll(exitBtn, cancelbtn);

                // Manejar la acción del botón
                alert.showAndWait().ifPresent(response -> {
                    if (response == exitBtn) {
                        Platform.exit();
                    }
                });
            } else {
                Platform.exit();
            }
        });
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("MainScene.fxml"));
            Scene scene = new Scene(root);

            primaryStage.setTitle("Super Shopping");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
        }

    }

    public static void main(String[] args) {
        launch(args);
    }
}
// Nota: Los archivos fxml fueron generados con SceneBuilder, por lo que no
// incluyen comentarios.