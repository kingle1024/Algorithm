package Programmers;

class PGM_12945{
    public static void main(String[] args) {

    }
    public static int solution(int n) {
        int answer = 0;
        answer = fibo(n)%1234567;
        return answer;
    }
    public static int fibo(int n){
        long arr[] = new long[n];
        arr[0] = 0;
        arr[1] = 1;
        for(int i=2; i<n; i++){
            arr[i] = (arr[i-2] + arr[i-1]) % 1234567;
        }
//        for(int i=0; i<n; i++){
//            System.out.println(i+" : "+arr[i]);
//        }

        return (int)(arr[n-2] + arr[n-1]);
    }
}