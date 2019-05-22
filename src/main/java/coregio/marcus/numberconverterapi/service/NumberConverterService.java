package coregio.marcus.numberconverterapi.service;

public interface NumberConverterService {
    String CONVERSION_LOG_MESSAGE = "Converted {} value {} to roman numeral {}";

    String convert(String value);
}
