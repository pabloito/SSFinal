import pandas as pd
import numpy as np
import matplotlib.pyplot as plt


#input
x = [90, 45, 30, 22, 18]
y = []
yerr = []
metricsLoad = []
plotCollection = []

for groupAmount in range(2,12,2):
    resultCollection = []
    metricsLoad.clear()
    for i in range(0,100):
        partialMetricsLoad = pd.read_csv('../Back2FrontGroupsSpecial/'+str(groupAmount)+'/output/'+str(i)+'metrics.csv')
        resultCollection.append(partialMetricsLoad.iloc[partialMetricsLoad['time'].size-1,0])

    y.append(np.mean(np.asarray(resultCollection)))
    yerr.append(np.asarray(resultCollection).std())

fig = plt.figure()
plt.title('Tiempo Total vs Tamaño de Grupo')
plt.xlabel('Tamaño')
plt.ylabel('Tiempo Total')

plt.errorbar(x, y, yerr=yerr, lw=0, ms=3, marker='o', c='b', elinewidth=1, capsize=5)

plt.legend(loc='lower right')
plt.grid(ls='--')
plt.savefig('../graficos/comparisonback2frontgroups')
plt.show()
