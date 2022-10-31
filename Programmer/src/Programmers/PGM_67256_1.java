package Programmers;

public class PGM_67256_1 {
    public static void main(String[] args) {
        int[] numbers = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
        String hand = "right";
        solution(numbers, hand);

        solution(new int[]{7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2}, "left");
        solution(new int[]{1,2,3,4,5,6,7,8,9,0}, "right");

    }
    public static String solution(int[] numbers, String hand) {
        String answer = "";
        // 2, 5, 8, 0일 때에 손에 있는 숫자
        StringBuffer sb = new StringBuffer();
        int leftX = 3;
        int leftY = 0;
        int rightX = 3;
        int rightY = 2;

        for(int i=0; i<numbers.length; i++){
            int x = (numbers[i]-1) / 3;
            int y = (numbers[i]-1) % 3;

//            if(numbers[i] % 3 == 0){
//                y = 2;
//                x = numbers[i] / 3 - 1;
//            }
//            if(numbers[i] < 4) x = 0;
            if(numbers[i] == 0){
                x = 3;
                y = 1;
            }

            System.out.println(numbers[i] +" ==> "+x + " "+y);
            if(numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7){
                sb.append("L");
                leftX = x;
                leftY = y;
//                System.out.println(numbers[i] +"] "+ leftX+","+ leftY +" / "+rightX +","+rightY +" -> "+x +","+y);
            }else if(numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9){
                sb.append("R");
                rightX = x;
                rightY = y;
            }else{
                int distanceL = -1;
                distanceL = Math.abs(y-leftY) + Math.abs(x - leftX);

                int distanceR = -1;
                distanceR = Math.abs(y-rightY) + Math.abs(x - rightX);

                if(distanceL == distanceR){
                    if(hand.equals("left")){
                        leftX = x;
                        leftY = y;
                        sb.append("L");
                    }else{
                        rightX = x;
                        rightY = y;
                        sb.append("R");
                    }
                    //  R이 더 가까운 경우
                }else if(distanceL > distanceR){
                    rightX = x;
                    rightY = y;
                    sb.append("R");
                }else{ // L이 더 가까운 경우
                    leftX = x;
                    leftY = y;
                    sb.append("L");
                }
            }
        }
        System.out.println(sb);
        answer = String.valueOf(sb);
        return answer;
    }
}
