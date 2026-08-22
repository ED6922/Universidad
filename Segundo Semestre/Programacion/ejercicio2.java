import java.util.ArrayList;
import java.util.Scanner;

public class ejercicio2 {
    public static void main(String[] args) {
        try (Scanner teclado = new Scanner(System.in)) {
            ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
            int siguienteId = 1;
            int opcion = 0;

            while (opcion != 5) {
                System.out.println("        MENU        ");
                System.out.println("1. Crear usuario");
                System.out.println("2. Ver usuarios");
                System.out.println("3. Editar usuario");
                System.out.println("4. Borrar usuario");
                System.out.println("5. Terminar");
                System.out.print("Seleccione una opcion: ");
                opcion = Integer.parseInt(teclado.nextLine());

                switch (opcion) {
                    case 1:
                         System.out.print("Ingrese un nombre: ");
                         String nombre = teclado.nextLine();
                         System.out.print("Ingrese su edad: ");
                         int edad = teclado.nextInt();
                         teclado.nextLine();
                         System.out.print("Ingrese su sueldo: ");
                         float sueldo = teclado.nextFloat();
                         teclado.nextLine();
                         System.out.print("Ingrese su cargo: ");
                         String cargo = teclado.nextLine();
                         usuarios.add(new Usuario(siguienteId, nombre, edad, sueldo, cargo));
                         siguienteId++;
                         System.out.println("Usuario creado.");
                         break;

                    case 2:
                        if (usuarios.size() == 0) {
                            System.out.println("No hay usuarios.");
                        } else {
                            for (Usuario usuario : usuarios) {
                                System.out.println(usuario.id + " - " + usuario.nombre
                                        + " - " + usuario.edad + " años"+ " - Sueldo: " + usuario.sueldo + " - Cargo: " + usuario.cargo);
                            }
                        }
                        break;

                    case 3:
                        System.out.print("Ingrese el ID que desea editar: ");
                        int idEditar = Integer.parseInt(teclado.nextLine());
                        boolean encontrado = false;
                        for (Usuario usuario : usuarios) {
                            if (usuario.id == idEditar) {
                                System.out.print("Ingrese el nuevo nombre: ");
                                usuario.nombre = teclado.nextLine();
                                System.out.print("Ingrese la nueva edad: ");
                                usuario.edad = Integer.parseInt(teclado.nextLine());
                                System.out.print("Ingrese el nuevo sueldo: ");
                                usuario.sueldo = Float.parseFloat(teclado.nextLine());
                                System.out.print("Ingrese el nuevo cargo: ");
                                usuario.cargo = teclado.nextLine();
                                System.out.println("Usuario editado.");
                                encontrado = true;
                            }
                        }
                        if (!encontrado) {
                            System.out.println("Usuario no encontrado.");
                        }
                        break;

                    case 4:
                        System.out.print("Ingrese el ID que desea borrar: ");
                        int idBorrar = Integer.parseInt(teclado.nextLine());
                        encontrado = false;
                        for (int i = 0; i < usuarios.size(); i++) {
                            if (usuarios.get(i).id == idBorrar) {
                                usuarios.remove(i);
                                System.out.println("Usuario borrado.");
                                encontrado = true;
                                break;
                            }
                        }
                        if (!encontrado) {
                            System.out.println("Usuario no encontrado.");
                        }
                        break;

                    case 5:
                        System.out.println("Programa terminado.");
                        break;

                    default:
                        System.out.println("Opcion no valida.");
                }
            }

            teclado.close();
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

  static class Usuario {
    int id;
    String nombre;
    int edad;
    Float sueldo;
    String cargo;

    public Usuario(int id, String nombre, int edad, Float sueldo, String cargo) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.sueldo = sueldo;
        this.cargo = cargo;
    }
}
}


