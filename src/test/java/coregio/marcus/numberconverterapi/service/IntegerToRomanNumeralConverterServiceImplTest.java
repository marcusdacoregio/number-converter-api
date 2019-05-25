package coregio.marcus.numberconverterapi.service;

import coregio.marcus.numberconverterapi.exception.InvalidIntegerForRomanConversionException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
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

    @DisplayName("Should throw exeption if value is smaller than 1")
    @Test
    void shouldThrowExceptionIfValueIsSmallerThanOne() {
        assertThrows(InvalidIntegerForRomanConversionException.class,
                () -> integerToRomanNumeralConverterService.convert(0));
        assertThrows(InvalidIntegerForRomanConversionException.class,
                () -> integerToRomanNumeralConverterService.convert(Integer.MIN_VALUE));
    }

    @DisplayName("Should throw exeption if value is bigger than 3999")
    @Test
    void shouldThrowExceptionIfValueIsBiggerThan3999() {
        assertThrows(InvalidIntegerForRomanConversionException.class,
                () -> integerToRomanNumeralConverterService.convert(4000));
        assertThrows(InvalidIntegerForRomanConversionException.class,
                () -> integerToRomanNumeralConverterService.convert(Integer.MAX_VALUE));
    }

}