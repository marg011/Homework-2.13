package pro.sky.skyprospringmockito.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class WrongSymbolsException extends RuntimeException{
    public WrongSymbolsException(String message) {
        super(message);
    }
}
