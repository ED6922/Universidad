// Importa ArrayList para gestionar colecciones dinámicas
import java.util.ArrayList;
// Importa Scanner para leer entrada del usuario
import java.util.Scanner;

// Clase principal para gestionar empleados
public class datos_usuario {
	// Scanner estático final para leer entrada del usuario
	private static final Scanner entrada = new Scanner(System.in);
	// ArrayList estático final para almacenar lista de empleados
	private static final ArrayList<Empleado> empleados = new ArrayList<>();

	// Método principal que ejecuta el programa
	public static void main(String[] args) {
		// Variable para almacenar la opción del menú
		int opcion;
		// Bucle do-while que repite hasta que el usuario seleccione salir
		do {
			// Imprime línea superior del menú
			System.out.println("\n╔══════════════════════════════════════╗");
			// Imprime título del menú
			System.out.println("║       GESTIÓN DE EMPLEADOS           ║");
			// Imprime separador del menú
			System.out.println("╠══════════════════════════════════════╣");
			// Imprime opción 1 del menú
			System.out.println("║ 1. Agregar empleado                  ║");
			// Imprime opción 2 del menú
			System.out.println("║ 2. Ver empleados                     ║");
			// Imprime opción 3 del menú
			System.out.println("║ 3. Actualizar empleados              ║");
			// Imprime opción 4 del menú
			System.out.println("║ 4. Eliminar empleados                ║");
			// Imprime opción 5 del menú
			System.out.println("║ 5. Salir                             ║");
			// Imprime línea inferior del menú
			System.out.println("╚══════════════════════════════════════╝");
			// Lee la opción ingresada por el usuario
			opcion = leerEntero("Opción: ");
			// Switch que ejecuta la acción según la opción elegida
			switch (opcion) {
				// Si opción es 1, llama al método agregar
				case 1 -> agregar();
				// Si opción es 2, llama al método listar
				case 2 -> ver();
				// Si opción es 3, llama al método actualizar
				case 3 -> actualizar();
				// Si opción es 4, llama al método eliminar
				case 4 -> eliminar();
				// Si opción es 5, imprime mensaje de finalización
				case 5 -> System.out.println("Programa finalizado.");
				// Si opción no es válida, imprime mensaje de error
				default -> System.out.println("Opción inválida.");
			}
		// Repite el bucle mientras opción sea distinta de 5
		} while (opcion != 5);
	}

	// Método privado estático para agregar un nuevo empleado
	private static void agregar() {
		String respuesta;
		do {
			// Verifica si se alcanzó el límite máximo de 100 empleados
			if (empleados.size() == 100) {
				System.out.println("Límite alcanzado.");
				return;
			}
			// Lee los datos del nuevo empleado
			String nombre = leerTexto("Nombre: ");
			String cargo = leerTexto("Cargo: ");
			double sueldo = leerDouble("Sueldo: ");
			String telefono = leerTexto("Teléfono: ");
			empleados.add(new Empleado(nombre, cargo, sueldo, telefono));
			System.out.println("Empleado agregado.");

			// Pregunta si se desea agregar otro empleado antes de volver al menú
			respuesta = leerTexto("¿Desea agregar otro empleado? (si/no): ");
		} while (respuesta.equalsIgnoreCase("si"));
	}

	// Método privado estático para listar todos los empleados
	private static void ver() {
		// Verifica si la lista de empleados está vacía
		if (empleados.isEmpty()) { 
			// Imprime mensaje si no hay empleados
			System.out.println("No hay empleados."); 
			// Sale del método si no hay empleados
			return; 
		}
		// Bucle for que itera sobre cada empleado en la lista
		for (int i = 0; i < empleados.size(); i++)
			// Imprime el número y datos de cada empleado
			System.out.println((i + 1) + ". " + empleados.get(i));
	}

