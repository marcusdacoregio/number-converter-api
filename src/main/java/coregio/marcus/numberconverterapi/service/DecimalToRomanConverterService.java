package coregio.marcus.numberconverterapi.service;

import coregio.marcus.numberconverterapi.enums.NumberType;
import org.springframework.stereotype.Service;

@Service("decimalToRomanConverter")
public class DecimalToRomanConverterService implements NumberConverterService<Integer> {

    private final IntegerToRomanNumeralConverterService integerToRomanNumeralConverterService;

    public DecimalToRomanConverterService(IntegerToRomanNumeralConverterService integerToRomanNumeralConverterService) {
        this.integerToRomanNumeralConverterService = integerToRomanNumeralConverterService;
    }

    @Override
    public boolean matches(NumberType numberType) {
        return NumberType.DECIMAL.equals(numberType);
    }

    @Override
    public String convert(Integer value) {
        return integerToRomanNumeralConverterService.convert(value);
    }

}
