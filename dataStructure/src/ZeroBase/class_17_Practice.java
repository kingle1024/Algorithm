// Practice
// 하기 예제를 스트림으로 구현해보세요.

import java.util.stream.IntStream;

public class class_17_Practice {
    public static void main(String[] args) {
        // 예제: 1~10 숫자 중 짝수 들의 합
        IntStream intStream = IntStream.range(1, 11).filter(n -> n %2 == 0);
//        intStream.forEach(n -> System.out.print(n +" "));
        int sum = intStream.sum();
        System.out.println(sum);

    }
}
