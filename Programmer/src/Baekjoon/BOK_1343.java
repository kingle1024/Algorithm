package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOK_1343 {
    static StringBuilder result = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        int idx = 0;
        int loop = 0;
        while(true){
            if(idx == s.length()) break;

            if(s.charAt(idx) == 'X'){
                if(loop == 4){
                    appendA(4);
                    loop = 0;
                }
                loop++;
            }else{
                if(loop == 4){
                    appendA(4);
                    result.append(".");
                    loop = 0;
                }else if(loop == 2){
                    appendB(2);
                    result.append(".");
                    loop = 0;
                }else{
                    if(loop != 0) {
                        System.out.println("-1");
                        return;
                    }else{
                        result.append(".");
                    }
                }
            }
            idx++;
        }

        if(loop == 2){
            appendB(2);
        }else if(loop == 4){
            appendA(4);
        }else{
            if(loop != 0) {
                System.out.println("-1");
                return;
            }else if(!s.contains("X")){
                System.out.println(s);
                return;
            }
        }

        System.out.println(result);

    }

    static void appendA(int loop){
        for (int i = 0; i < loop; i++) {
            result.append("A");
        }
    }
    static void appendB(int loop){
        for (int i = 0; i < loop; i++) {
            result.append("B");
        }
    }
}
