package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOK_2108 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int loop = Integer.parseInt(br.readLine());
        ArrayList<Integer> arrayList = new ArrayList<>();
        int sum = 0;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int maxKey = -1;
        int maxValue = -1;
        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<loop; i++){
            int num = Integer.parseInt(br.readLine());
            arrayList.add(num);
            sum += num;

            // 범위
            if(num >= max){
                max = Math.max(num, max);
            }else if(num < max){
                min = Math.min(num, min);
            }

            int value = map.getOrDefault(num, 0);
            int nextValue = value+1;
            map.put(num, nextValue);

            if(nextValue > maxValue){
                maxValue = nextValue;
                maxKey = num;
            }
        }

        // 반올림
        System.out.println(Math.round((double) sum / arrayList.size()));

        // 중앙값
        Collections.sort(arrayList);
        System.out.println(arrayList.get(arrayList.size()/2));

        // 최빈값 (자주 나오는 값)
        Iterator<Integer> iter = map.keySet().iterator();
        ArrayList<Integer> manyValues = new ArrayList<>();
        while(iter.hasNext()){
            int key = iter.next();
            if(map.get(key) == maxValue){
                manyValues.add(key);
            }
        }

        Collections.sort(manyValues);
//        System.out.println("size:"+manyValues.size());
        if(manyValues.size() > 1){
            System.out.println(manyValues.get(1));
        }else{
            System.out.println(manyValues.get(0));
        }

        // 범위
        if(loop != 1) {
            System.out.println(arrayList.get(arrayList.size()-1) - arrayList.get(0));
        }else
            System.out.println("0");
    }
}
