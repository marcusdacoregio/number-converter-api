package coregio.marcus.numberconverterapi.service;

import coregio.marcus.numberconverterapi.enums.NumberType;

public interface NumberConverterService<C> {

    boolean matches(NumberType numberType);

    String convert(C value);

}
