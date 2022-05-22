import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Part2_Practice01 {
    public static void main(String[] args) {
        // 파스칼의 삼각형
        int result[][] = new int[5][];
        List<List> arrayList = new ArrayList<List>();
        List<Integer> array = new ArrayList();
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        int arr[] = new int[]{1};
        int idx = 1;

        while(true){
            if(idx == input) {
                break;
            }
            array.add(solution(arr));
            idx++;
        }
        for (int i = 0; i < arr.length; i++) {
//            System.out.println(arr[i]);
//            result[i] = arr[i];
            arrayList.add((List) array.get(i));
        }
        for(Object a : array){
            System.out.println(a);
        }
    }
    static List solution(int test[]){
        int arr[] = new int[test.length+1];
        arr[0] = 1;
        arr[arr.length-1] = 1;
        for(int i=1; i<test.length; i++){
            arr[i] = test[i-1] +test[i];
        }
        return Arrays.asList(arr);
    }

}
