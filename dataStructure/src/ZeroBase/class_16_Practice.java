interface CompareTool{
    public abstract int getMaxNum(int num1, int num2);
}
public class class_16_Practice {
    public static void main(String[] args) {
        CompareTool cTool = new CompareTool() {
            @Override
            public int getMaxNum(int num1, int num2) {
                return num1 > num2? num1:num2;
            }
        };
        System.out.println(cTool.getMaxNum(10,11));

        CompareTool cTool2 = (num1,num2) -> {return num1 > num2 ? num1:num2;};
        System.out.println("cTool2.getMaxNum(10,11) = " + cTool2.getMaxNum(10,11));
    }
}
