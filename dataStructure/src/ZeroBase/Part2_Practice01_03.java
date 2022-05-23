import java.util.ArrayList;
import java.util.Arrays;

public class Part2_Practice01_03 {
    /*
    문자열 s1과 s2가 주어졌을 때
    s1을 permutation 한 문자열이 s2의 부분 문자열에 해당하면 true를 반환하고
    그렇지 않으면 false를 반환하는 프로그램을 작성하세요.
     */
    public static void main(String[] args) {
        System.out.println(Integer.valueOf('a'));
        System.out.println(Integer.valueOf('z'));
        System.out.println(Integer.valueOf('z')-Integer.valueOf('a'));

        String s1 = "ab"; // 0
        String s2 = "adbak"; // 01 12 23 34
        System.out.println(solution(s1, s2));
        System.out.println(solution2(s1, s2));
        System.out.println();

        s1 = "ac";
        s2 = "car";
        System.out.println(solution(s1, s2));
        System.out.println(solution2(s1, s2));
        System.out.println();

//        s1 = "ak";
//        s2 = "aabbkk";
//        System.out.println(solution(s1, s2));
//        System.out.println(solution2(s1, s2));
//        System.out.println();

//        s1 = "ab";
//        s2 = "bcab";
//        System.out.println(solution(s1, s2));
//        System.out.println(solution2(s1, s2));
//        System.out.println();
    }
    public static void permutation(char[] arr, int depth, int n, int r, boolean[] visited, char[] out, ArrayList<String> list){
        if(depth == r){
            list.add(new String(out));
        }

        for(int i=0; i < n; i++){
            if(visited[i] != true){
                visited[i] = true;
                out[depth] = arr[i];
                permutation(arr, depth+1, n, r, visited, out, list);
                visited[i] = false;
            }
        }
    }

    static boolean solution(String s1, String s2){
        boolean[] visited = new boolean[s1.length()];
        char[] out = new char[s1.length()];
        ArrayList<String> list = new ArrayList();
        permutation(s1.toCharArray(), 0, s1.length(), s1.length(), visited, out, list);

        for(String s: list){
            if(s2.contains(s)){
                return true;
            }
        }

        return false;
    }
    //    String s1 = "ab"; //
//    String s2 = "bcab"; // 1 0 -1
    static boolean solution2(String s1, String s2){
        int arr[] = new int[26]; // 모두 0으로 초기화
        for(int i = 0; i < s1.length(); i++){
            arr[Integer.valueOf(s1.charAt(i))-97] ++;
        }

        for (int i = 0; i < s1.length(); i++) {
            arr[Integer.valueOf(s2.charAt(i))-97] --;
            System.out.println(s2.charAt(i));
        }
//
        for(int i=s1.length()-1; i<s2.length()-1; i++){
            arr[Integer.valueOf(s2.charAt(i+1))-97]--;
            arr[Integer.valueOf(s2.charAt(i-1))-97]++;
            System.out.println("i:"+i +" "+s2.charAt(i) +" " + s2.charAt(i-1));
        }

        System.out.println(Arrays.toString(arr));
        boolean result = true;
        for(int i=0; i< arr.length; i++){
            if(arr[i] != 0){
                result = false;
                break;
            }
        }
        return false;
    }
}
