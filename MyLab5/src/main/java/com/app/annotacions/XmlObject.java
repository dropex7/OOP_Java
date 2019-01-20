package main.java.com.app.annotacions;

import java.lang.annotation.*;


@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface XmlObject {
    String name() default "";
}
