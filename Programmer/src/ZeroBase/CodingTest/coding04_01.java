package ZeroBase.CodingTest;

import java.util.ArrayList;
import java.util.Arrays;

public class coding04_01 {
    public static void main(String[] args) {
        String[] titles = {"아모르파티", "아기상어", "올챙이와개구리", "산다는건"};
        String[] lyrics = {"산다는게다그런거지", "아기상어뚜루루뚜루귀", "개울가에올챙이한마리꼬물", "산다는건다그런거래요힘들고"};
        String[] problems = {"산다", "아기상어", "올챙이"};

        solution(titles, lyrics, problems);
    }
    public static String[][] solution(String[] titles, String[] lyrics, String[] problems) {
        String[][] answer = {};
        answer = new String[problems.length][];
        for(int i=0; i<problems.length; i++){
            String s = problems[i];
            ArrayList<String> array = new ArrayList();
            for(int j=0; j<lyrics.length; j++){
                if(lyrics[j].length() < s.length()) continue;
                if(lyrics[j].startsWith(s)){
                    array.add(titles[j]);
                }
            }
            if(array.size() != 0)
                answer[i] = array.toArray(new String[array.size()]);
            else
                answer[i] = new String[]{};
        }


        return answer;
    }
}
