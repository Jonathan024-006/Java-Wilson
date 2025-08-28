import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuPrincipal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n===== MENÚ PRINCIPAL =====");
            System.out.println("1. Calcular IVA por categoría");
            System.out.println("2. Calcular estadísticas de lecturas");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese la categoría del producto: ");
                    String categoria = sc.nextLine().toUpperCase();
                    System.out.print("Ingrese el precio base: ");
                    double precioBase = sc.nextDouble();
                    sc.nextLine();

                    double porcentajeIVA;
                    switch (categoria) {
                        case "COMIDA":
                            porcentajeIVA = 5.0;
                            break;
                        case "ELECTRODOMESTICOS":
                            porcentajeIVA = 19.0;
                            break;
                        case "ROPA":
                            porcentajeIVA = 12.0;
                            break;
                        default:
                            System.out.println("Categoría no válida.");
                            continue;
                    }

                    double iva = precioBase * porcentajeIVA / 100;
                    double total = precioBase + iva;

                    System.out.printf("Subtotal: %.2f\n", precioBase);
                    System.out.printf("IVA (%.0f%%): %.2f\n", porcentajeIVA, iva);
                    System.out.printf("Total: %.2f\n", total);
                    break;

                case 2:
                    System.out.print("Ingrese la cantidad de lecturas: ");
                    int n = sc.nextInt();

                    if (n <= 0) {
                        System.out.println("La cantidad debe ser mayor que 0.");
                        continue;
                    }

                    List<Double> lecturas = new ArrayList<>();
                    for (int i = 0; i < n; i++) {
                        System.out.printf("Lectura %d: ", i + 1);
                        lecturas.add(sc.nextDouble());
                    }

                    double suma = 0;
                    double min = lecturas.get(0);
                    double max = lecturas.get(0);

                    for (double valor : lecturas) {
                        suma += valor;
                        if (valor < min) min = valor;
                        if (valor > max) max = valor;
                    }

                    double promedio = suma / n;

                    System.out.println("\n--- Resumen de Lecturas ---");
                    for (int i = 0; i < lecturas.size(); i++) {
                        System.out.printf("%d) %.2f\n", i + 1, lecturas.get(i));
                    }
                    System.out.printf("\nPromedio: %.2f\n", promedio);
                    System.out.printf("Mínimo: %.2f\n", min);
                    System.out.printf("Máximo: %.2f\n", max);
                    break;

                case 0:
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
                    break;
            }
        } while (opcion != 0);

        sc.close();
    }
}
