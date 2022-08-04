package ZeroBase.CodingTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
public class coding11_04 {
    static int min = Integer.MAX_VALUE;

    public static int solution(int money, int[] chips) {
        DFS(0,0, chips, money);
        return min;
    }
    public static void DFS(int L, int sum, int[] chips, int money) {
        if(sum > money) return;
        if(L >= min) return;
        if(sum == money) {
            min = Math.min(min, L);
        }else {
            for(int i = 0; i < chips.length; i++) {
                DFS(L + chips[chips.length-1], sum + chips[i], chips, money);
            }
        }
    }

    public static void main(String[] args){
        int[] chips = {1100, 500, 200, 150, 25};
        System.out.println(solution(3000, chips));
    }

}
