# coding: utf-8
import ipdb
from sqlalchemy import create_engine
from sqlalchemy.ext.declarative import declarative_base
from sqlalchemy import Column, Integer,String

#ipdb.set_trace()
engine = create_engine('sqlite:///:memory:', echo=True)
Base = declarative_base()

class User(Base):
    __tablename__ = 'users'
    id  = Column(Integer, primary_key=True)
    name = Column(String)
    fullname = Column(String)
    password = Column(String)
    def __repr__(self):
        return '<User(name={0.name}, fullname={0.fullname}, password={0.password}>'.format(self)
    
print(User.__table__)
#ipdb.set_trace()
Base.metadata.create_all(engine)
ed_user = User(name='ed', fullname='ed Jones', password='edpasswd')
an_user = User()
an_user.name = 'hehe'
from sqlalchemy.orm import sessionmaker
Session=sessionmaker()
Session.configure(bind=engine)
session=Session()
# insert 
session.add(ed_user)
session.add(an_user)
print(session.dirty)
print(session.new)
session.commit()
print('##########')
# update
our_user = session.query(User).filter_by(name='hehe').first()
our_user.password = 'new_pass'
print(session.dirty)
session.commit()

# rolling back
ed_user = session.query(User.id).filter_by(name='ed').first()
print(ed_user)
#ed_user.name = 'hello'
#edit_user = session.query(User).filter_by(name='ed').first()
#print(edit_user)
#session.rollback()
#print(session.query(User).filter_by(name='ed').first().id)
