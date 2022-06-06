package ZeroBase.Class;

public class Practice1_05 {
    public static void main(String[] args) {
//        int arr[] = {1,8,6,2,5,4,8,3,7};
        int arr[] = {5,3,9,2,1,1,1,1,1,1,1,1,1,2};
        int max = -1;
        int height = -1;
        int width = -1;

        for(int i=0; i<arr.length; i++){
            for (int j = i+1; j < arr.length; j++) {
                width = j - i;
                height = arr[i] > arr[j] ? arr[j] : arr[i];
                if(max < width * height){
                    max = width * height;
                }
            }
        }
        System.out.println(max);
    }

}
