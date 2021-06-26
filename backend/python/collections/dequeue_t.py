from collections import deque

def search(lines, pattern, history=5):
    previous_line = deque(maxlen=history)
    for line in lines:
        if pattern in line:
            previous_line.append(line)
    return previous_line 

if __name__ == '__main__':
    with open('weakref_t.py','rt') as f:
        for line in search(f, 'weak', 5):
            print(line, end='')
