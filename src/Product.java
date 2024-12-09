// Clase Product
public class Product {
    // Atributos
    private String name;
    private int initialQuantity;
    private int soldQuantity;

    // Constructor
    public Product(String name, int initialQuantity) {
        this.name = name;
        this.initialQuantity = initialQuantity;
        this.soldQuantity = 0;
    }

    // Metodo para obtener el nombre
    public String getName() {
        return name;
    }

    // Metodo para obtener la cantidad disponible
    public int getAvailableQuantity() {
        return initialQuantity - soldQuantity;
    }

    // Metodo para vender
    public void sell(int quantity) {
        // Verificar si hay suficiente cantidad disponible
        if (quantity <= getAvailableQuantity()) {
            soldQuantity += quantity;
        } else {
            System.out.println("No ha stock disponible para este producto: " + name);
        }
    }

    // Metodo para duplicar el inventario
    public void duplicateInventory() {
        // Duplicar la cantidad inicial si no hay stock disponible
        if (getAvailableQuantity() == 0) {
            initialQuantity *= 2;
        }
    }

    // Metodo para mostrar la información
    public void displayInfo() {
        System.out.println("Producto: " + name);
        System.out.println("Cantidad inicial: " + initialQuantity);
        System.out.println("Cantidad vendida: " + soldQuantity);
        System.out.println("Cantidad Disponible: " + getAvailableQuantity());
    }
}