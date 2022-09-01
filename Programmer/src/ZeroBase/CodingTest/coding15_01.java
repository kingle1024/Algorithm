package ZeroBase.CodingTest;

public class coding15_01 {
    public static void main(String[] args) {

//        System.out.println(solution("zeRobAsE!2#4"));
//        System.out.println(solution("aA1!"));
//        System.out.println(solution("aaa"));
//        System.out.println(solution("abc"));
//        System.out.println(solution("cba"));
//        System.out.println(solution("cBacBa"));
        System.out.println(solution("!12cqwcBa"));
        System.out.println(solution("!12cqwcBs"));
        System.out.println(solution("lq!2Q")); // length 5
        System.out.println(solution("lq!2Qlq!2Qlq!2Qlq!2Qr")); // length 21
        System.out.println(solution("lq!2Qlq!2Qlq!2Q!@#lq!2Q")); // length 21

    }
    public static boolean solution(String s) {
        if(s.length() < 6) return false;
        if(s.length() > 20) return false;

        for(int i=0; i<s.length()-2; i++){
            char c = s.charAt(i);
            String cStr = c+"";
            cStr = cStr.toLowerCase();
            c = cStr.charAt(0);
            int cNum1 = (int)c;

            char c2 = s.charAt(i+1);
            String cStr2 = c2+"";
            cStr2 = cStr2.toLowerCase();
            c2 = cStr2.charAt(0);
            int cNum2 = (int)c2;

            char c3 = s.charAt(i+2);
            String cStr3 = c3+"";
            cStr3 = cStr3.toLowerCase();
            c3 = cStr3.charAt(0);
            int cNum3 = (int)c3;

            // 연속된 숫자
            if(cNum1+1 == cNum2 && cNum2+1 == cNum3){
                return false;
            }
            // 같은 숫자
            if(cNum1 == cNum2 && cNum2 == cNum3){
                return false;
            }
        }

        boolean answer = false;
        boolean isLower = false;
        boolean isUpper = false;
        boolean isNumber = false;
        boolean isC = false;
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            int cNum = (int)c;

            if(cNum >= 48 && cNum <= 57) isNumber = true;
            else if(cNum >= 65 && cNum <= 90) isUpper = true;
            else if(cNum >= 97 && cNum <= 122) isLower = true;
            else isC = true;
        }
        if(isLower && isUpper && isNumber && isC) answer = true;

//        System.out.println("isLower:"+isLower);
//        System.out.println("isUpper:"+isUpper);
//        System.out.println("isNumber:"+isNumber);
//        System.out.println("isC:"+isC);

        return answer;
    }
}
