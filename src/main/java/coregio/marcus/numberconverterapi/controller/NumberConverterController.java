package coregio.marcus.numberconverterapi.controller;

import coregio.marcus.numberconverterapi.dto.ConversionResultDto;
import coregio.marcus.numberconverterapi.dto.NumberConversionDto;
import coregio.marcus.numberconverterapi.service.RomanNumeralConverter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/convert")
public class NumberConverterController {

    private final RomanNumeralConverter romanNumeralConverter;

    public NumberConverterController(RomanNumeralConverter romanNumeralConverter) {
        this.romanNumeralConverter = romanNumeralConverter;
    }

    @GetMapping("/roman")
    public ConversionResultDto convertToRomanNumeral(@Valid NumberConversionDto numberConversionDto) {
        String conversionResult = romanNumeralConverter.toRomanNumeral(numberConversionDto.getNumberToConvert(), numberConversionDto.getNumberType());
        return new ConversionResultDto(conversionResult);
    }

}