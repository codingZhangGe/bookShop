package com.qunar.qauction.common.utils.beanmapper;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 * Description: Annotation for mapping the class
 *
 * @author lingtong.fu
 * @version 2016-04-20 21:39
 */
@Target({ElementType.TYPE
})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MapClass {
    /**
    * Set the class which need to be mapped with the annotated class
    * @return
    */
    String value() default "";
}
