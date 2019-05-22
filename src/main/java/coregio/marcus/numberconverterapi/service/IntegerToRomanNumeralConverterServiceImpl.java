package coregio.marcus.numberconverterapi.service;

import coregio.marcus.numberconverterapi.enums.RomanNumeral;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IntegerToRomanNumeralConverterServiceImpl implements IntegerToRomanNumeralConverterService {

    private static final String EMPTY_STRING = "";
    private static final int MINIMUM_INTEGER_VALUE = 1;
    private static final int MAXIMUM_INTEGER_VALUE = 3999;

    @Override
    public String convert(Integer value) {
        if (isInvalidIntegerForConversion(value)) {
            return EMPTY_STRING;
        }

        StringBuilder integerToRomanConverted = new StringBuilder();
        List<RomanNumeral> romanNumeralsOrderedByValueDesc = RomanNumeral.getRomanNumeralsOrderedByValueDesc();

        Integer auxValue = value;

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
