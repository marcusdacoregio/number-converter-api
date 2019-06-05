package coregio.marcus.numberconverterapi.service;

import coregio.marcus.numberconverterapi.exception.InvalidDecimalForRomanConversionException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class DecimalToRomanNumeralAdapterImplTest {

    @InjectMocks
    private DecimalToRomanNumeralAdapterImpl decimalToRomanNumeralAdapter;

    @Mock
    private IntegerToRomanNumeralConverterService integerToRomanNumeralConverterService;

    @DisplayName("Should call conversion method with the same value received in parameter")
    @ParameterizedTest(name = "for the value \"{0}\", should be called convert method with {0} (same value)")
    @ValueSource(strings = {"1", "2", "3", "4", "5", "-1", "-2", "-3", "-50"})
    void shouldCallConversionMethodWithBinaryValueConvertedToInteger(String value) {
        decimalToRomanNumeralAdapter.convert(value);
        verify(integerToRomanNumeralConverterService).convert(Integer.valueOf(value));
    }

    @DisplayName("Should throw exception if parameter isnt a valid decimal number")
    @Test
    void shouldThrowExceptionIfParameterIsntAValidDecimalNumber() {
        final String conversionParameter = "ABC";

        assertThrows(InvalidDecimalForRomanConversionException.class,
                () -> decimalToRomanNumeralAdapter.convert(conversionParameter));
    }

    @DisplayName("Should have a specific message in exception thrown when its not a valid decimal number")
    @Test
    void shouldHaveSpecificMessageInExceptionThrown() {
        final String conversionParameter = "ABC";
        final String expectedMessage = String.format("%s is not a valid decimal number", conversionParameter);

        InvalidDecimalForRomanConversionException invalidDecimalForRomanConversionException = assertThrows(InvalidDecimalForRomanConversionException.class,
                () -> decimalToRomanNumeralAdapter.convert(conversionParameter));

        assertEquals(expectedMessage, invalidDecimalForRomanConversionException.getMessage());
    }
}