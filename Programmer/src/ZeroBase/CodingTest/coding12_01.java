package ZeroBase.CodingTest;

public class coding12_01 {
    public static void main(String[] args) {
        String s = "azbacefbaaaa";
//        s = "bbbaaaabbbbaaaaab";
//        s = "aaaaaefba";
        solution(s);
        s = "iiaiiioaaiiaaaiipp";
        solution(s);
    }
    public static int solution(String s) {
        int answer = 0;
        while(true){
            System.out.println("s:"+s);
            if(s.equals("a")) break;
            answer++;
            s = sort(s);

        }
        System.out.println(answer);
        return answer;
    }

    public static String sort(String s){
        s = s.replaceAll("a{2,}", "*");
        if(s.equals("a")){
            return "a";
        }
        StringBuilder sb = new StringBuilder(s);

        for(int i=1; i<sb.length()-1; i++){
            if (s.charAt(i) == 'a') {
                sb.deleteCharAt(i + 1);
                sb.insert(i, "a");
                sb.deleteCharAt(i - 1);
                sb.insert(i - 1, "a");
            }
        }

        if(s.charAt(0) == 'a' && s.charAt(1) != 'a'){
            sb.deleteCharAt(1);
            sb.insert(0, "a");
        }
        if(s.charAt(sb.length()-1) =='a' && s.charAt(sb.length()-2) != 'a') {
            sb.deleteCharAt(sb.length() - 2);
            sb.insert(0, "a");
        }

        return sb.toString().replace("*", "a");
    }
}
