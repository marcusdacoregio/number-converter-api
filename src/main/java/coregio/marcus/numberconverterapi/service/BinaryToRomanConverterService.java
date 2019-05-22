package coregio.marcus.numberconverterapi.service;

import coregio.marcus.numberconverterapi.enums.NumberType;
import org.springframework.stereotype.Service;

@Service("binaryToRomanConverter")
public class BinaryToRomanConverterService implements NumberConverterService<String, String> {

    @Override
    public boolean matches(NumberType numberType) {
        return NumberType.BINARY.equals(numberType);
    }

    @Override
    public String convert(String binaryValue) {
        return null;
    }

}
