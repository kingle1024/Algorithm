package BookStudy.day2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOK_11659 {
    public static void main(String[] args) throws IOException {
        solution();
    }
    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int size = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int arr[] = new int[size+1];
        int dp[] = new int[size+1];
        int sum = 0;

        st = new StringTokenizer(br.readLine());

        for(int i=1; i<size+1; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            sum += arr[i];
            dp[i] = sum;
        }
        int[] result = new int[n];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            result[i] = dp[end] - dp[start-1];
        }
        for (int i = 0; i < n; i++) {
            System.out.println(result[i]);
        }
        /*
        5 3
        5 4 3 2 1
        1 3
        2 4
        5 5
         */
    }
}
