public class Clothes extends Articulo {
    private String color;
    private String size;

    public Clothes(String tipo, Double precio, String color, String size) {
        super(tipo, precio);
        this.color = color;
        this.size = size;
    }

    // Implementar el método toString para que muestre la información del artículo
    @Override
    public String toString() {
        return getTipo() + " " + getColor() + " " + getSize() + " $" + getPrecio() + " ID: " + getId();
    }

    public String getColor() {
        return color;
    }

    public String getSize() {
        return size;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setSize(String size) {
        this.size = size;
    }

}
