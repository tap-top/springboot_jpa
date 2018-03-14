package com.boe.tww.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * 自定义注解，这里是Flag
 *
 * @author 唐万万
 * @create 2018-03-14 15:41
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.PARAMETER,ElementType.FIELD})
//自定义注解的实现类的类型
@Constraint(validatedBy = FlagValidatorClass.class)
public @interface FlagValidator {
    //flag的有效值多个使用","隔开
    String values();

    //提示内容
    String message() default "flag 不存在";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
