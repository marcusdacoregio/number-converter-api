package coregio.marcus.numberconverterapi.service;

import coregio.marcus.numberconverterapi.enums.NumberType;

public interface NumberConverterService<C, P> {

    boolean matches(NumberType numberType);

    P convert(C value);

}
