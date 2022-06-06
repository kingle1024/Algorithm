package ZeroBase.CodingTest;

public class coding02_05 {
    /*
    레나는 영상처리의 기초적인 계산 중 하나인 주변 평균을 구현하려고 한다.

주변 평균은 주변 KxK 픽셀값의 평균을 구해 픽셀 값을 대체하는 영상처리 기법이다.

예를 들면, 아래와 같은 2-D 배열로 표현된 이미지가 있다고 하자.


     */
    public static void main(String[] args) {
//        int[][] image = {
//                {4, 5, 2, 6, 7},
//                {5, 4, 2, 4, 6},
//                {6, 8, 4, 8, 7},
//                {7, 3, 6, 6, 4},
//                {5, 0, 4, 1, 5}};
//
//        solution(image, 3);

        int[][] image = {
                {4, 5, 2, 6, 7, 8, 9},
                {5, 4, 2, 4, 6, 8, 9},
                {6, 8, 4, 8, 7, 8, 9},
                {7, 3, 6, 6, 4, 8, 9},
                {5, 0, 4, 1, 5, 8, 9},
                {5, 0, 4, 1, 5, 8, 9},
                {5, 0, 4, 1, 5, 8, 9}
        };
        solution(image, 7);
    }
    public static int[][] solution(int[][] image, int K) {
        int[][] answer = {};
        answer = new int[image.length][image[0].length];
//        test(image, answer, K, 0, 4);
        for(int i=0; i<image.length; i++){
            for(int j=0; j<image[0].length; j++){
                call(image, answer, K, i, j);
            }
        }

//        print(answer);
        return answer;
    }
    public static void call(int[][] image, int[][] answer, int K, int a, int b){
        int temp = 0;

        for(int i=0; i<K; i++){
            if(a-(K/2)+i < 0) continue;
            if(a-(K/2)+i >= image.length) continue;
            for(int j=0; j<K; j++){
                if(b-(K/2)+j >= 0 && b-(K/2)+j < image[0].length) {
                    temp += image[a - (K/2) + i][b - (K/2) + j];
                }
            }
        }
        answer[a][b] = temp / (K*K);
    }
    public static void print(int[][] image){
        for(int i=0; i<image.length; i++){
            for(int j=0; j<image[0].length; j++){
                System.out.print(image[i][j]+" ");
            }
            System.out.println();
        }
    }
}
