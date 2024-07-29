package Baekjoon

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOK_6550 {

    // 6550
    public static void main(String[] args) throws IOException {
        process();
    }

    private static void process() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        String str;

        while(true){
            str = br.readLine();
            if(str == null || str.isEmpty()) break;

            st = new StringTokenizer(str);
            String s = st.nextToken();
            String t = st.nextToken();

            int sIdx = 0;
            int searchIdx = 0;
            while(true) {
                if(t.contains(s)) {
                    bw.write("Yes\n");
                    break;
                }

                char c = s.charAt(sIdx);
                boolean isMatch = false;
                for (int i = searchIdx; i < t.length(); i++) {
                    // 동일한 것을 찾으면
                    if(c == t.charAt(i)) {
                        searchIdx = i+1;
                        sIdx++;
                        isMatch = true;
                        break;
                    }
                }

                if(!isMatch) {
                    bw.write("No\n");
                    break;
                }

                if(sIdx == s.length()) {
                    bw.write("Yes\n");
                    break;
                }
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
