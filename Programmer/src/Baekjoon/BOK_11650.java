package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOK_11650 {
    public static void main(String[] args) throws IOException {
        solution();
    }
    static void solution() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int[][] arr = new int[N][2];
        for(int i=0; i<N; i++){
            String[] s = bf.readLine().split(" ");
            arr[i][0] = Integer.parseInt(s[0]);
            arr[i][1] = Integer.parseInt(s[1]);
        }

//        for(int i=arr.length-1; i>=0; i--){
//            for(int j = 0; j<i; j++){
//                if(arr[j][0] >= arr[i][0]){
//                    if(arr[j][1] > arr[i][1]) {
//                        int[] temp;
//                        temp = arr[j];
//                        arr[j] = arr[i];
//                        arr[i] = temp;
//                    }
//                }
//            }
//        }
        Arrays.sort(arr, (o1, o2) -> {
            if(o1[0] == o2[0]){
                return Integer.compare(o1[1], o2[1]);
            }else{
                return Integer.compare(o1[0], o2[0]);
            }
        });

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
}

