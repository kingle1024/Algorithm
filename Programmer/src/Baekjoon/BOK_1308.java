package Baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.StringTokenizer;

public class BOK_1308 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int year = Integer.parseInt(st.nextToken());
        int month = Integer.parseInt(st.nextToken());
        int day = Integer.parseInt(st.nextToken());
        LocalDate startDate = LocalDate.of(year, month, day);

        st = new StringTokenizer(br.readLine());
        int year2 = Integer.parseInt(st.nextToken());
        int month2 = Integer.parseInt(st.nextToken());
        int day2 = Integer.parseInt(st.nextToken());
        LocalDate endDate = LocalDate.of(year2, month2, day2);
        long daysBetween = ChronoUnit.DAYS.between(startDate, endDate);

        if (year2 - year > 1000 || (year2 - year == 1000 && (month2 > month || (month2 == month && day2 >= day)))) {
            bw.write("gg");
        } else {
            bw.write("D-" +Math.abs(daysBetween));
        }

        bw.flush();
        bw.close();
    }
}
