package ZeroBase.Class;

import java.util.Arrays;

/*
    양의 정수 배열 prices가 주어졌다.
    각 원소의 의미는 날짜 별 주식 가격을 의미한다.
    한 번에 한 주만 보유할 수 있다고 할 때 prices를 보고 사고 팔기를 반복해서
    얻을 수 있는 최대 수익을 반환하는 프로그램을 작성하세요.
 */
public class Part2_Chapter04_Class08_Practice02 {
    public static int solution(int[] prices){
        int result = 0;
        for(int i=0; i<prices.length-1; i++){
            if(prices[i] < prices[i+1]){
                result = result - prices[i] + prices[i+1];
            }
        }

        return result;
    }
    public static void main(String[] args) {
        // Test code
        int[] prices = {5, 1, 6, 4, 3, 5}; // 1 3 4 5 5 6
        System.out.println(solution(prices));

        prices = new int[]{1, 2, 3, 4, 5};
        System.out.println(solution(prices));

        prices = new int[]{5, 4, 3, 2, 1};
        System.out.println(solution(prices));
    }
}
