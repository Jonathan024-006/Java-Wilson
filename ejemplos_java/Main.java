import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("¡Hola desde Java en macOS!");
       /*  System.out.print("Otro saludo");
       System.out.println("Programación Java");
       System.out.print("Otro saludo");

       Manejo de variables
       int edad = 25; //Entero
       System.out.println("La edad es: " + edad);
       System.out.println("Su edad es: " + edad);

       double precio = 99.99; //Numero decimal
       char inicial = 'J'; //Carácter
       boolean esMayor = true; //Booleano
       String nombre = "Jorge"; //Cadena de texto

       int numero1 = 10;
       int numero2 = 15;

       int resultado = numero1 + numero2;

       System.out.print("El resultado es: " + resultado);*/

       //Uso de Scanner para capturar datos desde la consola

       java.util.Scanner sc = new java.util.Scanner(System.in);
       /*System.out.print("Ingrese su nombre: ");
       String nombre = sc.nextLine();
       System.out.println("nombre" + nombre);

       //Capturar un numero entero
       System.out.print("Ingrese su edad: ");
       int edad = sc.nextInt();
       System.out.println("nombre" + edad);

       //captura un numero decimal
       System.out.print("Ingrese su altura en metros: ");
       double altura = sc.nextDouble();
       System.out.println("nombre" + altura);

       //capturar un carácter
       System.out.print("Ingrese su inicial: ");
       char inicial = sc.next().charAt(0);
       System.out.println("nombre" + inicial);

       //capturar un valor booleano
       System.out.print("Eres estudiante? (true/false): ");
       boolean esEstudiante = sc.nextBoolean();
       System.out.println("nombre" + esEstudiante);

       System.out.println("\n=== Datos Ingresados ===");
       System.out.println("nombre" + nombre);
       System.out.println("edad" + edad);

    // Precaución con nextline() o nextDouble()
    // Cuando se usa nextlint() o nextDouble(), queda un salto de linea (\n) en el buffer,
    // lo que puede causar que nextline() se salte la entrada del usuario. Para evitarlo,
    // usa un scanner.nextline(); después de nextInt() o nextDouble().

    // Capturar un String
    System.out.print("Ingrese su nombre: ");
    String name = sc.nextLine();*/

    //Capturar un número entero
/*     System.out.print("Ingrese su edad: ");
    int age = sc.nextInt(); //Limpiar buffer
    sc.nextLine(); // Limpiar el buffer después de nextInt()
    int age_parameter = 18;

    boolean tieneBoleta = true;

    if (age >= age_parameter && tieneBoleta) {
        System.out.println("Puedes ingresar al evento.");
    } else {
        System.out.println("No puedes ingresar al evento.");
    }

    if (age >= 18 && tieneBoleta) {
        System.out.println("Puedes ingresar al evento.");
    } else if (age >=18 && !tieneBoleta) {
        System.out.println("No puedes ingresar al evento, no tienes boleta.");
    } else if (age < 18 && tieneBoleta) {
        System.out.println("No puedes ingresar al evento, eres menor de edad.");
    
    } else {
        System.out.println("No puedes ingresar al evento, no tienes boleta.");
    }

    //Mensaje de edad con operador ternario
    String mensaje = (age >= 18) ? "Eres mayor de edad." : "Eres menor de edad.";
    System.out.println(mensaje);

    mensaje = (age >= 18 && tieneBoleta) ? "Puedes ingresar al evento." : "No puedes ingresar al evento.";
    System.out.println(mensaje); */
    

/*     int edad = 19;
    boolean tieneBoleta = true;
    java.time.LocalDate fechaevento = java.time.LocalDate.parse("2025-08-14");
    String mensaje = "";
    
    if (edad >= 18){
        if (tieneBoleta) {
            if (fechaevento.isAfter(java.time.LocalDate.now())) {
                mensaje = "Puedes ingresar al evento.";
            } else {
                mensaje = "El evento ya ha pasado.";
            }
        } else {
            mensaje = "No puedes ingresar al evento, no tienes boleta.";
        }
    } else {
        mensaje = "No puedes ingresar al evento, eres menor de edad.";
    } */
    

    // Switch tradicional
    int dia = 3;

    switch (dia) {
        case 1:
            System.out.println("Lunes");
            break;
        case 2:
            System.out.println("Martes");
            break;
        case 3:
            System.out.println("Miércoles");
            break;
        case 4:
            System.out.println("Jueves");
            break;
        case 5:
            System.out.println("Viernes");
            break;
        case 6:
            System.out.println("Sábado");
            break;
        case 7:
            System.out.println("Domingo");
            break;
        default:
            System.out.println("Día inválido");
    }


    // Expresión switch Mejorada
/*     String resultado = switch (dia) {
        case 1 -> "Lunes";
        case 2 -> "Martes";
        case 3 -> "Miércoles";
        case 4 -> "Jueves";
        case 5 -> "Viernes";
        case 6 -> "Sábado";
        case 7 -> "Domingo";
        default -> "Día inválido";
    }; */
  /*   System.out.println(resultado); */

  
    sc.close();
    }
}
