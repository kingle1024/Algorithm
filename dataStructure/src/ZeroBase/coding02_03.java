public class coding02_03 {
    /*
    병선이는 압축된 문자열 code의 압축을 해제하는 프로그램을 작성하려고 한다. code는 기본적으로 다음과 같이 압축되어 있다.

n{알파벳_문자열} -> 알파벳_문자열을 n번 만큼 반복
즉, 3{abc}e는 abcabcabce로 압축을 해제할 수 있다.

병선이는 압축 효율을 높이고자, 위 방법을 다중으로 사용하기로 하였다.

즉, f2{a3{bc}}z는 f2{abcbcbc}z -> fabcbcbcabcbcbcz 로 압축을 해제할 수 있다.

압축된 문자열 code를 입력받아 압축을 해제하여 문자열로 출력하시오.


     */
    public static void main(String[] args) {
//        solution("zx3{abc}e");
//        solution("f2{a3{bc}}z");
        System.out.println(solution("test"));
    }
    public static String solution(String code) {
        String answer = "";
        int idx = 0;
        int catchIdx = -1;
        StringBuffer bf = new StringBuffer();
        String temp = "";
        String result = "";
        boolean check = false;
        String iterStr = code;
        while(true){
            if(iterStr.charAt(idx) == '{'){ // 1번째
                catchIdx = idx;
//                System.out.println(catchIdx);
            }else if(iterStr.charAt(idx) == '}'){ // 5번째
                // 앞에서부터 {까지 더해줌
                for(int i=0; i<catchIdx-1; i++){
                    result += iterStr.charAt(i);
                }

                // {} 안에 로직
                for(int i=catchIdx+1; i<idx; i++){
                    temp += iterStr.charAt(i);
                }
//                System.out.println(iterStr.charAt(catchIdx-1));
                for(int i=0; i<iterStr.charAt(catchIdx-1)-48; i++){
                    result += temp;
                }

                // } 뒤에 나머지 더해줌
                for(int i=idx+1; i<iterStr.length(); i++){
                    result += iterStr.charAt(i);
                }
                catchIdx = -1;
                iterStr = result;
                result = "";
                temp = "";
//                System.out.println(iterStr);
                idx = 0;
            }

            idx++;
            if(idx == iterStr.length() && catchIdx == -1) break;
        }
        answer = iterStr;
        return answer;
    }
}
