package dataStructure;

public class factorialRecursive {
	public static void main(String[] args) {
		System.out.println(factorialRecursive(10));
	}
	public static int factorialRecursive(int num){
		if(num == 1) 
			return 1;
		else
			return num * factorialRecursive(num-1);
	}
}
