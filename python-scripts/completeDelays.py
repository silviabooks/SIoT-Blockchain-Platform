import pandas as pd
from matplotlib import pyplot as plt

parte1 = pd.read_csv("./attempt3/slowtrxpart1-attempt3.csv", names=['trx', 'time'])
parte2 = pd.read_csv("./attempt3/slowtrxpart2-attempt3.csv", names=['trx', 'time'])
output = []
for index1, (trx1, time1) in parte1.iterrows():
    for index2, (trx2, time2) in parte2.iterrows():
        if trx1 == trx2:
            output.append(time2-time1)

ser = pd.Series(output)
ser.hist(cumulative=True, density=1, bins=100)
plt.show()

# file = open("./attempt2/instantBuyDelays26-9.txt", "r")
# instantBuyDelays = file.readlines()
# instantBuyDelays = [int(x.replace('\n', '')) for x in instantBuyDelays]
#
# ser2 = pd.Series(instantBuyDelays)
# ser2.hist(cumulative=True, density=1, bins=100)
# plt.show()

file = open("./attempt3/standardBuyDelays-attempt3.txt", "r")
standardBuyDelays = file.readlines()
standardBuyDelays = [int(x.replace('\n', '')) for x in standardBuyDelays]

ser = pd.Series(standardBuyDelays)
ser.hist(cumulative=True, density=1, bins=100)
plt.show()
plt.savefig("client-delay.png")
