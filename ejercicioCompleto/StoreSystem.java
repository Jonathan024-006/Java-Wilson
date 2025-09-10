import java.util.*;

/**
 * StoreSystem.java
 *
 * Sistema de Gestión de Tienda (versión con pedidos más bonitos en consola).
 */

// ---------------------- ABSTRACCIÓN ----------------------
abstract class Product {
    protected final int id;
    protected String name;
    protected double price;

    private static int nextId = 1;

    public Product(String name, double price) {
        if (name == null || name.isBlank()) throw new IllegalArgumentException("El nombre no puede estar vacío");
        if (price < 0) throw new IllegalArgumentException("El precio no puede ser negativo");
        this.id = nextId++;
        this.name = name;
        this.price = price;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public double getPrice() { return price; }

    public abstract String getInfo();

    @Override
    public String toString() {
        return getInfo();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product p = (Product) o;
        return this.id == p.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

// ---------------------- INTERFAZ ----------------------
interface Vendible {
    double calcularPrecioFinal();
    default boolean tieneDescuento() { return false; }
}

// ---------------------- HERENCIA ----------------------
class DigitalProduct extends Product implements Vendible {
    private double discount; // en %

    public DigitalProduct(String name, double price, double discount) {
        super(name, price);
        if (discount < 0 || discount > 100) throw new IllegalArgumentException("Descuento inválido");
        this.discount = discount;
    }

    @Override
    public double calcularPrecioFinal() {
        return price * (1 - discount / 100);
    }

    @Override
    public boolean tieneDescuento() { return discount > 0; }

    @Override
    public String getInfo() {
        return "DigitalProduct{id=" + id + ", name='" + name + "', price=" + price +
                ", discount=" + discount + "%}";
    }
}

class PhysicalProduct extends Product implements Vendible {
    private double shippingCost;

    public PhysicalProduct(String name, double price, double shippingCost) {
        super(name, price);
        if (shippingCost < 0) throw new IllegalArgumentException("El envío no puede ser negativo");
        this.shippingCost = shippingCost;
    }

    @Override
    public double calcularPrecioFinal() {
        return price + shippingCost;
    }

    @Override
    public String getInfo() {
        return "PhysicalProduct{id=" + id + ", name='" + name + "', price=" + price +
                ", shipping=" + shippingCost + "}";
    }
}

// ---------------------- CLIENTE ----------------------
class Customer {
    private final int id;
    private String name;

    private static int nextId = 1;

    public Customer(String name) {
        if (name == null || name.isBlank()) throw new IllegalArgumentException("El cliente debe tener nombre");
        this.id = nextId++;
        this.name = name;
    }

    public int getId() { return id; }
    public String getName() { return name; }

    @Override
    public String toString() {
        return "Customer{id=" + id + ", name='" + name + "'}";
    }
}

// ---------------------- COMPOSICIÓN: PEDIDO ----------------------
class Order {
    private final int id;
    private Customer customer;
    private Map<Product, Integer> products = new LinkedHashMap<>();

    private static int nextId = 1;

    public Order(Customer customer) {
        this.id = nextId++;
        this.customer = customer;
    }

    public void addProduct(Product p, int quantity) {
        products.put(p, products.getOrDefault(p, 0) + quantity);
    }

    public double calcularTotal() {
        double total = 0;
        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            Product p = entry.getKey();
            int qty = entry.getValue();
            if (p instanceof Vendible) {
                total += ((Vendible) p).calcularPrecioFinal() * qty;
            } else {
                total += p.getPrice() * qty;
            }
        }
        return total;
    }

    public void mostrarDetalle() {
        System.out.println("\n=======================================");
        System.out.println(" Pedido #" + id + " - Cliente: " + customer.getName());
        System.out.println("=======================================");
        System.out.printf("%-5s %-20s %-10s %-10s %-10s%n", "ID", "Producto", "Precio", "Cant", "Subtotal");
        System.out.println("---------------------------------------------------------------");

        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            Product p = entry.getKey();
            int qty = entry.getValue();
            double unit = (p instanceof Vendible) ? ((Vendible) p).calcularPrecioFinal() : p.getPrice();
            double subtotal = unit * qty;
            System.out.printf("%-5d %-20s %-10.2f %-10d %-10.2f%n",
                    p.getId(), p.getName(), unit, qty, subtotal);
        }

        System.out.println("---------------------------------------------------------------");
        System.out.printf("%-5s %-20s %-10s %-10s %-10.2f%n", "", "", "", "TOTAL:", calcularTotal());
        System.out.println("=======================================\n");
    }
}

// ---------------------- SISTEMA PRINCIPAL ----------------------
public class StoreSystem {
    private static Scanner sc = new Scanner(System.in);
    private static List<Customer> customers = new ArrayList<>();
    private static List<Product> products = new ArrayList<>();
    private static List<Order> orders = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("=== SISTEMA DE TIENDA INTERACTIVO ===\n");

