from concurrent.futures import ThreadPoolExecutor, as_completed
from urllib import request

'''
concurrent.futures.Executor: abc class 
    submit(fn, *args, **kwargs): return a 'future' object 
    map(fn, *iterables):  
    shutdown

deadlock can occur when the callable associated  with a future
waits on the result of another future
'''

URLS = ['http://www.baidu.com/',
        'http://www.hao123.com/']

def load_url(url, timeout):
    conn = request.urlopen(url, timeout=timeout)
    return conn.readall()

with ThreadPoolExecutor(max_workers=5) as executor:
    future_to_url = {executor.submit(load_url, url, 1): url for 
                    url in URLS}
    for future in  as_completed(future_to_url):
        url = future_to_url[future]
        try:
            data = future.result()
        except:
            print('error')
        else:
            print(url, len(data))

