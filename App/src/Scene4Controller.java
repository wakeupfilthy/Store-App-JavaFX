import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Scene4Controller implements Initializable {
    private Parent root;
    private Scene scene;
    private Stage stage;
    private Cart cart;
    private ObservableList<String> cartItems; // Lista de items en el carrito
    private double total; // Total de la compra

    @FXML
    private Button backBtn;
    @FXML
    private Label itemsnumber;
    @FXML
    private ListView<String> items;
    @FXML
    private Button pay;
    @FXML
    private TextField idtf;
    @FXML
    private Button removebtn;
    @FXML
    private Label removemsg;
    @FXML
    private Label totallb;

    @FXML
    void removeItem(ActionEvent event) { // Función para remover un item del carrito
        try {
            int id = Integer.parseInt(idtf.getText()); // Obtener el ID del item a remover
            for (Articulo a : cart.getCart()) { // Buscar el item en el carrito
                if (a.getId() == id) { // Si el item existe, removerlo
                    cart.removeProduct(a);
                    removemsg.setText("Item removed");
                    removemsg.setStyle("-fx-text-fill: green");
                    updateCart(); // Actualizar la lista de items en el carrito
                    displayItems(); // Actualizar el número de items en el carrito
                    displayTotal(); // Actualizar el total de la compra
                    break;
                } else {
                    removemsg.setText("Please enter a valid ID"); // Si el item no existe, mostrar mensaje de error
                    removemsg.setStyle("-fx-text-fill: red");
                }
            }
        } catch (Exception e) {
            removemsg.setText("Please enter a valid ID");
            removemsg.setStyle("-fx-text-fill: red");
        }

    }

    @FXML
    void PayItems(ActionEvent event) { // Función para pagar los items en el carrito y generar el ticket
        try {
            FileWriter ticket = new FileWriter("ticket.txt"); // Crear el archivo ticket.txt
            ticket.write("------Super shopping------\n"); // Escribir en el archivo
            ticket.write("Thanks for your purchase\n");
            ticket.write("Items bought:\n");
            for (Articulo a : cart.getCart()) { // Escribir los items comprados
                ticket.write("-" + a.toString() + "\n");
            }
            ticket.write("Total: $" + total); // Escribir el total de la compra
            ticket.close();
            Alert alert = new Alert(Alert.AlertType.INFORMATION); // Mostrar mensaje de éxito
            alert.setTitle("Thanks");
            alert.setHeaderText(null);
            alert.setContentText("Ticket generated successfully");
            alert.showAndWait(); // Esperar a que el usuario cierre el mensaje

            // Cerrar la aplicación
            Platform.exit();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    void continueShop(ActionEvent event) { // Función para regresar a la pantalla de compra
        try {
            root = FXMLLoader.load(getClass().getResource("Scene2.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    // Inicializar la pantalla
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        cart = Cart.getInstance(); // Obtener la instancia del carrito
        displayItems(); // Mostrar el número de items en el carrito
        displayTotal(); // Mostrar el total de la compra
        cartItems = FXCollections.observableArrayList(); // Inicializar la lista de items en el carrito
        updateCart(); // Actualizar la lista de items en el carrito
        items.setItems(cartItems); // Mostrar la lista de items en el carrito
    }

    public void displayItems() { // Función para mostrar el número de items en el carrito
        if (cart.getCart().size() == 0) { // Si el carrito está vacío, mostrar mensaje
            itemsnumber.setText("You have no items in your cart");
        } else { // Si el carrito no está vacío, mostrar el número de items
            itemsnumber.setText("You have: " + cart.getCart().size() + " items in your cart");
        }
    }

    public void updateCart() { // Función para actualizar la lista de items en el carrito
        cartItems.clear(); // Limpiar la lista
        cart = Cart.getInstance(); // Obtener la instancia del carrito
        List<Articulo> cartList = cart.getCart(); // Obtener la lista de items en el carrito
        for (Articulo articulo : cartList) { // Agregar los items a la lista
            cartItems.add(articulo.toString());
        }
    }

    public void displayTotal() { // Función para mostrar el total de la compra
        total = 0;
        cart = Cart.getInstance(); // Obtener la instancia del carrito
        List<Articulo> cartList = cart.getCart(); // Obtener la lista de items en el carrito
        for (Articulo articulo : cartList) { // Calcular el total de la compra
            total += articulo.getPrecio();
        }
        totallb.setText("$" + total);
    }

}
