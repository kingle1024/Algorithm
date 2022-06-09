package ZeroBase.CodingTest;

public class coding03_01 {
    public static void main(String[] args) {
        int[][] trust = {{1,3}, {2,3}};
        System.out.println(solution(3, trust));
        int[][] trust2 = {{1, 2}, {1, 4}, {1, 3}, {2, 1}, {4, 3}};
        System.out.println(solution(4, trust2));
    }
//    public static int solution(int N, int[][] trust){
//        for(int i=0; i<trust.length-1; i++){
//            if(trust[i][1] != trust[i+1][1]){
//                return -1;
//            }
//            if(trust[i][0] == trust[i][1]){
//                return -1;
//            }
//        }
//        if(trust[trust.length-1][0] == trust[trust.length-1][1]){
//            return -1;
//        }
//
//        return trust[0][1];
//    }
    public static int solution(int N, int[][] trust){
        int arr[] = new int[N];
        int total = (N*(N+1))/2;
        for(int i=0; i<trust.length; i++){
            arr[trust[i][0]-1] = -1;
            arr[trust[i][1]-1] = arr[trust[i][1]-1] + trust[i][0];
        }
        boolean check = false;
        int idx=  0;
        for(int i=0; i<arr.length; i++){
            if(arr[i]+i+1 == total){
                check = true;
                idx = i;

            }
        }
        if(check){
            return idx+1;
        }else {
            return -1;
        }
    }
}
