import java.util.Arrays;

public class test02 {
    /*
    컴퓨터는 정수를 표현할 때, 자료형에 따라 표현 가능한 숫자의 범위가 정해져있다. 기산이는 이러한 한계를 해결하고자, 숫자를 배열로 표현하기로 하였다.

기산이가 선택한 방법은 아래와 같다.

양수의 경우, 숫자의 각 자리를 큰 자릿수부터 순서대로 배열에 저장한다.
음수는 사용하지 않는다.
0의 경우, 빈 배열로 표현한다.
위 방법을 이용하여 배열로 표현된 숫자의 예는 아래와 같다.

1523 -> {1, 5, 2, 3}
0 -> {}
기산이는 이 표현법을 이용하는 덧셈기를 구현하고자 한다.

첫 번째 인자인 a와 두 번째 인자인 b를 입력받아, 배열 표현법으로 결과를 출력하시오.


     */
    public static void main(String[] args) {
        int[] a = {5, 2, 1, 4, 6};
        int[] b = {6, 9, 0, 4, 4};

        System.out.println(Arrays.toString(solution(a,b)));
        int[] c = {1};
        int[] d = {9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9};
        System.out.println(Arrays.toString(solution(c,d)));
    }
    /*
    [9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9], [1]
    기댓값 〉
    [1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]

     */
    public static int[] solution(int[] a, int[] b){ // 1, 1, 1, 1, 1  <> 0, 0, 0, 1, 1
        int c[];
        if(a.length > b.length){
            c = new int[a.length];
            for(int i=0; i<c.length; i++){
                if(i < a.length-b.length){
                    c[i] = 0;
                }else{
                    c[i] = b[i - (a.length-b.length)]; // 3-i  3 4
                }
            }
            b = c;
        }else if(a.length < b.length){
            c = new int[b.length];
            for(int i=0; i<c.length; i++){
                if(i < b.length-a.length){
                    c[i] = 0;
                }else{
                    c[i] = a[i - (b.length-a.length)]; // 3-i  3 4
                }
            }
            a = c;
        }
        int[] answer = {};
        int temp = 0;
        int bit = 0;
        StringBuffer sb = new StringBuffer();
        for(int i=a.length-1; i>=0; i--){
            temp = a[i] + b[i];
            if(bit == 1){
                temp++;
                bit = 0;
            }

            if(temp >= 10){
                if(i == 0){
                    sb.append(temp-10);
                    sb.append(1);
                }else {
                    sb.append(temp - 10);
                }
                bit = 1;
            }else{
                sb.append(temp);
            }
        }
        String result = String.valueOf(sb);
        answer = new int[result.length()];
        for(int i=result.length()-1; i>=0; i--){
            answer[result.length()-i-1] = result.charAt(i)-48;
        }
//        System.out.println(sb);

        return answer;
    }
}
