import java.util.Scanner;

public class volumen_area {
	private static final Scanner entrada = new Scanner(System.in);

	public static void main(String[] args) {
		int opcion;

		do {
			mostrarMenuPrincipal();
			opcion = leerEntero("Seleccione una opción: ");

			switch (opcion) {
				case 1 -> menuAreas();
				case 2 -> menuVolumenes();
				case 3 -> System.out.println("\n¡Gracias por utilizar el programa!");
				default -> System.out.println("\nOpción no válida. Intente nuevamente.");
			}
		} while (opcion != 3);

		entrada.close();
	}

	private static void mostrarMenuPrincipal() {
		System.out.println("\n╔══════════════════════════════════════╗");
		System.out.println("║       ÁREAS Y VOLÚMENES              ║");
		System.out.println("╠══════════════════════════════════════╣");
		System.out.println("║  1. Calcular un área                 ║");
		System.out.println("║  2. Calcular un volumen              ║");
		System.out.println("║  3. Salir                            ║");
		System.out.println("╚══════════════════════════════════════╝");
	}

	private static void menuAreas() {
		System.out.println("\n────── CÁLCULO DE ÁREAS ──────");
		System.out.println("1. Cuadrado");
		System.out.println("2. Triángulo");
		System.out.println("3. Círculo");
		System.out.println("4. Hexágono");
		int opcion = leerEntero("Seleccione una figura: ");
		double resultado;

		switch (opcion) {
			case 1 -> {
				double lado = leerPositivo("Lado: ");
				resultado = lado * lado;
				mostrarResultado("Área del cuadrado", resultado);
			}
			case 2 -> {
				double base = leerPositivo("Base: ");
				double altura = leerPositivo("Altura: ");
				resultado = base * altura / 2;
				mostrarResultado("Área del triángulo", resultado);
			}
			case 3 -> {
				double radio = leerPositivo("Radio: ");
				resultado = Math.PI * radio * radio;
				mostrarResultado("Área del círculo", resultado);
			}
			case 4 -> {
				double lado = leerPositivo("Lado: ");
				resultado = (3 * Math.sqrt(3) / 2) * lado * lado;
				mostrarResultado("Área del hexágono", resultado);
			}
			default -> System.out.println("Opción no válida.");
		}
	}

	private static void menuVolumenes() {
		System.out.println("\n────── CÁLCULO DE VOLÚMENES ──────");
		System.out.println("1. Cubo");
		System.out.println("2. Cilindro");
		System.out.println("3. Esfera");
		int opcion = leerEntero("Seleccione un sólido: ");
		double resultado;

		switch (opcion) {
			case 1 -> {
				double lado = leerPositivo("Lado: ");
				resultado = lado * lado * lado;
				mostrarResultado("Volumen del cubo", resultado);
			}
			case 2 -> {
				double radio = leerPositivo("Radio: ");
				double altura = leerPositivo("Altura: ");
				resultado = Math.PI * radio * radio * altura;
				mostrarResultado("Volumen del cilindro", resultado);
			}
			case 3 -> {
				double radio = leerPositivo("Radio: ");
				resultado = (4.0 / 3) * Math.PI * radio * radio * radio;
				mostrarResultado("Volumen de la esfera", resultado);
			}
			default -> System.out.println("Opción no válida.");
		}
	}

	private static int leerEntero(String mensaje) {
		System.out.print(mensaje);
		while (!entrada.hasNextInt()) {
			System.out.print("Ingrese un número entero válido: ");
			entrada.next();
		}
		return entrada.nextInt();
	}

	private static double leerPositivo(String mensaje) {
		double valor;
		do {
			System.out.print(mensaje);
			while (!entrada.hasNextDouble()) {
				System.out.print("Ingrese un número válido: ");
				entrada.next();
			}
			valor = entrada.nextDouble();
			if (valor <= 0) {
				System.out.println("El valor debe ser mayor que cero.");
			}
		} while (valor <= 0);
		return valor;
	}

	private static void mostrarResultado(String figura, double resultado) {
		System.out.printf("\n✓ %s: %.2f unidades%n", figura, resultado);
	}
}
