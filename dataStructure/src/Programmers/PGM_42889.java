class PGM_42889{
    public static void main(String[] args) {
//        solution(20, new int[]{1,2,2,1,3,21});
//        solution(5, new int[]{2, 1, 2, 6, 2, 4, 3, 3});
        solution(4, new int[]{4,4,4,4,4});
    }
    public static int[] solution(int N, int[] stages) {
        int[] answer = {};
        answer = new int[N];
        int arr[][] = new int[N+1][2];
        // 1 2 3 .. N

        for(int i=0; i<stages.length; i++){
            for(int j=0; j<stages[i]; j++){
                arr[j][1]++;
                if(j == stages[i]-1){
                    arr[j][0]++;
                }
            }
        }
        HashMap<Integer, Float> map = new HashMap<Integer, Float>();

        for(int i=0; i<N; i++){
            if(arr[i][0] == 0 ){
                map.put(i, (float)0);
                continue;
            }
//            System.out.println("arr[i][0]:"+arr[i][0]+" / arr[i][1]:"+arr[i][1]+"왔다:"+(int)((float)arr[i][0] / (float)arr[i][1]));
            map.put(i, (float)arr[i][0] / arr[i][1]);
        }

        // Map.Entry 리스트 작성
        List<Entry<Integer, Float>> list_entries = new ArrayList<Entry<Integer, Float>>(map.entrySet());

        // 비교함수 Comparator를 사용하여 오름차순으로 정렬
        Collections.sort(list_entries, new Comparator<Entry<Integer, Float>>() {
            // compare로 값을 비교
            public int compare(Entry<Integer, Float> obj1, Entry<Integer, Float> obj2) {
                // 오름 차순 정렬
                return obj2.getValue().compareTo(obj1.getValue());
            }
        });

        // 결과 출력
        int checkI=0;

        for(Entry<Integer, Float> entry : list_entries) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
            answer[checkI] = entry.getKey()+1;
            checkI++;
        }

        return answer;
    }
}