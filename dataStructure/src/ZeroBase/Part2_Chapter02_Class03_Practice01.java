public class Part2_Chapter02_Class03_Practice01 {
    // 짝수 데이터들의 평균과 홀수 데이터들의 평균을 출력하시오.

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int odd = 0; // 홀수
        int oddCnt = 0;
        int even = 0; // 짝수
        int evenCnt = 0;
        for(int i=0; i<arr.length; i++){
            if(arr[i] % 2 == 0){
                even += arr[i];
                evenCnt++;
            }else{
                odd += arr[i];
                oddCnt++;
            }
        }
        System.out.println(even / evenCnt);
        System.out.println(odd / oddCnt);
    }
}
