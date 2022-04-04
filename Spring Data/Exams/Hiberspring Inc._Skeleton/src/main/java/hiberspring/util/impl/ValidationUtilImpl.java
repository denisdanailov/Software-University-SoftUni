package hiberspring.util.impl;

import hiberspring.util.ValidationUtil;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

public class ValidationUtilImpl implements ValidationUtil {

    @Override
    public <E> boolean isValid(E entity) {

        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

        Set<ConstraintViolation<E>> errorSet = validator.validate(entity);

        return errorSet.isEmpty();
    }
}
