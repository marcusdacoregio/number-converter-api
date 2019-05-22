package coregio.marcus.numberconverterapi.service;

import coregio.marcus.numberconverterapi.enums.NumberType;
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
        Integer valueFromBinaryString = Integer.valueOf(binaryValue, 2);
        String conversionResult = integerToRomanNumeralConverterService.convert(valueFromBinaryString);

        LOGGER.info(CONVERSION_LOG_MESSAGE, NumberType.BINARY, binaryValue, conversionResult);
        return conversionResult;
    }

}
