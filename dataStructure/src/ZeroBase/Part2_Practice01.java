import java.util.Scanner;

public class Part2_Practice01 {
    public static void main(String[] args) {
        // 파스칼의 삼각형
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        int result[][] = new int[input][];
        result[0] = new int[]{1};
        int arr[] = new int[]{1};
        int idx = 1;

        result = pascal(input, arr, idx, result);

        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                System.out.print(result[i][j]);
            }
            System.out.println();
        }

    }
    static int[] solution(int arr[]){
        int resultArr[] = new int[arr.length+1];
        resultArr[0] = 1;
        resultArr[resultArr.length - 1] = 1;

        for(int i=1; i<arr.length; i++){
            resultArr[i] = arr[i-1] +arr[i];
        }
        return resultArr;
    }
    static int[][] pascal(int input, int[] arr, int idx, int[][] result){
        while(true){
            if(idx == input) {
                break;
            }
            arr = solution(arr);
            result[idx] = arr;
            idx++;
        }
        return result;
    }
}
