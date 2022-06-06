package ZeroBase.Class;

import java.util.Scanner;

public class Practice1_01 {
    public static void main(String[] args) {
        // 입력된 정수 자료형의 숫자를 거꾸로 변환하는 프로그램
        Scanner sc = new Scanner(System.in);
        StringBuffer sb = new StringBuffer();
        String str = sc.nextLine();
        String resultStr = "";
        for(int i=str.length()-1; i>=0; i--){
            if(str.charAt(i) != '-') {
                sb.append(str.charAt(i));
            }else{
                sb.insert(0, str.charAt(i));
            }
        }
        System.out.println(Integer.parseInt(String.valueOf(sb)));
    }
}
