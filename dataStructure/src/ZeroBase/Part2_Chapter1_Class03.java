import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;

public class Part2_Chapter1_Class03 {
    public static void main(String[] args) {
        // 두 개의 주사위를 던졌을 때 합히 3 또는 4의 배수일 경우의 수
        int[] dice1 = {1, 2, 3, 4, 5, 6};
        int[] dice2 = {1, 2, 3, 4, 5, 6};

        int nA = 0;
        int nB = 0;
        int nAandB = 0;

        // HashSet 이용
        HashSet<ArrayList> allCase = new HashSet<>();
        for(int item1: dice1){
            for(int item2: dice2){
                if((item1 + item2) % 3 == 0 || (item1 + item2) % 4 == 0){
                    ArrayList arrayList = new ArrayList(Arrays.asList(item1, item2));
                    allCase.add(arrayList);
                }
            }
        }
        System.out.println(allCase.toString());

        // 2. 곱의 법칙
        // 두 개의 주사위 a, b를 던졌을 때 a는 3의 배수, b는 4의 배수인 경우의 수
        Random d = new Random();
        int diceRandom1[] = {1, 2, 3, 4, 5, 6};
        int diceRandom2[] = {1, 2, 3, 4, 5, 6};
        nA = 0;
        nB = 0;
        for(int item1 : diceRandom1){
            if(item1 % 3 == 0){
                nA++;
            }
        }
        for(int item1 : diceRandom2){
            if(item1 % 4 == 0){
                nB++;
            }
        }

    }
}
