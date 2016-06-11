$GLOBAL_VARIABLE = 10

## I'm a comment

=begin
    Variable type of ruby
        1. local variable
            1. method local
            2. pesudo-variable: self, true, false, nil, __FILE__, __LINE__
        2. instance variable: @var
        3. class variable @@var
        4. global variable $var

    Tips:
        1. things between single quota can't be translated like '\n', "\n" is right
        2. parallel assignment:   a, b, c = 1, 2, 3
        3. ternary operator: condition ?: 
        4. check if variable is defined: defined? <variable> 
        5. .eq?: test type and value;  .equal?: test object id
        6. <express> <unless> <var>: expression executed when var is false
        7. break, next, redo
=end


print <<EOF
    first line
        second line with precede tab
EOF


BEGIN {
    puts '####This is where program start####'
}
END {
    puts '####This is where program end####'
}

## Datetypes
### Array
arr = ['string', 10, 3.14, [1, 2, 3]]
arr.each do |ele|
    print ele , "\n"
end

### Hash
colors = {
    "red" => 0xf00,
    "green" => 0x0f0,
    "blue" => 0x00f,
}
colors.each do |key, value|
    print key, ' is ', value, "\n"
end
### Range
(10..15).each do |num| #include end position
    print  num, ' '
end
(10...15).each do |num| #disclude end position
    print  num, ' '
end


## Class
class Customer
    @@no_of_customers = 0
    def initialize(id, name, addr)
        @cust_id = id
        @cust_name = name
        @cust_addr = addr
        @@no_of_customers += 1
    end
    def greet
        puts 'global variable: ' + String($GLOBAL_VARIABLE)
        puts "hello, nice to meet you, I'm #{@cust_name}"
    end
end

cust1 = Customer.new(1, 'Bob', 'none')
cust2 = Customer.new(2, 'John', 'none')

cust1.greet
#puts Customer::@@no_of_customers


## Loop
for key, value in colors do
    print key, ':', value , "\n"
end

#while 
