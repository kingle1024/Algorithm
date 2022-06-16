package ZeroBase.CodingTest;

public class coding04_02 {
    public static void main(String[] args) {
//        String[] words = {"hello", "hell", "good", "goose", "children", "card", "teachable"};
//        String[] queries = {"hell*", "goo*", "*able", "qua*"};
//        solution(words, queries); // 2 2 1 0
//        System.out.println();
        String[] words2 ={"zero", "base", "students", "are", "the", "best"};
        String[] queries2 = {"z*", "*e", "s*"};
        solution(words2, queries2); // 1 3 1

    }
    public static int[] solution(String[] words, String[] queries) {
        int[] answer = {};
        answer = new int[queries.length];
        boolean back = false;
        for(int i=0; i<queries.length; i++){
            back = false;
            int cnt = 0;
            if(queries[i].charAt(queries[i].length()-1) == '*'){
                back = true;
            }
            for(int j=0; j<words.length; j++){
                String temp = queries[i].replace("*", "");
                if(back) { // 별이 뒤에 있을 때에
                    if(words[j].startsWith(temp)){
                        cnt++;
                    }
                }else{ // 별이 앞에 있을 때에
//                    System.out.print("dk:"+words[j].substring(words[j].length()-temp.length(), words[j].length()));
//                    System.out.println(" / na:"+temp);
//                    if(words[j].substring(words[j].length()-temp.length(), words[j].length()).equals(temp)){
//                        cnt++;
//                    }
                    if(words[j].endsWith(temp)){
                        cnt++;
                    }
                }
            }
            answer[i] = cnt;
//            System.out.print(cnt + " ");
        }
        return answer;
    }
}
