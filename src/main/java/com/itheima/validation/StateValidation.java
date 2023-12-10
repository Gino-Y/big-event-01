package com.itheima.validation;

import com.itheima.anno.State;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class StateValidation implements ConstraintValidator<State, String>  {
    /*
    * @param s 被校验的参数
    * @param constraintValidatorContext 校验的上下文环境
    * @return true 校验通过 false 校验不通过
    * */
    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        // 提供校验规则
        if(s == null) {
            return false;
        }

        return "已发布".equals(s) || "草稿".equals(s);
    }
}
