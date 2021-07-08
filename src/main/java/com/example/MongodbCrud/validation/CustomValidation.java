package com.example.MongodbCrud.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = CustomValidator.class)
public @interface CustomValidation {
    String message() default "Not Valid  Entry...allow only lowerCase";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
