package coregio.marcus.numberconverterapi.dto;

import coregio.marcus.numberconverterapi.enums.NumberType;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class NumberConversionDto implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotNull(message = "Number to convert is required")
    @NotBlank(message = "Number to convert is required")
    private String numberToConvert;

    @NotNull(message = "The type of the number is required")
    private NumberType numberType;

    public String getNumberToConvert() {
        return numberToConvert;
    }

    public void setNumberToConvert(String numberToConvert) {
        this.numberToConvert = numberToConvert;
    }

    public NumberType getNumberType() {
        return numberType;
    }

    public void setNumberType(NumberType numberType) {
        this.numberType = numberType;
    }
}
