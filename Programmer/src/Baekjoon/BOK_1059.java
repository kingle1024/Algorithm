package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOK_1059 {
    public static void main(String[] args) throws IOException {

        System.out.println(solution());
    }
    static int solution() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int L = Integer.parseInt(bf.readLine());
        int[] arr= new int[L];
        String[] str = new String[L];
        str = bf.readLine().split(" ");
        for(int i=0; i<L; i++) {
            arr[i] = Integer.parseInt(str[i]);
        }
        Arrays.sort(arr);
        int n = Integer.parseInt(bf.readLine());
        int catchNum = -1;
        int catchIdx = -1;
        for(int i=0; i<L; i++){
            if(arr[0] > n){
                catchNum = arr[0];
                catchIdx = -1;
                break;
            }else if(arr[i] == n){
                return 0;
            }else if(arr[i] > n && i != 0){
                catchNum = arr[i-1];
                catchIdx = i-1;
                break;
            }
        }

        int start = -1;
        if(catchNum+1 < n){
            start = catchNum+1;
        }else if(arr[0] > n){
            start = 1;
        }else{
            start = n;
        }

        int result = 0;
        for(int i = start; i <= n; i++){
            for(int j=n; j<arr[catchIdx+1]; j++){
                if(i == j) continue;
//                System.out.println(i + " " + j);
                result++;
            }
        }
        return result;
    }
}
/*
TC #1
4
3 7 14 10
2
answer : 1


TC #2
4
4 7 14 10
2
answer : 3
 */