package ZeroBase.Class;

public class Part2_Practice01_05 {
    public static void main(String[] args) {
        int result = 0;
        result = solution(new int[][]{{1}});
//        result = solution(new int[][]{
//                {0,1,0,0},
//                {1,1,1,0},
//                {0,1,0,0},
//                {1,1,0,0}}
//        );
        System.out.println(result);

    }
    /*
        영토에 대한 지도 정보가 row x col grid 맵 형태로 다음과 같이 주어졌다.
        이 때, grid[i][j]가 1이면 땅 영역을 의미하고
        grid[i][j]가 0이면 물 영역을 의미한다.
        이와 같이 영토에 대한 지도 정보가 주어졌을 때 땅의 둘레를 구하는 프로그램을 작성하세요.
        - grid 한 cell의 변의 길이는 1이다.
        - 지도에는 하나의 독립된 영토만 있다. (분리된 땅 없음)
        - 땅 내부에 물이 존재하지 않는다.
     */
    static int solution(int arr[][]){
        int result = 0;
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr[i].length; j++){
                if(arr[i][j] == 0) continue;
                // top
                if(i-1 > -1 && arr[i-1][j] == 0){
                    result++;
                    System.out.println("top : arr["+i+"]["+j+"]");
                }else if(arr[i][j] == 1 && i-1 == -1){
                    result++;
                    System.out.println("top1 : arr["+i+"]["+j+"]");
                }
                // left
                if(j-1 > -1 && arr[i][j-1] == 0){
                    result++;
                    System.out.println("left : arr["+i+"]["+j+"]");
                }else if(arr[i][j] == 1 && j-1 == -1){
                    result++;
                    System.out.println("left1 : arr["+i+"]["+j+"]");
                }
                // right
                if(j+1 < arr[i].length && arr[i][j+1] == 0){
                    result++;
                    System.out.println("right: arr["+i+"]["+j+"]");
                }else if(arr[i][j] == 1 && j+1 == arr[i].length){
                    result++;
                    System.out.println("right1: arr["+i+"]["+j+"]");
                }
                // top
                if(i+1 < arr.length && arr[i+1][j] == 0){
                    result++;
                    System.out.println("bottom : arr["+i+"]["+j+"]");
                }else if(arr[i][j] == 1 && i+1 == arr.length){
                    result++;
                    System.out.println("bottom1 : arr["+i+"]["+j+"]");
                }
            }
        }
        return result;
    }
}
