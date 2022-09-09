package Programmers;

class PGM_12916 {
    public static void main(String[] args) {

    }
    boolean solution(String s) {
        if(s.length() == 0) return true;

        boolean answer = true;
        int p = 0;
        int y = 0;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == 'p' || s.charAt(i) == 'P'){
                p++;
            }else if(s.charAt(i) == 'y' || s.charAt(i) == 'Y'){
                y++;
            }
        }
        // System.out.println(p);
        // System.out.println(y);
        if(p != y)
            answer = false;
        else if(p == 0 && y == 0) // p와 y 모두 하나도 없는 경우
            answer = true;
        return answer;
    }
}