package basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.*;
/**
 * Created by white on 17/7/1.
 */

/*
    Predicate<T>:  接受一个T类型参数, 返回boolean结果
    Supplier<T>: 不接受参数, 返回一个T类型的结果
    Consumer<T>: 接受一个T类型参数, 不返回任何结果
    DoubleConsumer = Consumer<Double>
    UnaryOperator<T>: 接受一个T类型参数, 返回一个T类型结果
    BinaryOperator<T>: 接受两个T类型参数, 返回一个T类型参数
    Function<T, R>: 接受一个T类型参数, 返回一个R类型参数

 */
@FunctionalInterface
interface Function3 <A, B, C, R>{
    public R apply(A a, B b, C c);
}

public class FunctionalTest {
    public static void main(String[] args){
        //1. Predicate 泛型接口
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        Predicate<Integer> largerThanThree = (n) -> n > 3;
        Predicate<Integer> lessThanFive = (n) -> n < 5;
        Predicate<Integer> lessThanTen = (n) -> n < 10;
        Predicate<Integer> lessThanOne = (n) -> n < 1;
        Predicate<Integer> filter = largerThanThree.and(lessThanFive).or(lessThanTen).and(lessThanOne.negate());//negate()取反, add() 与, or() 或
        if(filter.test(4)){
            System.out.println("test passed");
        }else{
            System.out.println("test not passed");
        }
//        eval(list, largerThanThree);
        eval(list, (n) -> n < 3);
        //2. Supplier 泛型接口
        Supplier<String> supplier = ()->"supplier default";
        System.out.println(supplier.get());

        // 3. Consumer 接口
        Consumer<String> consumer = (String str) -> System.out.println(str);
        consumer.accept("accepted by consumer");

        // 4. Function 接口
        Function<Integer, String> func = (n) -> ("this is: " +  n);
        System.out.println(func.apply(10));

        // 5. UnaryOperator
        UnaryOperator<Integer> doubleInt = (n) -> (2*n);
        System.out.println("UnaryOperator test: " + doubleInt.apply(10));;

        // 6. BinaryOperator
        BinaryOperator<Integer> multi = (Integer n1, Integer n2) -> (n1 * n2);
        System.out.println("BinaryOperator test: " + multi.apply(10, 20));

        Optional<String> a = Optional.ofNullable(null);
        System.out.println(a.orElseGet(supplier));

        // 7. 自定义接受多个参数的function
        Function3<Integer, Integer, Integer, Integer>  f = (o, p, q) -> {
            System.out.printf("%d %d %d\n", o, p, q);
            return o + p + q;
        };

        System.out.println(f.apply(1, 2, 3));
    }

    public static void eval(List<Integer> list, Predicate<Integer> predicate){
        for(Integer i: list){
            if(predicate.test(i)){
                System.out.println(i);
            }
        }
    }
}
