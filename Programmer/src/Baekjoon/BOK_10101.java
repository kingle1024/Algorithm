package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOK_10101{
    static void solution() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[3];
        int res_flag = 0;
        int tmp_sum = 0;
        int tri_sum  = 180;
        for(int i=0; i<3; i++){
            arr[i] = Integer.parseInt(br.readLine());
            tmp_sum += arr[i]; // durlaks
        }
        Arrays.sort(arr);

        for(int i=0; i<2; i++){
            if(arr[i] == arr[i+1]){
                res_flag +=1;
            }
        }
//        System.out.println(res_flag);
//        System.out.println(tmp_sum);
        if (res_flag == 2 && tmp_sum == tri_sum) {
            System.out.println("Equilateral");
        } else if (res_flag == 1 && tmp_sum == tri_sum){
            System.out.println("Isosceles");
        } else if (res_flag == 0 && tmp_sum == tri_sum){
            System.out.println("Scalene");
        } else {
            System.out.println("Error");
        }

    }
    public static void main(String[] args) throws Exception{
        solution();
    }
}
