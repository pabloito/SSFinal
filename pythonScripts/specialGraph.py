import pandas as pd
import numpy as np
import matplotlib.pyplot as plt
import scipy.stats as stats
import pylab as pl


#input
configs = ["Random", "Back2Front", "Front2Back", "WindowMiddleAisle", "Back2FrontGroups", "Front2BackGroups", "SteffenPerfect", "SteffenModed"]
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
    fit = stats.norm.pdf(collection, np.mean(collection), np.std(collection))
    pl.plot(collection,fit,color[iterationIndex])
    iterationIndex += 1

pl.show()