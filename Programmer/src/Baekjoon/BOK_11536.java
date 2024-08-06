package Baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class BOK_11536 {

    // 11536
    public static void main(String[] args) throws IOException {
        process();

    }

    private static void process() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String[] arr1 = new String[n];
        String[] arr2 = new String[n];

        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            arr1[i] = input;
            arr2[i] = input;
        }

        Arrays.sort(arr2);
        if(Arrays.equals(arr1, arr2)) {
            bw.write("INCREASING");
        } else {
            boolean isAscending = true;
            for (int i = 0; i < arr1.length; i++) {
                if(arr1[i] != arr2[arr1.length-i-1]) {
                    isAscending = false;
                    break;
                }
            }
            if(isAscending) {
                bw.write("DECREASING");
            } else {
                bw.write("NEITHER");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

}
