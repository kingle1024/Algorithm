/*
데이터 재정렬
입력 예시)
입력 데이터 : 1 -> 2 -> 3 -> 4 -> 5
 */
package ZeroBase.Class;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class Part2_Chapter02_Class10_Practice01 {
    public static void reorderData(int[] arr){
        Deque d = new ArrayDeque();
        for(int i=0; i<arr.length; i++){
            d.add(arr[i]);
        }
        ArrayList array = new ArrayList();
        while(!d.isEmpty()){
            array.add(d.removeFirst());
            if(d.isEmpty()) {
                break;
            }
            array.add(d.removeLast());
        }
        System.out.println(array);

    }

    public static void main(String[] args) {
        // Test code
        int[] arr = {1, 2, 3, 4, 5};
        reorderData(arr); // 1 -> 5 -> 2 -> 4 -> 3
        int[] arr2 = {1, 2, 3, 4, 5, 6, 7};
        reorderData(arr2);
    }
}
