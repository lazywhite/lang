from pyzabbix import ZabbixAPI
import sys

class ZAPI(object):
    zapi = None
    def __init__(self, server, username, password):
        self.zapi = ZabbixAPI(server="http://%s/" % server)
        self.zapi.login(username, password)

    def get_host_id_by_name(self, hostName):
        host = self.zapi.host.get(output='extend', filter={'name':hostName})
        if len(host) != 1:
            print 'Found more than 1 host by host name, exiting'
            sys.exit(10)
        else:
            return host[0]['hostid']

    def get_graph_id(self, hostid, graphName):
        graph = self.zapi.graph.get(output='extend', hostids=hostid,
                                    filter={'name':graphName})
        if len(graph) != 1:
            print 'Found more than 1 graph by graph name, exiting'
            sys.exit(10)
        else:
            return graph[0]['graphid']
        

if __name__ == '__main__':
    zp = ZAPI("http://%s/" % server, "Admin", "zabbix")
    host_id = zp.get_host_id_by_name("Zabbix server")
    graph_id = zp.get_graph_id(host_id, "CPU load")
    print graph_id
     

