package coregio.marcus.numberconverterapi.dto;

public class ConversionResultDto<T> {

    private T result;

    public ConversionResultDto() {
        super();
    }

    public ConversionResultDto(T result) {
        this.result = result;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }
}
