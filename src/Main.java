// Nombre: Alisson Ibarguen
// Número de ID: 8-1020-2253
// Facultad: FACULTAD DE INGENIERÍA, ARQUITECTURA Y DISEÑO
// Carrera: Lic. INGENIERÍA EN SISTEMAS COMPUTACIONALES
// Curso: Programación de Computadoras II

/*
Enunciado: Crear una aplicación de línea de comandos que permita la gestión de inventarios de productos de una tienda
de zapatos. El objetivo es obtener información sobre varios productos, calcular la disponibilidad en inventario después
de las ventas y proporcionar información del producto. El programa podrá:
    Permitir el ingreso de información de los productos.
    Calcular la disponibilidad en inventario restando las unidades vendidas de la cantidad inicial.
    Determinar si hay suficiente stock disponible para una venta.
    Duplicar el inventario inicial de un producto que ya se haya vendido totalmente.
    Mostrar la información actualizada del inventario por pantalla.
*/

// importamos la clase Scanner del paquete java.util
// importamos la clase ArrayList del paquete java.util
import java.util.ArrayList;
import java.util.Scanner;

// Clase Product
public class Main {
    // Atributos
    private static ArrayList<Product> products = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    // Metodo principal
    public static void main(String[] args) {
        // Bucle infinito para mostrar el menú
        while (true) {
            System.out.println("1. Añadir Producto");
            System.out.println("2. Vender Producto");
            System.out.println("3. Duplicar Inventario");
            System.out.println("4. Mostrar Inventario");
            System.out.println("5. Salir");
            System.out.print("Elige una opción: ");
            
            // Leer la opción
            int option = scanner.nextInt();
            scanner.nextLine();  

            // Seleccionar la opción
            switch (option) {
                case 1:
                    addProduct();
                    break;
                case 2:
                    sellProduct();
                    break;
                case 3:
                    duplicateInventory();
                    break;
                case 4:
                    displayInventory();
                    break;
                case 5:
                    System.exit(0);
                default:
                    System.out.println("Opción invalida. Porfavor coloque otra.");
            }
        }
    }

    // Metodo para añadir un producto
    private static void addProduct() {
        System.out.print("Entre el nombre del producto: ");
        String name = scanner.nextLine();
        System.out.print("Entre la cantidad inicial: ");
        int quantity = scanner.nextInt();
        scanner.nextLine();  
        products.add(new Product(name, quantity));
    }

    // Metodo para vender un producto
    private static void sellProduct() {
        // Leer el nombre del producto y la cantidad a vender
        System.out.print("Entre el nombre del producto: ");
        String name = scanner.nextLine();
        System.out.print("Entre la cantidad a vender: ");
        int quantity = scanner.nextInt();
        scanner.nextLine();

        // Buscar el producto y vender
        for (Product product : products) {
            if (product.getName().equalsIgnoreCase(name)) {
                product.sell(quantity);
                return;
            }
        }
        System.out.println("Lo siento, No hemos encontrado el producto.");
    }

    // Metodo para duplicar el inventario
    private static void duplicateInventory() {
        System.out.print("Entre el nombre del producto: ");
        String name = scanner.nextLine();

        // Buscar el producto y duplicar el inventario
        for (Product product : products) {
            if (product.getName().equalsIgnoreCase(name)) {
                product.duplicateInventory();
                return;
            }
        }
        System.out.println("Producto no encontrado.");
    }

    // Metodo para mostrar el inventario
    private static void displayInventory() {
        for (Product product : products) {
            product.displayInfo();
            System.out.println();
        }
    }
}


