import java.util.Scanner;

public class BOK_1789 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long N = sc.nextLong();
        long max = 0;
        long temp = 0;
        for(long i=1; i<=N; i++){
            if(N == 1) {
                max = 1;
            }
            temp = i*(i+1)/2;
            if(temp > N){
                max = i-1;
                break;
            }
        }
        System.out.println(max);
    }
}
