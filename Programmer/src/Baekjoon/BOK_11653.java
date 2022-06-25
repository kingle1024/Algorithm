package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BOK_11653 {
    static void solution() throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        if(N == 1) return;
        int idx = 2;
        ArrayList<Integer> array = new ArrayList();
        int cntN = N;
        while(true){
            if(cntN == 1 || N == idx) break;
            if(cntN % idx == 0){
                array.add(idx);
                cntN /= idx;
                idx = 2;
            }else {
                idx++;
            }
        }
        if(array.size() == 0){
            System.out.println(N);
        }else {
            for (int i = 0; i < array.size(); i++) {
                System.out.println(array.get(i));
            }
        }
    }
    public static void main(String[] args) throws Exception{
        solution();
    }
}
