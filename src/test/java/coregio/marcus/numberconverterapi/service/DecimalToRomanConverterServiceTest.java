package coregio.marcus.numberconverterapi.service;

import coregio.marcus.numberconverterapi.enums.NumberType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;

@ExtendWith(SpringExtension.class)
class DecimalToRomanConverterServiceTest {

    @InjectMocks
    private DecimalToRomanConverterService decimalToRomanConverterService;

    @Mock
    private IntegerToRomanNumeralConverterService integerToRomanNumeralConverterService;

    @DisplayName("Should call conversion method with the same value received in parameter")
    @ParameterizedTest(name = "for the value \"{0}\", should be called convert method with {0} (same value)")
    @ValueSource(ints = {1, 2, 3, 4, 5, -1, -2, -3, -50, Integer.MAX_VALUE})
    void shouldCallConversionMethodWithBinaryValueConvertedToInteger(Integer value) {
        decimalToRomanConverterService.convert(value);
        verify(integerToRomanNumeralConverterService).convert(value);
    }

    @DisplayName("Should return true if number type is decimal")
    @Test
    void shouldReturnBooleanIfNumberTypeIsBinary() {
        boolean matches = decimalToRomanConverterService.matches(NumberType.DECIMAL);
        assertTrue(matches);
    }
}