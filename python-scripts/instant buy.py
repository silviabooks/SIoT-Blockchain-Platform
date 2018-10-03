import pandas as pd
from matplotlib import pyplot as plt


y_label = 'probability'
x_label = 'time (ms)'

plot_title_3 = 'Cumulative distribution of instant buy delays'

file = open("./attempt2/instantBuyDelays26-9.txt", "r")
instantBuyDelays = file.readlines()
delay_puliti = [int(x.replace('\n', '')) for x in instantBuyDelays]

ser2 = pd.Series(delay_puliti)
ser2.hist(cumulative=True, density=1, bins=100)
plt.xlabel(x_label)
plt.ylabel(y_label)
plt.title(plot_title_3)
plt.show()