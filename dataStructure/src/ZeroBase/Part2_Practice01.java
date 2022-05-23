import java.util.ArrayList;
import java.util.Scanner;

public class Part2_Practice01 {
    public static void main(String[] args) {
        // 파스칼의 삼각형
//        Scanner sc = new Scanner(System.in);
//        int input = sc.nextInt();
//        int result[][] = new int[input][];
//        result[0] = new int[]{1};
//        int arr[] = new int[]{1};
//        int idx = 1;
//
//        result = pascal(input, arr, idx, result);
//
//        for (int i = 0; i < result.length; i++) {
//            for (int j = 0; j < result[i].length; j++) {
//                System.out.print(result[i][j]);
//            }
//            System.out.println();
//        }
        ArrayList<ArrayList<Integer>> array = new ArrayList<>();
        array = arraySolution(5);
        for(int i=0; i<array.size(); i++){
            for(int j=0; j<array.get(i).size(); j++){
                System.out.printf(String.valueOf(array.get(i).get(j)));
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
    static ArrayList<ArrayList<Integer>> arraySolution(int numRows){
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        result.add(list);
        for (int i = 1; i < numRows; i++) {
            list = new ArrayList<>();
            for (int j = 0; j < result.get(i-1).size()+1; j++) {
                if(j == 0){ // 처음일 때에
                    list.add(1);
                }else if(j == result.get(i-1).size()){ // 마지막일 때에
                    list.add(1);
                }else {
                    list.add(result.get(i-1).get(j-1) + result.get(i-1).get(j));
                }
            }
            result.add(list);
        }

        return result;
    }
}
