[doc for restructtext](https://docs.python.org/devguide/documenting.html)  
[official doc](http://www.sphinx-doc.org/en/stable/rest.html)
## info
1. directive must be seperated by blank line
## install
```
pip install sphinx
rehash
sphinx-quickstart
```

## specify theme
```
pip install sphinx_rtd_theme
import sphinx_rtd_theme
html_theme = 'sphinx_rtd_theme'
html_theme_path = [sphinx_rtd_theme.get_html_theme_path()]
```
## markdown support
```
pip install recommonmark

conf.py
    source_parsers = {
       '.md': 'recommonmark.parser.CommonMarkParser',
       }
    source_suffix = ['.rst', '.md']
```
