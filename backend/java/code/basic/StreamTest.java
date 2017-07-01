package basic;

import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by white on 17/7/1.
 *
 * 1. 流API可以让代码更直观
 * 2. 可以使用多核CPU, 无需开发者自己实现并行
 *
 *  产生Stream
 *      Collection
 *          stream()
 *          parallelStream()
 *
 *  Stream
 *      .forEach(Consumer<T> c): iterate each element of this stream
 *      .map(Function<T, R> func): map each element to its corresponding result
 *      .filter(Predicate p): return a Stream filtered
 *      .limit(Integer n): reduce the number of stream elements to n
 *      .sorted(): sort the stream, so all the element of stream should be known
 *      .collect(Collectors c )
 *      .count(): 总数
 *      .distinct(): 去重
 *      .reduce(BinaryOperator)
 *      .allMatch(Predicate)
 *      .anyMatch(Predicate)
 *      .noneMatch(Predicate)
 *      .skip(n)
 *      .peek()
 *      .max(Comparable)
 *      .min(Comparable)
 *      .toArray()
 *      .findAny()
 *      .findFirst()
 *
 *
 *  Collectors 工具类
 *      toList() --> Collector(接口)
 *      toSet()
 *      toMap()
 *
 */
public class StreamTest {
    public static void main(String[] args) throws FileNotFoundException {
        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
        List<String> filteredList = strings.parallelStream().filter(string -> !string.isEmpty()).collect(Collectors.toList());
        Set<String> filteredSet = strings.parallelStream().filter(string -> !string.isEmpty()).collect(Collectors.toSet());
        Random r = new Random();
        int a = r.ints().limit(10).filter((n)->n>3).map((n) -> (2 * n)).reduce((n1, n2)->(n1 + n2)).getAsInt();
        System.out.println(a);
        r.ints().limit(10).filter((n)->n>3).forEach((n) -> System.out.println(n));

        List<Integer> numbers = Arrays.asList(3, 5, 7, 8, 1, 8, 4);
        numbers.set(3, null);
//        System.out.println(numbers.stream().sorted().limit(3).collect(Collectors.toList()));

        List<Optional<Integer>> alist = numbers.stream().map(n -> Optional.ofNullable(n)).collect(Collectors.toList());
        alist.stream().forEach(n -> System.out.println(n.orElse(0)));
    }

}
