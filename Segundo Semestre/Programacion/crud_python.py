usuarios = []


def pedir_datos():
	"""Solicita los datos de un usuario."""
	nombre = input("Nombre: ").strip()
	cargo = input("Cargo: ").strip()
	telefono = input("Teléfono: ").strip()
	return {"nombre": nombre, "cargo": cargo, "telefono": telefono}


def crear_usuario():
	usuarios.append(pedir_datos())
	print("Usuario creado correctamente.")


def listar_usuarios():
	if not usuarios:
		print("No hay usuarios registrados.")
		return

	for indice, usuario in enumerate(usuarios, start=1):
		print(f"\n{indice}. Nombre: {usuario['nombre']}")
		print(f"   Cargo: {usuario['cargo']}")
		print(f"   Teléfono: {usuario['telefono']}")


def seleccionar_usuario():
	listar_usuarios()
	if not usuarios:
		return None

	try:
		indice = int(input("Número de usuario: ")) - 1
		if 0 <= indice < len(usuarios):
			return indice
	except ValueError:
		pass

	print("Selección no válida.")
	return None


def actualizar_usuario():
	indice = seleccionar_usuario()
	if indice is None:
		return

	print("Ingresa los nuevos datos:")
	usuarios[indice] = pedir_datos()
	print("Usuario actualizado correctamente.")


def eliminar_usuario():
	indice = seleccionar_usuario()
	if indice is None:
		return

	usuarios.pop(indice)
	print("Usuario eliminado correctamente.")


def menu():
	while True:
		print("\n--- MENU ---")
		print("1. Crear usuario")
		print("2. Listar usuarios")
		print("3. Actualizar usuario")
		print("4. Eliminar usuario")
		print("5. Salir")

		opcion = input("Selecciona una opción: ").strip()

		if opcion == "1":
			crear_usuario()
		elif opcion == "2":
			listar_usuarios()
		elif opcion == "3":
			actualizar_usuario()
		elif opcion == "4":
			eliminar_usuario()
		elif opcion == "5":
			print("Programa finalizado.")
			break
		else:
			print("Opción no válida.")


if __name__ == "__main__":
	menu()
