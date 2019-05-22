package coregio.marcus.numberconverterapi.service;

import coregio.marcus.numberconverterapi.enums.NumberType;
import org.springframework.stereotype.Service;

@Service("decimalToRomanConverter")
public class DecimalToRomanConverterService implements NumberConverterService<Integer, String> {

    @Override
    public boolean matches(NumberType numberType) {
        return NumberType.DECIMAL.equals(numberType);
    }

    @Override
    public String convert(Integer value) {
        StringBuilder decimalToRomanConverted = new StringBuilder();


        return decimalToRomanConverted.toString();
    }

}
