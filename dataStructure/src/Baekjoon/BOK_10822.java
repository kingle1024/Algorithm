import java.util.Scanner;

public class BOK_10822 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        String arr[] = new String[input.length()];

        arr = input.split(",");
        int total = 0;
        for(int i=0; i<arr.length; i++){
            total += Integer.parseInt(arr[i]);
        }
        System.out.println(total);
    }
}
