package Baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BOK_11068 {

    // 11068 
    public static void main(String[] args) throws IOException {
        process();
    }

    private static void process() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int loop = Integer.parseInt(br.readLine());
        for (int i = 0; i < loop; i++) {
            int num = Integer.parseInt(br.readLine());
            boolean isPalindrom = true;
            // 2진수부터 시작
            for (int j = 2; j <= 64; j++) {
                isPalindrom = true;
                List<Integer> radian = radian(num, j);

                for (int k = 0; k < radian.size()/2; k++) {
                    if(!Objects.equals(radian.get(k), radian.get(radian.size() - k - 1))) {
                        isPalindrom = false;
                        break;
                    }
                }

                if(isPalindrom) {
                    break;
                }
            }

            if(isPalindrom) {
                bw.write("1\n");
            } else {
                bw.write("0\n");
            }
        }



        bw.flush();
        bw.close();
        br.close();
    }

    private static List<Integer> radian(int loop, int num) {
        List<Integer> list = new ArrayList<>();

        // 10 -> 2
        // 1010
        while(loop != 0) {
            int i = loop % num;
            loop = loop / num;

            list.add(i);
        }
        return list;
    }
}
