package ZeroBase.Class;

import java.util.ArrayList;

// 약수 구하기, 두 수의 최대공약수와 최소공배수 구하기
// 활용) 1~10의 수 중 A의 약수 또는 B의 약수인 경우의 수
// 활용) 1~10의 수 중 A의 약수이면서 B의 약수인 경우의 수
public class Part2_Chapter1_Class03_Practice {
    // 약수
    public static ArrayList getDivisor(int num){
        ArrayList result = new ArrayList();
        for(int i=1; i<=(int)num/2; i++){
            if(num % i == 0)
                result.add(i);
        }
        return result;
    }
    // 최대 공약수
    public static int getGCD(int numA, int numB){
        if(numA < 1) return -1;
        int gcd = 1;
        int min = -1;
        if(numA > numB){
            min = numB;
        }else{
            min = numA;
        }
        for(int i=2; i<=min; i++){
            if(numA % i == 0 && numB % i == 0){
                gcd = i;
                break;
            }
        }

        return gcd;
    }
    // 최소 공배수 (두 수 * 최대 공약수)
    public static int getLCM(int numA, int numB){
        int lcm = -1;
        lcm = (numA*numB) / getGCD(numA, numB);
        return lcm;
    }
    public static void main(String[] args) {
        System.out.println(getDivisor(6).toString());
        System.out.println(getGCD(0, 5));
        System.out.println(getGCD(3, 4));
        System.out.println(getLCM(4,6));
    }
}
