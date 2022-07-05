package ZeroBase.Class;

public class Part2_Chapter04_Class12 {
    public static int fib(int n){
        if(n == 1) return 1;
        else if(n ==2) return 1;
        else if(n == 3) return 2;

        return fib(n-2) + fib(n-1);
    }
    //  타블레이션
    public static int fibDP(int n){
        int[] dp = new int[n < 2 ? 2 : n+1];
        dp[0] = 0;
        dp[1] = 1;
        for(int i=2; i<=n; i++) {
            dp[i] = dp[i - 2] + dp[i - 1];
        }

        return dp[n];
    }
    // 메모이제이션 O(N)
    static int[] dp = new int[8];
    public static int fibDP2(int n){
        if(n <= 2) return 1;
        if(dp[n] != 0){
            return dp[n];
        }
        dp[n] = fibDP2(n-1) + fibDP2(n-2);
        return dp[n];
    }

    public static void main(String[] args) {
        // Test code
        System.out.println(fib(7));
        System.out.println(fibDP(7));
    }
}
