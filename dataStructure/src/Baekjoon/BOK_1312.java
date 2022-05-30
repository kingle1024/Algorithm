import java.util.Scanner;

public class BOK_1312 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int N = sc.nextInt();

        if(A/B > 0){
            A = A-(B*(A/B));
        }
//        System.out.println(A);
        int cnt = 0;
        int temp = 0;
        while(true){
            temp = A * 10 / B; // temp는 몫
            A = A * 10 % B;
//            System.out.println(A+"|"+temp);
            cnt++;
            if(cnt == N) break;
        }
        System.out.println(temp);
        sc.close();
    }
}
