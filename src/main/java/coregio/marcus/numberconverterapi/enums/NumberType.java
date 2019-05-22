package coregio.marcus.numberconverterapi.enums;

public enum NumberType {

    DECIMAL("decimalToRomanConverter"),
    BINARY("binaryToRomanConverter");

    private String beanName;

    NumberType(String beanName) {
        this.beanName = beanName;
    }

    public String getBeanName() {
        return beanName;
    }
}
