package Baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOK_5635 {

   static class People implements Comparable<People> {
        int year;
        int month;
        int day;
        String name;

        public People(String name, int day, int month, int year) {
            this.year = year;
            this.month = month;
            this.day = day;
            this.name = name;
        }

        @Override
        public int compareTo(People other) {
            int xYear = Integer.compare(this.year, other.year);
            if(xYear != 0) {
                return xYear;
            }

            int xMonth = Integer.compare(this.month, other.month);
            if(xMonth != 0) {
                return xMonth;
            }

            return Integer.compare(this.day, other.day);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        final int loop = Integer.parseInt(br.readLine());

        List<People> list = new ArrayList<>();
        StringTokenizer st;
        for (int i = 0; i < loop; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int day = Integer.parseInt(st.nextToken());
            int month = Integer.parseInt(st.nextToken());
            int year = Integer.parseInt(st.nextToken());
            list.add(new People(name, day, month, year));
        }

        Collections.sort(list);
        bw.write(list.get(list.size() - 1).name + "\n");
        bw.write(list.get(0).name + "\n");

        bw.flush();
        bw.close();
    }


}
