import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class Scene2Controller {
    private Parent root;
    private Scene scene;
    private Stage stage;

    @FXML
    Label welcomemsg;
    @FXML
    private Button clothe;
    @FXML
    private Button food;
    @FXML
    private Button cartBtn;
    @FXML
    private ImageView pant;
    @FXML
    private ImageView shirt;
    @FXML
    private ImageView skirt;
    @FXML
    private ImageView shirt2;
    @FXML
    private ImageView sale;
    @FXML
    private ImageView cart;

    public void displayName(String username) { // Función para recibir el nombre de usuario de la escena 1
        welcomemsg.setText("Welcome " + username + "! These are the best products in the market:");
    }

    @FXML
    void goToClothes(ActionEvent event) { // Función para ir a la escena 3
        try {
            root = FXMLLoader.load(getClass().getResource("Scene3.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        } catch (IOException e) {
            System.out.println(e);
        }

    }

    @FXML
    void goToFood(ActionEvent event) { // Función para ir a la escena 5
        try {
            root = FXMLLoader.load(getClass().getResource("Scene5.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        } catch (IOException e) {
            System.out.println(e);
        }
    }

    @FXML
    void goToCart(ActionEvent event) { // Función para ir a la escena 4
        try {
            root = FXMLLoader.load(getClass().getResource("Scene4.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        } catch (IOException e) {
            System.out.println(e);
        }
    }

}
