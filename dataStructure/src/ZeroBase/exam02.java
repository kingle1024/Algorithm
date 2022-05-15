class exam02{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("[캐시백 계산]");
        System.out.print("결제 금액을 입력해 주세요.(금액):");

        int paymentMoney = sc.nextInt(); // 결제 금액 입력
        int cashBack = 0;
        if(paymentMoney >= 3000){ // 2999
            cashBack = 300;
        }else{
            cashBack = (paymentMoney / 1000) * 100;
        }
        System.out.printf("결제 금액은 %d원이고, 캐시백은 %d원 입니다.", paymentMoney, cashBack);
    }
}