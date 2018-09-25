import pandas as pd

parte1 = pd.read_csv("parte1.csv", names=['trx', 'time'])
parte2 = pd.read_csv("parte2.csv", names=['trx', 'time'])
output = []
for index1, (trx1, time1) in parte1.iterrows():
    for index2, (trx2, time2) in parte2.iterrows():
        if trx1 == trx2:
            output.append(time2-time1)


def convert_millis(millis):
    seconds = (millis / 1000) % 60
    minutes = (millis / (1000*60)) % 60
    hours = (millis / (1000*60*60)) % 24
    return int(seconds), int(minutes), int(hours)


