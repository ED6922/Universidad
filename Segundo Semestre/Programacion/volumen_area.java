import java.util.Scanner; // Importa la clase para leer datos del teclado.

public class volumen_area { // Declara la clase principal del programa.
	private static final Scanner entrada = new Scanner(System.in); // Crea el lector de entrada estándar.

	public static void main(String[] args) { // Define el punto de inicio de la ejecución.
		int opcion; // Almacena la opción elegida por el usuario.

		do { // Repite el menú principal hasta seleccionar salir.
			mostrarMenuPrincipal(); // Muestra las opciones principales.
			opcion = leerEntero("Seleccione una opción: "); // Lee la opción elegida.

			switch (opcion) { // Ejecuta una acción según la opción.
				case 1 -> menuAreas(); // Abre el menú de áreas.
				case 2 -> menuVolumenes(); // Abre el menú de volúmenes.
				case 3 -> System.out.println("\n¡Gracias por utilizar el programa!"); // Muestra el mensaje de salida.
				default -> System.out.println("\nOpción no válida. Intente nuevamente."); // Informa una opción incorrecta.
			}
		} while (opcion != 3); // Continúa mientras no se elija la opción 3.

		entrada.close(); // Cierra el lector de entrada.
	}

	private static void mostrarMenuPrincipal() { // Declara el método del menú principal.
		System.out.println("\n╔══════════════════════════════════════╗"); // Imprime el borde superior.
		System.out.println("║       ÁREAS Y VOLÚMENES              ║"); // Imprime el título.
		System.out.println("╠══════════════════════════════════════╣"); // Imprime el separador.
		System.out.println("║  1. Calcular un área                 ║"); // Muestra la opción de áreas.
		System.out.println("║  2. Calcular un volumen              ║"); // Muestra la opción de volúmenes.
		System.out.println("║  3. Salir                            ║"); // Muestra la opción de salida.
		System.out.println("╚══════════════════════════════════════╝"); // Imprime el borde inferior.
	}

	private static void menuAreas() { // Declara el método para calcular áreas.
		System.out.println("\n────── CÁLCULO DE ÁREAS ──────"); // Muestra el título del menú.
		System.out.println("1. Cuadrado"); // Muestra la opción cuadrado.
		System.out.println("2. Triángulo"); // Muestra la opción triángulo.
		System.out.println("3. Círculo"); // Muestra la opción círculo.
		System.out.println("4. Hexágono"); // Muestra la opción hexágono.
		int opcion = leerEntero("Seleccione una figura: "); // Lee la figura elegida.
		double resultado; // Declara la variable para el área calculada.

		switch (opcion) { // Selecciona la fórmula correspondiente.
			case 1 -> {
				double lado = leerPositivo("Lado: "); // Lee el lado del cuadrado.
				resultado = lado * lado; // Calcula el área del cuadrado.
				mostrarResultado("Área del cuadrado", resultado); // Muestra el resultado.
			}
			case 2 -> {
				double base = leerPositivo("Base: "); // Lee la base.
				double altura = leerPositivo("Altura: "); // Lee la altura.
				resultado = base * altura / 2; // Calcula el área triangular.
				mostrarResultado("Área del triángulo", resultado); // Muestra el resultado.
			}
			case 3 -> {
				double radio = leerPositivo("Radio: "); // Lee el radio.
				resultado = Math.PI * radio * radio; // Calcula el área circular.
				mostrarResultado("Área del círculo", resultado); // Muestra el resultado.
			}
			case 4 -> {
				double lado = leerPositivo("Lado: "); // Lee el lado del hexágono.
				resultado = (3 * Math.sqrt(3) / 2) * lado * lado; // Calcula el área hexagonal.
				mostrarResultado("Área del hexágono", resultado); // Muestra el resultado.
			}
			default -> System.out.println("Opción no válida."); // Informa una opción incorrecta.
		}
	}

	private static void menuVolumenes() { // Declara el método para calcular volúmenes.
		System.out.println("\n────── CÁLCULO DE VOLÚMENES ──────");
		System.out.println("1. Cubo");
		System.out.println("2. Cilindro");
		System.out.println("3. Esfera");
		int opcion = leerEntero("Seleccione un sólido: "); // Lee el sólido elegido.
		double resultado; // Declara la variable para el volumen calculado.

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

	private static int leerEntero(String mensaje) { // Declara un método para leer enteros.
		System.out.print(mensaje); // Solicita el dato al usuario.
		while (!entrada.hasNextInt()) { // Valida que la entrada sea entera.
			System.out.print("Ingrese un número entero válido: "); // Solicita una entrada válida.
			entrada.next(); // Descarta el dato incorrecto.
		}
		return entrada.nextInt(); // Devuelve el entero leído.
	}

	private static double leerPositivo(String mensaje) { // Declara un método para leer positivos.
		double valor; // Almacena el valor introducido.
		do { // Repite la lectura hasta obtener un valor positivo.
			System.out.print(mensaje); // Solicita el valor.
			while (!entrada.hasNextDouble()) { // Valida que la entrada sea decimal.
				System.out.print("Ingrese un número válido: "); // Solicita una entrada válida.
				entrada.next(); // Descarta el dato incorrecto.
			}
			valor = entrada.nextDouble(); // Lee el número introducido.
			if (valor <= 0) { // Comprueba que sea mayor que cero.
				System.out.println("El valor debe ser mayor que cero."); // Informa del error.
			}
		} while (valor <= 0); // Repite si el valor no es positivo.
		return valor; // Devuelve el valor validado.
	}

	private static void mostrarResultado(String figura, double resultado) { // Declara el método para mostrar resultados.
		System.out.printf("\n✓ %s: %.2f unidades%n", figura, resultado); // Imprime el resultado con dos decimales.
	}
}
