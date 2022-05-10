import java.util.Arrays;

class PGM_86051{
    public static void main(String[] args) {
        // https://programmers.co.kr/learn/courses/30/lessons/86051
        // 없는 숫자 더하기
    }
    public int solution(int[] numbers) {
        int arr[] = new int[10];
        int answer = 0;
        Arrays.fill(arr, -1);
        for(int i=0; i<numbers.length; i++){
            arr[numbers[i]] = numbers[i];
        }
        for(int i=0; i<10; i++){
            if(arr[i] == -1){
                answer += i;
            }
        }

        return answer;
    }
}