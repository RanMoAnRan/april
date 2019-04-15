package d3_annotation.myannnotation;

public class MyAnnotationDemo {
    @MyAnnotation(value = 20, name = "靖哥", codes = {"001", "002"})
    @Deprecated()
    public void method() {
        System.out.println("method.....");
    }

}
