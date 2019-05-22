package coregio.marcus.numberconverterapi.service;

import coregio.marcus.numberconverterapi.enums.RomanNumeral;
import coregio.marcus.numberconverterapi.exception.InvalidIntegerForRomanConversionException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IntegerToRomanNumeralConverterServiceImpl implements IntegerToRomanNumeralConverterService {

    private static final int MINIMUM_INTEGER_VALUE = 1;
    private static final int MAXIMUM_INTEGER_VALUE = 3999;

    @Override
    public String convert(Integer value) {
        if (isInvalidIntegerForConversion(value)) {
            throw new InvalidIntegerForRomanConversionException(String.format("%d is not a valid number for conversion", value));
        }

        List<RomanNumeral> romanNumeralsOrderedByValueDesc = RomanNumeral.getRomanNumeralsOrderedByValueDesc();

        Integer auxValue = value;

        StringBuilder integerToRomanConverted = new StringBuilder();
        for (RomanNumeral romanNumeral : romanNumeralsOrderedByValueDesc) {
            while (auxValue >= romanNumeral.getValue()) {
                integerToRomanConverted.append(romanNumeral.getLetter());
                auxValue -= romanNumeral.getValue();
            }
        }

        return integerToRomanConverted.toString();
    }

    private boolean isInvalidIntegerForConversion(Integer value) {
        return value < MINIMUM_INTEGER_VALUE || value > MAXIMUM_INTEGER_VALUE;
    }

}
