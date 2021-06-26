import csv


tb = [
    ["a", 100, "test"],
    ["b", 200, None],
    ["c", None, "test"],
]


with open("a.csv", "w") as f:
    writer = csv.writer(f)
    for r in tb:
        writer.writerow(r)
