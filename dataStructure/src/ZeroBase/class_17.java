import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/*
    스트림(Stream)
    v 배열, 컬렉션 등의 데이터를 하나씩 참조하여 처리 가능한 기능
    v for문의 사용을 줄여 코드를 간결하게 함
    v 스트림은 크게 3가지로 구성
        - Stream 생성
        - 중개 연산
        - 최종 연산
    v 데이터소스객체.Stream생성().중개연산().최종연산();

    v 배열 스트림
        String[] arr = new String[]{"a", "b", "C"};
        Stream stream = Arrays.stream(arr);
    v 컬렉션 스트림
        ArrayList list = new ArrayList(Arrays.asList(1,2,3));
        Stream stream = list.stream();

    스트림 중개연산
    v Filtering
        - filter 내부 조건에 참인 요소들을 추출
        IntStream intStream = IntStream.range(1, 10).filter(n -> n%2 == 0);
    v Mapping
        - map 안의 연산을 요소별로 수행
        IntStream intStream = IntStream.rage(1, 10).map(n -> n+1);

    스트림 최종연산
    v Sum, Average
    IntStream.range(1, 5).sum()
    IntStream.range(1, 5).average().getAsDouble()

    v min, max
    IntStream.range(1, 5).min().getAsInt();
    IntStream.range(1, 5).max().getAsInt();
 */
public class class_17 {
    public static void main(String[] args) {
        // 1. 스트림 생성
        // 1-1. 배열 스트림
        System.out.println("== 배열 스트림 == ");
        String arr[] = new String[]{"a", "b", "c"};

        System.out.println("== fori ==");
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

        System.out.println("== forEach ==");
        for (String item: arr){
            System.out.println(item);
        }

        System.out.println("== to Stream ==");
        Stream stream1 = Arrays.stream(arr);
        stream1.forEach(System.out::println);

        // 1-2. 컬렉션 스트림
        System.out.println("== 컬렉션 스트림 ==");
        ArrayList list1 = new ArrayList(Arrays.asList(1, 2, 3));
        System.out.println(list1);

        Stream stream2 = list1.stream();
//        stream2.forEach(System.out::println);
        stream2.forEach(num -> System.out.println("num = " + num));

        // 1-3. 스트림 builder
        System.out.println("== 스트림 builder ==");
        Stream streamBuilder = Stream.builder().add(1).add(2).add(3).build();
//        streamBuilder.forEach(System.out::println);
        streamBuilder.forEach(num -> System.out.println("num = " + num));

        // 1-4. 스트림 generate
        System.out.println("== 스트림 generate ==");
        Stream streamGenerate = Stream.generate( () -> "abc" ).limit(3);
        streamGenerate.forEach(System.out::println);

        // 1-5. 스트림 iterate
        System.out.println("== 스트림 iterate ==");
        Stream streamIterate = Stream.iterate(10, n -> n * 2).limit(3);
        streamIterate.forEach(System.out::println);

        // 1-6. 기본 타입 스트림
        System.out.println("== 기본타입 스트림 ==");
        IntStream intStream = IntStream.range(1, 5);
        intStream.forEach(System.out::println);

        // 2. 스트림 중개 연산
        // 2-1. Filtering
        System.out.println("== Filtering ==");
        IntStream intStream2 = IntStream.range(1, 10).filter(n -> n % 2 == 0);
        intStream2.forEach(System.out::println);

        // 2-2. Mapping
        System.out.println("== Mapping ==");
        IntStream intStream3 = IntStream.range(1, 10).map(n -> n+1);
        intStream3.forEach(n -> System.out.print(n + " "));
        System.out.println();

        // 2-3. Sorting
        System.out.println("== Sorting ==");
        IntStream intStream4 = IntStream.builder().add(5).add(1).add(3).add(4).add(2).build();
        IntStream intStreamSort = intStream4.sorted();
        intStreamSort.forEach(System.out::println);

        // 3. 최종 연산
        // 3-1. Sum, Average
        System.out.println("== sum, average ==");
        int sum = IntStream.range(1, 5).sum();
        double average = IntStream.range(1, 5).average().getAsDouble();

        // 3-2. Min, Max
        System.out.println("== min, max ==");
        int min = IntStream.range(1, 5).min().getAsInt();
        System.out.println("min = " + min);
        int max = IntStream.range(1, 5).max().getAsInt();
        System.out.println("max = " + max);

        // 3-3. reduce
        System.out.println("== reduce ==");
        Stream<Integer> stream3 = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4,5)).stream();
        System.out.println(stream3.reduce((x, y) -> x+y).get());

        // 3-4. forEach
        System.out.println("== forEach ==");
        IntStream.range(1, 10).filter(n -> n == 5).forEach(System.out::println);

    }
}
