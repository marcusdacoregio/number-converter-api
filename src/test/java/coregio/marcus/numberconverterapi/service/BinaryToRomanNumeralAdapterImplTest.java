package coregio.marcus.numberconverterapi.service;

import coregio.marcus.numberconverterapi.exception.InvalidBinaryForRomanConversionException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class BinaryToRomanNumeralAdapterImplTest {

    @InjectMocks
    private BinaryToRomanNumeralAdapterImpl binaryToRomanNumeralAdapter;

    @Mock
    private IntegerToRomanNumeralConverterService integerToRomanNumeralConverterService;

    @DisplayName("Should call conversion method with binary value converted to integer")
    @ParameterizedTest(name = "for the binary value \"{0}\", should be called convert method with {1}")
    @CsvSource({
            "0001, 1",
            "0010, 2",
            "0011, 3",
            "0111, 7",
            "1111, 15",
            "1000, 8",
            "1100, 12",
    })
    void shouldCallConversionMethodWithBinaryValueConvertedToInteger(String binaryValue, Integer expectedIntegerArgument) {
        binaryToRomanNumeralAdapter.convert(binaryValue);
        verify(integerToRomanNumeralConverterService).convert(expectedIntegerArgument);
    }

    @DisplayName("Should throw exception if parameter isnt a valid binary number")
    @ParameterizedTest
    @ValueSource(strings = {
            "",
            "*/$#@%@¨@",
            "ABC",
            "0002",
            "0003",
            "9999",
            "-2147483648",
            "2147483647"
    })
    void shouldThrowExceptionIfParameterIsntAValidBinaryNumber(String conversionParameter) {
        assertThrows(InvalidBinaryForRomanConversionException.class,
                () -> binaryToRomanNumeralAdapter.convert(conversionParameter));
    }

    @DisplayName("Should have a specific message in exception thrown when its not a valid binary number")
    @Test
    void shouldHaveSpecificMessageInExceptionThrown() {
        final String conversionParameter = "ABC";
        final String expectedMessage = String.format("%s is not a valid binary number", conversionParameter);

        InvalidBinaryForRomanConversionException invalidBinaryForRomanConversionException = assertThrows(InvalidBinaryForRomanConversionException.class,
                () -> binaryToRomanNumeralAdapter.convert(conversionParameter));

        assertEquals(expectedMessage, invalidBinaryForRomanConversionException.getMessage());
    }
}