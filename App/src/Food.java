public class Food extends Articulo {
    private String expirationDate;
    private String importprod;
    private Double kg;

    public Food(String tipo, Double kg, Double precio, String expirationDate, String importprod) {
        super(tipo, precio);
        this.expirationDate = expirationDate;
        this.importprod = importprod;
        this.kg = kg;
    }

    // Implementar el método toString para que muestre la información del artículo
    @Override
    public String toString() {
        return getTipo() + " " + getExpirationDate() + " " + getImportprod() + " " + getKg() + "kg" + " $" + getPrecio()
                + " ID: " + getId();
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getImportprod() {
        return importprod;
    }

    public void setImportprod(String importprod) {
        this.importprod = importprod;
    }

    public Double getKg() {
        return kg;
    }

    public void setKg(Double kg) {
        this.kg = kg;
    }

}
