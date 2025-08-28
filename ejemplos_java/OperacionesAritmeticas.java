import java.util.Scanner;
public class OperacionesAritmeticas {

    public double num1;
    public double num2;

    public double sumar()
    {
        double suma = num1 + num2;
        return suma;
    }

    public double restar()
    {
        double resta = num1 - num2;
        return resta;
    }

    public double multiplicar()
    {
        double multiplicacion = num1 * num2;
        return multiplicacion;
    }

    public double dividir()
    {
        if (num2 == 0) {
            throw new ArithmeticException("No se puede dividir por cero");
        }
        double division = (double) num1 / num2;
        return division;
    }

    public String impresionSumar()
    {
        return "La suma es: " + sumar();
    }

    public String impresionRestar()
    {
        return "La resta es: " + restar();
    }

    public String impresionMultiplicar()
    {
        return "La multiplicación es: " + multiplicar();
    }

    public String impresionDividir()
    {
        try {
            return "La división es: " + dividir();
        } catch (ArithmeticException e) {
            return "Error: " + e.getMessage();
        }
    }

    public void Menu()
    {
        Scanner sc = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("\n=== Menú de Operaciones Aritméticas ===");
            System.out.println("1. Sumar");
            System.out.println("2. Restar");
            System.out.println("3. Multiplicar");
            System.out.println("4. Dividir");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();

            if (opcion >= 1 && opcion <= 4) {
                System.out.print("Ingrese el primer número: ");
                num1 = sc.nextDouble();
                System.out.print("Ingrese el segundo número: ");
                num2 = sc.nextDouble();

                switch (opcion) {
                    case 1:
                        System.out.println("Resultado: " + sumar());
                        break;
                    case 2:
                        System.out.println("Resultado: " + restar());
                        break;
                    case 3:
                        System.out.println("Resultado: " + multiplicar());
                        break;
                    case 4:
                        if (num2 != 0) {
                            System.out.println("Resultado: " + dividir());
                        } else {
                            System.out.println("Error: No se puede dividir entre cero.");
                        }
                        break;
                }
            } else if (opcion != 0) {
                System.out.println("Opción inválida. Intente de nuevo.");
            }
        } while (opcion != 0);
        System.out.println("¡Hasta luego!");
    }

}
