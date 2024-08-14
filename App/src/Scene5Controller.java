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
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.stage.Stage;

public class Scene5Controller implements Initializable {
    private Parent root;
    private Scene scene;
    private Stage stage;
    private Cart cart;
    int applesamnt;
    int chickenamnt;
    int chocolateamnt;

    @FXML
    private Button add2cartbtn;

    @FXML
    private Button add2cartbtn2;

    @FXML
    private Button add2cartbtn3;

    @FXML
    private Spinner<Integer> appleamount;

    @FXML
    private Label apples;

    @FXML
    private Label chicken;

    @FXML
    private Spinner<Integer> chickenamount;

    @FXML
    private Label chocolate;

    @FXML
    private Spinner<Integer> chocolateamount;

    @FXML
    private Label explb;

    @FXML
    private Label explb2;

    @FXML
    private Label explb21;

    @FXML
    private Label importlb;

    @FXML
    private Label importlb2;

    @FXML
    private Label importlb3;

    @FXML
    private Label msglb;

    @FXML
    private Label msglb2;

    @FXML
    private Label msglb3;

    @FXML
    private Label totallb;

    @FXML
    private Label totallb2;

    @FXML
    private Label totallb3;
    @FXML
    private Button Cartbtn;
    @FXML
    private Button backbtn;

    @FXML
    void goBack(ActionEvent event) { // Función para regresar a la escena anterior
        try {
            root = FXMLLoader.load(getClass().getResource("Scene2.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            System.out.println("Error");
        }
    }

    @FXML
    void goToCart(ActionEvent event) { // Función para ir a la escena del carrito
        try {
            root = FXMLLoader.load(getClass().getResource("Scene4.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            System.out.println("Error");
        }
    }

    // Este bloque de funciones addToCart es para agregar a la lista de compras,
    // funciona de la misma manera para los 3 productos
    @FXML
    void addToCart(ActionEvent event) { // Función para agregar a la lista de compras
        try {
            // Crea un objeto de tipo Food con los datos de la comida
            Food apple = new Food(apples.getText(), (double) applesamnt, 4.00 * applesamnt, explb.getText(),
                    importlb.getText());
            cart.addProduct(apple); // Agrega el objeto a la lista de compras
            msglb.setText("Added to cart");
            msglb.setStyle("-fx-text-fill: green");
            System.out.println(apple.toString());
            // Cambia a la escena del carrito
            root = FXMLLoader.load(getClass().getResource("Scene4.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            msglb.setText("Error");
            msglb.setStyle("-fx-text-fill: red");
        }

    }

    @FXML
    void addToCart2(ActionEvent event) {
        try {
            Food chickeninst = new Food(chicken.getText(), (double) chickenamnt, 5.00 * chickenamnt, explb2.getText(),
                    importlb2.getText());
            cart.addProduct(chickeninst);
            msglb2.setText("Added to cart");
            msglb2.setStyle("-fx-text-fill: green");
            System.out.println(chicken.toString());
            root = FXMLLoader.load(getClass().getResource("Scene4.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            msglb2.setText("Error");
            msglb2.setStyle("-fx-text-fill: red");
        }
    }

    @FXML
    void addToCart3(ActionEvent event) {
        try {
            Food chocolateinst = new Food(chocolate.getText(), (double) chocolateamnt / 10, 2.0 * chocolateamnt,
                    explb21.getText(),
                    importlb3.getText());
            cart.addProduct(chocolateinst);
            msglb3.setText("Added to cart");
            msglb3.setStyle("-fx-text-fill: green");
            System.out.println(chocolateinst.toString());
            root = FXMLLoader.load(getClass().getResource("Scene4.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            msglb3.setText("Error");
            msglb3.setStyle("-fx-text-fill: red");
        }

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) { // Función para inicializar la escena
        cart = Cart.getInstance(); // Obtiene la instancia de la lista de compras
        // Crea los Spinner para seleccionar la cantidad de cada producto
        SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 10, 1);
        SpinnerValueFactory<Integer> valueFactory2 = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 10, 1);
        SpinnerValueFactory<Integer> valueFactory3 = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 10, 1);
        appleamount.setValueFactory(valueFactory); // Asigna los Spinner a cada producto
        chickenamount.setValueFactory(valueFactory2);
        chocolateamount.setValueFactory(valueFactory3);
        totallb.setText("Total: $4.00"); // Asigna el precio total de cada producto
        totallb2.setText("Total: $5.00");
        totallb3.setText("Total: $2.00");
        applesamnt = appleamount.getValue(); // Obtiene la cantidad de cada producto
        chickenamnt = chickenamount.getValue();
        chocolateamnt = chocolateamount.getValue();
        appleamount.valueProperty().addListener((obs, oldValue, newValue) -> { // Función para actualizar el precio
                                                                               // total de cada producto
            applesamnt = appleamount.getValue();
            totallb.setText("Total: $" + applesamnt * 4.00);
        });
        chickenamount.valueProperty().addListener((obs, oldValue, newValue) -> {
            chickenamnt = chickenamount.getValue();
            totallb2.setText("Total: $" + chickenamnt * 5.00);
        });
        chocolateamount.valueProperty().addListener((obs, oldValue, newValue) -> {
            chocolateamnt = chocolateamount.getValue();
            totallb3.setText("Total: $" + chocolateamnt * 2.00);
        });

    }

}
