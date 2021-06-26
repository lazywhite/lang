class Demo:
    def __init__(self, age):
        self._age = age

    @staticmethod
    def greet():
        print("hello")

    @classmethod
    def class_name(cls):
        print("Demo")

    @property
    def age(self):  # 不能有其它参数, 不能跟已有的属性名重复
        return self._age

    @age.setter
    def age(self, value):  # setter函数名与property重名
        if value > 100 or value < 0:
            raise ValueError("should between 0, 100")
        self._age = value


d = Demo(10)

d.greet()
d.class_name()

d.age = 3
print(d.age)
