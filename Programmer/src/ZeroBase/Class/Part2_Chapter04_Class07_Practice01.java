package ZeroBase.Class;

/*
    a, b, c, d로 이루어진 알파벳 문자열에 대해서
    다음과 같은 규칙으로 문자열을 정리한 후 남은 문자열을 반환하는 프로그램 작성
    양쪽의 문자를 비교한 후 같으면 삭제하는데, 연속해서 같은 문자가 등장하면 함께 삭제한다.
    최종적으로 남은 문자열을 반환하세요.

    입출력 예시
    입력 s : "ab"
    출력 : "ab"

    입력 : "aaabbaa"
    출력 : (없음)
 */
public class Part2_Chapter04_Class07_Practice01 {
    public static String solution(String s){
        int left = 0;
        int right = s.length()-1;
        String result = "";
        int tmp = 0;
        while(true) {
            while (true) {
                if (s.charAt(left) == s.charAt(left + 1)) {
                    left += 1;
                }else {
                    break;
                }
            }
            while (true) {
                if (s.charAt(right) == s.charAt(right - 1)) {
                    right -= 1;
                }else {
                    break;
                }
            }
            if(s.charAt(left) != s.charAt(right)){
                result += s.charAt(left);
                result += s.charAt(right);
                left++;
            }else{
                left++;
                right--;
            }
            if(left >= right) break;
//            System.out.println(left+ " " +right + result);
        }
        return result;
    }
    public static void main(String[] args) {
        System.out.println(solution("ab"));
        System.out.println(solution("aaabbaa"));
        System.out.println(solution("aabcddba"));
    }
}
