import java.util.*;

public class PGM_42862 {
    public static void main(String[] args) {
        solution(5, new int[]{2, 4}, new int[]{1, 3, 5}); // 5
        solution(5, new int[]{2, 4}, new int[]{3}); // 4
        solution(3, new int[]{3}, new int[]{1}); // 2
        solution(5, new int[]{2, 4}, new int[]{2, 3}); // 5
        solution(5, new int[]{2, 4}, new int[]{2, 4}); // 5
        solution(5, new int[]{1,2,3,4,5}, new int[]{3,4}); // 2
        solution(5, new int[]{1,2,5}, new int[]{1,4,5}); // 4
        solution(5, new int[]{3,4,5}, new int[]{1,2,5}); // 4
        solution(4, new int[]{2,3}, new int[]{3,4}); // 3

    }
    public static int solution(int n, int[] lost, int[] reserve) {
        Arrays.sort(lost);
        int answer = 0;
        int[] arr = new int[n+2];

        for(int i=0; i<reserve.length; i++){
            arr[reserve[i]] = 1;
//            System.out.println("re:"+reserve[i]);
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        // 본인이 잃어버렸는데, 본인이 체육복을 가져온 경우
        for (int i = 0; i < lost.length; i++) {
            int number = lost[i];
            if(arr[number] == 1){
                arr[number] = 0;
//                System.out.println("it's me:"+number);
            }else{
                arrayList.add(lost[i]);
            }
        }
//        for (int i = 0; i < arr.length; i++) {
//            System.out.print(arr[i] +" ");
//        }
//        System.out.println();

        int cnt = 0;
        for (int i = 0; i < arrayList.size(); i++) {
            int number = arrayList.get(i);
//            if(reserve[i] == lost[i] && arr[number] == 1) continue;
//            System.out.println("arr[number]:"+arr[number]);

            if(arr[number-1] == 1){
                arr[number-1] = 0;
            }else if(arr[number+1] == 1){
                arr[number+1] = 0;
            }else{
                cnt++;
            }
        }
        System.out.println(n-cnt);
        answer = n-cnt;
        return answer;
    }
}
