import addressbook_pb2

address_book = addressbook_pb2.AddressBook()

print dir(address_book)
with open('demo', 'rb') as f:
    address_book.ParseFromString(f.read())

print address_book

