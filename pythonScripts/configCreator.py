import random

lastrow = 30
filename = "../input/seatConfig"

#[START FILE] Hago 10 iteraciones sobre el proceso de creacion de configuracion
for w in range(0,10):
    f = open(filename + str(w) + ".lsv", "w")
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

# Configuracion por grupos Atras para Adelante
# groups = 4
# group_lengths = []
# extra_rows = lastrow%groups
# base_group_length = lastrow//groups

# while extra_rows > 0:
#     group_lengths.append(base_group_length+1)
#     extra_rows -= 1
# while len(group_lengths)<groups:
#     group_lengths.append(base_group_length)

# acum = 1
# passengers = []
# for j in range(groups):

#     group_j_passengers = []
#     group_j_rows = range(acum, acum + group_lengths[j])

#     for i in group_j_rows:
#         for s in seats:
#             group_j_passengers.append(str(i)+s+'\n')

#     random.shuffle(group_j_passengers)
#     for i in range(len(group_j_passengers)):
#         passengers.append(group_j_passengers[i])

#     acum += group_lengths[j]

# for i in range(len(passengers)):
#     f.write(passengers[i])

#[END FILE]
    f.close()