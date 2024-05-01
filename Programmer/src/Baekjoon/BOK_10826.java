
package Baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigDecimal;


public class BOK_10826 {
  public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        if (n == 0) {
            bw.write("0");
            bw.flush();
            bw.close();
            return;
        } else if (n == 1) {
            bw.write("1");
            bw.flush();
            bw.close();
            return;
        } else if (n == 2) {
            bw.write("1");
            bw.flush();
            bw.close();
            return;
        }

        BigDecimal[] arr = new BigDecimal[n+1];

        arr[0] = new BigDecimal(0);
        arr[1] = new BigDecimal(1);

        for (int i = 2; i <= n; i++) {
            arr[i] = arr[i-1].add(arr[i-2]);
        }

        bw.write(String.valueOf(arr[n]));

        bw.flush();
        bw.close();
    }
}
