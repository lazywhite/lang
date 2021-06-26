import argparse

'''
pip install argparse

参数相互排斥
    parser.add_mutually_exclusive_group()

参数list
    action="append"

参数备选list
    choices=[]

参数默认值
    action='store_true'
    default=42

参数类型及自动转换
    type=str

必须
    required=False
'''

parser = argparse.ArgumentParser(description='search some files')

parser.add_argument(dest='filenames', metavar='filename', nargs='*')
parser.add_argument('-p', '--pat', metavar='pattern', required=True, dest='patterns',
                    action='append', help='text pattern to search for')

parser.add_argument('-v', dest='verbose', action='store_true', help='verbose mode')
parser.add_argument('-o','--output', dest='outfile', action='store', help='output file')
parser.add_argument('--speed', dest='speed', action='store', choices={'slow', 'fast'},
                    default='slow', help='search speed')
args = parser.parse_args()

print(args.filenames)
print(args.patterns)
print(args.verbose)
print(type(args.outfile))
print(args.speed)
