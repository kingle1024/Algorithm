package ZeroBase.Class;

import java.util.Arrays;

public class Part2_Chapter02_Class03_Practice03 {
    // 배열 arr의 데이터 순서를 거꾸로 변경하세요.
    // 추가 배열을 사용하지 않고 구현
    public static void main(String[] args) {
        int arr[] = {1, 3, 5, 7, 9, 11};
        int temp;
        for (int i = 0; i < arr.length/2; i++) {
            temp = arr[i];
            arr[i] = arr[arr.length-1-i];
            arr[arr.length-1-i] = temp;
        }
        System.out.println(Arrays.toString(arr));
    }
}
