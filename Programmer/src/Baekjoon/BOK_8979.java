package com.douzone.comet.batch.bm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class BOK_8979 {
    // 8979
    static class Olympic {
        private final int position;
        private final int gold;
        private final int silver;
        private final int bronze;
        private int rank;

        public Olympic(int position, int gold, int silver, int bronze, int rank) {
            this.position = position;
            this.gold = gold;
            this.silver = silver;
            this.bronze = bronze;
            this.rank = rank;
        }

        public void setRank(int rank) {
            this.rank = rank;
        }

        public int getPosition() {
            return position;
        }

        public int getGold() {
            return gold;
        }

        public int getSilver() {
            return silver;
        }

        public int getBronze() {
            return bronze;
        }

        public int getRank() {
            return rank;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        final int N = Integer.parseInt(st.nextToken());
        final int K = Integer.parseInt(st.nextToken());
        Comparator<Olympic> comparator = Comparator.
            comparingInt(Olympic::getGold)
            .thenComparingInt(Olympic::getSilver)
            .thenComparingInt(Olympic::getBronze)
            .reversed();
        List<Olympic> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            list.add(new Olympic (
                Integer.parseInt(st.nextToken()),
                Integer.parseInt(st.nextToken()),
                Integer.parseInt(st.nextToken()),
                Integer.parseInt(st.nextToken()),
                -1
            ));
        }
        if(K == 1) {
            bw.write("1\n");
            bw.flush();
            bw.close();
            return;
        }
        Collections.sort(list, comparator);

        final int size = list.size();
        int rankCusor = 2;
        list.get(0).setRank(1);
        boolean isResult = false;
        for (int i = 1; i < size; i++) {
            if( list.get(i-1).getGold() == list.get(i).getGold()
                && list.get(i-1).getSilver() == list.get(i).getSilver()
                && list.get(i-1).getBronze() == list.get(i).getBronze()
            ) {
                final int prevRank = list.get(i-1).getRank();
                list.get(i).setRank(prevRank);
            } else {
                list.get(i).setRank(rankCusor);
            }
            rankCusor++;

            if(list.get(i).getPosition() == K) {
                bw.write(list.get(i).getRank() + "\n");
                isResult = true;
                break;
            }
        }
        if(!isResult) {
            bw.write(list.get(0).getRank() + "\n");
        }

        bw.flush();
        bw.close();
    }
}
