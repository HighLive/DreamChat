import json
import pandas as pd


with open("../Crawler-Twitch/temp.json", encoding='UTF-8') as jFile:
    data = json.load(jFile)

    # get time(sec) from chatting data
    freq = [0]*int(data[len(data)-1]['time']+1)
    print(len(data))
    for n in data:
        time = int(data[n]['time'])
        freq[time] += 1
        

    