package Programmers;

import java.util.Arrays;

class PGM_12953{
    public static void main(String[] args) {

    }
    public int solution(int[] arr) {
        int answer = 0;
        Arrays.sort(arr);
        int maxNum = arr[arr.length-1];
        boolean check = false;
        int cnt = 0;
        while(true){
            cnt = 0;
            for(int i=0; i < arr.length; i++){
                if(maxNum % arr[i] == 0){
                    cnt++;
                }else{
                    break;
                }
            }
            if(cnt == arr.length) break;
            maxNum++;
        }
        answer = maxNum;
        return answer;
    }
}