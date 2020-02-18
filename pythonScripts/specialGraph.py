import pandas as pd
import numpy as np
import matplotlib.pyplot as plt
import scipy.stats as stats
import pylab as pl


#input
configs = ["Random", "SteffenModed", "Back2FrontGroups", "Front2BackGroups", "Back2Front", "Front2Back", "SteffenPerfect", "WindowMiddleAisle"]
metricsLoad = []
plotCollection = []

for config in configs:
    resultCollection = []
    metricsLoad.clear()
    for i in range(0,100):
        partialMetricsLoad = pd.read_csv('../'+config+'/output/'+str(i)+'metrics.csv')
        resultCollection.append(partialMetricsLoad.iloc[partialMetricsLoad['time'].size-1,0])

    plotCollection.append(sorted(resultCollection))

color = ['-.r', '-.g', '-.b', '-.c', '-.m', '-.y', '-.k','-.m']
#plot
iterationIndex = 0
for collection in plotCollection:
    if iterationIndex == 4 or iterationIndex == 6:
        pl.legend()
        pl.savefig('../graficos/iteration'+str(iterationIndex))
        pl.show() 
    fit = stats.norm.pdf(collection, np.mean(collection), np.std(collection))
    pl.plot(collection,fit,color[iterationIndex], label=configs[iterationIndex])
    iterationIndex += 1

pl.legend()
pl.savefig('../graficos/iteration'+str(iterationIndex))
pl.show()

iterationIndex = 0
for collection in plotCollection:
    fit = stats.norm.pdf(collection, np.mean(collection), np.std(collection))
    pl.plot(collection,fit,color[iterationIndex], label=configs[iterationIndex])
    iterationIndex += 1
pl.legend()
pl.savefig('../graficos/general')
pl.show() 