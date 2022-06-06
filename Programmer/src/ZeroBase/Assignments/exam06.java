package ZeroBase.Assignments;

import java.util.ArrayList;
import java.util.Random;

public class exam06 {
    public static void main(String[] args) {
        // 가상 대선 당선 시뮬레이션 프로그램
        Random r = new Random();

        int voteArr[] = {0, 0, 0, 0};
        String voteName[] = {"이재명", "윤석열", "심상정", "안철수"};
        int maxNum = 10000;
        String voteFor = "";
        int randNum = -1;
        for(int i=0; i<maxNum; i++){
            randNum = r.nextInt(4);
            switch (randNum){
                case 0:{
                    voteArr[0]++;
                    break;
                }
                case 1:{
                    voteArr[1]++;
                    break;
                }
                case 2:{
                    voteArr[2]++;
                    break;
                }
                case 3:{
                    voteArr[3]++;
                    break;
                }
            }
            System.out.printf("[투표진행율]: %.2f%%, %d명 투표 => %s\n", (float)(i+1)/maxNum*100, i+1, voteName[randNum]);
            System.out.printf("[기호:1] 이재명: %05.2f%% (투표수: %d)\n", (float)voteArr[0]/maxNum*100, voteArr[0]);
            System.out.printf("[기호:2] 윤석열: %05.2f%% (투표수: %d)\n", (float)voteArr[1]/maxNum*100, voteArr[1]);
            System.out.printf("[기호:3] 심상정: %05.2f%% (투표수: %d)\n", (float)voteArr[2]/maxNum*100, voteArr[2]);
            System.out.printf("[기호:4] 안철수: %05.2f%% (투표수: %d)\n", (float)voteArr[3]/maxNum*100, voteArr[3]);
        }

        int max = -1;
        // 최대값 구하는 로직
        for(int i=0; i<voteArr.length; i++){
            if(max < voteArr[i]) max = voteArr[i];
        }

        ArrayList<Integer> array = new ArrayList<>();
        // 동일한 표의 당선자가 있는지 확인하는 로직
        getOverlap(array, voteArr, max);

        // 출력 로직
        getPrint(array, voteName);
    }
    public static void getOverlap(ArrayList<Integer> array, int voteArr[], int max){
        // 동일한 표의 당선자가 있는지 확인하는 로직
        int voteDuplication = 0;

        for(int i=0; i<voteArr.length; i++){
            if(voteDuplication > 1){
                break;
            }
            if(max == voteArr[i]){
                array.add(i);
                voteDuplication++;
            }
        }
    }
    public static void getPrint(ArrayList<Integer> array, String voteName[]){
        // 출력 로직
        if(array.size() > 1){
            System.out.print("[투표 결과] 중복된 당선인이 존재합니다.(");
            for (int i = 0; i < array.size(); i++) {
                if(i == array.size()-1) {
                    System.out.print(voteName[array.get(i)]);
                }
                else{
                    System.out.print(voteName[array.get(i)]+", ");
                }
            }
            System.out.print(")\n");
        }else{
            System.out.println("[투표 결과] 당선인: "+voteName[array.get(0)]);
        }
    }
}