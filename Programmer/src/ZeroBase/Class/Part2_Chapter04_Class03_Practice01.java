package ZeroBase.Class;

/*
 nums 배열에 3가지 색으로 구분되는 데이터들이 들어 있다.
 0은 흰색, 1은 파랑, 2는 빨강이라고 할때
 주어진 nums 배열에서 흰색 부터 빨강 순으로 인접하게 정렬시킨 후 출력하는 프로그램을 작성 하시오
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class Part2_Chapter04_Class03_Practice01 {
    public static void solution(int[] arr){
        if(arr == null || arr.length == 0) return;
        HashMap<Integer, Integer> hash = new HashMap<>();
        for(int i=0; i<arr.length; i++){
            hash.put(arr[i], hash.getOrDefault(arr[i], 0) + 1);
        }
        ArrayList<Integer> array = new ArrayList<>(hash.keySet());
        Collections.sort(array);

        int idx = 0;
        for(int i=0; i<array.size(); i++){
            int cnt = hash.get(array.get(i));
            while(cnt > 0){
                arr[idx++] = array.get(i);
                cnt--;
            }
        }
    }
    public static void main(String[] args) {
        // Test Code
        int[] arr = {2, 0, 2, 1, 1, 0};
        solution(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println();

        arr = new int[]{2, 0, 1};
        solution(arr);
        System.out.println(Arrays.toString(arr));
    }
}
