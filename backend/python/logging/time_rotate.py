from logging.handlers import TimedRotatingFileHandler
import logging

log_file = 'test.log'

time_handler = TimedRotatingFileHandler(log_file, when='D', interval=1, backupCount=30)
time_handler.suffix = '%Y-%m-%d'
time_handler.setLevel('DEBUG')

fmt = '%(asctime)s - %(funcName)s - %(lineno)s - %(levelname)s - %(message)s'
formatter = logging.Formatter(fmt)
time_handler.setFormatter(formatter)

logger = logging.getLogger()
logger.setLevel('DEBUG')
logger.addHandler(time_handler)

logger.info("hehe")
