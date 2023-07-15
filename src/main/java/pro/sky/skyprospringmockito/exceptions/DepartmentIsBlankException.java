package pro.sky.skyprospringmockito.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class DepartmentIsBlankException extends RuntimeException {
    public DepartmentIsBlankException(String message) {
        super(message);
    }
}
