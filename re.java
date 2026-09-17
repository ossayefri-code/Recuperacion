import java.util.Scanner;
import java.util.Stack;

public class re {
    static class Producto {
        String nombre;
        double precio;

        Producto(String nombre, double precio) {
            this.nombre = nombre;
            this.precio = precio;
        }

        @Override
        public String toString() {
            return nombre + " - $" + precio; f
        }
    }

    static final int MAX = 10;
    static Producto[] productosAltos = new Producto[MAX];
    static Stack<Producto> productosBajos = new Stack<>();
    static int contadorAltos = 0;
    static Scanner sc = new Scanner(System.in);

    public static void registrarProducto() {
        System.out.print("Ingrese nombre del producto de belleza: ");
        String nombre = sc.nextLine();

        System.out.print("Ingrese precio del producto: ");
        double precio = sc.nextDouble();
        sc.nextLine();

        if (precio > 200000) {
            if (contadorAltos < MAX) {
                productosAltos[contadorAltos] = new Producto(nombre, precio);
                contadorAltos++;
                System.out.println("Producto agregado al arreglo.");
            } else {
                System.out.println("El arreglo ya est� lleno.");
            }
        } else {
            productosBajos.push(new Producto(nombre, precio));
            System.out.println("Producto agregado a la pila.");
        }
    }

    public static void mostrarArreglo() {
        System.out.println("\nProductos de belleza > 200000:");
        if (contadorAltos == 0) {
            System.out.println("No hay productos en el arreglo.");
            return;
        }

        for (int i = 0; i < contadorAltos; i++) {
            System.out.println((i + 1) + ". " + productosAltos[i]);
        }
    }

    public static void mostrarPila() {
        System.out.println("\nProductos de belleza <= 200000:");
        if (productosBajos.isEmpty()) {
            System.out.println("No hay productos en la pila.");
            return;
        }

        Stack<Producto> aux = new Stack<>();
        while (!productosBajos.isEmpty()) {
            Producto p = productosBajos.pop();
            aux.push(p);
            System.out.println("- " + p);
        }

        while (!aux.isEmpty()) {
            productosBajos.push(aux.pop());
        }
    }

    public static void menu() {
        int opcion;

        do {
            System.out.println("\n===== MENU PRODUCTOS DE BELLEZA =====");
            System.out.println("1. Registrar producto");
            System.out.println("2. Mostrar arreglo (> 200000)");
            System.out.println("3. Mostrar pila (<= 200000)");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opcion: ");

            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    registrarProducto();
                    break;
                case 2:
                    mostrarArreglo();
                    break;
                case 3:
                    mostrarPila();
                    break;
                case 4:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opcion invalida.");
            }
        } while (opcion != 4);
    }

    public static void main(String[] args) {
        System.out.println("Bienvenido al sistema de productos de belleza.");
        menu();
    }
}
