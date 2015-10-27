package be.g00glen00b.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.*;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target({ METHOD, FIELD, ANNOTATION_TYPE })
@Retention(RUNTIME)
@Constraint(validatedBy = CheckMailValidator.class)
@Documented
public @interface Email {

	String message() default "{be.g00glen00b.validation.Email}";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
