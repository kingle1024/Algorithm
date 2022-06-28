package ZeroBase.Class;

/*
    각 원소의 값은 해당 위치에서 오른쪽으로 이동할 수 있는 최대 값이다.
    첫 번째 위치에서 시작해서 가장 끝까지 이동이 가능한지 판별하는 프로그램을 작성하세요.
    이동이 가능하면 true, 불가능하면 false를 반환하세요.
    입출력 예시

 */
public class Part2_Chapter04_Class08_Practice01 {
    public static boolean solution(int[] nums){
        for(int i=0; i<nums.length; i++){
            if(nums[i] + i >= nums.length-1){
                return true;
            }else if(i == nums.length-2 && nums[i] == 0) break;
        }
        return false;
    }
    public static void main(String[] args) {
        // Test code
        int[] nums = {2, 3, 0, 1, 4};
        System.out.println(solution(nums));

        nums = new int[]{3, 0, 0, 1, 1};
        System.out.println(solution(nums));

        nums = new int[]{3, 2, 1, 0, 4};
        System.out.println(solution(nums));

        nums = new int[]{1, 1, 1, 1, 1, 1, 1, 0};
        System.out.println(solution(nums));
    }
}
