import pandas as pd
import numpy as np
import matplotlib.pyplot as plt


#input
configs = ["Random", "Back2Front", "Front2Back", "WindowMiddleAisle", "Back2FrontGroups", "Front2BackGroups", "SteffenPerfect", "SteffenModed"]
markeveryConfig= [10, 20, 30, 5, 10, 20, 5, 10]
erroreveryConfig= [25, 50, 75, 10, 25, 50, 10, 25]
stepConfig = [50,100,150,10,50,100,20,50]
iterationIndex = 0
for config in configs:
    metricsLoad0 = pd.read_csv('../'+config+'/output/0metrics.csv')
    metricsLoad1 = pd.read_csv('../'+config+'/output/1metrics.csv')
    metricsLoad2 = pd.read_csv('../'+config+'/output/2metrics.csv')
    metricsLoad3 = pd.read_csv('../'+config+'/output/3metrics.csv')
    metricsLoad4 = pd.read_csv('../'+config+'/output/4metrics.csv')
    metricsLoad5 = pd.read_csv('../'+config+'/output/5metrics.csv')
    metricsLoad6 = pd.read_csv('../'+config+'/output/6metrics.csv')
    metricsLoad7 = pd.read_csv('../'+config+'/output/7metrics.csv')
    metricsLoad8 = pd.read_csv('../'+config+'/output/8metrics.csv')
    metricsLoad9 = pd.read_csv('../'+config+'/output/9metrics.csv')

    metricsLoad = [metricsLoad0, metricsLoad1, metricsLoad2, metricsLoad3, metricsLoad4, metricsLoad5, metricsLoad6, metricsLoad7, metricsLoad8, metricsLoad9]

    partialSize = 0
    maxSize = 0
    for data in metricsLoad:
        partialSize = data['time'].size
        if maxSize < partialSize:
            maxSize = partialSize

    x = []
    y = []
    yerr = []

    for i in range(0, maxSize):
        xVals = []
        yVals = []

        for data in metricsLoad:
            if i < data['time'].size:
                xVals.append(data.iloc[i,0])
                yVals.append(data.iloc[i,1])

        x.append(np.mean(np.asarray(xVals)))
        y.append(np.mean(np.asarray(yVals)))
        yerr.append(np.asarray(yVals).std())

    plotEveryX = np.arange(0, int(round(np.max(x))), step=stepConfig[iterationIndex])

    fig = plt.figure()
    plt.title('Sentados vs Tiempo - 10 corridas')
    plt.xlabel('Tiempo [s]')
    plt.ylabel('Sentados')

    #ploteo
    #for j in range(0, 2):
    plt.errorbar(x, y, yerr=yerr, markevery=markeveryConfig[iterationIndex], errorevery=erroreveryConfig[iterationIndex], lw=0.5, ms=0.5, marker='.', c='b', elinewidth=1, capsize=5, label=config)

    plt.legend(loc='lower right')
    plt.xticks(plotEveryX)
    plt.grid(ls='--')
    plt.savefig('../graficos/sentadosVsTiempo' + config)
    plt.show()
    iterationIndex += 1