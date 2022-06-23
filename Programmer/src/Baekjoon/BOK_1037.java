package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

public class BOK_1037 {

    public static void main(String[] args) throws Exception{
        solution();
    }
    static void solution() throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());

        String[] arr = bf.readLine().split(" ");
        int[] arrInt = new int[arr.length];
        int max = Integer.MIN_VALUE;
        HashSet<Integer> hash = new HashSet();
        for (int i = 0; i < arr.length; i++) {
            int num  = Integer.parseInt(arr[i]);
            hash.add(num);

            if(max < num){
                max = num;
            }
        }

        int idx = 2;
        int checkNum = 0;
        while(true){
            boolean check = false;
            checkNum = max * idx;
            for(int i=2; i<checkNum; i++){
                if(checkNum % i == 0){
                    if(!hash.contains(i)){
                        check = true;
                        break;
                    }
                }
            }
            if(!check){
                break;
            }
            idx++;
        }
        System.out.println(checkNum);
    }
}
