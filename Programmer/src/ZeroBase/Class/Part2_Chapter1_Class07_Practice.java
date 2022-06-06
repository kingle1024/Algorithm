package ZeroBase.Class;

public class Part2_Chapter1_Class07_Practice {
    static double powRecursion(int n, double recursion){
        if(n < 0) n *= -1;
        if(recursion < 0) recursion *= -1;
        else if(recursion > 0 && recursion < 1){

        }else if(recursion == 1) return n;
        return powRecursion(n, recursion-1) * n;
    }
    static double pow(int n, double r){
        double result = powRecursion(n,r);
        if(r < 0) result = 1.0 / result;
        if(n < 0) result = result * -1;

        return result;
    }
    static double sqrt(int a){
        double result = 1;

        for(int i = 0; i < 10; i++){
            result = (result + (a / result)) / 2;
        }

        return result;
    }
    public static void main(String[] args) {
        // Test Code
        System.out.println("== Math pow ==");
        // 1. 제곱, 제곱근, 지수
        System.out.println(Math.pow(2,-4));
        System.out.println(Math.pow(2,-3));

        System.out.println("== My Pow ==");
        System.out.println(pow(2,3));
        System.out.println(pow(2, -3));
        System.out.println(pow(-2, -3));
//        System.out.println(pow(16, 1.0/2));
//
        System.out.println("== 제곱근 ==");
        System.out.println(Math.sqrt(16));
        System.out.println(Math.sqrt(9));
        System.out.println(Math.sqrt(10));
        System.out.println(Math.pow(16, 1.0/2));
//        System.out.println(Math.pow(16, 1.0/4));


//
//        // 참고) 절대 값
//        System.out.println("== 절대 값 ==");
//        System.out.println(Math.abs(5));
//        System.out.println(Math.abs(-5));
//
//        // 2. 로그
//        System.out.println("== 로그 ==");
//        System.out.println(Math.E);
//        System.out.println(Math.log(Math.E));
//        System.out.println(Math.log10(1005));
//        System.out.println(Math.log(4) / Math.log(2)); // log_2 ^4 => 2
//        System.out.println(Math.log1p(10));
    }
}
