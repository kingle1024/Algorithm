package BookStudy;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.io.FileInputStream;

public class coding2 {
        static int AnswerN;
        static int N = 10;
        static char[][] map;
        static int NM;
        static int cnt;
        static int[] point;
        static boolean[][] visited;
        static Queue<coding1.People> q;

    public static void main(String args[]) throws Exception {
        //System.setIn(new FileInputStream("C:\sample_input.txt"));
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        point = new int[2];
        for(int i=0; i<T; i++){
            NM = sc.nextInt();
            map = new char[NM][NM];
            cnt = 0;
            visited = new boolean[NM][NM];
            for (int j = 0; j < NM; j++) {
                for (int k = 0; k < NM; k++) {
                    map[j][k] = sc.next().charAt(0);
                    if(map[j][k] == 'X'){
                        point[0] = j;
                        point[1] = k;
//                        System.out.println(j+" "+k);
                    }
                }
            }
            bfs(point[0], point[1], -1);
            System.out.println("#"+(i+1)+" "+ cnt);
        }

        for(int test_case = 1; test_case <= T; test_case++) {
            N = sc.nextInt();
            System.out.println("#"+test_case+" "+AnswerN);
        }
    }
    public static void bfs(int x, int y, int arrow){
        visited[x][y] = true;
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        Queue<Man> q = new LinkedList<>();
        q.add(new Man(x, y, arrow));
        while(!q.isEmpty()) {
            Man m = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = m.x + dx[i];
                int ny = m.y + dy[i];

                if(nx < 0 || ny <0 || nx >= NM || ny >= NM){
                    continue;
                }
                if(visited[nx][ny]) continue;
                if(map[nx][ny] == 'Y' || map[nx][ny] == 'L') continue;

                visited[nx][ny] = true;
                if(m.arrow == -1){
                    cnt++;
                    q.add(new Man(nx, ny, i));
                }else{
                    if(m.arrow == i && map[nx][ny] == 'H'){
                        cnt++;
                        q.add(new Man(nx, ny, i));
                    }
                }


            }
        }
    }
    static class Man{
        int x;
        int y;
        int arrow;

        public Man(int x, int y, int arrow) {
            this.x = x;
            this.y = y;
            this.arrow = arrow;
        }
    }
}
