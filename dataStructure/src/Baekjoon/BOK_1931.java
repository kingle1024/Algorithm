import java.util.*;
public class BOK_1931 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        boolean check = false;
        int cnt = 0;
        int max = 0;

        int arr[][] = new int[num][2];
        for(int i=0; i<num; i++){
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
            if(max < arr[i][1]){
                max = arr[i][1];
            }
        }
        Arrays.sort(arr, new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1] == o2[1]){
                    return o1[0] - o2[0];
                }
                return o1[1] - o2[1];
            }
        });

        int land[] = new int[max+1];

        for(int i=0; i<arr.length; i++){
            check = false;

            for(int z = arr[i][0]+1; z <= arr[i][1]; z++){
                if(land[z] == 1) break;
                else if(z == arr[i][1]){
                    for (int k = arr[i][0]; k <= arr[i][1]; k++) {
                        land[k] = 1;
                    }
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }
}