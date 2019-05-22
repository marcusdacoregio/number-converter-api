package coregio.marcus.numberconverterapi.service;

import coregio.marcus.numberconverterapi.enums.NumberType;
import org.springframework.stereotype.Service;

@Service("binaryToRomanConverter")
public class BinaryToRomanConverterService implements NumberConverterService<String> {

    private final IntegerToRomanNumeralConverterService integerToRomanNumeralConverterService;

    public BinaryToRomanConverterService(IntegerToRomanNumeralConverterService integerToRomanNumeralConverterService) {
        this.integerToRomanNumeralConverterService = integerToRomanNumeralConverterService;
    }

    @Override
    public boolean matches(NumberType numberType) {
        return NumberType.BINARY.equals(numberType);
    }

    @Override
    public String convert(String binaryValue) {
        Integer valueFromBinaryString = Integer.valueOf(binaryValue, 2);

        return integerToRomanNumeralConverterService.convert(valueFromBinaryString);
    }

}
