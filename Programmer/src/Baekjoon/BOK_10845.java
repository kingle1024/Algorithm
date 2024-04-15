package Baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;

public class BOK_10845 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        Deque<Integer> dq = new LinkedList<>();
        // push X: 정수 X를 큐에 넣는 연산이다.
        // pop: 큐에서 가장 앞에 있는 정수를 빼고, 그 수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
        // size: 큐에 들어있는 정수의 개수를 출력한다.
        // empty: 큐가 비어있으면 1, 아니면 0을 출력한다.
        // front: 큐의 가장 앞에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
        // back: 큐의 가장 뒤에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
        for (int i = 1; i <= N; i++) {
            String input = br.readLine();
            if (input.contains("push")) {
                String arr[] = input.split(" ");
                dq.add(Integer.parseInt(arr[1]));
            } else if ("front".equals(input)) {
                bw.write(dq.peekFirst() == null ? "-1\n" : dq.peekFirst() + "\n");
            } else if ("back".equals(input)) {
                bw.write(dq.peekLast() == null ? "-1\n" : dq.peekLast() + "\n");
            } else if ("size".equals(input)) {
                bw.write(dq.size() + "\n");
            } else if ("empty".equals(input)) {
                bw.write(dq.isEmpty() ? "1\n" : "0\n");
            } else if ("pop".equals(input)) {
                if (dq.isEmpty()) {
                    bw.write("-1\n");
                } else {
                    bw.write(dq.pollFirst() + "\n");
                }
            }
        }

        bw.flush();
        bw.close();
    }
}
