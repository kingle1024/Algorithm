package ZeroBase.Class;

/**
 * 정수 n이 주어졌을 때 아래의 연산을 통해 1로 만들려고 한다
 * - 2로 나누어 떨어지면 2로 나누기
 * - 3으로 나누어 떨어지면 3으로 나누기
 * - 1 빼기
 * 위의 연산을 통해 1로 만들 때 필요한 최소한의 연산 횟수를 출력하는 프로그램을 작성하세요.
 */
public class Part2_Chapter04_Class12_Practice01 {
    public static int solution(int n){
        int[] dp = new int[11];
        dp[0] = 0;
        dp[1] = 0;
        dp[2] = 1;
        dp[3] = 1;
        if(n < 4) return dp[n];
        // 7 => 6 => 2 => 1
        // 8 => 4 => 2 => 1
        // 9 => 3 => 1
        // 15 =>
        int num = n;

        for(int i= 4; i<= n; i++){
            if(i % 3 == 0){
                dp[i] = 1 + dp[i/3];
            }else if(n % 2 == 0){
                dp[i] = 1 + dp[i/2];
            }else{
                dp[i] = 1 + dp[i-1];
            }
//            System.out.println(i+" " +dp[i] +" ");
        }

        return dp[n];
    }
    public static void main(String[] args) {
        // Test code
        System.out.println(solution(2)); // 1
        System.out.println(solution(4)); // 2
        System.out.println(solution(9)); // 2
        System.out.println(solution(10)); // 3
    }
}
