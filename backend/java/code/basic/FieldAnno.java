package basic;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;



@Retention(RetentionPolicy.RUNTIME) //表示这个注解可以在运行时通过反射访问, 不定义则信息不会保留到运行期
@Target(ElementType.FIELD)//表示注解只能用在类和接口上
public @interface FieldAnno {
    int value();
    String name();
    int age() default 0;
}
