import java.util.ArrayList;

//  같은 숫자는 싫어
public class PGM_12906 {
    public static void main(String[] args) {
        int arr[] = {1,1,3,3,0,1,1};
        solution(arr);
        arr = new int[]{4, 4, 4, 3, 3};
        solution(arr);
        arr = new int[]{1,2,2,3,2,2,1};
        solution(arr);
        arr = new int[]{1,1};
        solution(arr);
    }
    public static int[] solution(int []arr) {
        int[] answer = {};
        if(arr.length == 1){
            return answer = new int[]{arr[0]};
        }
        ArrayList<Integer> array = new ArrayList();
        boolean check = false;
        for(int i=0; i<arr.length-1; i++){
            if(arr[i] != arr[i+1]){
                if(array.size() == 0){
                    array.add(arr[i]);
                    array.add(arr[i+1]);
                }else{
                    array.add(arr[i+1]);
                }
                check = true;
            }
        }

        if(!check) array.add(arr[0]);
        answer = new int[array.size()];

        for(int i=0; i<array.size(); i++){
            answer[i] = array.get(i);
            System.out.print(answer[i]+" ");
        }
        System.out.println();

        return answer;
    }
}
