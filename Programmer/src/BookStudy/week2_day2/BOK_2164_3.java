package BookStudy.week2_day2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOK_2164_3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new LinkedList<>();
        // 제일 위에 있는 카드를 바닥에 버린다.
        // 그 다음, 제일 위에 있는 카드를 제일 아래에 있는 카드 밑으로 옮긴다.

        for(int i=1; i<=N; i++){
            queue.add(i);
        }
        /*
        1
        2
        3
        4
        5
        6
         */
        int result = 0;
        while(!queue.isEmpty()){
            result = queue.poll();
            if(queue.isEmpty()) break;
            int num = queue.poll();
            queue.add(num);
        }
        System.out.println(result);
    }
}
