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
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class Scene3Controller implements Initializable {
    private Parent root;
    private Scene scene;
    private Stage stage;
    private Cart cart;
    private String[] Color = { "Black", "White", "Brown" };
    private String[] Color2 = { "Black", "White" };
    private String[] Color3 = { "Blue", "Beige", "Green" };
    private String[] Color4 = { "Navy Blue", "Blue", "Faded Blue", "Black" };
    private String[] Color5 = { "Black", "Green", "Brown" };
    private String[] Size = { "XS", "S", "M", "L", "XL", "XXL" };
    private String[] Size2 = { "26", "28", "30", "32", "34", "36", "38" };
    int shirtAmount;
    int shirtAmount2;
    int shirtAmount3;
    int shirtAmount4;
    int shirtAmount5;
    int shirtAmount6;

    @FXML
    private ChoiceBox<String> Colorpick;
    @FXML
    private ChoiceBox<String> Colorpick2;
    @FXML
    private ChoiceBox<String> Colorpick3;
    @FXML
    private ChoiceBox<String> Colorpick4;
    @FXML
    private ChoiceBox<String> Colorpick5;
    @FXML
    private ChoiceBox<String> Colorpick6;
    @FXML
    private ChoiceBox<String> SizePick;
    @FXML
    private ChoiceBox<String> SizePick2;
    @FXML
    private ChoiceBox<String> SizePick3;
    @FXML
    private ChoiceBox<String> SizePick4;
    @FXML
    private ChoiceBox<String> SizePick5;
    @FXML
    private ChoiceBox<String> SizePick6;
    @FXML
    private Button addToCartBtn;
    @FXML
    private Button addToCartBtn2;
    @FXML
    private Button addToCartBtn3;
    @FXML
    private Button addToCartBtn4;
    @FXML
    private Button addToCartBtn5;
    @FXML
    private Button addToCartBtn6;
    @FXML
    private Label alertmsg;
    @FXML
    private Label alertmsg2;
    @FXML
    private Label alertmsg3;
    @FXML
    private Label alertmsg4;
    @FXML
    private Label alertmsg5;
    @FXML
    private Label alertmsg6;
    @FXML
    private Spinner<Integer> amountspn;
    @FXML
    private Spinner<Integer> amountspn2;
    @FXML
    private Spinner<Integer> amountspn3;
    @FXML
    private Spinner<Integer> amountspn4;
    @FXML
    private Spinner<Integer> amountspn5;
    @FXML
    private Spinner<Integer> amountspn6;
    @FXML
    private ImageView shirt1;
    @FXML
    private ImageView shirt2;
    @FXML
    private ImageView pant1;
    @FXML
    private ImageView pant2;
    @FXML
    private ImageView skirt1;
    @FXML
    private ImageView skirt2;
    @FXML
    private Label shirtName1;
    @FXML
    private Label shirtName2;
    @FXML
    private Label pantsName1;
    @FXML
    private Label pantsName2;
    @FXML
    private Label skirtName1;
    @FXML
    private Label skirtName2;
    @FXML
    private Label total;
    @FXML
    private Label total2;
    @FXML
    private Label total3;
    @FXML
    private Label total4;
    @FXML
    private Label total5;
    @FXML
    private Label total6;
    @FXML
    private Button backbtn;
    @FXML
    private Button cartbtn;

    @FXML
    void goToCart(ActionEvent event) { // Funcion para ir al carrito
        try {
            root = FXMLLoader.load(getClass().getResource("Scene4.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @FXML
    void goBack(ActionEvent event) { // Funcion para regresar a la pagina anterior
        try {
            root = FXMLLoader.load(getClass().getResource("Scene2.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // Este tipo de funciones addToCart son para agregar los productos al carrito y
    // funcionan de la misma manera
    @FXML
    void addToCart(ActionEvent event) { // Funcion para agregar la pimer camisa al carrito
        try {
            if (Colorpick.getValue() == null) { // Si no se selecciona un color
                alertmsg.setText("Please select a color");
                alertmsg.setStyle("-fx-text-fill: red");
            } else if (SizePick.getValue() == null) { // Si no se selecciona una talla
                alertmsg.setText("Please select a size");
                alertmsg.setStyle("-fx-text-fill: red");
            } else { // Si se selecciona un color y una talla
                // Se crea un objeto de tipo Clothes con los datos seleccionados
                for (int i = 0; i < shirtAmount; i++) { // Se agrega la cantidad de objetos al carrito
                    Clothes shirt = new Clothes(shirtName1.getText(), 25.00, Colorpick.getValue(), SizePick.getValue());
                    cart.addProduct(shirt);
                    System.out.println(shirt.toString());
                }
                alertmsg.setText("Added to cart!");
                alertmsg.setStyle("-fx-text-fill: green");
                // Se abre la ventana del carrito
                root = FXMLLoader.load(getClass().getResource("Scene4.fxml"));
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @FXML
    void addToCart2(ActionEvent event) { // Funcion para agregar al carrito la segunda camisa
        try {
            if (Colorpick2.getValue() == null) {
                alertmsg2.setText("Please select a color");
                alertmsg2.setStyle("-fx-text-fill: red");
            } else if (SizePick2.getValue() == null) {
                alertmsg2.setText("Please select a size");
                alertmsg2.setStyle("-fx-text-fill: red");
            } else {
                for (int i = 0; i < shirtAmount2; i++) {
                    Clothes shirt2 = new Clothes(shirtName2.getText(), 28.00, Colorpick2.getValue(),
                            SizePick2.getValue());
                    cart.addProduct(shirt2);
                    System.out.println(shirt2.toString());
                }
                alertmsg2.setText("Added to cart!");
                alertmsg2.setStyle("-fx-text-fill: green");
                root = FXMLLoader.load(getClass().getResource("Scene4.fxml"));
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    @FXML
    void addToCart3(ActionEvent event) { // Funcion para agregar al carrito el primer pantalon
        try {
            if (Colorpick3.getValue() == null) {
                alertmsg3.setText("Please select a color");
                alertmsg3.setStyle("-fx-text-fill: red");
            } else if (SizePick3.getValue() == null) {
                alertmsg3.setText("Please select a size");
                alertmsg3.setStyle("-fx-text-fill: red");
            } else {
                for (int i = 0; i < shirtAmount3; i++) {
                    Clothes pants = new Clothes(pantsName1.getText(), 30.00, Colorpick3.getValue(),
                            SizePick3.getValue());
                    cart.addProduct(pants);
                    System.out.println(pants.toString());
                }
                alertmsg3.setText("Added to cart!");
                alertmsg3.setStyle("-fx-text-fill: green");
                root = FXMLLoader.load(getClass().getResource("Scene4.fxml"));
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    @FXML
    void addToCart4(ActionEvent event) { // Funcion para agregar al carrito el segundo pantalon
        try {
            if (Colorpick4.getValue() == null) {
                alertmsg4.setText("Please select a color");
                alertmsg4.setStyle("-fx-text-fill: red");
            } else if (SizePick4.getValue() == null) {
                alertmsg4.setText("Please select a size");
                alertmsg4.setStyle("-fx-text-fill: red");
            } else {
                for (int i = 0; i < shirtAmount4; i++) {
                    Clothes pants2 = new Clothes(pantsName2.getText(), 50.00, Colorpick4.getValue(),
                            SizePick4.getValue());
                    cart.addProduct(pants2);
                    System.out.println(pants2.toString());
                }
                alertmsg4.setText("Added to cart!");
                alertmsg4.setStyle("-fx-text-fill: green");
                root = FXMLLoader.load(getClass().getResource("Scene4.fxml"));
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    @FXML
    void addToCart5(ActionEvent event) { // Funcion para agregar al carrito la primera falda
        try {
            if (Colorpick5.getValue() == null) {
                alertmsg5.setText("Please select a color");
                alertmsg5.setStyle("-fx-text-fill: red");
            } else if (SizePick5.getValue() == null) {
                alertmsg5.setText("Please select a size");
                alertmsg5.setStyle("-fx-text-fill: red");
            } else {
                for (int i = 0; i < shirtAmount5; i++) {
                    Clothes skirt = new Clothes(skirtName1.getText(), 20.00, Colorpick5.getValue(),
                            SizePick5.getValue());
                    cart.addProduct(skirt);
                    System.out.println(skirt.toString());
                }
                alertmsg5.setText("Added to cart!");
                alertmsg5.setStyle("-fx-text-fill: green");
                root = FXMLLoader.load(getClass().getResource("Scene4.fxml"));
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @FXML
    void addToCart6(ActionEvent event) { // Funcion para agregar al carrito la segunda falda
        try {
            if (Colorpick6.getValue() == null) {
                alertmsg6.setText("Please select a color");
                alertmsg6.setStyle("-fx-text-fill: red");
            } else if (SizePick6.getValue() == null) {
                alertmsg6.setText("Please select a size");
                alertmsg6.setStyle("-fx-text-fill: red");
            } else {
                for (int i = 0; i < shirtAmount6; i++) {
                    Clothes skirt2 = new Clothes(skirtName2.getText(), 30.00, Colorpick6.getValue(),
                            SizePick6.getValue());
                    cart.addProduct(skirt2);
                    System.out.println(skirt2.toString());
                }
                alertmsg6.setText("Added to cart!");
                alertmsg6.setStyle("-fx-text-fill: green");
                root = FXMLLoader.load(getClass().getResource("Scene4.fxml"));
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    // Esta funcion inicializa los valores y elementos de la escena
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        cart = Cart.getInstance(); // Se obtiene la instancia del carrito
        Colorpick.getItems().addAll(Color); // Se agregan los colores a los choicebox
        Colorpick.setOnAction(this::getColor); // Se agrega el evento de seleccionar un color
        Colorpick2.getItems().addAll(Color2); // lo mismo para los demas choicebox
        Colorpick2.setOnAction(this::getColor2);
        Colorpick3.getItems().addAll(Color3);
        Colorpick3.setOnAction(this::getColor3);
        Colorpick4.getItems().addAll(Color4);
        Colorpick4.setOnAction(this::getColor4);
        Colorpick5.getItems().addAll(Color5);
        Colorpick5.setOnAction(this::getColor5);
        Colorpick6.getItems().addAll(Color2);
        Colorpick6.setOnAction(this::getColor6);
        SizePick.getItems().addAll(Size); // Se agregan las tallas a los choicebox
        SizePick2.getItems().addAll(Size);
        SizePick3.getItems().addAll(Size2);
        SizePick4.getItems().addAll(Size2);
        SizePick5.getItems().addAll(Size);
        SizePick6.getItems().addAll(Size);
        // Se agregan los valores a los spinners para seleccionar la cantidad de cada
        // producto (1-5)
        SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 5, 1);
        SpinnerValueFactory<Integer> valueFactory2 = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 5, 1);
        SpinnerValueFactory<Integer> valueFactory3 = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 5, 1);
        SpinnerValueFactory<Integer> valueFactory4 = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 5, 1);
        SpinnerValueFactory<Integer> valueFactory5 = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 5, 1);
        SpinnerValueFactory<Integer> valueFactory6 = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 5, 1);
        amountspn.setValueFactory(valueFactory); // Se agregan los valores a los spinners
        amountspn2.setValueFactory(valueFactory2);
        amountspn3.setValueFactory(valueFactory3);
        amountspn4.setValueFactory(valueFactory4);
        amountspn5.setValueFactory(valueFactory5);
        amountspn6.setValueFactory(valueFactory6);
        total.setText("25.00"); // Se agregan los valores de los totales de cada producto
        total2.setText("28.00");
        total3.setText("30.00");
        total4.setText("50.00");
        total5.setText("20.00");
        total6.setText("30.00");
        shirtAmount = amountspn.getValue(); // Se obtiene el valor de la cantidad de cada producto
        shirtAmount2 = amountspn2.getValue();
        shirtAmount3 = amountspn3.getValue();
        shirtAmount4 = amountspn4.getValue();
        shirtAmount5 = amountspn5.getValue();
        shirtAmount6 = amountspn6.getValue();
        // Se agregan los eventos para actualizar el total de cada producto al cambiar
        // la cantidad
        amountspn.valueProperty().addListener((obs, oldValue, newValue) -> {
            shirtAmount = amountspn.getValue();
            total.setText(shirtAmount * 25 + ".00");
        });
        // lo mismo para los demas spinners
        amountspn2.valueProperty().addListener((obs, oldValue, newValue) -> {
            shirtAmount2 = amountspn2.getValue();
            total2.setText(shirtAmount2 * 28 + ".00");
        });
        amountspn3.valueProperty().addListener((obs, oldValue, newValue) -> {
            shirtAmount3 = amountspn3.getValue();
            total3.setText(shirtAmount3 * 30 + ".00");
        });
        amountspn4.valueProperty().addListener((obs, oldValue, newValue) -> {
            shirtAmount4 = amountspn4.getValue();
            total4.setText(shirtAmount4 * 50 + ".00");
        });
        amountspn5.valueProperty().addListener((obs, oldValue, newValue) -> {
            shirtAmount5 = amountspn5.getValue();
            total5.setText(shirtAmount5 * 20 + ".00");
        });
        amountspn6.valueProperty().addListener((obs, oldValue, newValue) -> {
            shirtAmount6 = amountspn6.getValue();
            total6.setText(shirtAmount6 * 30 + ".00");
        });
    }

    // Este bloque de funciones getColor se encarga de cambiar la imagen de cada
    // producto al seleccionar un color
    public void getColor(ActionEvent event) {
        String color = Colorpick.getValue(); // Se obtiene el valor del color seleccionado
        try {
            if (color.equals("Black")) { // Se compara el valor del color con los colores disponibles
                shirt1.setStyle("-fx-image: url('/images/shirt1.jpg')"); // Se cambia la imagen del producto
            } else if (color.equals("White")) {
                shirt1.setStyle("-fx-image: url('/images/shirt3.jpg')");
            } else if (color.equals("Brown")) {
                shirt1.setStyle("-fx-image: url('/images/shirt2.jpg')");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // funcionan de la misma manera para los demas productos
    public void getColor2(ActionEvent event) {
        String color2 = Colorpick2.getValue();
        try {
            if (color2.equals("Black")) {
                shirt2.setStyle("-fx-image: url('/images/shirt4.jpg')");
            } else if (color2.equals("White")) {
                shirt2.setStyle("-fx-image: url('/images/shirt6.jpg')");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void getColor3(ActionEvent event) {
        String color3 = Colorpick3.getValue();
        try {
            if (color3.equals("Blue")) {
                pant1.setStyle("-fx-image: url('/images/pants1.jpg')");
            } else if (color3.equals("Beige")) {
                pant1.setStyle("-fx-image: url('/images/pants8.jpg')");
            } else if (color3.equals("Green")) {
                pant1.setStyle("-fx-image: url('/images/pants2.jpg')");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void getColor4(ActionEvent event) {
        String color4 = Colorpick4.getValue();
        try {
            if (color4.equals("Navy Blue")) {
                pant2.setStyle("-fx-image: url('/images/pants4.jpg')");
            } else if (color4.equals("Blue")) {
                pant2.setStyle("-fx-image: url('/images/pants5.jpg')");
            } else if (color4.equals("Faded Blue")) {
                pant2.setStyle("-fx-image: url('/images/pants6.jpg')");
            } else if (color4.equals("Black")) {
                pant2.setStyle("-fx-image: url('/images/pants7.jpg')");
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void getColor5(ActionEvent event) {
        String color5 = Colorpick5.getValue();
        try {
            if (color5.equals("Black")) {
                skirt1.setStyle("-fx-image: url('/images/skirt2.jpg')");
            } else if (color5.equals("Green")) {
                skirt1.setStyle("-fx-image: url('/images/skirt5.jpg')");
            } else if (color5.equals("Brown")) {
                skirt1.setStyle("-fx-image: url('/images/skirt6.jpg')");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void getColor6(ActionEvent event) {
        String color6 = Colorpick6.getValue();
        try {
            if (color6.equals("Black")) {
                skirt2.setStyle("-fx-image: url('/images/skirt4.jpg')");
            } else if (color6.equals("White")) {
                skirt2.setStyle("-fx-image: url('/images/skirt7.jpg')");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}