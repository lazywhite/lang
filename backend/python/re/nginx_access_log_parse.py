import re
import pprint

conf = '$remote_addr - $remote_user [$time_local] "$request" $status $body_bytes_sent "$http_referer" "$http_user_agent"'
regex = ''.join(
    '(?P<' + g + '>.*?)' if g else re.escape(c)
    for g, c in re.findall(r'\$(\w+)|(.)', conf))

print regex
log = '112.3.194.120 - - [17/Jan/2015:20:07:34 +0800] "GET /Introdction%20to%20Guitar/1%20-%202%20-%20Choosing%20the%20Right%20Guitar-%20Right-Handed%20vs%20Left-Handed%20(3-20).mp4 HTTP/1.1" 206 546849 "http://example.com/video/302/" "Mozilla/5.0 (Windows NT 5.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/31.0.1650.63 Safari/537.36"'

m = re.match(regex, log)

pprint.pprint(m.groupdict())
