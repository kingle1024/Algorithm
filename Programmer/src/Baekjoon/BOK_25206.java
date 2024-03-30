package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOK_25206 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        double gradeTotal = 0;
        double sum = 0;
        // 과목명, 학점, 등급
        for (int i = 0; i < 20; i++) {
            String input = br.readLine();
            StringTokenizer st = new StringTokenizer(input);
            // 과목명
            st.nextToken();
            // 학점
            double d = Double.parseDouble(st.nextToken());
            // 과목평점
            String grade = st.nextToken();
            if("P".equals(grade)) {
                continue;
            }
            sum += d * getGradeNumber(grade);
            gradeTotal += d;
        }
        if(sum == 0 || gradeTotal == 0) {
            System.out.println("0.000000");
        } else {
            System.out.println(sum / gradeTotal);
        }
    }
    public static double getGradeNumber(String grade){
        switch (grade) {
            case "A+": {
                return 4.5;
            }
            case "A0": {
                return 4.0;
            }
            case "B+": {
                return 3.5;
            }
            case "B0": {
                return 3.0;
            }
            case "C+": {
                return 2.5;
            }
            case "C0": {
                return 2.0;
            }
            case "D+": {
                return 1.5;
            }
            case "D0": {
                return 1.0;
            }
            case "F": {
                return 0.0;
            }
        }
        return -999991;
    }
}
