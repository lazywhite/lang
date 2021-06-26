import signal
import resource
import os

def time_exceeded(signal, frame):
    print('Time\'s up')
    raise SystemExit(1)

def set_max_runtime(seconds):
    soft, hard = resource.getrlimit(resource.RLIMIT_CPU)
    print(soft, hard)
    resource.setrlimit(resource.RLIMIT_CPU, (seconds, hard))
    signal.signal(signal.SIGXCPU, time_exceeded)

def limit_memory(maxsize):
    soft, hard = resource.getrlimit(resource.RLIMIT_AS)
    print(soft,hard)
    resource.setrlimit(resource.RLIMIT_AS, (maxsize, hard))


set_max_runtime(1)
limit_memory(0)
while True:
    pass
