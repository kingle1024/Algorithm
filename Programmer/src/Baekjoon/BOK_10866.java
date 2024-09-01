package Baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOK_10866 {

    // 10866
    public static void main(String[] args) throws IOException {
        process();
    }

    private static void process() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        Deque<Integer> deque = new ArrayDeque<>();
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String a = st.nextToken();
            int b = -1;
            if(st.countTokens() == 1) {
                b = Integer.parseInt(st.nextToken());
            }

            switch(a) {
                case "push_front": {
                    deque.addFirst(b);
                    break;
                }
                case "push_back": {
                    deque.addLast(b);
                    break;
                }
                case "pop_front": {
                    if(deque.isEmpty()) {
                        bw.write("-1\n");
                    } else {
                        bw.write(deque.pollFirst() + "\n");
                    }
                    break;
                }
                case "pop_back": {
                    if(deque.isEmpty()) {
                        bw.write("-1\n");
                    } else {
                        bw.write(deque.pollLast() + "\n");
                    }
                    break;
                }
                case "size": {
                    bw.write(deque.size() +"\n");
                    break;
                }
                case "empty": {
                    if(deque.isEmpty()) {
                        bw.write("1\n");
                    } else {
                        bw.write("0\n");
                    }
                    break;
                }
                case "front": {
                    if(deque.isEmpty()) {
                        bw.write("-1\n");
                    } else {
                        bw.write(deque.peekFirst() + "\n");
                    }
                    break;
                }
                case "back": {
                    if(deque.isEmpty()) {
                        bw.write("-1\n");
                    } else {
                        bw.write(deque.peekLast() + "\n");
                    }
                    break;
                }
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
