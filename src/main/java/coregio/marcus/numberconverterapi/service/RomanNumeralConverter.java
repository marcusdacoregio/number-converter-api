package coregio.marcus.numberconverterapi.service;

import coregio.marcus.numberconverterapi.enums.NumberType;

public interface RomanNumeralConverter {
    String toRomanNumeral(String value, NumberType numberType);
}