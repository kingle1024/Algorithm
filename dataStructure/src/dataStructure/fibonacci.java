package dataStructure;

public class fibonacci {
	public static void main(String[] args) {
		System.out.println(fibo(10));
	}
	public static int fibo(int num){
		if(num == 1){
			return 1;
		}
		else if(num == 0)
			return 0;
		else{
			return fibo(num-2) + fibo(num-1);
		}
	}
}
