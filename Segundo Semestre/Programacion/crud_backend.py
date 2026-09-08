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


def agregar_empleado(nombre, cargo, sueldo):
	empleado = Empleado(nombre, cargo, float(sueldo))
	empleados.append(empleado)
	return empleado


def ver_empleados():
	return empleados.copy()


def editar_empleado(numero, nombre, cargo, sueldo):
	if numero < 1 or numero > len(empleados):
		return False
	empleado = empleados[numero - 1]
	empleado.set_nombre(nombre)
	empleado.set_cargo(cargo)
	empleado.set_sueldo(float(sueldo))
	return True


def borrar_empleado(numero):
	if numero < 1 or numero > len(empleados):
		return False
	empleados.pop(numero - 1)
	return True


