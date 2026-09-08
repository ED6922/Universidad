class Empleado:
	def __init__(self, nombre, cargo, sueldo):
		self.nombre = nombre
		self.cargo = cargo
		self.sueldo = sueldo

	def set_nombre(self, nombre):
		self.nombre = nombre

	def set_cargo(self, cargo):
		self.cargo = cargo

	def set_sueldo(self, sueldo):
		self.sueldo = sueldo

	def ver(self):
		return f"Nombre: {self.nombre}\nCargo: {self.cargo}\nSueldo: {self.sueldo}"

	def get_nombre(self):
		return self.nombre

	def get_cargo(self):
		return self.cargo

	def get_sueldo(self):
		return self.sueldo


empleados = []


def agregar_empleado():
	nombre = input("Nombre: ")
	cargo = input("Cargo: ")
	sueldo = float(input("Sueldo: "))
	empleados.append(Empleado(nombre, cargo, sueldo))
	print("Empleado agregado.")


def ver_empleados():
	if len(empleados) == 0:
		print("No hay empleados.")
	else:
		print("\nLista de empleados:")
		for numero, empleado in enumerate(empleados, 1):
			print(f"\nEmpleado {numero}")
			print(empleado.ver())


def editar_empleado():
	ver_empleados()
	if len(empleados) > 0:
		numero = int(input("Número del empleado a editar: "))
		if numero >= 1 and numero <= len(empleados):
			empleado = empleados[numero - 1]
			empleado.set_nombre(input("Nuevo nombre: "))
			empleado.set_cargo(input("Nuevo cargo: "))
			empleado.set_sueldo(float(input("Nuevo sueldo: ")))
			print("Empleado editado.")
		else:
			print("Número no válido.")


def borrar_empleado():
	ver_empleados()
	if len(empleados) > 0:
		numero = int(input("Número del empleado a borrar: "))
		if numero >= 1 and numero <= len(empleados):
			empleados.pop(numero - 1)
			print("Empleado borrado.")
		else:
			print("Número no válido.")


def menu():
	opcion = ""
	while opcion != "5":
		print("\n--- Menú ---")
		print("1. Agregar empleado")
		print("2. Editar empleado")
		print("3. Ver empleados")
		print("4. Borrar empleado")
		print("5. Salir")
		opcion = input("Seleccione una opción: ")

		if opcion == "1":
			agregar_empleado()
		elif opcion == "2":
			editar_empleado()
		elif opcion == "3":
			ver_empleados()
		elif opcion == "4":
			borrar_empleado()
		elif opcion == "5":
			print("Programa terminado.")
		else:
			print("Opción no válida.")


menu()
