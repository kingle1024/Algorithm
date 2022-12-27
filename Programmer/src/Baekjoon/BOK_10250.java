package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOK_10250 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int loop = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int i=0; i<loop; i++){
            st = new StringTokenizer(br.readLine());
            int h = Integer.parseInt(st.nextToken()); // 6
            int w = Integer.parseInt(st.nextToken()); // 12
            int n = Integer.parseInt(st.nextToken()); // 10

            int floor = n % h;
            int ho = (n / h) + 1;
            if(floor == 0 ){
                floor = h;
                ho -=1;
            }
            if(String.valueOf(ho).length() < 2){
                System.out.println(floor +"0" + ho);
            }else{
                System.out.println(floor +"" + ho);
            }

        }
    }
}
