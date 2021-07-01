from setuptools import setup
setup(
    name="helloworld",
    version="1.0",
    long_description="a long long description",
    url="www.baidu.com",
    author="jsx",
    author_email="jsx@test.com",
    packages=[
        'helloworld',
        ],
    scripts=[
        'bin/serve',
        'bin/helloworld',
        ],
    install_requires=[
        'Flask==1.0',
        ],
    package_data={'':['templates/*']},
    include_package_data=True,

    )
