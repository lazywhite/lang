# bytes are a sequence of number between 0-255
# string are a sequence  of characters 
# they are connected by encoding 


# ord('A') = 65
# chr(65) = 'A'
from string import Template

t = Template('$who has $mount$$')
print(t.substitute(who='jerry', mount=100))
# =====================================================
# format specification mini-language
replacement_field ::=  "{" [field_name] ["!" conversion] [":" format_spec] "}"
field_name        ::=  arg_name ("." attribute_name | "[" element_index "]")*
arg_name          ::=  [identifier | integer]
attribute_name    ::=  identifier
element_index     ::=  integer | index_string
index_string      ::=  <any source character except "]"> +
conversion        ::=  "r" | "s" | "a"
format_spec       ::=  <described in the next section>

## Three conversion flags are currently supported: '!s' which calls str() on the value, '!r' which calls repr() and '!a' which calls ascii().


format_spec ::=  [[fill]align][sign][#][0][width][,][.precision][type]
fill        ::=  <any character>
align       ::=  "<" | ">" | "=" | "^"
sign        ::=  "+" | "-" | " "
width       ::=  integer
precision   ::=  integer
type        ::=  "b" | "c" | "d" | "e" | "E" | "f" | "F" | "g" | "G" | "n" | "o" | "s" | "x" | "X" | "%"

