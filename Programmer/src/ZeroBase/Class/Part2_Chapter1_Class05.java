package ZeroBase.Class;

public class Part2_Chapter1_Class05 {
    public static void main(String[] args) {
//        1. 조합
        System.out.println("== 조합 ==");
//        서로 다른 4명 중 주번 2명 뽑는 경우의 수
        int n = 4;
        int r = 2;
        System.out.println(factorial(4) / (factorial((n-r)) * factorial(r)));

//        2. 중복 조합
        System.out.println("== 중복 조합 ==");
//        후보 2명, 유권자 3명일 때 무기명 투표 경우의 수
        n = 2;
        r = 3;
        System.out.println(factorial(n+r-1) / (factorial(n+r-1-r) * factorial(r)) );
    }
    public static int factorial(int n){
        int result = 1;
        for(int i=2; i<=n; i++){
            result *=i;
        }
        return result;
    }
}
