package Programmers;

public class PGM_118670 {
    public static void main(String[] args) {
        int[][] rc = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        String[] operations = {"Rotate", "ShiftRow"};
        solution(rc, operations);
        rc = new int[][]{
                {1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}
        };
        operations = new String[]{"ShiftRow", "Rotate", "ShiftRow", "Rotate"};
        solution(rc, operations);
    }
    public static int[][] solution(int[][] rc, String[] operations) {
        int[][] answer = {};

        for(int i=0; i<operations.length; i++){
            if(operations[i].equals("Rotate")){
                rc = rotate(rc);
            }else if(operations[i].equals("ShiftRow")){
                rc = shiftRow(rc);
            }
        }
//        System.out.println(rc);
        answer = rc;
        return answer;
    }
    public static int[][] rotate(int[][] rc){
        int[][] change = new int[rc.length][rc[0].length];
        if(rc.length != rc[0].length) {
            for (int i = 0; i < rc[0].length - 1; i++) {
                // 맨위
                change[0][i + 1] = rc[0][i];
                // 맨 아래
                change[rc.length - 1][rc[0].length - 2 - i] = rc[rc.length - 1][rc[0].length - 1 - i];
            }
            for (int i = 0; i < rc.length - 1; i++) {
                // 한칸씩 밑으로 이동
                change[i + 1][rc[0].length - 1] = rc[i][rc[0].length - 1];
                // 맨 왼쪽 처리
                change[rc.length - 2 - i][0] = rc[rc.length - 1 - i][0];

                if (i > 0) {
                    for (int j = 1; j < rc[0].length - 1; j++) {
                        change[i][j] = rc[i][j];
                    }
                }
            }
        }else{
            for (int i = 0; i < rc.length - 1; i++) {
                change[0][i + 1] = rc[0][i];
                change[rc.length - 1][rc[0].length - 2 - i] = rc[rc.length - 1][rc[0].length - 1 - i];
                change[i + 1][rc[0].length - 1] = rc[i][rc[0].length - 1];
                change[rc.length - 2 - i][0] = rc[rc.length - 1 - i][0];

                if (i > 0) {
                    for (int j = 1; j < rc[0].length - 1; j++) {
                        change[i][j] = rc[i][j];
                    }
                }
            }
        }

//        System.out.println(change);
        return change;
    }
    public static int[][] shiftRow(int[][] rc){
        int[][] change = new int[rc.length][rc[0].length];
        for (int i = 0; i < rc.length - 1; i++) {
            change[i + 1] = rc[i];
        }
        for (int j = 0; j < rc[0].length; j++) {
            change[0][j] = rc[rc.length - 1][j];
        }
//        System.out.println(change);
        return change;
    }
}
