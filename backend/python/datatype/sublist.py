#!/usr/bin/python


class folder(list):
    def __init__(self, name):
        self.name = name 
    def dir(self):
        print "I'm the %s folder" % self.name
        for element in self:
            print element


a = folder('haha')
a.append('one')
a.append('two')
a.dir()
