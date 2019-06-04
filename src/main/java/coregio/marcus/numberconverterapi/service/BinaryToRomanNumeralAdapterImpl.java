package coregio.marcus.numberconverterapi.service;

import coregio.marcus.numberconverterapi.exception.InvalidBinaryForRomanConversionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service("binaryToRomanConverter")
class BinaryToRomanNumeralAdapterImpl implements RomanConverterAdapter {

    private static final Logger LOGGER = LoggerFactory.getLogger(BinaryToRomanNumeralAdapterImpl.class);

    private final IntegerToRomanNumeralConverterService integerToRomanNumeralConverterService;

    public BinaryToRomanNumeralAdapterImpl(IntegerToRomanNumeralConverterService integerToRomanNumeralConverterService) {
        this.integerToRomanNumeralConverterService = integerToRomanNumeralConverterService;
    }

    @Override
    public String convert(String binaryValue) {
        Integer valueFromBinaryString = getIntegerValueOrThrow(binaryValue);
        return integerToRomanNumeralConverterService.convert(valueFromBinaryString);
    }

    private Integer getIntegerValueOrThrow(String binaryValue) {
        try {
            return Integer.valueOf(binaryValue, 2);
        } catch (NumberFormatException e) {
            String message = String.format("%s is not a valid binary number", binaryValue);
            LOGGER.error(message, e);
            throw new InvalidBinaryForRomanConversionException(message);
        }
    }

}