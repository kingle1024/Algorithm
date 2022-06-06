class PGM_12977{
    public static void main(String[] args) {

    }
    public int solution(int[] nums) {
        int answer = 0;
        int total = 0;
        for(int i=0; i<nums.length; i++){
            for(int j=i+1; j<nums.length; j++){
                for(int k=j+1; k<nums.length; k++){
                    total = nums[i] + nums[j] + nums[k];
                    if( decimal(total) < 1) answer++;
                }
            }
        }
        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        // System.out.println("Hello Java");

        return answer;
    }
    public int decimal(int num){
        for(int i=2; i<num; i++){
            // System.out.println("num:"+num+"/i:"+i+"/ num%i:"+num%i);
            if(num % i == 0){
                return 1;
            }
        }
        return 0;
    }
}