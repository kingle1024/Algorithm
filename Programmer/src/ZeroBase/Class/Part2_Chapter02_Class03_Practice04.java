package ZeroBase.Class;

public class Part2_Chapter02_Class03_Practice04 {
    // 배열 arr에서 peek 값 모두 출력
    // peek란 양 옆에 idx보다 큰 숫자다.
    public static void main(String[] args) {
        int[] arr = {3, 1, 2, 6, 2, 2, 5, 1, 9, 10, 1, 11};
//        for(int i=0; i<arr.length; i+=3){
//            System.out.print(arr[i] +" ");
//            if(i+3 >= arr.length) {
//                System.out.print(arr[arr.length-1]);
//            }
//        }
        if(arr[0] > arr[1]){
            System.out.print(arr[0]+" ");
        }
        for(int i=1; i<arr.length-1; i++){
            if(arr[i-1] < arr[i] && arr[i+1] < arr[i]){
                System.out.print(arr[i]+" ");
            }
        }
        if(arr[arr.length-2] < arr[arr.length-1]){
            System.out.print(arr[arr.length-1]+" ");
        }
    }
}
