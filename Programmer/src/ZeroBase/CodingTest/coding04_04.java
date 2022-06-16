package ZeroBase.CodingTest;


import java.util.*;

public class coding04_04 {
    public static void main(String[] args) {
//        int[] start = {0, 2, 3, 5, 6};
//        int[] time = {2, 4, 2, 1, 3};
//        System.out.println(solution(start, time));
        // [4, 2, 7, 2, 6], [5, 2, 5, 4, 3]
        // [1, 3, 4, 0, 2]
        // 실행한 결괏값 [0,1,4,3,2]이 기댓값 [1,3,4,0,2]과 다릅니다.
        int[] start2 = {4, 2, 7, 2, 6};
        int[] time2 = {5, 2, 5, 4, 3};
        solution(start2, time2);
    }
    public static int[] solution(int[] start, int[] time) {
        int[] answer = {};

        int[] startTmp = start.clone();
        int[] timeTmp = time.clone();
        boolean[] check = new boolean[start.length];

        int c = 0;
        int[] result = new int[start.length];
        int minTime = Integer.MAX_VALUE;
        int minIdx = -1;
        while(true){
            ArrayList<Integer> array = new ArrayList<>();
            minIdx = -1;
            minTime = Integer.MAX_VALUE;
            for(int i=0; i<start.length; i++){
                if(startTmp[i] <= 0){
                    if(!check[i]){
                        if(minTime > timeTmp[i]) {
                            minTime = timeTmp[i];
                            minIdx = i;
                        }
                    }
                }
            }
            if(minIdx == -1){
                for (int i = 0; i < startTmp.length; i++) {
                    startTmp[i] -= 1;
                }
                continue;
            }
            System.out.println(minIdx);
            array.add(minIdx);
            if(array.size() != 0){
                Collections.sort(array);
                check[array.get(0)] = true;
                result[c] = array.get(0);
                c++;
            }
            int kk = timeTmp[array.get(0)];
            // 처리
            for(int k = 0; k < kk; k++) {
                for (int i = 0; i < startTmp.length; i++) {
                    startTmp[i] -= 1;
                }
            }

            if(c >= start.length) break;
        }

        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] +" ");
        }
        answer = result;
        return answer;
    }
}
