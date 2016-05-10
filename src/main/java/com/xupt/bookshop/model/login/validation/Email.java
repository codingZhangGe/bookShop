package com.xupt.bookshop.model.login.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.Pattern;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by zhangge on 16-5-10.
 */
@Pattern(regexp = "/^(\\w)+(\\.\\w+)*@(\\w)+((\\.\\w+)+)$/;\n" +"\n")
@Target({ElementType.FIELD,ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {})
public @interface Email {
    String message() default " 邮箱格式不正确";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};



}
