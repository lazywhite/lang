import logging
import os
from threading import Thread


pypath = os.path.dirname(os.path.abspath(__file__))

def get_logger(name):
    log_file = os.path.join(pypath, "log/%s.log" % name)

    formatter = logging.Formatter('%(asctime)s - %(name)s - %(levelname)s - %(message)s')
    f_handler = logging.FileHandler(log_file,mode='a')
    #s_handler = logging.StreamHandler()

    f_handler.setFormatter(formatter)
    #s_handler.setFormatter(formatter)

    level = logging.DEBUG 
    logger = logging.getLogger(name)
    logger.setLevel(level)
    logger.addHandler(f_handler)
    #logger.addHandler(s_handler)

    return logger


def run(name):
    logger = get_logger(name) 
    logger.warning('warning from thread_%s' % name)

for i in range(1, 10):
    thread = Thread(target=run, args=("thread_%d" %(i),))
    thread.start()
    thread.join()


print('main thread')
