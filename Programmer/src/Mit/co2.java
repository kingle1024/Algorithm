package Mit;

public class co2 {
    public static void main(String[] args) {
        String[] history;
        String[][] option;
        String keyword;
        history = new String[]{"hello i am david", "hello kail", "hi tina"};
        option = new String[][]{{"W", "T"}};
        keyword = "hello";
        solution(history, option, keyword);

    }
    public static void solution(String[] history, String[][] option, String keyword){
        if(option[0][0].equals("W")){
            for(int i=0; i<history.length; i++) {
                match(history[i], keyword);
            }
        }
    }
    public static boolean match(String str, String keyword){
        String[] strArr = str.split(" ");
        for(int i=0; i<strArr.length; i++){
            if(keyword.equals(strArr[i])){
                System.out.println(str);
                break;
            }
        }
        return true;
    }

}
