package com.springboot.valid_exception.config.annotation;

import javax.validation.Constraint;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD) //어디서 선언할 수 있는지 정의
@Retention(RetentionPolicy.RUNTIME) //어노테이션이 유지되는 범위
@Constraint(validatedBy = TelephoneValidator.class)
public @interface Telephone {

    String message() default "전화번호 형식이 일치하지 않습니다.";
    Class[] groups() default {};
    Class[] payload() default {};
}
