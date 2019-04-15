package d3_annotation.myannnotation;

import java.lang.annotation.*;

import static java.lang.annotation.ElementType.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(value={CONSTRUCTOR, FIELD, LOCAL_VARIABLE, METHOD, PACKAGE, PARAMETER, TYPE})
public @interface MyAnnotation {
    //自定义属性没有默认值
    public abstract int value() default 20;
    public abstract String name() default "hah";
    String[] codes();
}
