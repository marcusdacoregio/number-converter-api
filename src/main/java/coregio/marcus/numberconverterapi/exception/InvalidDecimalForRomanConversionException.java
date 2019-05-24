package coregio.marcus.numberconverterapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidDecimalForRomanConversionException extends RuntimeException {

    public InvalidDecimalForRomanConversionException(String message) {
        super(message);
    }

}
