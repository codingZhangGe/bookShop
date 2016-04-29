package com.xupt.bookshop.model.login.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.Pattern;

/**密码检测
 * Created by zhangge on 16-3-31.
 */
@Pattern(regexp = "^[a-zA-Z]\\w{5,17}$")
@Target({ElementType.FIELD,ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {})
public @interface Password {
String message() default " 密码检测信息-----";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
