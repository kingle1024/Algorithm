package Programmers;

import java.util.ArrayList;
import java.util.Arrays;

//모의고사

public class PGM_42840 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{1,2,5,5,2})));
//        System.out.println(Arrays.toString(solution(new int[]{1, 2, 3, 4, 5})));
//        System.out.println(Arrays.toString(solution(new int[]{1, 3, 2, 4, 2})));
//        System.out.println(Arrays.toString(solution(new int[]{5,4})));
//        System.out.println(Arrays.toString(solution(new int[]{1,2,3,4,5,1,2,3,4,5})));
//        System.out.println(Arrays.toString(solution(new int[]{2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5})));

    }
    public static int[] solution(int[] answers){
        if(answers == null || answers.length == 0) return new int[]{1,2,3};
        int[] result = {};
        int a[] = {1, 2, 3, 4, 5};
        int b[] = {2, 1, 2, 3, 2, 4, 2, 5};
        int c[] = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int cnt[] = new int[3];
        int max = -1;

        for(int i=0; i<answers.length; i++){
            int n = answers[i];
            if(n == a[i % a.length]){
                cnt[0]++;
                if(max < cnt[0]) max = cnt[0];
            }
            if(n == b[i % b.length]){
                cnt[1]++;
                if(max < cnt[1]) max = cnt[1];
            }
            if(n == c[i % c.length]){
                cnt[2]++;
                if(max < cnt[2]) max = cnt[2];
            }
        }
        ArrayList<Integer> array = new ArrayList();
        for(int i=0; i<cnt.length; i++){
            System.out.println(cnt[i]);
            if(cnt[i] == max){
                array.add(i+1);
            }
        }

        result = new int[array.size()];
        for(int i=0; i<result.length; i++){
            result[i] = array.get(i);
        }

        if(max == -1){
            result = new int[3];
            for(int i=0; i<3; i++){
                result[i] = i+1;
            }
        }

        return result;
    }

}
