import java.util.ArrayList;
import java.util.Arrays;

public class coding01 {
    public static void main(String[] args) {
        int num = 123;
        String temp = Integer.toString(num);
        System.out.println(temp.length());
        int[] answer = {};
        ArrayList<Integer> array = new ArrayList();
        array.add(1);
        answer = new int[5];
    }
    /*
    앞에서부터 읽을 때와 뒤에서부터 읽을 때 똑같은 단어를 팰린드롬(palindrome)이라고 합니다. 예를들어서 racecar, 10201은 팰린드롬 입니다.

두 자연수 n, m이 매개변수로 주어질 때, n 이상 m 이하의 자연수 중 팰린드롬인 숫자의 개수를 return 하도록 solution 함수를 완성해 주세요.


     */
    class Solution {
        public int solution(int n, int m) {
            int answer = 0;
            boolean check = false;
            for(int i=n; i<=m; i++){
                if(i < 10) answer++;
                else{
                    String toStr = Integer.toString(i);
                    check = false;
                    for(int j=0; j < toStr.length()/2; j++){
                        if(toStr.charAt(j) != toStr.charAt(toStr.length() - 1 - j)){
                            check = true; // 다르면 나가리
                            break;
                        }
                    }
                    if(!check) answer++;
                }
            }

            return answer;
        }
    }
}
