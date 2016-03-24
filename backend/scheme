programs are data;data are self-evaluating programs;program are called "form" in scheme
symbol is not self-evaluated ,it return the value it holds;

; comment
(exit)

sequence：(begin (display "hello") (newline))
(set！ a 10) 重新赋值


Data Type
1.simple datatypes(self evaluating) :
    boolean(#t,#f) 
    number(integer real complex rational)(prefix:#b #o #d #x)
    characters:(prefix #\)
    symbols(define a 'xy) 
    variable (define x 10)
2.compund datatypes:
    string(sequence of characters)(define a "hello world") 用双引号括起来就是字符串
    vector(sequnce of anything,may contain a vector) (define a '#(1 2 3 4)) \\#(3 2 4)
    dotted pairs:(define a '(1 . #t)) (car a) (cdr a) (set-car! a 2)
    list:(define a '(1 2 3 4 . ()))  This special kind of nested dotted pair is called a list.  (list-ref a 1) (list-tail a 3)
4.other datatypes:
    procedure: cons
    port: A port is the conduit through which input and output is performed. Ports are usually associated with files and consoles.(display "Hello, World!" (current-output-port))
5.conversions between different datatypes(char integer string list number symbol) 

Conditionals
    (if test-expression then-branch else-branch )
    when and unless are convenient conditionals to use when only one branch (the “then” or the “else” branch) of the basic conditional is needed.
    when’s branch is an implicit begin, whereas if requires an explicit begin if either of its branches has more than one form.
    The cond is thus a multi-branch conditional. Each clause has a test and an associated action. The first test that succeeds triggers its associated action. The final else clause is chosen if no other test succeeded.
    The cond actions are implicit begins.
    (cond ((char<? c #\c) -1)
      ((char=? c #\c) 0)
      (else 1))
    A special case of the cond can be compressed into a case expression. This is when every test is a membership test.
    (case c
    ((#\a) 1)
    ((#\b) 2)
    ((#\c) 3)
    (else 4))
    The special form and returns a true value if all its subforms are true. The actual value returned is the value of the final subform. If any of the subforms are false, and returns #f.
    The special form or returns the value of its first true subform. If all the subforms are false, or returns #f.
    Both and and or evaluate their subforms left-to-right. As soon as the result can be determined, and and or will ignore the remaining subforms.
    


We will use the more general term form instead of program, so that we can deal with program fragments too.

Some procedures can be called at different times with different numbers of arguments. To do this, the lambda parameter list is replaced by a single symbol. This symbol acts as a variable that is bound to the list of the arguments that the procedure is called on.


Recursion

字符串的方法 string-ref string-append (make-string 3) (string-set! a 1 #\a) 
Vectors are sequences like strings, but their elements can be anything, not just characters

I/O
    read read-char read-line 
    write display write-char
    (current-output-port)(current-input-port)
    (open-input-file)(open-output-file)(close-input-file)(close-output-file)
    (call-with-input-file)(call-with-output-file)
    (open-input-string)(open-output-string)(get-output-string)
Loading files
    (load "file-path")(load-relative "path")
Macro
Structure
Alist and Table
System interface
Object and Class
Jumps
Amb
Engine
CGI-script
":"; exec csi -r $0 "$@"
