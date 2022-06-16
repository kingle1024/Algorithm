package ZeroBase.CodingTest;

import java.util.ArrayList;

public class coding04_03 {
    public static void main(String[] args) {
        String[] words = {"hello", "hear", "hell", "good", "goose", "children", "card", "teachable"};
        String[] query = {"he??", "g???", "childre?", "?"};
        solution(words, query);
    }
    public static String[][] solution(String[] words, String[] queries) {
        String[][] answer = {};
        answer = new String[queries.length][];
        boolean back = false;
        ArrayList<ArrayList<String>> totalArray = new ArrayList<>();
        for(int i=0; i<queries.length; i++){
            ArrayList<String> array = new ArrayList();
            int length = queries[i].length();
            back = false;
            if(queries[i].endsWith("?")){
                back = true;
            }
            for(int j=0; j<words.length; j++){
                if(words[j].length() != length) continue;
                String temp = queries[i].replace("?", "");
                if(back){
                    if(words[j].startsWith(temp)){
//                        System.out.print(words[j]+" ");
                        array.add(words[j]);
                    }
                }
            }
            answer[i] = new String[array.size()];
            System.out.println(array.size());
//            System.out.println();
            totalArray.add(array);

        }

        for(int i=0; i<totalArray.size(); i++){
            for(int j=0; j<totalArray.get(i).size(); j++){
                answer[i][j] = totalArray.get(i).get(j);
            }
        }
        return answer;
    }
}
