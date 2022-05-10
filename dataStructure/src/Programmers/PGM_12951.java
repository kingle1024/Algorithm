
public class PGM_12951 {
    public static void main(String[] args) {
//        System.out.println(solution("3people unFollowed me"));
        System.out.println(solution("for the last week   "));
//        System.out.println(solution("3people   unFollowed"));
    }
    public static String solution(String s) {
        String answer = "";
        String arr[] = s.split(" ");

        for(int i=0; i<arr.length; i++){
            if(arr.length == 1){
                answer += lowerCase(arr[i]);
            }else if(i == arr.length-1){
                answer += lowerCase(arr[i])+"";
                break;
            }else{
                answer += lowerCase(arr[i]) + " ";
            }
        }

        return answer;
    }
    public static String lowerCase(String s){
        String result = "";
        String temp = "";
        try{
            result = s.toLowerCase();
            temp = result.charAt(0) +"";
            result = temp.toUpperCase() + result.substring(1, result.length());

        }catch(Exception e){
            return s;
        }
        return result;
    }
}

