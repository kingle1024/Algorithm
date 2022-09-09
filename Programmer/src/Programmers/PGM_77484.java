package Programmers;

class PGM_77484{
    public static void main(String[] args) {

    }
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = {};
        answer = new int[2];
        int maxCnt = 0;
        int cnt = 0;
        for(int i=0; i<lottos.length; i++){
            if(lottos[i] == 0){
                maxCnt++;
                continue;
            }
            for(int j=0; j<win_nums.length; j++){
                if(lottos[i] == win_nums[j]){
                    cnt++;
                }
            }
        }
        System.out.println(maxCnt+ " "+cnt);
        int arr[] = new int[2];
        arr[0] = maxCnt+cnt;
        arr[1] = cnt;
        if(cnt == 6) maxCnt = 6;
        for(int i=0; i<arr.length; i++){
            switch(arr[i]){
                case 6:{
                    answer[i] = 1;
                    break;
                }
                case 5:{
                    answer[i] = 2;
                    break;
                }
                case 4:{
                    answer[i] = 3;
                    break;
                }
                case 3:{
                    answer[i] = 4;
                    break;
                }
                case 2:{
                    answer[i] = 5;
                    break;
                }
                default:{
                    answer[i] = 6;
                }
            }
        }
        return answer;
        /*
            44, 31, 25, 1, 0, 0
            45, 31, 19, 10, 6, 1
        */
    }
}