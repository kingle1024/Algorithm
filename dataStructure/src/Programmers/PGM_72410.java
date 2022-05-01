public class PGM_72410 {
    public static void main(String[] args) {
        solution("abcdefghijklmn.p");
    }

    public static String solution(String new_id) {
        // 2021 카카오 블라인드 채용 - 신규 아이디 추천
        String answer = "";
        // 1 단계
        answer = new_id.toLowerCase();
        String temp = "";
        int idx = 0;

        // 2단계
        for (int i = 0; i < new_id.length(); i++) {
            if (((int)answer.charAt(i) >= 97 && (int)answer.charAt(i) <= 122)
                    || ((int)answer.charAt(i) >= 48 && (int)answer.charAt(i) <= 57)
                    || answer.charAt(i) == '-'
                    || answer.charAt(i) == '_'
                    || answer.charAt(i) == '.'
            ) {
//                System.out.println(i);
                temp += answer.charAt(i);
            }
        }
        answer = temp;

        // 3단계
        while(answer.indexOf("..") > -1) {
            answer = answer.replace("..", ".");
        }

        // 4단계
        if(answer.length() != 1) {
            if (answer.charAt(0) == '.') { // 맨처음 .일때
                answer = answer.substring(1, answer.length());
            }
            if (answer.charAt(answer.length() - 1) == '.') { // 맨끝에 .일때
                answer = answer.substring(0, answer.length() - 1);
            }
        }else if(answer.length() == 1){
            if(answer.charAt(0) == '.'){
                answer = "";
            }
        }

        // 5단계
        if(answer == ""){
            answer = "a";
        }

        // 6단계
        if(answer.length() > 15){
            answer = answer.substring(0, 15);
            if(answer.charAt(answer.length()-1) == '.'){
                answer = answer.substring(0, answer.length()-1);
            }
        }

        // 7단계
        if(answer.length() <= 2){
            while(true){
                answer = answer + answer.charAt(answer.length()-1);
                if(answer.length() == 3) break;
            }
        }

        return answer;
    }
}

