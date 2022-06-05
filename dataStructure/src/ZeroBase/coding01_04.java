import java.util.HashMap;
import java.util.HashSet;

public class coding01_04 {
    public static void main(String[] args) {
        System.out.println(solution("ULURRDLLU"));
        System.out.println(solution("LULLLLLLU"));
        System.out.println(solution("LULLLLLLURDL"));
        System.out.println(solution("UDUDUDUDUD"));
    }
    /*
    게임 캐릭터를 4가지 명령어를 통해 움직이려 합니다. 명령어는 다음과 같습니다.
U: 위쪽으로 한 칸 가기
D: 아래쪽으로 한 칸 가기
R: 오른쪽으로 한 칸 가기
L: 왼쪽으로 한 칸 가기
캐릭터는 좌표평면의 (0, 0) 위치에서 시작합니다. 좌표평면의 경계는 왼쪽 위(-5, 5), 왼쪽 아래(-5, -5), 오른쪽 위(5, 5), 오른쪽 아래(5, -5)로 이루어져 있습니다.


     */
    public static int solution(String dirs) {
        int answer = 0;
        int x = 0;
        int y = 0;

        HashSet hash = new HashSet();

        for(int i=0; i<dirs.length(); i++){
//            System.out.printf(dirs.charAt(i)+"");
            switch(dirs.charAt(i)){
                case 'U':{
                    if(y <= 4 && y >= -5){
                        hash.add(x+","+y+"|"+x+","+(y+1));
                        hash.add(x+","+(y+1)+"|"+x+","+y);
                        y++;
                    }
                    break;
                }
                case 'L':{
                    if(x <= 5 && x >= -4){
                        hash.add((x-1)+","+y+"|"+x+","+y);
                        hash.add(x+","+y+"|"+(x-1)+","+y);
                        x--;
                    }
                    break;
                }
                case 'R':{
                    if(x <= 4 && x >= -5){
                        hash.add((x+1)+","+y+"|"+x+","+y);
                        hash.add(x+","+y+"|"+(x+1)+","+y);
                        x++;
                    }
                    break;
                }
                case 'D':{
                    if(y <= 5 && y >= -4){
                        hash.add(x+","+y+"|"+x+","+(y-1));
                        hash.add(x+","+(y-1)+"|"+x+","+y);
                        y--;
                    }
                    break;
                }
            }
        }
        answer = hash.size();

        return answer/2;
    }
}
