from dataclasses import dataclass
from datetime import datetime

@dataclass
class User:
    name: str
    age: int
    birthday: datetime = None
    def __post_init__(self):
        if type(self.birthday ) == str:
            self.birthday = datetime.strptime(self.birthday, '%Y-%m-%d')

u = User(name="bob", age=10, birthday='2017-01-01')
print(u.birthday, type(u.birthday))
