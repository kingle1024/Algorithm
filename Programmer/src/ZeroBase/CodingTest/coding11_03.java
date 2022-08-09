package ZeroBase.CodingTest;

public class coding11_03 {
    static String[] words;
    public static boolean solution(String s, String[] wordss) {
        boolean answer = true;
        words = wordss;
        return dfs(s);
    }
    public static boolean dfs(String s){
        System.out.println("z:"+s);
        if(s.length() == 0) return true;

        for(int i=0; i<words.length; i++) {
            if(s.startsWith(words[i])){
//                System.out.println(s.substring(words[i].length(), s.length()));
                if(dfs(s.substring(words[i].length(), s.length()))){
                    return true;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        String s = "zerobase";
        String[] words = {"zer", "ro", "zerro", "basaae"};
        System.out.println(solution(s, words));
    }
}
