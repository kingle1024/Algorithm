class PGM_12939{
    public static void main(String[] args) {

    }
    public String solution(String s) {
        String answer = "";
        String arr[] = s.split(" ");
        int arrInt[] = new int[arr.length];
        for(int i=0; i<arr.length; i++){
            arrInt[i] = Integer.parseInt(arr[i]);
        }
        Arrays.sort(arrInt);
        answer = arrInt[0] +" "+arrInt[arrInt.length-1];
        return answer;
    }
}