package Baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.StringTokenizer;

public class BOK_1244 {

    // 1244
    public static void main(String[] args) throws IOException {
        process();
    }

    private static void process() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            list.add(num);
        }

        int peopleCnt = Integer.parseInt(br.readLine());
        for(int i = 0; i < peopleCnt; i++) {
            st = new StringTokenizer(br.readLine());
            int sex = Integer.parseInt(st.nextToken());
            int give = Integer.parseInt(st.nextToken());

            if(sex == 1) {
                for (int j = give; j <= list.size(); j *= 2) {
                    int i1 = list.get(j - 1);
                    list.remove(j - 1);
                    if(i1 == 1) {
                        list.add(j-1, 0);
                    } else {
                        list.add(j-1, 1);
                    }
                }
            } else {
                int nowIdx = give - 1;
                int leftIdx = nowIdx - 1;
                int rightIdx = nowIdx + 1;
                int nowNum = list.get(nowIdx);

                if(leftIdx >= 0 && rightIdx < list.size()) {
                    if(Objects.equals(list.get(leftIdx), list.get(rightIdx))) {
                        while(leftIdx >= 0) {
                            if(!Objects.equals(nowNum, list.get(leftIdx))) {
                                break;
                            }
                            leftIdx--;
                        }
                        while(rightIdx < list.size()) {
                            if(!Objects.equals(nowNum, list.get(rightIdx))) {
                                break;
                            }
                            rightIdx++;
                        }

                    }
                } else if(leftIdx == 0 && rightIdx < list.size()) {
                    if(Objects.equals(list.get(leftIdx), list.get(rightIdx))) {
                        while (rightIdx < list.size()) {
                            if (!Objects.equals(nowNum, list.get(rightIdx))) {
                                break;
                            }
                            rightIdx++;
                        }
                    }
                } else if(leftIdx >= 0 && rightIdx == list.size()) {
                    if(Objects.equals(list.get(leftIdx), list.get(rightIdx))) {
                        while(leftIdx >= 0) {
                            if(!Objects.equals(nowNum, list.get(leftIdx))) {
                                break;
                            }
                            leftIdx--;
                        }
                    }
                }

                for (int j = leftIdx; j <= rightIdx; j++) {
                    int i1 = list.get(j);
                    list.remove(j);
                    if(i1 == 1) {
                        list.add(j, 0);
                    } else {
                        list.add(j, 1);
                    }
                }
            }
        }

        for (Integer integer : list) {
            bw.write(integer + " ");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
