package coregio.marcus.numberconverterapi.controller;

import coregio.marcus.numberconverterapi.dto.ConversionResultDto;
import coregio.marcus.numberconverterapi.dto.NumberConversionDto;
import coregio.marcus.numberconverterapi.service.NumberConverterService;
import coregio.marcus.numberconverterapi.util.ApplicationContextProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/convert")
public class NumberConverterController {

    private final ApplicationContextProvider applicationContextProvider;

    public NumberConverterController(ApplicationContextProvider applicationContextProvider) {
        this.applicationContextProvider = applicationContextProvider;
    }

    @GetMapping("/roman")
    public ConversionResultDto convertToRomanNumeral(@Valid NumberConversionDto numberConversionDto) {
        NumberConverterService bean = getNumberConverterService(numberConversionDto);
        String conversionResult = bean.convert(numberConversionDto.getNumberToConvert());

        return new ConversionResultDto(conversionResult);
    }

    private NumberConverterService getNumberConverterService(NumberConversionDto numberConversionDto) {
        return (NumberConverterService) applicationContextProvider.getContext().getBean(
                numberConversionDto.getNumberType().getBeanName());
    }

}
