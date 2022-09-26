    package BookStudy.week2_day2;

    import java.io.BufferedReader;
    import java.io.IOException;
    import java.io.InputStreamReader;
    import java.util.Stack;
    import java.util.StringTokenizer;

    // https://www.youtube.com/watch?v=XwG-QcBQ9-I
    public class BOK_17298_2 {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            Stack<Integer> stack = new Stack<>();

            int[] arr = new int[N];
            if(N == 1){
                System.out.println("-1");
                return;
            }
            for(int i=0; i<N; i++){
                int num = Integer.parseInt(st.nextToken());
                arr[i] = num;
            }
            int idx = 0;
            int searchIdx = 1;
            int[] result = new int[N];
            while(true){
                if(arr[idx] < arr[searchIdx]){
                    // 6 4 2 3 5
                    result[idx] = arr[searchIdx];
                    while(!stack.isEmpty()){
                        int stackIdx = stack.peek();
                        if(arr[stackIdx] < arr[searchIdx]){
                            stack.pop();
                            result[stackIdx] = arr[searchIdx];
                        }else{
                            break;
                        }
                    }
                }else{
                    stack.push(idx);
                }
                idx++;
                searchIdx++;
                if(searchIdx >= N) break;
            }
//            System.out.println(result+ " "+stack);
            StringBuffer sb = new StringBuffer();
            for(int i=0; i< result.length; i++){
                if(result[i] == 0){
                    sb.append("-1 ");
                }else{
                    sb.append(result[i] +" ");
                }
            }
            System.out.println(sb.toString());
        }

    }
