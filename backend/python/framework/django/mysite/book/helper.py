def handle_uploaded_file(f):
    with open('/srv/salt/files/scripts/name.txt', 'wb+') as destination:
        for chunk in f.chunks():
            destination.write(chunk)

def file_iterator(filename, chunk_size=512):
    with open(filename, 'rb') as f:
        while True:
            c = f.read(chunk_size)
            if c:
                yield c
            else:
                break

def commit_callback():
    print "transaction commit callback"
