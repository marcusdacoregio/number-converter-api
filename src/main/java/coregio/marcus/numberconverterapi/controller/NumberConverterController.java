package coregio.marcus.numberconverterapi.controller;

import coregio.marcus.numberconverterapi.dto.RomanNumberConversionDto;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/convert")
public class NumberConverterController {

    @PutMapping("/roman")
    public void convertToRomanNumeral(@RequestBody @Valid RomanNumberConversionDto romanNumberConversionDto) {

    }

}
