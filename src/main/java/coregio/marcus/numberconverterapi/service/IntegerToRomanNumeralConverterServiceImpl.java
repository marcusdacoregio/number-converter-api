package coregio.marcus.numberconverterapi.service;

import coregio.marcus.numberconverterapi.enums.RomanNumeral;
import coregio.marcus.numberconverterapi.exception.InvalidIntegerForRomanConversionException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
class IntegerToRomanNumeralConverterServiceImpl implements IntegerToRomanNumeralConverterService {

    private static final int MINIMUM_INTEGER_VALUE = 1;
    private static final int MAXIMUM_INTEGER_VALUE = 3999;

    private static final Map<Integer, String> CACHED_RESULTS = new ConcurrentHashMap<>();

    @Override
    public String convert(Integer value) {
        throwIfInvalidIntegerForConversion(value);

        return CACHED_RESULTS.computeIfAbsent(value, this::convertToRomanNumeral);
    }

    private String convertToRomanNumeral(Integer valueToConvert) {
        List<RomanNumeral> romanNumeralsOrderedByValueDesc = RomanNumeral.getRomanNumeralsOrderedByValueDesc();
        Integer auxValue = valueToConvert;

        StringBuilder integerToRomanConverted = new StringBuilder();
        for (RomanNumeral romanNumeral : romanNumeralsOrderedByValueDesc) {
            while (auxValue >= romanNumeral.getValue()) {
                integerToRomanConverted.append(romanNumeral.getLetter());
                auxValue -= romanNumeral.getValue();
            }
        }

        return integerToRomanConverted.toString();
    }

    private void throwIfInvalidIntegerForConversion(Integer value) {
        if (value < MINIMUM_INTEGER_VALUE || value > MAXIMUM_INTEGER_VALUE) {
            throw new InvalidIntegerForRomanConversionException(String.format("The value must be between %d and %d", MINIMUM_INTEGER_VALUE, MAXIMUM_INTEGER_VALUE));
        }
    }

}
