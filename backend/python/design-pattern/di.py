'''
    Dependency injection
'''
############### Original design ################
#class MySQLDAL(object):
#    def add(self, username):
#        print 'write user to database using mysql'
#        return 


#class SQLiteDAL(object):
#    def add(self, username):
#        print 'write user to database using sqlite'
#        return 


#class User(object):
#    dal = None

#    def __init__(self, username=None, dbType=None):
#        if dbType == 'mysql':
#            self.dal = MySQLDAL()
#        if dbType == 'sqlite':
#            self.dal = SQLiteDAL()
#        self.username = username

#    def add(self):
#        print 'add user %s' % self.username
#        self.dal.add(self.username)


#if __name__ == '__main__':
#    u = User('bob', 'sqlite')
#    u.add()

############### Using DI ################

from abc import ABCMeta, abstractmethod

class DAL:
    __metaclass__ = ABCMeta

    @abstractmethod
    def add(self, username):
        pass


class MySQLDAL(DAL):
    def add(self, username):
        print 'write user to database using mysql'
        return 


class SQLiteDAL(DAL):
    def add(self, username):
        print 'write user to database using sqlite'
        return 


class User(object):
    dal = None
    def __init__(self, username=None, dal=None):
        self.username = username
    
    @classmethod
    def add_dal(self, dal):
        self.dal = dal

    def add(self):
        print 'add user %s' % self.username
        if not self.dal:
            print 'dal not initialized'
        self.dal.add(self.username)

if __name__ == '__main__':
    dal = MySQLDAL()
    User.add_dal(dal)
    u = User('bob')
    u.add()

