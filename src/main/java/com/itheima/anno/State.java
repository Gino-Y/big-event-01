package com.itheima.anno;

import com.itheima.validation.StateValidation;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Target({FIELD})
@Retention(RUNTIME)
@Constraint(
        validatedBy = {StateValidation.class} // 指定提供校验规则的类
)
public @interface State {
    // 校验不通过时的提示信息
    String message() default "state参数的值只能是已发布或草稿";
    // 指定分组
    Class<?>[] groups() default {};
    // 负载 获取State注解的时候，除了校验信息，还可以获取其他信息
    Class<? extends Payload>[] payload() default {};
}
