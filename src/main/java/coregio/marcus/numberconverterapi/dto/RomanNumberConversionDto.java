package coregio.marcus.numberconverterapi.dto;

import coregio.marcus.numberconverterapi.enums.NumberType;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class RomanNumberConversionDto implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotNull
    @NotBlank
    private String numberToConvert;

    @NotNull
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
