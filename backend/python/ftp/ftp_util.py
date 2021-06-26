from __future__ import print_function
from ftplib import FTP, error_perm

class MyFTP(object):

    def __init__(self, host, port, username, password):
        try:
            ftp = FTP()
            ftp.connect(host, int(port))
            ftp.login(username, password)
            self.ftp = ftp
            self.host = host
            self.port = port
            self.user = username
            self.password = password
        except Exception as e:
            print(e)
            self.ftp = None

    def downloadfile(self, remotepath, localpath):
        fp = open(localpath, 'wb')
        self.ftp.set_debuglevel(0)
        self.ftp.retrbinary('RETR'+remotepath, fp.write)

        fp.close()

    def uploadfile(self, remotepath, localpath):
        fp = open(localpath, 'rb')
        self.ftp.set_debuglevel(0)
        self.ftp.storbinary('STOR '+remotepath, fp)
        fp.close()

    def makedir(self, path):
        '''
        path must be absolute path
        eg: path = /a/b/c/d/e
        '''
        if path:
            tmp = path.split("/")

            for i in range(2, len(tmp) + 1):
                p = "/".join(tmp[0:i])
                try:
                    self.ftp.mkd(p)
                except error_perm as e:
                    if '550' in str(e):
                        continue
                    else:
                        break
                    
        else:
            print("empty path provided")

    def close(self):
        self.ftp.close()


    def __str__(self):
        return 'FTP: %s@%s:%s' % (str(self.user), str(self.host), str(self.port))
