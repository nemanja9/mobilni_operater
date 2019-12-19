
package validator;

import exception.ValidationException;


public interface Validator {
    public void validate(Object value) throws ValidationException;
}
