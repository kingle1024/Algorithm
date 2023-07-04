package Baekjoon;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOK_2562 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int arr[] = new int[9];

        for(int i=0; i<9; i++) {
            int N = Integer.parseInt(in.readLine());
            arr[i] = N;
        }

        int max = arr[0];

        for(int i=0; i<9; i++) {
            if(max<arr[i]) {
                max = arr[i];
            }
        }

        System.out.println("max = " + max);
        bw.write(max+"\n");

        bw.close();
        in.close();
//        out.flush();
    }

}
