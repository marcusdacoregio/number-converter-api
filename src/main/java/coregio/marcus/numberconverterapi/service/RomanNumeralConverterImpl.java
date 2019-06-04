package coregio.marcus.numberconverterapi.service;

import coregio.marcus.numberconverterapi.enums.NumberType;
import coregio.marcus.numberconverterapi.util.ApplicationContextProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class RomanNumeralConverterImpl implements RomanNumeralConverter {

    private static final Logger LOGGER = LoggerFactory.getLogger(RomanNumeralConverterImpl.class);

    private final ApplicationContextProvider applicationContextProvider;

    public RomanNumeralConverterImpl(ApplicationContextProvider applicationContextProvider) {
        this.applicationContextProvider = applicationContextProvider;
    }

    @Override
    public String toRomanNumeral(String value, NumberType numberType) {
        RomanConverterAdapter romanConverterAdapter = getNumberConverterService(numberType);
        String romanNumeral = romanConverterAdapter.convert(value);

        LOGGER.info("Converted {} value {} to roman numeral {}", numberType, value, romanNumeral);

        return romanNumeral;
    }

    private RomanConverterAdapter getNumberConverterService(NumberType numberType) {
        return (RomanConverterAdapter) applicationContextProvider.getContext()
                .getBean(numberType.getBeanName());
    }

}