	// Método privado estático para actualizar un empleado existente
	private static void actualizar() {
		// Llama al método ver para mostrar todos los empleados
		ver();
		// Verifica si la lista está vacía
		if (empleados.isEmpty()) 
			// Sale del método si no hay empleados
			return;

		// Lee el número del empleado a actualizar y resta 1 para obtener índice
		int indice = leerEntero("Número a actualizar: ") - 1;
		// Verifica si el índice es válido
		if (indice < 0 || indice >= empleados.size()) {
			// Imprime mensaje de índice inválido
			System.out.println("Número inválido.");
			// Sale del método si el índice es inválido
			return;
		}

		// Obtiene el empleado a actualizar
		Empleado empleado = empleados.get(indice);
		// Lee y actualiza el nombre del empleado
		empleado.nombre = leerTexto("Nuevo nombre: ");
		// Lee y actualiza el cargo del empleado
		empleado.cargo = leerTexto("Nuevo cargo: ");
		// Lee y actualiza el sueldo del empleado
		empleado.sueldo = leerDouble("Nuevo sueldo: ");
		// Lee y actualiza el teléfono del empleado
		empleado.telefono = leerTexto("Nuevo teléfono: ");
		// Imprime mensaje de confirmación
		System.out.println("Empleado actualizado.");
	}

	// Método privado estático para eliminar un empleado
	private static void eliminar() {
		// Llama al método ver para mostrar todos los empleados
		ver();
		// Verifica si la lista no está vacía
		if (!empleados.isEmpty()) {
			// Lee el número del empleado a eliminar y resta 1 para obtener índice
			int indice = leerEntero("Número a eliminar: ") - 1;
			// Verifica si el índice es válido
			if (indice >= 0 && indice < empleados.size()) 
				// Elimina el empleado en el índice especificado
				empleados.remove(indice);
			// Si el índice no es válido
			else 
				// Imprime mensaje de índice inválido
				System.out.println("Número inválido.");
		}
	}

	// Método privado estático para leer texto del usuario
	private static String leerTexto(String mensaje) {
		// Imprime el mensaje
		System.out.print(mensaje); 
		// Lee y retorna la línea ingresada por el usuario
		return entrada.nextLine();
	}
	
	// Método privado estático para leer un número entero del usuario
	private static int leerEntero(String mensaje) {
		// Intenta convertir el texto ingresado a entero
		try { 
			// Retorna el valor entero parseado
			return Integer.parseInt(leerTexto(mensaje)); 
		}
		// Si hay error en la conversión
		catch (NumberFormatException e) { 
			// Retorna -1 como valor por defecto
			return -1; 
		}
	}
	
	// Método privado estático para leer un número decimal del usuario
	private static double leerDouble(String mensaje) {
		// Intenta convertir el texto ingresado a double
		try { 
			// Retorna el valor double 
			return Double.parseDouble(leerTexto(mensaje)); 
		}
		// Si hay error en la conversión
		catch (NumberFormatException e) { 
			// Retorna 0 como valor por defecto
			return 0; 
		}
	}

	// Clase privada estática que representa un empleado
	private static class Empleado {
		// Variable de instancia para almacenar el nombre
		String nombre, 
		// Variable de instancia para almacenar el cargo
		cargo, 
		// Variable de instancia para almacenar el teléfono
		telefono;
		// Variable de instancia para almacenar el sueldo
		double sueldo;

		// Constructor que inicializa un empleado con sus datos
		Empleado(String nombre, String cargo, double sueldo, String telefono) {
			// Asigna el nombre recibido como parámetro
			this.nombre = nombre;
			// Asigna el cargo recibido como parámetro
			this.cargo = cargo;
			// Asigna el sueldo recibido como parámetro
			this.sueldo = sueldo;
			// Asigna el teléfono recibido como parámetro
			this.telefono = telefono;
		}

		// Método que sobrescribe toString para mostrar los datos del empleado
		@Override
		public String toString() {
			// Retorna una cadena formateada con los datos del empleado
			return nombre + " | Cargo: " + cargo + " | Sueldo: " + sueldo
					+ " | Teléfono: " + telefono;
		}
	}

}
