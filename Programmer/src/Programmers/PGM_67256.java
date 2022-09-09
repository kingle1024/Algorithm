package Programmers;

public class PGM_67256 {
    public static void main(String[] args) {
        int arr[] = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
        System.out.println(solution(arr, "right"));

//        int arr[] = {7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2};
//        System.out.println(solution(arr, "left"));

//        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
//        System.out.println(solution(arr, "right"));
        // right
        // "LRLLLRLLRRL"

    }
    public static String solution(int[] numbers, String hand) {
        String answer = "";
        int arr[][] = {
                {0,0}, {0,1}, {0,2},
                {1,0}, {1,1}, {1,2},
                {2,0}, {2,1}, {2,2},
                {3,0}, {3,1}, {3,2}
        };
        System.out.println(arr[0][0]); // 1
        System.out.println(arr[1][0]); // 2

        int left = 10;
        int leftPos = left;
        int right = 12;
        int rightPos = right;

        int leftTotal = 0;
        int rightTotal = 0;
        for(int i=0; i<numbers.length; i++){
            switch(numbers[i]){
                case 1: case 4: case 7: {
                    answer += "L";
                    leftPos = numbers[i];
                    break;
                }
                case 3: case 6: case 9:{
                    answer += "R";
                    rightPos = numbers[i];
                    break;
                }
                default:{
                    if(numbers[i] == 0) numbers[i] = 11;
                    // y2-y1 x2-x1
                    leftTotal = Math.abs(arr[numbers[i]-1][1] - arr[leftPos-1][1]) + Math.abs(arr[numbers[i]-1][0] - arr[leftPos-1][0]);
                    rightTotal = Math.abs(arr[numbers[i]-1][1] - arr[rightPos-1][1]) + Math.abs(arr[numbers[i]-1][0] - arr[rightPos-1][0]);

                    if(hand.equals("left")){ // 7 0 8 2
                        if( leftTotal <= rightTotal){
//                            System.out.println("[1] "+i +" "+ numbers[i] +" "+leftTotal +" " +rightTotal+" / "+leftPos+" "+rightPos);
//                            System.out.println(Math.abs(arr[numbers[i]-1][1] - arr[leftPos-1][1]));
//                            System.out.println(Math.abs(arr[numbers[i]-1][0] - arr[leftPos-1][0]));
//
//                            System.out.println(Math.abs(arr[numbers[i]-1][1] - arr[rightPos-1][1]));
//                            System.out.println(Math.abs(arr[numbers[i]-1][0] - arr[rightPos-1][0]));
                            leftPos = numbers[i];
                            answer += "L";
                        }else{
//                            System.out.println("[2] "+i +" "+ numbers[i] +" "+leftTotal +" " +rightTotal+" / "+leftPos+" "+rightPos);
//                            System.out.println(Math.abs(arr[numbers[i]-1][1] - arr[leftPos-1][1]));
//                            System.out.println(Math.abs(arr[numbers[i]-1][0] - arr[leftPos-1][0]));
//
//                            System.out.println(Math.abs(arr[numbers[i]-1][1] - arr[rightPos-1][1]));
//                            System.out.println(Math.abs(arr[numbers[i]-1][0] - arr[rightPos-1][0]));
                            rightPos = numbers[i];
                            answer += "R";
                        }
                    }else{
                        if( rightTotal <= leftTotal){
                            System.out.println("[3] "+i +" "+ numbers[i] +" "+leftTotal +" " +rightTotal+" / "+leftPos+" "+rightPos);
//                            System.out.println(Math.abs(arr[numbers[i]-1][1] - arr[leftPos-1][1]));
//                            System.out.println(Math.abs(arr[numbers[i]-1][0] - arr[leftPos-1][0]));
//
//                            System.out.println(Math.abs(arr[numbers[i]-1][1] - arr[rightPos-1][1]));
//                            System.out.println(Math.abs(arr[numbers[i]-1][0] - arr[rightPos-1][0]));
                            rightPos = numbers[i];
                            answer += "R";

                        }else{ // 1 3 4 5 8 2 1 4 5 9 5
                            System.out.println("[4] "+i +" "+ numbers[i] +" "+leftTotal +" " +rightTotal+" / "+leftPos+" "+rightPos);
//                            System.out.println(Math.abs(arr[numbers[i]-1][1] - arr[leftPos-1][1]));
//                            System.out.println(Math.abs(arr[numbers[i]-1][0] - arr[leftPos-1][0]));
//
//                            System.out.println(Math.abs(arr[numbers[i]-1][1] - arr[rightPos-1][1]));
//                            System.out.println(Math.abs(arr[numbers[i]-1][0] - arr[rightPos-1][0]));
                            leftPos = numbers[i];
                            answer += "L";
                        }
                    }
                }
            }
        }
        return answer;
        /*
        L L 0
        R R 1
        L L 2
        L L 3
        L L 4
        R L 5 / 8 3 2
        L L 6
        L L 7
        R L 8
        R R 9
        L L 10

         */
    }
}
// LRLLRRLLLRR
