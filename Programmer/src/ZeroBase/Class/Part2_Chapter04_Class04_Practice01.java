package ZeroBase.Class;

/*
    이진 탐색 추가 구현
    target 값이 arr 내에 있으면 해당 인덱스 반환
    없으면 해당 값이 있을 경우의 위치에 -1을 곱하고 1을 뺀 값을 반환

    입출력 예시
    입력 arr : 1, 2, 5, 10, 20, 30, 40, 50, 60

    target : 30
    출력 : 5

    target : 3
    출력 : -3
 */
public class Part2_Chapter04_Class04_Practice01 {
    public static int solution(int[] arr, int target){
        if(arr == null || arr.length == 0){
            return -1;
        }
        int left = 0;
        int right = arr.length-1;
        int mid = 0;
        while (true) {
            mid = (left+right)/2;
            if(left > right){
                return (left*-1)-1;
            }
            if(target == arr[mid]){
                break;
            }else if(target > arr[mid]){
                left = mid+1;
            }else if(target < arr[mid]){
                right = mid-1;
            }
        }

        return mid;
    }
    public static void main(String[] args) {
        // Test Code
        int[] arr = {1, 2, 5, 10, 20, 30, 40, 50, 60};
        System.out.println(solution(arr, 30));
        System.out.println(solution(arr, 3));
        System.out.println(solution(arr, 11));
        System.out.println(solution(arr, 35));
        System.out.println(solution(arr, 65));
        System.out.println(solution(arr, 0));

        System.out.println("===");
        arr = new int[]{4, 5, 6, 7, 8, 9, 1, 2};
        System.out.println(solution(arr, 0));
        System.out.println(solution(arr, 3));

    }
}
