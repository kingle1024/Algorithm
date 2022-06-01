public class Part2_Chapter02_Class03_Practice06 {
    // 배열 arr에서 중복 값을 제거한 새 배열을 만드시오.
    public static void main(String[] args) {
        int[] arr = {1, 5, 3, 2, 2, 3, 1, 4, 1, 2, 3, 5};
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr.length; j++){
                if(j == i) continue;
                else{
                    if(arr[i] == arr[j]){
                        arr[j] = -1;
                    }
                }
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] != -1)
                System.out.print(arr[i]+" ");
        }
        // 1 5 3 2 4
    }
}
