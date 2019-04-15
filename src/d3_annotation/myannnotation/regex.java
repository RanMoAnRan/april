package d3_annotation.myannnotation;

public class regex {
    public static void main(String[] args) {
        String regex="^[1-9]\\d{4,11}";
        String regex1="^\\w+?[@][a-zA-Z]+?[.][a-zA-Z]";
        String ss="154@qq.com";
        boolean matches = ss.matches(regex1);
        System.out.println(matches);
    }
}
