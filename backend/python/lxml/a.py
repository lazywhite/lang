from lxml import etree

with open('example.xml','rw') as file:
    doc = etree.parse(file)
    root = doc.getroot()
    link3 = etree.Element('link')
    link3.text = 'haha'
    a = {'key':'value'}
    link3.attrib.update(a)
    root.append(link3)
    doc.write('back.xml')
