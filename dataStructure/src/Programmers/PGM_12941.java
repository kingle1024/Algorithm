import java.util.Arrays;
class PGM_12941{
    public static void main(String[] args) {

    }

    public class test05 {
        public static void main(String[] args) {

            System.out.println(solution(new int[]{1,4,2}, new int[]{5, 4, 4}));
        }
        public static int solution(int []A, int []B)
        {
            int answer = 0;
            Arrays.sort(A);
            Arrays.sort(B);
            for(int i=0; i<A.length; i++){
                answer += A[i] * B[A.length -i -1];
            }
            // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.

            return answer;
        }
    }


}