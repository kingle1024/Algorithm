package Baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class BOK_15904 {
  public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();
        final int length = input.length();
        List<Character> upperStr = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            int num = input.charAt(i);
            // 대문자 범위
            if(num >= 65 && num <= 96) {
                upperStr.add((char)num);
            }
        }

        int searchIdx = 0;
        String searchStr = "UCPC";
        boolean isUCPC = false;

        for (int i = 0; i < upperStr.size(); i++) {
            if(searchStr.charAt(searchIdx) == upperStr.get(i)) {
                searchIdx++;
            }

            if(searchIdx == 4) {
                isUCPC = true;
                break;
            }
        }

        if(isUCPC) {
            bw.write("I love UCPC");
        } else {
            bw.write("I hate UCPC");
        }

        bw.flush();
        bw.close();
    }

}
