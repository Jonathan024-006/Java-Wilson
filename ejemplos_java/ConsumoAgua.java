import java.util.Scanner;

public class ConsumoAgua {
    public static void main(String[] args) {
        final double TARIFA_POR_LITRO = 0.15;

        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese el nombre del usuario: ");
        String nombreUsuario = sc.nextLine();

        System.out.print("Ingrese la lectura inicial del mes (en litros): ");
        int lecturaInicial = sc.nextInt();

        System.out.print("Ingrese la lectura final del mes (en litros): ");
        int lecturaFinal = sc.nextInt();


        if (lecturaFinal <= lecturaInicial) {
            System.out.println("Error: La lectura final debe ser mayor que la lectura inicial.");
        } else {
            int consumoLitros = lecturaFinal - lecturaInicial;


            double costoTotal = consumoLitros * TARIFA_POR_LITRO;

            System.out.println("\n--- Resumen del consumo ---");
            System.out.println("Usuario: " + nombreUsuario);
            System.out.println("Consumo: " + consumoLitros + " litros");
            System.out.printf("Costo total: $%.2f\n", costoTotal);
        }

        sc.close();
    }
}
