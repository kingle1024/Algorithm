package Baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class BOK_4659 {

   public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while(true) {
            String s = br.readLine();
            if("end".equals(s)) {
                break;
            }
            int vowelCnt = 0;
            int consonant = 0;
            boolean isAcceptable = false;

            for (int i = 0; i < s.length()-1; i++) {
                char nowChar = s.charAt(i);
                char nextChar = s.charAt(i+1);
                boolean isNowVowel = checkVowel(nowChar);
                boolean isNextVowel = checkVowel(nextChar);

                if(isNowVowel && isNextVowel) {
                    isAcceptable = true;
                    vowelCnt += 2;
                } else if(!isNowVowel && !isNextVowel) {
                    consonant += 2;
                } else {
                    vowelCnt = 0;
                    consonant = 0;
                    if(isNowVowel || isNextVowel) {
                        isAcceptable = true;
                    }
                }

                if(nowChar == nextChar && (nowChar != 'e' && nextChar != 'e')  && (nowChar != 'o' && nextChar != 'o')) {
                    isAcceptable = false;
                    break;
                }

                if(vowelCnt > 3 || consonant > 3) {
                    isAcceptable = false;
                    break;
                }
            }

            if(s.length() == 1 && checkVowel(s.charAt(0))) {
                isAcceptable = true;
            }

            if(isAcceptable) {
                bw.write("<" + s + ">" + " is acceptable.\n");
            } else {
                bw.write("<" + s + ">" + " is not acceptable.\n");
            }


        }

        bw.flush();
        bw.close();
    }

    private static boolean checkVowel(char c) {
        switch (c) {
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u':
            {
                return true;
            }

            default: {
                return false;
            }
        }
    }

}
