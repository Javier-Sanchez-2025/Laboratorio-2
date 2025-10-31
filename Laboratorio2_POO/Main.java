import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = null;

        try {
            scanner = new Scanner(System.in);

            System.out.println("=== SISTEMA DE INVENTARIO Y VENTAS ===");

            // Crear producto con valores temporales
            ProductoAlimenticio producto = new ProductoAlimenticio("temp", "temp", 0.0, "temp", 0);

            // Solicitar código con validación
            while (true) {
                try {
                    System.out.print("Ingrese el codigo del producto: ");
                    String codigo = scanner.nextLine();
                    producto.setCodigo(codigo);
                    break;
                } catch (IllegalArgumentException e) {
                    System.out.println("Error: " + e.getMessage());
                }
            }

            // Solicitar nombre con validación
            while (true) {
                try {
                    System.out.print("Ingrese el nombre del producto: ");
                    String nombre = scanner.nextLine();
                    producto.setNombre(nombre);
                    break;
                } catch (IllegalArgumentException e) {
                    System.out.println("Error: " + e.getMessage());
                }
            }

            // Solicitar precio con validación
            while (true) {
                try {
                    System.out.print("Ingrese el precio del producto: ");
                    double precio = scanner.nextDouble();
                    scanner.nextLine();
                    producto.setPrecio(precio);
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Error: Por favor ingrese un valor numerico valido para el precio.");
                    scanner.nextLine();
                } catch (IllegalArgumentException e) {
                    System.out.println("Error: " + e.getMessage());
                }
            }

            // Solicitar fecha de caducidad con validación
            while (true) {
                try {
                    System.out.print("Ingrese la fecha de caducidad (AAAA-MM-DD): ");
                    String fechaCaducidad = scanner.nextLine();
                    producto.setFechaCaducidad(fechaCaducidad);
                    break;
                } catch (InventarioException e) {
                    System.out.println("Error: " + e.getMessage());
                } catch (IllegalArgumentException e) {
                    System.out.println("Error: " + e.getMessage());
                }
            }

            // Solicitar stock con validación
            while (true) {
                try {
                    System.out.print("Ingrese el stock inicial del producto: ");
                    int stock = scanner.nextInt();
                    scanner.nextLine();
                    producto.setStock(stock);
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Error: Por favor ingrese un número entero válido para el stock.");
                    scanner.nextLine();
                } catch (IllegalArgumentException e) {
                    System.out.println("Error: " + e.getMessage());
                }
            }

            // Mostrar detalles del producto creado
            System.out.println("\n=== PRODUCTO REGISTRADO EXITOSAMENTE ===");
            System.out.println("Detalles del producto:");
            System.out.println("Codigo: " + producto.getCodigo());
            System.out.println("Nombre: " + producto.getNombre());
            System.out.println("Precio: $" + producto.getPrecio());
            System.out.println("Fecha de Caducidad: " + producto.getFechaCaducidad());
            System.out.println("Stock inicial: " + producto.getStock() + " unidades");
            System.out.println("Representación completa: " + producto.toString());

            // === NUEVA FUNCIONALIDAD: SISTEMA DE VENTAS ===
            System.out.println("\n=== SISTEMA DE VENTAS ===");

            while (true) {
                try {
                    System.out.print("\n¿Cuantas unidades desea comprar? (0 para salir): ");
                    int cantidadComprada = scanner.nextInt();
                    scanner.nextLine(); // Limpiar buffer

                    if (cantidadComprada == 0) {
                        System.out.println("Saliendo del sistema de ventas...");
                        break;
                    }

                    // Intentar realizar la venta
                    producto.vender(cantidadComprada);
                    System.out.println("Venta exitosa! Nuevo stock: " + producto.getStock() + " unidades");

                    // Mostrar información compleja después de la venta
                    producto.mostrarInfoCompleja();

                } catch (InputMismatchException e) {
                    System.out.println("Error: Por favor ingrese un número entero válido.");
                    scanner.nextLine(); // Limpiar buffer
                } catch (StockInsuficienteException e) {
                    System.out.println("Error de stock: " + e.getMessage());
                } catch (IllegalArgumentException e) {
                    System.out.println("Error en la cantidad: " + e.getMessage());
                } catch (Exception e) {
                    System.out.println("Error inesperado: " + e.getMessage());
                }
            }

        } catch (Exception e) {
            System.err.println("Error inesperado: " + e.getMessage());
            e.printStackTrace();
        } finally {
            if (scanner != null) {
                scanner.close();
                System.out.println("\nScanner cerrado correctamente.");
            }
        }

        System.out.println("\nTotal de productos creados: " + Producto.getContadorProductos());

        // Ejemplos de otros productos
        System.out.println("\n=== EJEMPLOS DE PRODUCTOS ===");

        try {
            ProductoElectronico electronico = new ProductoElectronico("ELEC001", "Laptop", 1500.00, 24, 5);
            System.out.println("Producto electrónico: " + electronico);
            electronico.mostrarInfoCompleja();

            ProductoAlimenticio alimento = new ProductoAlimenticio("ALIM001", "Manzana", 1.50, "2025-06-15", 100);
            System.out.println("Producto alimenticio: " + alimento);
            alimento.mostrarInfoCompleja();

            // Prueba de venta en producto electrónico
            System.out.println("\n=== PRUEBA DE VENTA EN LAPTOP ===");
            try {
                electronico.vender(3);
                System.out.println(" Venta de 3 laptops exitosa. Stock restante: " + electronico.getStock());
            } catch (Exception e) {
                System.out.println(" Error en venta: " + e.getMessage());
            }

        } catch (Exception e) {
            System.err.println("Error en ejemplos: " + e.getMessage());
        }

        System.out.println("Total final de productos: " + Producto.getContadorProductos());
    }
}