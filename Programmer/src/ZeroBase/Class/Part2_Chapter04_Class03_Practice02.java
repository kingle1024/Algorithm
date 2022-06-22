package ZeroBase.Class;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

/*
 Practice02
 문자열 배열 strs가 주어졌을 때 anagram으로 묶어서 출력하는 프로그램을 작성하세요.
 anagram은 철자 순서를 바꾸면 같아지는 문자를 의미한다.
 예) elvis <-> lives
 anagram 그룹 내에서 출력 순서는 상관 없다.

 입력 : "eat", "tea", "tan", "ate", "nat", "bat"
 출력 : [[eat, tea, ate], [bat], [tan, nat]]
 */
public class Part2_Chapter04_Class03_Practice02 {
    public static ArrayList<ArrayList<String>> solution(String[] strs){
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        String[] strSort = strs.clone();
        for(int i=0; i<strSort.length; i++){
            char[] cArr = strSort[i].toCharArray();
            sort(cArr);
            strSort[i] = String.valueOf(cArr);
            ArrayList<String> array = map.getOrDefault(strSort[i], new ArrayList<>());
            array.add(strs[i]);
            map.put(strSort[i], array);
        }
        return new ArrayList<>(map.values());
//        ArrayList<String> mapArray = new ArrayList<>(map.keySet());
//
//        ArrayList<ArrayList<String>> result = new ArrayList<>();
//        for(int i=0; i<mapArray.size(); i++){
//            result.add(map.get(mapArray.get(i)));
//        }

//        for(int i=0; i<result.size(); i++){
//            for(int j=0; j<result.get(i).size(); j++){
//                System.out.print(result.get(i).get(j)+" ");
//            }
//            System.out.println();
//        }

//        return result;
    }
    public static void sort(char[] arr){
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0; i<arr.length; i++){
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        int idx = 0;
        ArrayList<Character> array = new ArrayList<>(map.keySet());
        for(int i=0; i<array.size(); i++){
            int cnt = map.get(array.get(i));
            while(cnt > 0){
                arr[idx++] = array.get(i);
                cnt--;
            }
        }
//        System.out.println(Arrays.toString(arr));
    }
    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(solution(strs));

        strs = new String[]{"abc", "bac", "bca", "xyz", "zyx", "aaa"};
        System.out.println(solution(strs));
    }
}
