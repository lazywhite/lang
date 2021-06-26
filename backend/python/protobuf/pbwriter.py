import addressbook_pb2
address_book = addressbook_pb2.AddressBook()
person = address_book.people.add()
person.id = 1234
person.name = "John Doe"
person.email = "jdoe@example.com"
phone = person.phones.add()
phone.number = "555-4321"
phone.type = addressbook_pb2.Person.HOME



with open('demo', 'wb') as f:
    f.write(address_book.SerializeToString())

