nombres = []

for i in range(10):
	nombre = input(f"Escribe el nombre {i + 1}: ")
	nombres.append(nombre)

nombres_iniciales = nombres.copy()
	
for i in range(len(nombres)):
	posicion_menor = i
	for j in range(i + 1, len(nombres)):
		if nombres[j].lower() < nombres[posicion_menor].lower():
			posicion_menor = j
	nombres[i], nombres[posicion_menor] = nombres[posicion_menor], nombres[i]

listas_nombres = {
	"como empezo": nombres_iniciales,
	"como termino": nombres
}

print("\nNombres ordenados:")
for nombre in nombres:
	print(nombre)

print("\nDiccionario con las listas:")
print(listas_nombres)
