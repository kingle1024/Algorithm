package Baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class BOK_15312 {

    // 15312
    public static void main(String[] args) throws IOException {
        process();
    }

    private static void process() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] number = {3, 2, 1, 2, 3, 3, 2, 3, 3, 2, 2, 1, 2, 2, 1, 2, 2, 2, 1, 2, 1, 1, 1, 2, 2, 1}; //대문자 획순

        String A = br.readLine();
        String B = br.readLine();
        List<Integer> list = new ArrayList<>(); // <Integer>

        for (int i = 0; i < A.length(); i++) {
            int num1 = number[(A.charAt(i) - 65)];
            list.add(num1);
            int num2 = number[(B.charAt(i) - 65)];
            list.add(num2);
        }

        while(true) {
            List<Integer> newList = new ArrayList<>();
            for (int i = 0; i < list.size()-1; i++) {
                newList.add((list.get(i) + list.get(i+1))%10);
            }

            list = newList;
            if(newList.size() == 2) {
                bw.write(newList.get(0) + "" + newList.get(1));
                break;
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

}
