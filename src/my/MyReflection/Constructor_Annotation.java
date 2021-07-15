package my.MyReflection;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//表示用于构造方法
@Target(ElementType.CONSTRUCTOR)
//运行时加载Annotation到JVM中
@Retention(RetentionPolicy.RUNTIME)
public @interface Constructor_Annotation {
    String value() default "默认构造方法";
}
