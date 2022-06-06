package ZeroBase.Assignments;

import java.util.Scanner;

public class exam02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("[캐시백 계산]");

        String strPaymentMoney = "";
        int paymentMoney; // 결제 금액 입력
        while(true) {
            System.out.print("결제 금액을 입력해 주세요.(금액):");
            strPaymentMoney = sc.nextLine();
            try{
                paymentMoney = Integer.parseInt(strPaymentMoney);
                while(true){
                    if(paymentMoney < 0){
                        throw new Exception();
                    }else{
                        break;
                    }
                }
                break;
            }catch(Exception e){
                System.out.println("잘못 입력하셨습니다. 0 이상의 숫자를 입력해주세요.");
            }
        }

        int cashBack = 0;
        if(paymentMoney >= 3000){ // 2999
            cashBack = 300;
        }else{
            cashBack = (paymentMoney / 1000) * 100;
        }
        System.out.printf("결제 금액은 %d원이고, 캐시백은 %d원 입니다.", paymentMoney, cashBack);
    }
}
