package ZeroBase.Class;

/*
    원형 루트 상에 n개의 주요소가 있다.
    각 주유소의 가스 보유량은 gas 배열에 주어지고,
    해당 주유소에서 다음 주유소로의 이동 비용은 cost 배열에 주어진다.

    어떤 위치에서 차량이 가스를 채워 출발하면 모든 주유소를 방문하고 원래의 위치로 돌아올 수 있는지
    계산하는 프로그램을 작성하세요.
 */
public class Part2_Chapter04_Class08_Practice04 {
    public static int solution(int[] gas, int[] cost){
        int[] temp = new int[gas.length];
        int result = -1;
        int checkR = 0;
        for(int i=0; i<gas.length; i++){
            temp[i] = gas[i]-cost[i];
            checkR += temp[i];
            if(result == -1 && temp[i] > 0){
                result = i;
            }
        }
        if(checkR < 0) {
            return result;
        }else{
            return -1;
        }
    }
    public static void main(String[] args) {
        // Test code
        int[] gas = {1, 2, 3, 4, 5};
        int[] cost = {3, 4, 5, 1, 2};
        System.out.println(solution(gas, cost));

        gas = new int[]{2, 3, 4};
        cost = new int[]{3, 4, 3};
        System.out.println(solution(gas, cost));
    }
}
