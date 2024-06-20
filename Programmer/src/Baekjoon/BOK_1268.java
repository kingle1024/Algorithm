package Baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOK_1268 {

    public static void main(String[] args) throws IOException {
        process();
    }
    private static void process() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 배열에 값 넣기
        int N = Integer.parseInt(br.readLine());
        List<Set<Integer>> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            Set<Integer> set = new HashSet<>();
            list.add(set);
        }

        int[][] arr = new int[N][5];
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                int num = Integer.parseInt(st.nextToken());
                arr[i][j] = num;
            }
        }

        //
        int[][] cntArr = new int[N][5];
        for (int y = 0; y < N; y++) {
            for (int x = 0; x < 5; x++) {
                int myNum = arr[y][x];

                // 학생수 만큼 돌면서 자기 번호와 맞는 학생을 찾는다.
                for (int yy = 0; yy < N; yy++) {
                    if(myNum == arr[yy][x]) {
                        list.get(y).add(yy); // 찾으면 학생의 번호를 넣는다.
                    }
                }
            }
        }

        int index = findIndexOfLargestSet(list);
        bw.write((index+1) + "");

        bw.flush();
        bw.close();
    }

    public static int findIndexOfLargestSet(List<Set<Integer>> list) {
        if (list == null || list.isEmpty()) {
            throw new IllegalArgumentException("리스트는 null이거나 비어 있을 수 없습니다.");
        }

        int maxIndex = 0;
        int maxSize = 0;

        for (int i = 0; i < list.size(); i++) {
            Set<Integer> set = list.get(i);
            if (set.size() > maxSize) {
                maxSize = set.size();
                maxIndex = i;
            }
        }

        return maxIndex;
    }

}
