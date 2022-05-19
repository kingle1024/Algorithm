import java.util.Scanner;

public class Practice1_04 {
    public static void main(String[] args) {
        start5();
    }
    public static int sc(){
        Scanner sc = new Scanner(System.in);
        int idx = sc.nextInt();
        return idx;
    }
    public static void start1(){
        int idx = sc();
        for(int i=0; i<idx; i++){
            for (int j = 0; j < idx; j++) {
                System.out.printf("*");
            }
            System.out.println();
        }
    }
    public static void start2(){
        int idx = sc();
        for (int i = 0; i < idx; i++) {
            for (int j = 0; j < i+1; j++) {
                System.out.printf("*");
            }
            System.out.println();
        }
    }
    public static void start3(){
        int idx = sc();
        for (int i = 0; i < idx; i++) {
            for (int j = 0; j < idx-i-1; j++) {
                System.out.printf(" ");
            }
            for (int k = 0; k < i+1; k++) {
                System.out.printf("*");
            }
            System.out.println();
        }
    }
    public static void start4(){
        int idx = sc();
        for (int i = 0; i < idx; i++) {
            for (int j = 0; j < idx-1-i; j++) {
                System.out.printf(" ");
            }
            for (int j = 0; j < 2*i+1; j++) {
                System.out.printf("*");
            }
            for (int j = 0; j < idx-1-i; j++) {
                System.out.printf(" ");
            }
            System.out.println();
        }
    }
    public static void start5(){
        int idx = sc();
        for (int i = 0; i < idx/2; i++) {
            for (int j = 0; j < (idx-1)/2-i; j++) {
                System.out.printf(" ");
            }
            for (int k = 0; k < 2*(i+1)-1; k++) {
                System.out.printf("*");
            }
            System.out.println();
        }
        for (int i = idx/2; i >= 0; i--) {
            for (int j = 0; j < (idx-1)/2-i; j++) {
                System.out.printf(" ");
            }
            for (int k = 0; k < 2*(i+1)-1; k++) {
                System.out.printf("*");
            }
            System.out.println();
        }
    }

}
