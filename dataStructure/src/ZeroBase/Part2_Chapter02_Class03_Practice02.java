public class Part2_Chapter02_Class03_Practice02 {
    // target에 해당하는 값의 인덱스를 출력
    // 해당 값이 여러 개인 경우 가장 큰 인덱스 출력
    public static void main(String[] args) {
        int[] arr = {1, 1, 100, 1, 1, 1, 100};
        int cnt = -1;
        int targetData = 100;
        for(int i=0; i<arr.length; i++){
            if(arr[i] == targetData)
                cnt = i;
        }
        System.out.println(cnt);
    }
}
