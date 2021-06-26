import requests
import sys

class Graph(object):
    def __init__(self, server, username, password):
        data={'name': username,
            'password': password,
            'enter': 'Sign in',
            'autologin': '1'}
        login_resp = requests.post('http://%s/index.php' % server, data=data, timeout=1)
        self.sessionid = login_resp.cookies.get('zbx_sessionid') 
        self.server = server
    def get_graph(self, graphid, period, stime, graph_file):
        params = {
                'graphid': str(graphid),
                'period': str(period),
                'stime': str(stime),
                }
        resp = requests.get('http://%s/chart2.php' % self.server, params=params, cookies={'zbx_sessionid': self.sessionid})
#        print resp.url
        with open(graph_file, 'wb') as fp:
            fp.write(resp.content)

if __name__ == '__main__':
    server='192.168.10.91:8027'
    username='Admin'
    password='zabbix'

    g  = Graph(server, username, password)
    g.get_graph('524', '2331563', '20170221012332', 'cpu_load.png')

