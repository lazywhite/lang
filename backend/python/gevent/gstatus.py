import gevent

def win():
    return 'you win'

def lose():
    raise Exception('you failed')

winner = gevent.spawn(win)
loser = gevent.spawn(lose)

print(winner.ready())
print(loser.ready())

print(winner.started)
print(loser.started)

try:
    gevent.joinall([winner, loser])

except:
    print("this will never be reached")


print(winner.value)
print(loser.value)


print(winner.successful())
print(loser.successful())

print(loser.exception)
