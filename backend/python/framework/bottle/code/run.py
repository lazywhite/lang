from test import app
import sys
import os

if __name__ == '__main__':
#    sys.path.insert(0, os.path.dirname(os.path.abspath(__file__)))
    app.run(host='localhost', port=8080, reloader=True)
