import glob


dir_name = "/root/script"

files = glob.glob("%s/*.sh" % dir_name)
print(files)
