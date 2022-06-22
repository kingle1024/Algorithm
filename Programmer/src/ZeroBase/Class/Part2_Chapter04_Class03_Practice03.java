package ZeroBase.Class;

/*
    intervals 라는 구간으로 이루어진 배열이 주어졌을 때,
    오버랩 되는 구간을 합치는 프로그램을 작성하세요.
    합친 구간은 오름차순으로 정렬해서 반환하시오.

    입출력 예시
    입력 : [2, 6], [1, 3], [15, 18], [8, 10]
    출력 : [1, 6], [8, 10], [15, 18]

 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Part2_Chapter04_Class03_Practice03 {
    public static ArrayList<int[]> solution(int[][] intervals){
        if(intervals == null || intervals.length < 2){
            return new ArrayList<>();
        }
        boolean[] checkArr = new boolean[intervals.length];
        int length = 0;

        Arrays.sort(intervals, Comparator.comparingInt(o1 -> o1[0]));

        for(int i=0; i<intervals.length; i++){
            for(int j=intervals[i][0]; j<=intervals[i][1]; j++){
                for(int k=i+1; k<intervals.length-1; k++){
                    if(!checkArr[k]) {
                        if (intervals[k][0] == j || intervals[k][1] == j) {
                            if (intervals[i][0] > intervals[k][0]) {
                                intervals[i][0] = intervals[k][0];
                            }
                            if(intervals[i][1] < intervals[k][1]){
                                intervals[i][1] = intervals[k][1];
                            }
                            checkArr[k] = true;
                            length++;
                        }
                    }
                }
            }
        }

        int cnt = 0;
        int result[] = new int[intervals.length - length];
        ArrayList<int[]> resultArray = new ArrayList<>();
        for(int i=0; i<intervals.length; i++){
            if(!checkArr[i]){
                resultArray.add(intervals[i]);
            }
        }

        return resultArray;
    }
    public static void main(String[] args) {
        // Test code
        int[][] intervals = {{2, 6}, {1, 3}, {15, 18}, {8, 10}};
//        solution(intervals);
        for(int[] item : solution(intervals)){
            System.out.println(Arrays.toString(item) + " ");
        }
        System.out.println();
    }
}
