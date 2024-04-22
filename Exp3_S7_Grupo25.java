
package exp3_s7_grupo25;

import java.util.ArrayList;
import java.util.Scanner;

public class Exp3_S7_Grupo25 {

    private static String nombreTeatro = "Teatro Moro";
    private static int capacidadSala = 100;
    private static int entradasDisponibles = capacidadSala;
    private static double precioBaseVIP = 5000;
    private static double precioBasePlatea = 4000;
    private static double precioBaseBalcon = 3000;
    private static double totalIngresos = 0;
    private static ArrayList<String> ventas = new ArrayList<>();
    
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            System.out.println("=== " + nombreTeatro + " ===");
            System.out.println("1. Venta de entradas");
            System.out.println("2. Visualizar resumen de ventas");
            System.out.println("3. Generar boleta");
            System.out.println("4. Calcular ingresos totales");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    ventaEntradas(scanner);
                    break;
                case 2:
                    visualizarResumenVentas();
                    break;
                case 3:
                    generarBoleta();
                    break;
                case 4:
                    calcularIngresosTotales();
                    break;
                case 5:
                    continuar = false;
                    System.out.println("Gracias por su compra.");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione nuevamente.");
                    break;
            }
        }
    }

    public static void ventaEntradas(Scanner scanner) {
        System.out.println("=== Venta de Entradas ===");
        System.out.print("Seleccione la ubicación (VIP, Platea, Balcón): ");
        String ubicacion = scanner.next();
        double precioBase = 0;

        switch (ubicacion.toLowerCase()) {
            case "vip":
                precioBase = precioBaseVIP;
                break;
            case "platea":
                precioBase = precioBasePlatea;
                break;
            case "balcón":
                precioBase = precioBaseBalcon;
                break;
            default:
                System.out.println("Ubicación no válida.");
                return;
        }

        System.out.print("¿Es estudiante? (Sí / No): ");
        String esEstudiante = scanner.next();
        double descuento = 0;

        if (esEstudiante.equalsIgnoreCase("sí")) {
            descuento = 0.1; // Descuento del 10% para estudiantes
        } else {
            System.out.print("¿Es de la tercera edad? (Sí / No): ");
            String esTerceraEdad = scanner.next();
            if (esTerceraEdad.equalsIgnoreCase("sí")) {
                descuento = 0.15; // Descuento del 15% para personas de la tercera edad
            }
        }

        double precioFinal = precioBase - (precioBase * descuento);
        double descuentoPorcentaje = descuento * 100;

        if (entradasDisponibles > 0) {
            System.out.println("Ubicación: " + ubicacion);
            System.out.println("Costo Base: $" + precioBase);
            System.out.println("Descuento Aplicado: " + (int)(descuentoPorcentaje) + "%");
            System.out.println("Costo Final: $" + precioFinal);
            System.out.println("¡Entrada vendida! Disfrute del espectáculo en la ubicación: " + ubicacion);
            totalIngresos += precioFinal;
            entradasDisponibles--;
            ventas.add("Ubicación: " + ubicacion + ", Costo Base: $" + precioBase + ", Descuento Aplicado: " + (int)(descuentoPorcentaje) + "%, Costo Final: $" + precioFinal);
        } else {
            System.out.println("Lo sentimos, no hay entradas disponibles.");
        }
    }

    public static void visualizarResumenVentas() {
        System.out.println("=== Resumen de Ventas ===");
        for (String venta : ventas) {
            System.out.println(venta);
        }
    }

    public static void generarBoleta() {
        System.out.println("=== Boleta ===");
        System.out.println("---------------------------------------");
        System.out.println("              " + nombreTeatro);
        System.out.println("---------------------------------------");
        for (String venta : ventas) {
            System.out.println(venta);
        }
        System.out.println("---------------------------------------");
        System.out.println("Gracias por su visita al " + nombreTeatro);
        System.out.println("---------------------------------------");
    }

    public static void calcularIngresosTotales() {
        System.out.println("=== Ingresos Totales ===");
        System.out.println("Total Ingresos: $" + totalIngresos);
    }
}