package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOK_12891 {
    public static void main(String[] args) throws IOException {
        solution();
    }
    static int[] nowArr;
    static int minCnt;
    static HashMap<Character, Integer> minCharHash;
    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());
        String dnaStr = br.readLine();

        minCharHash = new HashMap<>();
        StringTokenizer minimalCharToken = new StringTokenizer(br.readLine());

        char[] acgtArr = new char[]{'A','C','G','T'};
        minCnt = 0;
        for(int i=0; i<4; i++){
            int charTokenCnt = Integer.parseInt(minimalCharToken.nextToken());
            minCharHash.put(acgtArr[i], charTokenCnt);
            if(charTokenCnt == 0) minCnt++;
        }
        int result = 0;

        nowArr = new int[4];
        for(int i=0; i<p; i++){
            char c = dnaStr.charAt(i);
            add(c);
        }
        if(minCnt == 4){
            result++;
        }

        int idx = 0;
        for(int i = p; i<s; i++){
            char c = dnaStr.charAt(i);
            add(c);
            remove(dnaStr.charAt(idx));
            if(minCnt == 4){
                result++;
            }
//            System.out.println("i:"+i+" idx:"+idx);
            idx++;
        }
        System.out.println(result);
    }

    private static void remove(char c) {
        switch (c){
            case 'A':{
                if(nowArr[0] == minCharHash.get(c)) minCnt--;
                nowArr[0]--;
                break;
            }
            case 'C':{
                if(nowArr[1] == minCharHash.get(c)) minCnt--;
                nowArr[1]--;
                break;
            }
            case 'G':{
                if(nowArr[2] == minCharHash.get(c)) minCnt--;
                nowArr[2]--;
                break;
            }
            case 'T':{
                if(nowArr[3] == minCharHash.get(c)) minCnt--;
                nowArr[3]--;
                break;
            }
        }
    }

    private static void add(char c) {
        switch (c){
            case 'A':{
                nowArr[0]++;
                if(nowArr[0] == minCharHash.get(c)) minCnt++;
                break;
            }
            case 'C':{
                nowArr[1]++;
                if(nowArr[1] == minCharHash.get(c)) minCnt++;
                break;
            }
            case 'G':{
                nowArr[2]++;
                if(nowArr[2] == minCharHash.get(c)) minCnt++;
                break;
            }
            case 'T':{
                nowArr[3]++;
                if(nowArr[3] == minCharHash.get(c)) minCnt++;
                break;
            }
        }
    }
}
