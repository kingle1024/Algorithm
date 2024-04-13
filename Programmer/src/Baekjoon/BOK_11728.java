import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 11728
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for (int i = 0; i < x; i++) {
            pq.add(Long.valueOf(st.nextToken()));
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < y; i++) {
            pq.add(Long.valueOf(st.nextToken()));
        }

        while (!pq.isEmpty()) {
            bw.write(pq.poll() + " ");
        }
        bw.flush();
        bw.close();
    }
}
