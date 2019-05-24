package coregio.marcus.numberconverterapi.service;

import coregio.marcus.numberconverterapi.enums.NumberType;
import coregio.marcus.numberconverterapi.exception.InvalidBinaryForRomanConversionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service("binaryToRomanConverter")
class BinaryToRomanConverterServiceImpl implements NumberConverterService {

    private static final Logger LOGGER = LoggerFactory.getLogger(BinaryToRomanConverterServiceImpl.class);

    private final IntegerToRomanNumeralConverterService integerToRomanNumeralConverterService;

    public BinaryToRomanConverterServiceImpl(IntegerToRomanNumeralConverterService integerToRomanNumeralConverterService) {
        this.integerToRomanNumeralConverterService = integerToRomanNumeralConverterService;
    }

    @Override
    public String convert(String binaryValue) {
        Integer valueFromBinaryString = getIntegerValueOrThrow(binaryValue);
        String conversionResult = integerToRomanNumeralConverterService.convert(valueFromBinaryString);

        LOGGER.info(CONVERSION_LOG_MESSAGE, NumberType.BINARY, binaryValue, conversionResult);
        return conversionResult;
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
