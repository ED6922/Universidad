nombres = []

for i in range(10):
	nombre = input(f"Escribe el nombre {i + 1}: ")
	nombres.append(nombre)
	
for i in range(len(nombres)):
	posicion_menor = i
	for j in range(i + 1, len(nombres)):
		if nombres[j].lower() < nombres[posicion_menor].lower():
			posicion_menor = j
	nombres[i], nombres[posicion_menor] = nombres[posicion_menor], nombres[i]

print("\nNombres ordenados:")
for nombre in nombres:
	print(nombre)
