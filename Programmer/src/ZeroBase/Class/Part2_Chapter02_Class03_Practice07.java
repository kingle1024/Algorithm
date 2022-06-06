package ZeroBase.Class;

import java.util.Arrays;

public class Part2_Chapter02_Class03_Practice07 {
    // 2차원 배열 arr을 시계방향 90도 회전시킨 결과를 출력하세요.
    // 1 2 3 4 5
    // 6 7 8 9 10
    // 11 12 13 14 15
    // 결과 :
    // 11 6 1
    // 12 7 2
    // 13 8 3
    // 14 9 4
    // 15 10 5
    public static void main(String[] args) {
        int arr[][] = {{1,2,3,4,5}, {6,7,8,9,10}, {11,12,13,14,15}};
        int newArr[][] = new int[arr[0].length][arr.length];
        System.out.println("arr.length = " + arr.length);
        System.out.println("arr[0].length = " + arr[0].length);
        System.out.println(arr[1][0]);

        for (int i = 0; i < arr[0].length; i++) {
            for(int j=0; j<arr.length; j++){
                newArr[i][j] = arr[arr.length-j-1][i];
                System.out.print(newArr[i][j]+" ");
            }
            System.out.println();
        }

    }
}
