package Baekjoon;

import java.util.Scanner;

// 평균은 넘겠지
public class BOK_4344 {
    public static void main(String[] args) {
        solution();
    }
    static void solution(){
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        double result[] = new double[num];
        for(int i=0; i<num; i++){
            int studentClass = sc.nextInt();
            double total = 0;
            double[] arr = new double[studentClass];
            for(int j=0; j<studentClass; j++){
                arr[j] = sc.nextDouble();
                total += arr[j];
            }
            double rate = 0;
            for (int k = 0; k < arr.length; k++) {
                if(total/studentClass < arr[k]){
                    rate++;
                }
            }
            double r = (rate*100)/studentClass;
            result[i] = r;
        }
        for(int i=0; i<num; i++){
            System.out.printf("%.3f",result[i]);
            System.out.println("%");
        }
    }
}
