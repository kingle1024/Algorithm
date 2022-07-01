package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOK_2003 {
    public static void main(String[] args) throws Exception{
        solution();
    }
    public static void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NM = br.readLine().split(" ");
        int M = Integer.parseInt(NM[1]);

        String[] strArr = br.readLine().split(" ");
        int arr[] = new int[strArr.length];
        for(int i=0; i<strArr.length; i++){
            arr[i] = Integer.parseInt(strArr[i]);
        }
        int left = 0;
        int right = 0;
        int cnt = 0;
        while (true){
            int sum = 0;
            if(left == right) sum += arr[left];
            else{
                for(int i=left; i<=right; i++){
                    sum += arr[i];
                }
//                sum += arr[left] + arr[right];
            }
            if(sum == M){
                cnt++;
//                System.out.println(left+ " "+ right);
                if(left == right) right++;
                else left++;
            }else if(sum > M){
                left++;
            }else if(sum < M){
                right++;
            }
            if(left == arr.length || right == arr.length) break;
        }

        System.out.println(cnt);


    }
}
