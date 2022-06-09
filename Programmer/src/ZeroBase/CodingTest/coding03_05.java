package ZeroBase.CodingTest;

public class coding03_05 {
    public static void main(String[] args) {
//        solution(new int[]{4,2,2,0,3,5}, new int[]{10,20,20,20,40,30}, new int[]{1, 0, 1, 0, 0, 0});
//        solution(new int[]{1,2,2,0,3,5}, new int[]{10,20,20,20,40,30}, new int[]{1, 0, 1, 0, 0, 0});
//        solution(new int[]{1,2,2,0,3,5}, new int[]{10,20,20,20,40,30}, new int[]{0, 0, 0, 0, 0, 0});

        System.out.println(solution(new int[]{1,2,2,0,3,5}, new int[]{10,20,20,20,40,30}, new int[]{0, 1, 1, 1, 1, 1}));
    }
    public static int solution(int[] reward, int[] health, int[] optional) {
        boolean c = false;
        for(int i=0; i<optional.length; i++){
            if(optional[i] == 0){
                c = true;
                break;
            }
        }
        if(!c) return 0;

        int answer = 0;
        int[] optinalTmp = optional.clone();
        int temp = 0;
        int temp2 = 0;
        int min = 0;
        for(int i=0; i<optional.length; i++){
            if(optinalTmp[i] == 1){
                temp = getTime(reward, health, optinalTmp);
                optinalTmp[i] = 0;
                temp2 = getTime(reward, health, optinalTmp);
                if(temp < temp2){
                    min = temp;
                    optinalTmp[i] = 1;
                }else{
                    min = temp2;
                }
                System.out.println("min:"+min);
            }else{
                min = getTime(reward, health, optinalTmp);
            }
        }
        System.out.println(min);

        return min;
    }
    static int getTime(int[] reward, int[] health, int[] optional) {
        int idx = 0;
        int attack = 1; // 공격력
        int time = 0;
        while(true) {
            int healthTemp = health[idx];
            if(optional[idx] == 0) {
                while (true) {
                    if (healthTemp > 0) {
                        healthTemp -= attack;
                        time++;
                    } else {
                        attack += reward[idx];
                        break;
                    }
                }
            }

            idx++;
            if(reward.length == idx) break;
        }
        return time;
    }

}
