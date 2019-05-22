package coregio.marcus.numberconverterapi.service;

import coregio.marcus.numberconverterapi.enums.NumberType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;

@ExtendWith(SpringExtension.class)
class BinaryToRomanConverterServiceTest {

    @InjectMocks
    private BinaryToRomanConverterService binaryToRomanConverterService;

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
        binaryToRomanConverterService.convert(binaryValue);
        verify(integerToRomanNumeralConverterService).convert(expectedIntegerArgument);
    }

    @DisplayName("Should return true if number type is binary")
    @Test
    void shouldReturnBooleanIfNumberTypeIsBinary() {
        boolean matches = binaryToRomanConverterService.matches(NumberType.BINARY);
        assertTrue(matches);
    }
}