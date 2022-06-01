public class Part2_Chapter02_Class03_Practice05 {
    // 오름차순으로 정렬하기
    public static void main(String[] args) {
        int[] arr = {5, 3, 1, 4, 6, 1};
        int[] visited = arr.clone();
        int min = Integer.MAX_VALUE;
        int idx = 0;
        int catchCnt = 0;
        int outCnt = 0;
        while(true){
            if(visited[idx] != 0 && min >= arr[idx] ){
                min = arr[idx];
                catchCnt = idx;
            }
            idx++;

            if(idx == visited.length) {
                visited[catchCnt] = 0;
                idx = 0;
                System.out.print(min+" ");
                outCnt++;
                min = Integer.MAX_VALUE;
            }
            if(outCnt == visited.length)
                break;
        }
    }
}
