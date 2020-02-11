import random

lastrow = 30
filename = "../seatConfig.lsv"

f = open(filename, "w")
seats = ['A','B','C','E','F','G']


# Configuracion de Prueba 'Atras para adelante'
# for i in range(1,lastrow+1):
#     for s in seats:
#         f.write(str(i)+s+'\n')

# Configuracion de Prueba 'Adelante para atras'
# for i in reversed(range(1,lastrow+1)):
#     for s in seats:
#         f.write(str(i)+s+'\n')

# Configuracion de Prueba 'Columna A despues B despues C ....'
# for s in seats:
#   for i in range(1,lastrow+1):
#         f.write(str(i)+s+'\n')


# Configuracion de Prueba 'Random'
orderedArray = []
for i in range(1,lastrow+1):
    for s in seats:
        orderedArray.append((str(i)+s+'\n'))

random.shuffle(orderedArray)

for i in range(len(orderedArray)):
    f.write(orderedArray[i])

f.close()