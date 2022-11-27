package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOK_1764 {
    public static void main(String[] args) throws IOException {
        solution();
    }
    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<String, Integer> map = new HashMap<>();
        ArrayList<String> array = new ArrayList<>();
        for(int i = 0; i < N + M; i++){
            String s = br.readLine();
            if(map.get(s) == null){
                map.put(s, 1);
            }else{
                array.add(s);
            }
        }
        Collections.sort(array);

        System.out.println(array.size());
        for (String s : array) {
            System.out.println(s);
        }

    }
}
