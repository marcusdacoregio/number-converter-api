package coregio.marcus.numberconverterapi.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
class IntegerToRomanNumeralConverterServiceImplTest {

    @InjectMocks
    private IntegerToRomanNumeralConverterServiceImpl integerToRomanNumeralConverterService;

    @DisplayName("Should convert integer to correspondent roman numeral")
    @ParameterizedTest(name = "\"{0}\" should be {1}")
    @CsvFileSource(resources = "/roman_numerals_up_to_3999.csv")
    void shouldConvertIntegerToCorrespondentRomanNumeral(Integer value, String romanNumeralExpected) {
        String romanNumeral = integerToRomanNumeralConverterService.convert(value);
        assertEquals(romanNumeralExpected, romanNumeral);
    }

}