
public class PGM_67256 {
    public static void main(String[] args) {

    }
    class Solution {
        public String solution(int[] numbers, String hand) {
            String answer = "";
            int left = 10;
            int leftPos = left;
            int right = 12;
            int rightPos = right;
            int leftCnt = 0;
            int rightCnt = 0;

            int leftTotal = 0;
            int rightTotal = 0;
            for(int i=0; i<numbers[i]; i++){
                switch(numbers[i]){
                    case 1, 4, 7: {
                        answer += "L";
                        leftPos = numbers[i];
                        break;
                    }
                    case 3, 6, 9:{
                        answer += "R";
                        rightPos = numbers[i];
                        break;
                    }
                    default:{
                        if(numbers[i] == 0) numbers[i] = 11;
                        // x2-x1 + y2-y1

                        leftTotal = Math.abs( (numbers[i] % 3) - leftPos % 3)) + Math.abs( (numbers[i] / 3 - leftPos / 3));


                        Math.abs((leftPos / 3) + leftPos % 3));
                        Math.abs((rightPos / 3 + rightPos % 3));
                        Math.abs((numbers[i] / 3) + numbers[i] % 3); // 5 -> (1,2)

                    }
                }
            }

            return answer;
        }

    /*
     1 - L
     3 - R
     4 - L
     5 - L
     8 - R L 5 3 8
     2 - R
     1 - L
     4 - L
     5 - L R
     9 - R
     5 - R L
    */
    }
}

