package Programmers;

import java.util.LinkedList;
import java.util.Queue;

public class PGM_118667 {
    public static void main(String[] args) {
        solution(new int[]{3, 2, 7, 2}, new int[]{4, 6, 5, 1});
        solution(new int[]{1, 2, 1, 2}, new int[]{1, 10, 1, 2});
        solution(new int[]{1, 1}, new int[]{1, 5});
    }
    public static int solution(int[] queue1, int[] queue2) {
        int answer = -2;
        Queue<Long> q1 = new LinkedList<>();
        Queue<Long> q2 = new LinkedList<>();
        long totalQ1 = 0;
        long totalQ2 = 0;
        for(int i=0; i<queue1.length; i++){
            totalQ1 += queue1[i];
            q1.add((long) queue1[i]);
        }
        for (int i = 0; i < queue2.length; i++) {
            totalQ2 += queue2[i];
            q2.add((long) queue2[i]);
        }

        int cnt = 0;
        long sum = totalQ1 + totalQ2;
        int length = queue1.length + queue2.length;
        long q2Num = -1;
        long q1Num = -1;
        while(true){
            if(sum/2 > totalQ1){
                q2Num = q2.poll();
                q1.add(q2Num);
                totalQ1 += q2Num;
                cnt++;
//                System.out.println("aaa");
            }else if(sum/2 < totalQ1){
                q1Num = q1.poll();
                q2.add(q1Num);
                totalQ1 -= q1Num;
                cnt++;
//                System.out.println("bbb");
            }else if(sum/2 == totalQ1) break;
            if(cnt > length*2){
                cnt = -1;
                break;
            }
        }
//        System.out.println(cnt);
        answer = cnt;
        return answer;
    }
}
