package ZeroBase.Class;

/*
    양의 정수 n이 주어지고 다음의 연산을 수행할 수 있을 때,
    1. n이 짝수인 경우, 2로 나누기 연산
    2. n이 홀수일 때는 1을 더하거나 1을 빼는 연산
    주어진 n이 1이 되는데 필요한 최소한의 연산 횟수를 반환하세요.
 */
public class Part2_Chapter04_Class08_Practice03 {
    public static int solution(int n){
        int cnt1 = 0;
        int cnt2 = 0;
        int n1 = n;
        int n2 = n;
        while(n1 != 1){
            if(n1%2 == 0) {
                n1 /= 2;
                cnt1++;
            }else if(n1%2 == 1){
                n1 +=1;
                cnt1++;
            }else if(n1 == 0){
                cnt1 = Integer.MAX_VALUE;
                break;
            }else{
                break;
            }
        }

        while(n2 != 1){
            if(n2 %2 == 0){
                n2 /= 2;
                cnt2++;
            }else if(n2 %2 == 1){
                n2 -=1;
                cnt2++;
            }else if(n2 == 0){
                cnt2 = Integer.MAX_VALUE;
                break;
            }else{
                break;
            }
        }

        return cnt1 > cnt2 ? cnt2 : cnt1;
    }
    public static int solution2(int n){
        if(n == 0 || n == 2){
            return 1;
        }
        if(n == 1){
            return 0;
        }

        int cnt = 0;
        while(n != 1){
            if(n == 3){
                cnt += 2;
                break;
            }

            if(n % 2 == 0){
                n /=2;
            }else if((n+1)%4 == 0){
                n +=1;
            }else if((n-1)%4 == 0){
                n -=1;
            }
            cnt++;
        }
        return cnt;
    }
    public static void main(String[] args) {
        // Test code
        System.out.println(solution(8)); // 3
        System.out.println(solution(7)); // 4
        System.out.println(solution(9)); // 4
        System.out.println(solution(6)); // 3
    }
}
