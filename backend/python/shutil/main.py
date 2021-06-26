from shutil import make_archive
name = os.path.expanduser(os.path.join('~', 'myarch'))
root_dir = os.path.expanduser(os.path.join('~','.ssh'))
make_archive(name, 'gztar', root_dir)

