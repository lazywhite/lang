import csv
from collections import namedtuple 

with open('stock.csv') as f:
    f_csv = csv.reader(f)
    headers = next(f_csv)
    print(headers)
    Row = namedtuple('Row', headers)
    result = []
    a = []
    while True:
        line = next(f_csv,None)
        if line is None :
            break
        elif line == []:
            continue
        else:
            result.append(Row(*line))
    print(result)

