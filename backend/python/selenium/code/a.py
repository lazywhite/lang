from selenium import webdriver
from selenium.webdriver.chrome.options import Options

'''
unknown error: DevToolsActivePort file doesn't exist
其中
“–no-sandbox”参数是让Chrome在root权限下跑
“–headless”参数是不用打开图形界面
可以额外加这些参数获得更好体验
chrome_options.add_argument('blink-settings=imagesEnabled=false')
chrome_options.add_argument('--disable-gpu')
'''

chrome_options = Options()
chrome_options.add_argument('--no-sandbox')
chrome_options.add_argument('--disable-dev-shm-usage')
chrome_options.add_argument('--headless')
browser = webdriver.Chrome(chrome_options=chrome_options)
browser.get("http://www.baidu.com")
print(browser.page_source)
browser.close()



