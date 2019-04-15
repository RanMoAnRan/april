package d2_fansheandproxy.Variable;

//可变参数
public class VariableDemo {
    public static void main(String[] args) {
        int sum = getSum("sum:",1, 2, 3);
        System.out.println(sum);
    }


    public static int getSum(String name,int... a) {
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            int i1 = a[i];
            sum+=i1;

        }
        System.out.println(name);
        return sum;
    }
}
