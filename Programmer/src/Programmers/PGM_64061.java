package Programmers;

import java.util.Stack;
class PGM_64061{
    public static void main(String[] args) {

    }
    class Solution {
        public int solution(int[][] board, int[] moves) {
            int answer = 0;
            int temp = 99999;
            Stack<Integer> stack = new Stack<>();
            for(int k=0; k<moves.length; k++){
                for(int i=0; i<board.length; i++){
                    if(board[i][moves[k]-1] == 0 ){
                        continue;
                        // 다음 줄로 넘어가고 아무 일도 일도 일어나지 않음
                    }else{ // 만약 0이 아니면 0으로 처리하고 stack에 넣는다.
                        // 스택에 데이터 넣어주기
                        if(stack.isEmpty()){
                            stack.push(board[i][moves[k]-1]);
                            board[i][moves[k]-1] = 0; // 어찌되었든 해당 위치는 0으로 처리
                        }else{
                            temp = stack.pop(); // stack에서 1개 빼기
                            if(temp == board[i][moves[k]-1]){ // 같은 숫자면
                                answer+=2;
                            }else{
                                stack.push(temp);
                                stack.push(board[i][moves[k]-1]);
                            }
                            board[i][moves[k]-1] = 0; // 어찌되었든 해당 위치는 0으로 처리
                        }
                        break;
                    }
                }
            }
            return answer;
        }
    }
    /*
    [0,0,0,0,0],
    [0,0,1,0,3],
    [0,2,5,0,1],
    [4,2,4,4,2],
    [3,5,1,3,1]]
    */
    // [1,5,3,5,1,2,1,4]
    // 4 3 1 1 3 2 ? 4
    // 터트렸더니, 다음 문자가 또 터지는 경우
}