import Baekjoon;
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

        int sLength = s.length();
        int tLength = t.length();
        int lcm = lcm(sLength, tLength);

        StringBuilder sSb = getStringBuilder(lcm, sLength, s);
        StringBuilder tSb = getStringBuilder(lcm, tLength, t);

        if(sSb.toString().contentEquals(tSb)) {
            bw.write("1");
        } else {
            bw.write("0");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public static int gcd(int a, int b) {
        while(b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    public static int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }

    private static StringBuilder getStringBuilder(int lcm, int sLength, String s) {
        StringBuilder sSb = new StringBuilder();
        int sLcm = lcm / sLength;
        for (int i = 0; i < sLcm; i++) {
            sSb.append(s);
        }
        return sSb;
    }
}
