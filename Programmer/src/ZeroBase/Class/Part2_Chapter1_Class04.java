package ZeroBase.Class;// 기초 수학 - 순열
import java.util.stream.IntStream;
public class Part2_Chapter1_Class04 {
    public static void main(String[] args) {
        // 1. 팩토리얼
        System.out.println("== 팩토리얼 ==");
//        5!
        int n = 5;
        int result = 1;
        result = factorial(5);
        System.out.println("result = " + result);

        // 2. 순열
        System.out.println("== 순열 ==");
        // 5명을 3줄로 세우는 경우의 수 (5P3)
        n = 5;
        int r = 3;
        result = 1;
        System.out.println(factorial(n) / factorial((n-r)));


        // 3. 중복 순열
        System.out.println("== 중복 순열 ==");
        // 서로 다른 4개의 수 중 2개를 뽑는 경우의 수 (중복 허용)
        n = 4;
        r = 2;
        result = 1;
        System.out.println((int)Math.pow(n,r));

        // 4. 원 순열
        System.out.println("== 원 순열 ==");
        // 원 모양의 테이블에 3명을 앉히는 경우의 수
        System.out.println(factorial(3-1));
    }
    public static int factorial(int n){
        int result = 1;
        for(int i=1; i<=n; i++){
            result *= i;
        }
        return result;
    }
}
