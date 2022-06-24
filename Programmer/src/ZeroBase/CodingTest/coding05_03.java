package ZeroBase.CodingTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class coding05_03 {
    public static void main(String[] args) {
        int[] arr ={-3, 0, 3, 4, 5, 12, 15, 14, 12, 11};
        System.out.println(solution(arr));
        System.out.println("=====");

        int[] arr2= {-5, 4, 6, 12, 16, 17};
        System.out.println(solution(arr2));
    }
    public static int solution(int[] arr){
        int answer = -1;
        int left = 0;
        int right = arr.length-1;
        while(left < right){
            int mid = (left + right) / 2;
            if(arr[mid] < arr[mid+1]){
                left = mid+1;
            }else{
                right = mid; // -1하면 틀린다.
            }
//            System.out.println(mid +" "+left +" " + right);
            if(left == right && left == arr.length-1){
                return -1;
            }else if (left == right && left == 0) {
                return -1;
            }
        }

        return left;
    }
    public static int solution3(int[] arr) {
        int answer = -1;

        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<arr.length; i++){
            map.put(arr[i], i);
        }

        ArrayList<Integer> array = new ArrayList<>(map.keySet());
        Collections.sort(array);
        for(int i=array.size()-1; i>=0; i--){
            int idx = map.get(array.get(i));
            if(idx == 0 || idx == arr.length-1) continue;
            if(arr[idx-1] < arr[idx] && arr[idx+1] < arr[idx]){
                answer = idx;
                break;
            }
        }

//        for(int i=1; i<arr.length-1; i++){
//            if(arr[i-1] < arr[i] && arr[i+1] < arr[i]){
//                answer = i;
//                break;
//            }
//        }
        System.out.println(answer);
        return answer;
    }

    /*
    public static int solution(int[] arr) {
        if( arr.length < 2) return -1;
        int answer = -1;
        for(int i=1; i<arr.length-1; i++){
            if(arr[i-1] < arr[i] && arr[i+1] < arr[i]){
                answer = i;
                break;
            }
        }
//        System.out.println(answer);
        return answer;
    }
     */
}
