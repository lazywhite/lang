import heapq

class PriorityQueue:
    def __init__(self):
        self._queue = []
        self._index = 0

    def push(self, item, priority):
        heapq.heappush(self._queue, (-priority, self._index, item))
        self._index += 1

    def pop(self):
        self._index -= 1
        return heapq.heappop(self._queue)[-1]

class Item:
    def __init__(self, name):
        self.name = name
    def __repr__(self):
        return 'Item: {}'.format(self.name)


q = PriorityQueue()
q.push(Item('foo'), 1)
q.push(Item('bar'), 10)
q.push(Item('spam'), 30)
q.push(Item('grok'), 20)
print(q._queue)
print(q._index)
print(q.pop())
print(q.pop())
print(q.pop())
print(q.pop())
