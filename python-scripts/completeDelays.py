import pandas as pd
from matplotlib import pyplot as plt

y_label = 'probability'
x_label = 'time (ms)'

# parte1 = pd.read_csv("./attempt3/slowtrxpart1-attempt3.csv", names=['trx', 'time'])
# parte2 = pd.read_csv("./attempt3/slowtrxpart2-attempt3.csv", names=['trx', 'time'])

parte1 = pd.read_csv("slowtrxpart1-26-9.csv", names=['trx', 'time'])
parte2 = pd.read_csv("slowtrxpart2-26-9.csv", names=['trx', 'time'])

output = []
for index1, (trx1, time1) in parte1.iterrows():
    for index2, (trx2, time2) in parte2.iterrows():
        if trx1 == trx2:
            output.append(time2-time1)
# PLOT FOR END2END DELAY
ser = pd.Series(output)
ser.max()
ser.hist(cumulative=True, density=1, bins=100, color='grey')
plt.xlabel('time')
plt.ylabel(y_label)
plt.xticks([200000.,  400000.,  600000.,  800000., 1000000., ser.max()],
           ('3 min', '6 min', '10 min', '13 min', '16 min', '20 min'))

plt.show()


file = open("./attempt2/instantBuyDelays26-9.txt", "r")
instantBuyDelays = file.readlines()
delay_puliti = [int(x.replace('\n', '')) for x in instantBuyDelays]

ser2 = pd.Series(delay_puliti)
ser2.hist(cumulative=True, density=1, bins=100, color='grey')
plt.xlabel(x_label)
plt.ylabel(y_label)
plt.show()

file = open("./attempt3/standardBuyDelays-attempt3.txt", "r")
standardBuyDelays = file.readlines()
standardBuyDelays = [int(x.replace('\n', '')) for x in standardBuyDelays]

ser = pd.Series(standardBuyDelays)
ser.hist(cumulative=True, density=1, bins=100, color='grey')
plt.xlabel(x_label)
plt.ylabel(y_label)
plt.show()
#plt.savefig(plot_title_2 + ".png")
