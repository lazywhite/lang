import getpass
import sys

if sys.stdin.isatty():
    p = getpass.getpass('Using getpass, Input password: ')
else:
    print 'Using readline, Input password: '
    p = sys.stdin.readline().rstrip()
    # echo 'pass' | python getpass_t.py
