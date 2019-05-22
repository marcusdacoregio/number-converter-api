package coregio.marcus.numberconverterapi.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.mockito.Mockito.verify;

@ExtendWith(SpringExtension.class)
class DecimalToRomanConverterServiceImplTest {

    @InjectMocks
    private DecimalToRomanConverterServiceImpl decimalToRomanConverterServiceImpl;

    @Mock
    private IntegerToRomanNumeralConverterService integerToRomanNumeralConverterService;

    @DisplayName("Should call conversion method with the same value received in parameter")
    @ParameterizedTest(name = "for the value \"{0}\", should be called convert method with {0} (same value)")
    @ValueSource(strings = {"1", "2", "3", "4", "5", "-1", "-2", "-3", "-50"})
    void shouldCallConversionMethodWithBinaryValueConvertedToInteger(String value) {
        decimalToRomanConverterServiceImpl.convert(value);
        verify(integerToRomanNumeralConverterService).convert(Integer.valueOf(value));
    }
}