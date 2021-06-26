import yaml

def get_config(config_file_path):
    with open(config_file_path,  'r') as stream:
        try:
            cfg = yaml.load(stream)
        except yaml.YAMLError as exc:
            print(exc)
    return cfg
