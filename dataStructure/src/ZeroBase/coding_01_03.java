public class coding03 {
    public static void main(String[] args) {

    }
    /*
    자연수 N이 주어지면, N의 각 자릿수의 합을 구해서 return 하는 solution 함수를 만들어 주세요.
예를들어 N = 123이면 1 + 2 + 3 = 6을 return 하면 됩니다.

     */
    public int solution(int n) {
        int answer = 0;
        String temp = Integer.toString(n);
        for(int i=0; i<temp.length(); i++){
            answer += Integer.parseInt(temp.charAt(i)+"");
        }
        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        // System.out.println("Hello Java");

        return answer;
    }
}
