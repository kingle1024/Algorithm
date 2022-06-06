package ZeroBase.Class;

public class Part2_Chapter1_Class06 {
    public static void main(String[] args) {
        // 점화식 -> 반복문, 재귀함수
        System.out.println("== 점화식/재귀함수 연습1 ==");
        // 1, 3, 9, 27, ... 의 n번째 수
        int n = 4;
        int result = 1;
        for (int i = 0; i < n; i++) {
            if (i == 0){
                result = 1;
            }else {
                result *= 3;
            }
        }

        // 1, 2, 3, 4, 5, 6, ...의 n번째 까지의 합
        n = 5;
        result = 0;
        for (int i = 1; i < n; i++) {
            result += i;
        }
        System.out.println("result = " + result);

        System.out.println(recursion2(n));

        // 1, 1, 2, 3, 5, 8, 13, ...의 n번 째 수

        System.out.println(recursion3(6));
    }
    static int recursion1(int n){
        if(n == 1) return 1;
        return recursion1(n-1) * 3;
    }
    static int recursion2(int n){
        if(n == 1) return 1;
        return recursion2(n-1) + n;
    }
    static int recursion3(int n){
        if(n==0) return 1;
        else if(n==1) return 1;
        else if(n==2) return 2;
        return recursion3(n-2) + recursion3(n-1);
    }
}
