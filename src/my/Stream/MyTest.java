package my.Stream;

import java.util.stream.Stream;

public class MyTest {
    public static void main(String[] args) {
        Stream<Integer> stream3 = Stream.of(1, 2, 3);
        stream3.filter(i -> i == 2).forEach(num ->System.out.println(num));
    }
}
