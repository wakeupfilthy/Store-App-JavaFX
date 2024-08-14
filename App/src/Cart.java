import java.util.ArrayList;
import java.util.List;

/*esta clase es un singleton que representa el carrito de compras
    * solo puede haber una instancia de esta clase
    * se usa el patron de diseño singleton
    * https://www.geeksforgeeks.org/singleton-class-java/
*/
public class Cart {
    public static Cart instance; // instancia unica de la clase
    private List<Articulo> shcart; // lista de articulos en el carrito

    private Cart() {
        shcart = new ArrayList<>(); // inicializar la lista de articulos
    }

    // metodo para obtener la instancia unica de la clase
    public static Cart getInstance() {
        if (instance == null) { // si no hay una instancia, crear una
            instance = new Cart();
        }
        return instance;
    }

    public void addProduct(Articulo product) {
        shcart.add(product);
    }

    public void removeProduct(Articulo product) {
        shcart.remove(product);
    }

    public List<Articulo> getCart() {
        return shcart; // regresa la lista de articulos
    }
}
