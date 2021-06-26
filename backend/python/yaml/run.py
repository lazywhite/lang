import yaml
from pprint import pprint

data = {}

with open('et.yml','r+') as f:
    data = yaml.safe_load(f)

pprint(data)
pprint(data.get("foo"))
pprint(data.get("bar"))
pprint(data.get("bar2"))

data['test'] = "vs"

# 注意mode必须是wt, 不能是wb
#with open('et.yml','wt') as f:
#    yaml.dump(data, f)
#    yaml.safe_dump(data, f)
