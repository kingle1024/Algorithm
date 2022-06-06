package ZeroBase.Class;

import java.util.Scanner;

public class Practice2_01 {
    public static void main(String[] args) {
        // 로마 숫자 표기를 정수형으로 변환하는 프로그램을 작성하세요.
        /*
            III -> 3
            IV -> 4
            VI -> 6
            XIII -> 13
            XXVI -> 26
            MCMXCIV -> 1994
         */
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        int arr[] = new int[input.length()];
        int result = 0;
        arr[0] = lomaToNum(input.charAt(0));
        result += arr[0];

        for (int i = 1; i < input.length(); i++) {
            if(lomaToNum(input.charAt(i-1)) < lomaToNum(input.charAt(i)) ){
                result -= lomaToNum(input.charAt(i-1));
                result = result + lomaToNum(input.charAt(i)) - lomaToNum(input.charAt(i-1));
            }else{
                result = result + lomaToNum(input.charAt(i));
            }
        }

        System.out.println(result);
    }
    public static int lomaToNum(char c){
        int num = -1;
        switch(c){
            case 'I':{
                num = 1;
                break;
            }
            case 'V':{
                num = 5;
                break;
            }
            case 'X':{
                num = 10;
                break;
            }
            case 'L':{
                num = 50;
                break;
            }
            case 'C':{
                num = 100;
                break;
            }
            case 'D':{
                num = 500;
                break;
            }
            case 'M':{
                num = 1000;
                break;
            }
        }
        return num;
    }
}
