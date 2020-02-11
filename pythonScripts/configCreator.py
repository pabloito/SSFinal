lastrow = 30
filename = "../seatConfig.lsv"

f = open(filename, "w")
seats = ['A','B','C','E','F','G']
for i in range(1,lastrow+1):
    for s in seats:
        f.write(str(i)+s+'\n')
f.close()