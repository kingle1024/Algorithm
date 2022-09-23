package BookStudy.day5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOK_1253 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        if(n == 1){
            System.out.println("1");
            return;
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        int cnt = 0;

        for(int i=0; i<n; i++) {
            int start = 0;
            int end = n-1;
            int target = arr[i];
            while (start < end) {
                if(start == i){
                    start++;
                    continue;
                }else if(end == i){
                    end--;
                    continue;
                }

                int sum = arr[start] + arr[end];
                if(sum == target){
                    System.out.println(arr[i] +" " + arr[start]+"+"+ arr[end]+" -> "+sum);
                    cnt++;
                    break;
                }else if(sum < target){
                    start++;
                }else{
                    end--;
                }
            }
        }
        System.out.println(cnt);
    }
}
