import java.util.Arrays;

public class Part2_Practice01_02 {
    /*
    양의 정수로 이루어진 arr 배열이 주어졌을 때
    해당 데이터로 만들 수 있는 permutation 중에서 다음과 같은 데이터를 출력하는 프로그램을 작성하세요.
    - 현재 데이터보다 이전의 큰 수를 출력
    - 한 번의 swap으로 출력 가능한 큰 수를 출력
     */

    public static void solution(int[] arr){
        int lastNum;
        int swap;
        boolean check = false;
        for(int j=arr.length-1; j > 1; j--) {
            check = false;
            lastNum = arr[j];
            for (int i = j - 1; i > 0; i--) {
                if (lastNum < arr[i]) {
                    swap = arr[i];
                    arr[i] = lastNum;
                    arr[j] = swap;
                    check = true;
                    break;
                }
            }
            if(check) break;
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        // Test code
        int[] arr = {3, 2, 1}; // 3 1 2
        solution(arr);

        arr = new int[]{1, 9, 4, 7, 6}; // 1 9 4 6 7
        solution(arr);

        arr = new int[]{1, 1, 2, 3}; // 1 1 2 3
        solution(arr);

        arr = new int[]{5, 7, 3, 4, 5}; // 5 5 3 4 7
        solution(arr);

        arr = new int[]{5, 7, 3, 6, 6}; // 5 6 3 6 7
        solution(arr);

        arr = new int[]{5, 7, 4, 3, 7}; // 5 7 3 4 7
        solution(arr);

        arr = new int[]{5, 4, 3, 7, 7}; // 5 3 4 7 7
        solution(arr);
    }
}
