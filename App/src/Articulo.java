import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public abstract class Articulo {
    private int id;
    private String tipo;
    private Double precio;

    public Articulo(String tipo, Double precio) {
        this.id = generateID();
        this.tipo = tipo;
        this.precio = precio;
    }

    // función que genera un numero de serie aleatorio de 3 digitos
    private int generateID() {
        Random random = new Random();
        int numserie = random.nextInt(900) + 100; // genera un numero entre 0 y 899 y le suma 100 para que sea de 3
                                                  // digitos

        // Verificar que el número de serie generado no esté en el conjunto de números
        // previamente generados
        Set<Integer> iDGenerados = new HashSet<>(); // conjunto de numeros de serie generados
        while (iDGenerados.contains(numserie)) {
            numserie = random.nextInt(900) + 100; // Si el numero de serie ya existe, genera otro
        }

        // Agregar el número de serie generado al conjunto de números generados
        iDGenerados.add(numserie);

        return numserie;
    }

    public abstract String toString();

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Double getPrecio() {
        return precio;
    }

    public int getId() {
        return id;
    }
}
