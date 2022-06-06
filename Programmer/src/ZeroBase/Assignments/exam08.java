package ZeroBase.Assignments;

import java.util.Scanner;

public class exam08 {
    public static void main(String[] args) {
        System.out.println("[과세금액 계산 프로그램]");
        System.out.print("연소득을 입력해 주세요.:");
        Scanner sc = new Scanner(System.in);
        int annualIncome = sc.nextInt();
        int incomeChanges = annualIncome;
        int taxArr[] = {0, 12000000, 46000000, 88000000, 150000000, 300000000, 500000000, 1000000000, Integer.MAX_VALUE};
        int progressiveArr[] = {0, 1080000, 5220000, 14900000, 19400000, 25400000, 35400000, 65400000};
        float tariffArr[] = {0.06f, 0.15f, 0.24f, 0.35f, 0.38f, 0.40f, 0.42f, 0.45f};
        int tariffTotal = 0; // 세율 전체
        int progressiveTotal = 0; // 누진공제 전체
        int taxBaseNum = 0; // 과세구간
        int annualIncomeSection = 0; // 과세표준
        for(int i=0; i<taxArr.length-1; i++){
            if(annualIncome > taxArr[i]){
                taxBaseNum = i;
            }else{
                break;
            }
        }

        for(int i=0; i<taxArr.length-1; i++){
            incomeChanges = annualIncome - taxArr[i];
            if(i < taxBaseNum){
                annualIncomeSection = taxArr[i+1] - taxArr[i];
                tariffTotal += (int)(annualIncomeSection * tariffArr[i]);
                System.out.printf("\t%10d * %2d%% = %10d\n",annualIncomeSection, (int)(tariffArr[i]*100), (int)((annualIncomeSection) * tariffArr[i]));
            }else{
                tariffTotal += (int)(incomeChanges * tariffArr[i]);
                System.out.printf("\t%10d * %2d%% = %10d\n", incomeChanges, (int)(tariffArr[i]*100), (int)((incomeChanges) * tariffArr[i]));
                if(annualIncome > 12000000) // 세율 6%일 때에는 누진공제 없음
                    progressiveTotal = (int)(annualIncome * tariffArr[i]) - progressiveArr[i];
                break;
            }
        }

        System.out.printf("\n[세율에 의한 세금]:\t\t\t\t%d\n",tariffTotal);
        System.out.printf("[누진공제 계산에 의한 세금]:\t\t%d",progressiveTotal);

    }
}
