#!/usr/local/bin/ruby
puts "hello world"
puts Math.sqrt(9)

## get input
# gets

## Function
def greet(name="world")
    puts "function hello #{name.capitalize}"
end

greet('bob')

## Class
class Greeter
    def initialize(name = "world")
        @name = name
    end
    def say_hi
        puts "Hi #{@name}!"
    end
end

g = Greeter.new("Pat")
g.say_hi


## Attribute access
puts Greeter.instance_methods(false)

puts g.respond_to?("name")
puts g.respond_to?("to_s")


## Change class
class Greeter
    attr_accessor :name
end

puts "name before #{g.name}"
g.name = "bob"
puts "name after #{g.name}"
puts $0
