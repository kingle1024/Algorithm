package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOK_1193 {
    public static void main(String[] args) throws IOException {
        solution();
    }
    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 1/1 -> 1/2 -> 2/1 -> 3/1 -> 2/2 -> 1/3 -> 1/4 -> 2/3 -> 3/2
        int x = 1;
        int y = 1;
        boolean check = false;
        int idx = 1;
        while(true){
            if(idx == N){
                System.out.println(x +"/"+ y);
                break;
            }

            if(!check) {
                if (x - 1 >= 1 && y + 1 >= 1) {
                    x -= 1;
                    y += 1;
                } else {
                    y += 1;
                    check = true;
                }
            }else{
                if(x + 1 >= 1 && y - 1 >= 1){
                    x += 1;
                    y -= 1;
                }else{
                    x +=1;
                    check = false;
                }
            }
            idx++;
        }
    }

}
