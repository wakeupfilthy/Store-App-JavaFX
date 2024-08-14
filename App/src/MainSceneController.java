import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;
import javafx.event.ActionEvent;

public class MainSceneController {
    private Parent root;
    private Scene scene;
    private Stage stage;
    String password;
    String username;

    @FXML
    private Label errpass;

    @FXML
    private Label erruser;

    @FXML
    private PasswordField tpassword;

    @FXML
    TextField tusername;

    @FXML
    void btnLogInClicked(ActionEvent event) throws IOException {
        // Función para validar el usuario y contraseña al hacer clic en el botón
        try {
            password = tpassword.getText();
            if (tusername.getText().isEmpty()) { // Verificar si el campo de usuario está vacío
                erruser.setText("Username is empty");
            } else if (tusername.getText().length() > 12) { // Verificar si el usuario es demasiado largo
                erruser.setText("Username is too long");
            } else if (tpassword.getText().isEmpty()) { // Verificar si el campo de contraseña está vacío
                errpass.setText("Password is empty");
            } else if (password.length() < 6) { // Verificar si la contraseña es demasiado corta
                errpass.setText("Password must be 6 characters long");
            } else {
                erruser.setText("");
                errpass.setText("");

                String username = tusername.getText(); // Obtener el nombre de usuario
                FXMLLoader loader = new FXMLLoader(getClass().getResource("Scene2.fxml")); // Cargar la escena 2
                root = loader.load();
                Scene2Controller scene2Controller = loader.getController(); // Obtener el controlador de la escena 2
                scene2Controller.displayName(username); // Enviar el nombre de usuario al controlador de la escena 2

                // root = FXMLLoader.load(getClass().getResource("Scene2.fxml"));
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}