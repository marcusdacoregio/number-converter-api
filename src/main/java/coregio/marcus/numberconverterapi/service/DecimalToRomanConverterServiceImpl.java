package coregio.marcus.numberconverterapi.service;

import coregio.marcus.numberconverterapi.enums.NumberType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service("decimalToRomanConverter")
class DecimalToRomanConverterServiceImpl implements NumberConverterService {

    private static final Logger LOGGER = LoggerFactory.getLogger(DecimalToRomanConverterServiceImpl.class);

    private final IntegerToRomanNumeralConverterService integerToRomanNumeralConverterService;

    public DecimalToRomanConverterServiceImpl(IntegerToRomanNumeralConverterService integerToRomanNumeralConverterService) {
        this.integerToRomanNumeralConverterService = integerToRomanNumeralConverterService;
    }

    @Override
    public String convert(String value) {
        Integer integerValue = Integer.valueOf(value);
        String conversionResult = integerToRomanNumeralConverterService.convert(integerValue);

        LOGGER.info(CONVERSION_LOG_MESSAGE, NumberType.DECIMAL, integerValue, conversionResult);
        return conversionResult;
    }

}
