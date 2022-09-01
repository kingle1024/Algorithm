package ZeroBase.CodingTest;

import java.util.LinkedList;
import java.util.Queue;

public class coding15_03 {
    public static void main(String[] args) {
        int[] arr = {1, -1, -20, 4, -7, 5};
        solution(arr, 2);
    }
    static int max;
    static int[] dp;
    public static int solution(int[] arr, int k) {
        int answer = 0;
        max = 0;
//        dfs(arr, 0, k, arr[0]);
        dp = new int[arr.length];

        bfs(arr, k);
//        System.out.println("max:"+max);


        return max;
    }

    static class People15{
        int x;
        int cnt;

        public People15(int x, int cnt) {
            this.x = x;
            this.cnt = cnt;
        }
    }
    public static void bfs(int arr[], int k){
        Queue<People15> q = new LinkedList<>();
        q.add(new People15(0, arr[0]));
        while(!q.isEmpty()) {
            People15 p = q.poll();
            for (int i = 1; i <= k; i++) {
                int nx = p.x + i;
                System.out.println(nx +" ");
//                if(nx >= arr.length) break;
                if(nx >= arr.length) continue;

                int sum = p.cnt + arr[nx];

                if(dp[nx] == 0) dp[nx] = sum;
                else if(dp[nx] >= sum) continue;
                else dp[nx] = sum;

                System.out.println(nx+" "+ arr[nx] +" " + sum);

                q.add(new People15(nx, sum));
                max = Math.max(sum, max);
            }
        }
    }
    public static void dfs(int[]arr, int index, int k, int sum){
        if(index > k+1) return;
        int s = sum;

        for(int i=1; i<=k; i++){
//            System.out.print(index+" "+s+" ");
            s += arr[index+i];
//            System.out.println(arr[index+i] +" " + s);
            dfs(arr, index+i, k, s);
        }
//        System.out.println(s);
        max = Math.max(s, max);
    }
}
