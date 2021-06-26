from bs4 import BeautifulSoup as bs
from bs4 import Comment
html_doc = """
<html><head><title>The Dormouse's story</title></head>
<body>
<p class="title"><b>The Dormouse's story</b></p>

<p class="story">Once upon a time there were three little sisters; and their names were
<a href="http://example.com/elsie" class="sister" id="link1">Elsie</a>,
<a href="http://example.com/lacie" class="sister" id="link2">Lacie</a> and
<a href="http://example.com/tillie" class="sister" id="link3">Tillie</a>;
and they lived at the bottom of a well.</p>

<p class="story">...</p>
"""
soup = bs(html_doc)
p = soup.find_all('p')[0]

story_p = soup.findAll('p', {"class":"story"}) # find by attr
### soup.find('div', attrs={'class':'hive'})
#print(p.name)
#print(p.attrs['class'])
#p.contents.append('foo')
#print(p.contents)
#s = soup.new_string('hello', Comment)
#p.contents.append(s)
#p.attrs['id']='foo'
#print(p)
#tag = soup.new_tag('img', src='static/a.jpg')
#p.b.append(tag)
#p.b.img.contents.append('adkfj') #
#print(p.find_next()) # find next tag 
#print(p.find_next_sibling())
#print(p.find_next_siblings())
print(p.find_parent().name)
#print(soup.text)
#print(soup)