        boolean running = true;
        while (running) {
            System.out.println("\n--- MENÚ PRINCIPAL ---");
            System.out.println("1. Añadir cliente");
            System.out.println("2. Añadir producto");
            System.out.println("3. Crear pedido");
            System.out.println("4. Ver pedidos");
            System.out.println("5. Salir");
            System.out.print("Seleccione opción: ");

            int option = Integer.parseInt(sc.nextLine());
            switch (option) {
                case 1 -> addCustomer();
                case 2 -> addProduct();
                case 3 -> createOrder();
                case 4 -> viewOrders();
                case 5 -> running = false;
                default -> System.out.println("Opción inválida");
            }
        }

        System.out.println("\n=== FIN DEL SISTEMA ===");
    }

    private static void addCustomer() {
        System.out.print("Ingrese nombre del cliente: ");
        String name = sc.nextLine();
        Customer c = new Customer(name);
        customers.add(c);
        System.out.println("Cliente registrado: " + c);
    }

    private static void addProduct() {
        System.out.println("¿Qué tipo de producto?");
        System.out.println("1. Digital");
        System.out.println("2. Físico");
        int type = Integer.parseInt(sc.nextLine());

        System.out.print("Nombre: ");
        String name = sc.nextLine();
        System.out.print("Precio: ");
        double price = Double.parseDouble(sc.nextLine());

        Product p = null;
        if (type == 1) {
            System.out.print("Descuento (%): ");
            double discount = Double.parseDouble(sc.nextLine());
            p = new DigitalProduct(name, price, discount);
        } else if (type == 2) {
            System.out.print("Costo de envío: ");
            double shipping = Double.parseDouble(sc.nextLine());
            p = new PhysicalProduct(name, price, shipping);
        } else {
            System.out.println("Tipo inválido.");
            return;
        }

        products.add(p);
        System.out.println("Producto añadido: " + p);
    }

    private static void createOrder() {
        if (customers.isEmpty() || products.isEmpty()) {
            System.out.println("Debe haber clientes y productos registrados antes de crear un pedido.");
            return;
        }

        System.out.println("Seleccione cliente:");
        for (Customer c : customers) {
            System.out.println("  " + c.getId() + ". " + c.getName());
        }
        int customerId = Integer.parseInt(sc.nextLine());
        Customer customer = customers.stream().filter(c -> c.getId() == customerId).findFirst().orElse(null);
        if (customer == null) {
            System.out.println("Cliente no encontrado.");
            return;
        }

        Order order = new Order(customer);

        boolean adding = true;
        while (adding) {
            System.out.println("Seleccione producto (ID) o 0 para terminar:");
            for (Product p : products) {
                System.out.println("  " + p.getId() + ". " + p.getName() + " ($" + p.getPrice() + ")");
            }
            int pid = Integer.parseInt(sc.nextLine());
            if (pid == 0) {
                adding = false;
            } else {
                Product p = products.stream().filter(x -> x.getId() == pid).findFirst().orElse(null);
                if (p != null) {
                    System.out.print("Cantidad: ");
                    int qty = Integer.parseInt(sc.nextLine());
                    order.addProduct(p, qty);
                    System.out.println("Añadido " + qty + "x " + p.getName());
                } else {
                    System.out.println("Producto no encontrado.");
                }
            }
        }

        orders.add(order);
        order.mostrarDetalle();
    }

    private static void viewOrders() {
        if (orders.isEmpty()) {
            System.out.println("No hay pedidos.");
            return;
        }
        for (Order o : orders) {
            o.mostrarDetalle();
        }
    }
}
