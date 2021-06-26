import logging

def main():
   logging.basicConfig(
           filename = 'app.log',
           filemode="a", # default is 'a'
           level = logging.ERROR,
           format = '%(levelname)s:%(asctime)s:%(message)s')
   logger = logging.getLogger()
   hostname = 'www.python.org'
   item = 'spam'
   filename = 'data.csv'
   mode = 'r'

   logger.critical('host %s unknow', hostname)
   logger.error('couldn\'t find %r', item)
   logger.warning('feature is deprecated')
   logger.info('opening file %r, mode=%r', filename, mode)
   logger.debug('got here')


   '''
   记录错误栈至日志
   try:
       1/0
   except:
       logger.exception("error") # 必须传入一个参数
   '''

if __name__ == '__main__':
   main()
