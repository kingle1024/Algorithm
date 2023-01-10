package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOK_1475 {
    static int[] arr;
    static int result;
    public static void main(String[] args) throws IOException {
        arr = new int[10];
        result = 0;
        allAdd();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        searchCnt(str);
        System.out.println(result);
    }

    private static void searchCnt(String str) {
        for(int i=0; i<str.length(); i++){
            int num = Integer.parseInt(String.valueOf(str.charAt(i)));
            checkNum(num);
        }
    }

    private static void checkNum(int num) {
//        System.out.println("start num = " + num);
        if(arr[num] > 0){
            arr[num] -= 1;
        }else{
            if(num == 6 && arr[9] > 0){
                arr[9] -= 1;
            }else if(num == 9 && arr[6] > 0){
                arr[6] -= 1;
            }else{
//                System.out.println("[+] num = " + num);
                allAdd();
                arr[num] -=1;
            }
        }
    }

    private static void allAdd() {
        for(int i=0; i<10; i++){
            arr[i] += 1;
        }
        result+=1;
    }
}
