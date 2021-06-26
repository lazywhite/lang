import unittest
def average(values):
    """Computes the arithmetic mean of a list of numbers.

    >>> print average([20, 30, 70])
    40.0
    """
    return sum(values, 0.0) / len(values)

class TestStatisticalFunctions(unittest.TestCase):

    def test_average(self):
        self.assertEqual(average([20, 30, 70]), 40.0)
        self.assertEqual(round(average([1, 5, 7]), 1), 4.3)
        with self.assertRaises(ZeroDivisionError):
            average([])
        with self.assertRaises(TypeError):
            average(20, 30, 70)

## 执行方式
## 1. python /path/to/test.py
if __name__ == '__main__':
    unittest.main() # Calling from the command line invokes all tests
  # 或者 python -m unittest /path/to/test.py


## 2. 指定某个测试模块
#python -m unittest test.test_mod.TestApi

## 3. 指定某个测试函数
#python -m unittest test.test_mod.TestApi.test_create_all
