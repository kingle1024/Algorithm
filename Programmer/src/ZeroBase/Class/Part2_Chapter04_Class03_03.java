package ZeroBase.Class;

import java.util.*;
import java.util.LinkedList;

// 기수 정렬
public class Part2_Chapter04_Class03_03 {
    public static void radixSort(int[] arr){
        List<Queue<Integer>> list = new ArrayList<>();
        for(int i=0; i<10; i++){
            list.add(new LinkedList<>());
        }
        int idx = 0;
        int div = 1;
        int maxLen = getMaxLen(arr);

        for(int i=0; i<maxLen; i++) {
            for(int j=0; j<arr.length; j++) {
                list.get((arr[j] / div) % 10).offer(arr[j]);
            }
            for(int j=0; j<10; j++){
                Queue<Integer> queue = list.get(j);

                while(!queue.isEmpty()){
                    arr[idx++] = queue.poll();
                }
            }
            idx = 0;
            div *= 10;
        }
    }
    public static int getMaxLen(int[] arr){
        int maxLen = 0;
        int cnt = 0;
        for(int i=0; i<arr.length; i++){
            cnt = 0;
            int temp = arr[i];
            while(true){

                if(temp / 10 == 0){
                    break;
                }else{
                    temp = temp/10;
                    cnt++;
                }
            }
            if(maxLen < cnt){
                maxLen = cnt;
            }
//            int len = (int)Math.log10(arr[i]) + 1;
//            if(maxLen < len){
//                maxLen = len;
//            }
        }
        maxLen +=1 ;
        System.out.println(maxLen);
        return (maxLen);
    }
    public static void radixSort2(int[] arr){
        List<Queue> list = new ArrayList<>();

        for(int i=0; i < 10; i++){
            list.add(new LinkedList<>());
        }

        int idx = 0;
        int digit = 1;
        int maxLen = getMaxLen(arr);

        for(int i=0; i<maxLen; i++) {
            for(int j=0; j<arr.length; j++) {
                list.get((arr[j] / digit) % 10).offer(arr[j]);
            }

            for(int j=0; j<10; j++){
                Queue<Integer> queue = list.get(j);
                while(!queue.isEmpty()){
                    arr[idx++] = queue.poll();
                }
            }

            idx = 0;
            digit *= 10;
        }

    }
    public static void main(String[] args) {
        int[] arr = {10, 322, 52, 27, 48, 17, 99, 56};
        radixSort2(arr);
        System.out.println("기수 정렬 : " + Arrays.toString(arr));
    }
}
