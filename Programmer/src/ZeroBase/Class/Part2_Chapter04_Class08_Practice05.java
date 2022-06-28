package ZeroBase.Class;

import java.util.Arrays;

/*
    정수 num이 주어졌을 때,
    num 숫자에서 두 자리를 최대 한번만 교체하여 얻을 수 있는 최대값을 출력하세요.

 */
public class Part2_Chapter04_Class08_Practice05 {
    public static int solution(int num){
        String s = String.valueOf(num);
        int[] arr = new int[s.length()];
        int max = 1;
        arr[0] = Integer.parseInt(s.charAt(0)+"");
        for(int i=1; i<s.length(); i++){
            arr[i] = Integer.parseInt(s.charAt(i)+"");
            if(arr[max] < arr[i]){
                max = i;
            }
        }
//        System.out.println(max + " " + min);
        if(arr[max] > arr[0]){
            int temp = arr[0];
            arr[0] = arr[max];
            arr[max] = temp;
        }else{
            for(int i=1; i<max; i++){
                if(arr[i] < arr[max]){
                    int temp = arr[i];
                    arr[i] = arr[max];
                    arr[max] = temp;
                }
            }
        }
        String result = "";
        for(int i=0; i<arr.length; i++){
            result += String.valueOf(arr[i]);
        }
        return Integer.parseInt(result);
    }
    public static void main(String[] args) {
        // Test code
        System.out.println(solution(2736));
        System.out.println(solution(7116));
        System.out.println(solution(91));
        System.out.println(solution(19));
    }
}
