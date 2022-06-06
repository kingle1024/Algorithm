package ZeroBase.Class;

import java.util.ArrayList;
import java.util.HashSet;

public class Part2_Practice01_04 {
    /*
    주어진 양의 정수가 행복한 수 인지를 판별하는 프로그램을 작성하세요.

    행복한 수란,
    각 자리수를 제곱한 것을 더하는 과정을 반복했을 때 1로 끝나는 수 이다.
    행복한 수가 아니라면 1에 도달하지 못하고 같은 수열이 반복하게 된다.
     */
    public static void main(String[] args) {
        System.out.println(solution(19));
        System.out.println(solution(2));
        System.out.println(solution(61));
    }
    static boolean solution2(int num){
        HashSet<Integer> hash = new HashSet();
        boolean result = false;
        int hashSize = 0;
        int checkRecursion = num;
        while(true){
//            System.out.println("[1] "+checkRecursion +" "+hash.size());
            hashSize = hash.size();
            checkRecursion = happyNumber(checkRecursion);
            hash.add(checkRecursion);
//            System.out.println("[2] "+hash.size());
            if(hashSize == hash.size()){
//                System.out.println("[3] "+hashSize +" "+hash.size());
                break;
            }else if(checkRecursion == 1){
                result = true;
                break;
            }

        }

        return result;
    }
    static boolean solution(int num){
        boolean result = false;
        int recursionNum = num;
        int temp = 0;
        int checkRecursion = happyNumber(num);
        int idx = 0;

        do{
            recursionNum = happyNumber(recursionNum);

            if(recursionNum == 1){
                result = true;
                break;
            }else if(recursionNum == temp){
                break;
            }

            if(idx == 0) temp = recursionNum;
            idx++;
        }while(true);

        return result;
    }

    static int happyNumber(int num){
        ArrayList<String> array = new ArrayList();
        String temp = String.valueOf(num);
        int result = 0;
        for(int i=0; i<temp.length(); i++){
            array.add(temp.charAt(i)+"");
            result += (int)Math.pow(Double.parseDouble(temp.charAt(i)+""),2);
        }
        return result;
    }
}
