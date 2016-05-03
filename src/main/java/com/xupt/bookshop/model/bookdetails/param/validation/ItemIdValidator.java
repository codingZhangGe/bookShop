package com.xupt.bookshop.model.bookdetails.param.validation;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import org.hibernate.validator.constraints.NotBlank;

/**
 * @author yunfeng.yang created on 16-4-24
 * @version 1.0
 */
@Target({ METHOD, FIELD, ANNOTATION_TYPE })
@Retention(RUNTIME)
@Constraint(validatedBy = {})
@Documented
@NotBlank
public @interface ItemIdValidator {
    String message() default " {com.xupt.bookshop.model.bookDetails}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
