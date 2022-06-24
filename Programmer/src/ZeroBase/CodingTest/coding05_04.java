package ZeroBase.CodingTest;

import java.util.Arrays;

public class coding05_04 {
    public static void main(String[] args) {
        int N = 10;
        int[] branches = {6, 7, 10, 16, 12};
        System.out.println(solution(N, branches));
        int N2 = 20;
        int[] branches2 = {8, 15, 16, 18, 32, 16, 20, 15};
        System.out.println(solution(N2, branches2));
    }
    public static int solution(int N, int[] branches){
        if(N < 1) return -1;
        else if(branches.length < 1) return -1;


        int idx = branches[0]/2;
        int cnt = 0;
        while(true){
            cnt = 0;
            for(int i=0; i<branches.length; i++){
                cnt += (branches[i] / idx);
            }
            if(cnt < N){
                System.out.println(idx);
                idx-=1;
                break;
            }
            idx++;
            if(idx < 0) return -1;
        }

        return idx;
    }
    public static int solution2(int N, int[] branches){
        if(N < 1) return -1;
        else if(branches.length < 1) return -1;

//        Arrays.sort(branches);
        int idx = branches[0];
        int cnt = 0;
        while(true){
            cnt = 0;
            for(int i=0; i<branches.length; i++){
                cnt += (branches[i] / idx);
            }
            if(cnt >= N){
//                System.out.println(idx);
//                idx-=1;
                break;
            }
            idx--;
            if(idx < 0) return -1;
        }

        return idx;
    }
}
