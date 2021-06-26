import jpype

jar_path = "/path/to/jar"
arg = "-Djava.class.path=%s" % jar_path

jvm_path = jpype.getDefaultJVMPath()

# 无法在同一个py里面执行多次
jpype.startJVM(jvm_path, arg)

jpype.JPackage("pkg").TestClass.TestMethod("arg1")
