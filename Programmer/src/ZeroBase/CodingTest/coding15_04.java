package ZeroBase.CodingTest;

import java.util.Arrays;

public class coding15_04 {
    public static void main(String[] args) {
        int[] div1 = {2, 2, 2, 3, 3, 4, 6, 9};
        int[] div2 = {4, 8, 12, 16};

        System.out.println(solution(div1, div2));
    }
    public static int solution(int[] numsDivide, int[] numsDivided) {
        int answer = 0;
        Arrays.sort(numsDivide);
        // 2 2 3 3 4 6 9
        boolean isDiv = true;
        int idx = -1;
        for(int i=0; i<numsDivide.length; i++) {
            isDiv = true;
            for (int j = 0; j < numsDivided.length; j++) {
                if(numsDivided[j] % numsDivide[i] != 0) {
                    isDiv = false;
                    break;
                }
            }
            if(isDiv){
                idx = i;
                break;
            }
        }
//        for (int i = idx+1; i < numsDivide.length; i++) {
//            if(numsDivide[i] != idx) {
//                answer = i;
//                break;
//            }
//        }
        answer = idx;
        return answer;
    }
}
