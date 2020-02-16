import random

lastrow = 30
#CONFIGS
configs = ["Random", "Back2Front", "Front2Back", "WindowMiddleAisle", "BigGroups"]
notImplementedConfigs = ["MidGroups", "SmallGroups", "SteffenPerfect", "SteffenModed"]

#Generic functions
def printSeats(f, row):
    for i in range(1,lastrow+1):
        f.write(str(i)+row+'\n')

#CONFIG FUNCTIONS
# Configuracion de Prueba 'Random'
def randomConfig(f):
    orderedArray = []
    for i in range(1,lastrow+1):
        for s in seats:
            orderedArray.append((str(i)+s+'\n'))
    random.shuffle(orderedArray)
    for i in range(len(orderedArray)):
        f.write(orderedArray[i])

# Configuracion de Prueba 'Atras para adelante'
def back2FrontConfig(f):
    for i in range(1,lastrow+1):
        for s in seats:
            f.write(str(i)+s+'\n')

# Configuracion de Prueba 'Adelante para atras'
def front2BackConfig(f):
    for i in reversed(range(1,lastrow+1)):
        for s in seats:
            f.write(str(i)+s+'\n')

# Configuracion de Prueba 'Ventana medio pasillo'
def windowMiddleAisleConfig(f):
    for order in range(int(len(seats)/2)):
        printSeats(f, seats[order])
        printSeats(f, seats[len(seats)-order-1])

# Configuracion por grupos Atras para Adelante
def groupsConfig(f):
    groups = 4
    group_lengths = []
    extra_rows = lastrow%groups
    base_group_length = lastrow//groups

    while extra_rows > 0:
        group_lengths.append(base_group_length+1)
        extra_rows -= 1
    while len(group_lengths)<groups:
        group_lengths.append(base_group_length)

    acum = 1
    passengers = []
    for j in range(groups):

        group_j_passengers = []
        group_j_rows = range(acum, acum + group_lengths[j])

        for i in group_j_rows:
            for s in seats:
                group_j_passengers.append(str(i)+s+'\n')

        random.shuffle(group_j_passengers)
        for i in range(len(group_j_passengers)):
            passengers.append(group_j_passengers[i])

        acum += group_lengths[j]

    for i in range(len(passengers)):
        f.write(passengers[i])

# Configuracion por grupos Adelante para Atras
def front2BackGroupsConfig(f):
    groups = 4
    group_lengths = []
    extra_rows = lastrow%groups
    base_group_length = lastrow//groups

    while extra_rows > 0:
        group_lengths.append(base_group_length+1)
        extra_rows -= 1
    while len(group_lengths)<groups:
        group_lengths.append(base_group_length)

    acum = 1
    passengers = []
    for j in range(groups):

        group_j_passengers = []
        group_j_rows = range(acum, acum + group_lengths[j])

        for i in group_j_rows:
            for s in seats:
                group_j_passengers.append(str(i)+s+'\n')

        random.shuffle(group_j_passengers)
        for i in range(len(group_j_passengers)):
            passengers.append(group_j_passengers[i])

        acum += group_lengths[j]

    for i in reversed(range(len(passengers))):
        f.write(passengers[i])

#FILE BUILDER
configsFunctions = [randomConfig, back2FrontConfig, front2BackConfig, windowMiddleAisleConfig, groupsConfig]
iterationIndex = 0
for folder in configs:
    filename = "../" + folder + "/input/seatConfig"
    arrangeMentFunction = configsFunctions[iterationIndex]
    #[START FILE] Hago 10 iteraciones sobre el proceso de creacion de configuracion
    for w in range(0,10):
        f = open(filename + str(w) + ".lsv", "w")
        seats = ['A','B','C','E','F','G']
        arrangeMentFunction(f)
        #[END FILE]
        f.close()
    iterationIndex += 1 