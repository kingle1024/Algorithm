package ZeroBase.Class;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

/*
    nums1과 nums2 두 배열이 주어졌을 때
    두 배열의 공통 원소를 배열로 반환하는 프로그램을 작성하세요.
    결과 배열의 원소에는 중복 값이 없도록 하며 순서는 상관 없다.

    입출력 예시
    nums1 : 1, 2, 2, 1
    nums2 : 2, 2
    출력 : 2

    nums1 : 4, 9, 5
    nums2 : 9, 4, 9, 8, 4
    출력 : 4, 9 (or 9, 4)

 */
public class Part2_Chapter04_Class07_Practice02 {
    public static int[] solution(int[] nums1, int[] nums2){
        HashSet<Integer> hash1 = new HashSet();
        for (int num : nums1){
            hash1.add(num);
        }
        HashSet<Integer> hash2 = new HashSet();
        for (int num : nums2){
            hash2.add(num);
        }
        Iterator<Integer> iterator = hash1.iterator();
        ArrayList<Integer> array = new ArrayList<>();
        while(iterator.hasNext()){
            int num = iterator.next();
            if(hash2.contains(num)){
                array.add(num);
            }
        }
        int[] result = new int[array.size()];
        for(int i=0; i<array.size(); i++){
            result[i] = array.get(i);
        }

//            while(true){
//                if(nums1[idx1] == nums1[idx1+1]){
//                    idx1 += 1;
//                }
//                if(idx1 == nums1.length-1) break;
//            }
//            while(true){
//                if(nums2[idx2] == nums2[idx2+1]){
//                    idx2 += 1;
//                }
//                if(idx2 == nums2.length-1) break;
//            }
//
//            if(nums1 == nums2){
//                array.add(nums1[idx1]);
//            }else{
//                if(nums1[idx1] < nums2[idx2]){
//                    idx1++;
//                }else{
//                    idx2++;
//                }
//            }
//            if(idx1 == nums1.length || idx2 == nums2.length) break;

        return result;
    }
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        System.out.println(Arrays.toString(solution(nums1, nums2)));

        nums1 = new int[]{4, 9, 5};
        nums2 = new int[]{9, 4, 9, 8, 4};
        System.out.println(Arrays.toString(solution(nums1, nums2)));

        nums1 = new int[]{1, 7, 4, 9};
        nums2 = new int[]{7, 9};
        System.out.println(Arrays.toString(solution(nums1, nums2)));
    }
}
