import numpy as np
import re
artist_pattern = r"(?P<id>[^\s]*)\s+(?P<name>.*)"
user_artist_pattern = r"(?P<user_id>[^\s]*)\s+(?P<artist_id>[^\s]*)\s+(?P<num>[^\s]*)"

#ARTIST_DATA = 'artist_data.txt'
#USER_ARTIST_DATA = 'user_artist_data.txt'
'''
每个文件截取前1W行
'''
ARTIST_DATA = 'art_data.txt'
USER_ARTIST_DATA = 'user_art_data.txt'
def load_artist_data():
    pattern = re.compile(artist_pattern)    
    data = []
    with open(ARTIST_DATA) as f:
        for line in f.readlines():
            rt = pattern.match(line).groupdict()
            id = rt.get("id")
            name = rt.get("name")
            data.append([str(id), str(name)])

    return np.asarray(data)
        
def load_user_artist_data():
    pattern = re.compile(user_artist_pattern)
    data = []
    with open(USER_ARTIST_DATA) as f:
        for line in f.readlines():
            rt = pattern.match(line).groupdict()
            user_id = rt.get("user_id")
            artist_id = rt.get("artist_id")
            num = rt.get("num")
            data.append([str(user_id), str(artist_id), num])
    return np.asarray(data)

def get_artist_name(artist_id, artist_array):
    for row in artist_array:
        if str(row[0]) == str(artist_id):
            print(row)
            return row[1]


def printListenerTimePlayed(user_id):
    artist_array = load_artist_data()
    user_artist_array = load_user_artist_data()

    for row in user_artist_array:
        if str(row[0]) == str(user_id):
            print("%s - %d" % (get_artist_name(row[1], artist_array), int(row[2])))

printListenerTimePlayed(1000002 )

