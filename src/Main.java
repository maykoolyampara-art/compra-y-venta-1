import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        final int TAMANIO = 5;

        String[] nombres = new String[TAMANIO];
        double[] precios = new double[TAMANIO];
        int[] stock = new int[TAMANIO];
        int[] carrito = new int[TAMANIO];

        int contadorProductos = 0;
        int opcion;

        do {
            System.out.println("===== SISTEMA DE VENTAS =====");
            System.out.println("1. Registrar productos");
            System.out.println("2. Mostrar catalogo");
            System.out.println("3. Comprar productos");
            System.out.println("4. Obtener factura");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opcion: ");

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {

                case 1:
                    if (contadorProductos < TAMANIO) {

                        System.out.print("Nombre del producto: ");
                        nombres[contadorProductos] = scanner.nextLine();

                        System.out.print("Precio del producto: S/ ");
                        precios[contadorProductos] = scanner.nextDouble();

                        System.out.print("Cantidad disponible: ");
                        stock[contadorProductos] = scanner.nextInt();
                        scanner.nextLine();

                        if (precios[contadorProductos] >= 0 &&
                                stock[contadorProductos] >= 0) {

                            contadorProductos++;
                            System.out.println("Producto registrado correctamente.");

                        } else {
                            System.out.println("Ingrese valores validos.");
                        }

                    } else {
                        System.out.println("No se pueden registrar mas productos.");
                    }
                    break;

                case 2:
                    System.out.println("\n===== CATALOGO =====");

                    if (contadorProductos == 0) {
                        System.out.println("No hay productos registrados.");
                    } else {
                        for (int i = 0; i < contadorProductos; i++) {
                            System.out.println((i + 1) + ". " + nombres[i] + " | S/ " + String.format("%.2f", precios[i]) + " | Stock: " + stock[i]);
                        }
                    }
                    break;

                case 3:
                    if (contadorProductos == 0) {
                        System.out.println("Registre productos primero.");
                    } else {
                        System.out.println("\n===== CARRITO DE COMPRAS =====");

                        for (int i = 0; i < contadorProductos; i++) {
                            System.out.println((i + 1) + ". " + nombres[i] + " | S/ " + String.format("%.2f", precios[i]) + " | Stock: " + stock[i]);
                        }

                        System.out.print("Numero del producto: ");
                        int producto = scanner.nextInt();

                        if (producto >= 1 && producto <= contadorProductos) {
                            int indice = producto - 1;

                            System.out.print("Cantidad que desea comprar: ");
                            int cantidad = scanner.nextInt();

                            if (cantidad > 0 && cantidad <= stock[indice]) {
                                carrito[indice] += cantidad;
                                stock[indice] -= cantidad;

                                System.out.println("Producto agregado al carrito.");
                            } else {
                                System.out.println("Cantidad no valida o stock insuficiente.");
                            }
                        } else {
                            System.out.println("Producto no valido.");
                        }

                        scanner.nextLine();
                    }
                    break;

                case 4:
                    double total = 0;

                    System.out.println("========== FACTURA ==========");
                    System.out.println("PRODUCTO | CANTIDAD | PRECIO | SUBTOTAL");

                    for (int i = 0; i < contadorProductos; i++) {
                        if (carrito[i] > 0) {
                            double subtotal = carrito[i] * precios[i];
                            total += subtotal;

                            System.out.println(nombres[i] + " | " + carrito[i] + " | S/ " + String.format("%.2f", precios[i]) + " | S/ " + String.format("%.2f", subtotal));
                        }
                    }

                    System.out.println("-----------------------------");
                    System.out.println("TOTAL A PAGAR: S/ "
                            + String.format("%.2f", total));
                    System.out.println("=============================");

                    break;

                case 5:
                    System.out.println("Gracias por utilizar el sistema de ventas.");
                    break;

                default:
                    System.out.println("Opcion no valida.");
            }

        } while (opcion != 5);

        scanner.close();
    }
}

