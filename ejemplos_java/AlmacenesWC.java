public class AlmacenesWC {
    public static void main(String[] args) {
        int precioZapatos = 350000;
        int precioTenis = 280000;
        int precioCamisetas = 175000;
        int precioJeans = 200000;


        System.out.println("Almacén WC");
        System.out.println("Precio de los Zapatos: $" + precioZapatos);
        System.out.println("Precio de los Tenis: $" + precioTenis);
        System.out.println("Precio de las Camisetas: $" + precioCamisetas);
        System.out.println("Precio de los Jeans: $" + precioJeans);

        int total = precioZapatos + precioTenis + precioCamisetas + precioJeans;
        int promedio = total / 4;

        System.out.println("\nTotal: $" + total);
        System.out.println("Promedio de Precios: $" + promedio);

        double nuevoPrecioJeans = precioJeans * 1.062;

        double nuevoPrecioZapatos = precioZapatos * 0.992;

        System.out.println("\nNuevo Precio de los Zapatos: $" + (int)nuevoPrecioZapatos);
        System.out.println("Nuevo Precio de los Jeans: $" + (int)nuevoPrecioJeans);
    }
}
    

