package coregio.marcus.numberconverterapi.service;

import coregio.marcus.numberconverterapi.exception.InvalidDecimalForRomanConversionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service("decimalToRomanConverter")
class DecimalToRomanNumeralAdapterImpl implements RomanConverterAdapter {

    private static final Logger LOGGER = LoggerFactory.getLogger(DecimalToRomanNumeralAdapterImpl.class);

    private final IntegerToRomanNumeralConverterService integerToRomanNumeralConverterService;

    public DecimalToRomanNumeralAdapterImpl(IntegerToRomanNumeralConverterService integerToRomanNumeralConverterService) {
        this.integerToRomanNumeralConverterService = integerToRomanNumeralConverterService;
    }

    @Override
    public String convert(String value) {
        Integer integerValue = getIntegerValueOrThrow(value);
        return integerToRomanNumeralConverterService.convert(integerValue);
    }

    private Integer getIntegerValueOrThrow(String value) {
        try {
            return Integer.valueOf(value);
        } catch (NumberFormatException e) {
            String message = String.format("%s is not a valid decimal number", value);
            LOGGER.error(message, e);
            throw new InvalidDecimalForRomanConversionException(message);
        }
    }

}
