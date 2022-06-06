package ZeroBase.Class;

import java.util.Scanner;

public class Practice1_02 {
    public static void main(String[] args) {
        // 알파벳 대소문자 변경
//        System.out.println((int)'a');
//        System.out.println((int)'z');
//        System.out.println((int)'A');
//        System.out.println((int)'Z');
        Scanner sc = new Scanner(System.in);
        char input = sc.next().charAt(0);
        if((int)input > 96){
            System.out.println((char)(input - 32));
        }else{
            System.out.println((char)(input + 32));
        }
    }
}
