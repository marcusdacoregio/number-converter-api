package coregio.marcus.numberconverterapi.enums;

import java.util.Arrays;
import java.util.List;

public enum RomanNumeral {

    M("M", 1000),
    CM("CM", 900),
    D("D", 500),
    CD("CD", 400),
    C("C", 100),
    XC("XC", 90),
    L("L", 50),
    XL("XL", 40),
    X("X", 10),
    IX("IX", 9),
    V("V", 5),
    IV("IV", 4),
    I("I", 1);

    private String letter;
    private int value;
    private static List<RomanNumeral> romanNumeralsOrderedByValueDesc;

    static {
        romanNumeralsOrderedByValueDesc = Arrays.asList(values());
    }

    RomanNumeral(String letter, int value) {
        this.letter = letter;
        this.value = value;
    }

    public String getLetter() {
        return letter;
    }

    public int getValue() {
        return value;
    }

    public static List<RomanNumeral> getRomanNumeralsOrderedByValueDesc() {
        return romanNumeralsOrderedByValueDesc;
    }

}
