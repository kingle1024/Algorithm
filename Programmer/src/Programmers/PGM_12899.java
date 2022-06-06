public class PGM_12899 {
    public static void main(String[] args) {
        int n = 30;
        for(int i=1; i<=n; i++){
            System.out.println(i +"->"+solution(i));
        }
//        System.out.println(solution(50000));
        System.out.println(solution2(n));
    }
    public static String solution2(int n){
        String result =  "";
        if(n % 3 == 0){
            result += "4";
            result = factorization((n/3)-1) + result;
        }
        return result;
    }
    public static String factorization(int n){
//        13 / 3
        String result = "";
        int temp = n;
        while(true){
            if(temp == 0) break;
            result = Integer.toString(temp - (3 * (temp / 3)))  + result;
//            System.out.println(temp - (n * (temp / n)));
            temp = temp / 3;
        }
//        return Integer.parseInt(result);
        return result;
    }

    public static String solution(int n) {
        String answer = "";
        int arr[] = new int[n+1];
        arr[1] = 1;

        int tempN = n;
        boolean check = false;

        for(int i=2; i <= n; i++){
            if(arr[i-1] % 10 == 1){
                arr[i] = arr[i-1]+1;
                continue;
            }else if(arr[i-1] % 10 == 2){
                arr[i] = arr[i-1]+2;
                continue;
            }else{
                tempN = arr[i-1]+1;
                arr[i] = tempN;
            }

            while(true){ // arr[i]에 1 더하기
                int firstNum = Integer.parseInt(String.valueOf(arr[i]).charAt(0)+"");
                if(arr[i] > 10 && (firstNum == 3 || firstNum == 6 || firstNum == 9)){
//                    System.out.println("hi : "+tempN+" | "+firstNum+" | "+arr[i]+" | "+mul(arr[i]));
                    arr[i] = arr[i] + mul(arr[i]);
                }

                while(true){ // 모든 자리수 체크하는 과정
                    if(tempN == 0){
                        check = false;
                        break;
                    } // 321
                    if(fun1(tempN)){ // 각 자리수가 1,2,4가 맞는지 확인
                        tempN = tempN / 10; // 맞으면 다음 자리 숫자 체크
                    }else{
                        check = true; // 하나라도 틀리면 빠져나가기
                        break;
                    }
                }

                if(check){
                    arr[i]++;
                    tempN = arr[i];
                }else{
                    break;
                }
            }
        }
        answer = String.valueOf(arr[n]);
        return answer;
    }
    static boolean fun1(int num){ // 마지막 자리수가 1, 2, 4인지 확인하는 함수
        int temp = num %10;
        boolean check = false;
        if(temp == 1){
            check = true;
        }else if(temp == 2){
            check = true;
        }else if(temp == 4){
            check = true;
        }
        return check;
    }
    static int mul(int num){
        int nLength = String.valueOf(num).length();
        int result = 1;
        for(int i=1; i<nLength; i++){
            result *= 10;
        }
        return result;
    }
}
