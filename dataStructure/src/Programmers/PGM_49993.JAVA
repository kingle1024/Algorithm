package Programmers;

import java.util.*;
// x만큼 간격이 있는 n개의 숫자_https://programmers.co.kr/learn/courses/30/lessons/12954
public class PGM_49993 {
    public static void main(String[] args) {
        // https://mozzioi.tistory.com/99
        String skill = "CBDK";
        skill = "CBDK";
//        String[] skill_tress = {"BACDE","CBADF","AECB","BDA"};
//        String[] skill_tress = {"BACDE","CBADF", "AECB"};
//        skill_tress = {"BACDE","CBADF","AECB","BDA"};
        String[] skill_tress = {"CB", "CXYB", "BD", "AECD", "ABC", "AEX", "CDB", "CBKD", "IJCB", "LMDK"};
//        String[] skill_tress = {"CDB"};
        System.out.println(solution(skill, skill_tress));
    }
    public static long[] solution(int x, int n) {
        // https://programmers.co.kr/skill_checks/358606?challenge_id=2508
        /*
        선행 스킬이란 어떤 스킬을 배우기 전에 먼저 배워야 하는 스킬을 뜻합니다.

예를 들어 선행 스킬 순서가 스파크 → 라이트닝 볼트 → 썬더일때, 썬더를 배우려면 먼저 라이트닝 볼트를 배워야 하고, 라이트닝 볼트를 배우려면 먼저 스파크를 배워야 합니다.

위 순서에 없는 다른 스킬(힐링 등)은 순서에 상관없이 배울 수 있습니다. 따라서 스파크 → 힐링 → 라이트닝 볼트 → 썬더와 같은 스킬트리는 가능하지만, 썬더 → 스파크나 라이트닝 볼트 → 스파크 → 힐링 → 썬더와 같은 스킬트리는 불가능합니다.

선행 스킬 순서 skill과 유저들이 만든 스킬트리1를 담은 배열 skill_trees가 매개변수로 주어질 때, 가능한 스킬트리 개수를 return 하는 solution 함수를 작성해주세요.


         */
        int answer = -1;
        int idx = 0;
        int result = 0;
        boolean check[] = new boolean[skill.length()];
        boolean loop = false;
        int idxCatch = 0;
        int temp = 0;
        for(int i=0; i<skill_trees.length; i++){
            idx = 0;
            loop = false;
            // 구하는 로직
            while(true){
                if(loop) break;
                idxCatch = 0;
                for (int j = 0; j < skill_trees[i].length(); j++) {
                    char pick = skill.charAt(idx);
                    if (skill_trees[i].charAt(j) == pick) { // 만약에 같은 문자를 찾으면
                        if(idxCatch > j){ // 다음 문자가 앞에 있으면 무한루프를 빠져나온다.
                            loop = true;
                            break;
                        }

                        idx++;
                        idxCatch = j;

                        if(idx == skill.length()){
                            result++;
                            System.out.println(skill_trees[i]);
                            loop = true;
                            break;
                        }

                    }
                    if(j == skill_trees[i].length()-1){ // 마지막까지 문자가 포함되어 있지 않은 경우
                        loop = true;
                        break;
                    }
                }

                if(idx == skill_trees[i].length()){ // AECB skill이 끝나지 않았지만, 잡은 위치가 마지막일 경우
                    result++;
                    System.out.println(skill_trees[i]);
                    loop = true;
                }
            }

        }
        if(result == 0)
            return answer;
        else
            return result;
    }
}
