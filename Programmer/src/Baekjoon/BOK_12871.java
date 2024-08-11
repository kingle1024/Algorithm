package com.douzone.comet.batch.bm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOK_12871 {

    // 12871
    public static void main(String[] args) throws IOException {
        process();
    }

    private static void process() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        String t = br.readLine();

        String s1 = t.replaceAll(s, "");

        if(s1.isEmpty()) {
            bw.write("1");
        } else {
            if(s.replaceAll(t, "").isEmpty()) {
                bw.write("0");
            } else {
                bw.write("1");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
