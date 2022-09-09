package Programmers;

class PGM_17681{
    public static void main(String[] args) {

    }
    public static String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = {};
        answer = new String[n];
        String arr1_change = "";
        String arr2_change = "";

        for(int i=0; i<arr1.length; i++){
            arr1_change = Integer.toBinaryString(arr1[i]);
            arr2_change = Integer.toBinaryString(arr2[i]);
            while(arr1_change.length() < n){
                arr1_change = "0"+arr1_change;
            }
            while(arr2_change.length() < n){
                arr2_change = "0"+arr2_change;
            }
//            System.out.println(arr1_change);
//            System.out.println(arr2_change);

            for(int j=0; j<n; j++){
                if(answer[i] == null) answer[i] = "";
                if(arr1_change.charAt(j) == '1' || arr2_change.charAt(j) == '1'){
                    answer[i] += "#";
//                    System.out.println("Test1:"+arr1_change.charAt(j) +" " +arr2_change.charAt(j));
                }else{
                    answer[i] += " ";
//                    System.out.println("Test2:"+arr1_change.charAt(j) +" " +arr2_change.charAt(j));
                }
            }
        }

        return answer;
    }
}