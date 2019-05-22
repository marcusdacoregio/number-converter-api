package coregio.marcus.numberconverterapi.dto;

public class ConversionResultDto {

    private String result;

    public ConversionResultDto() {
        super();
    }

    public ConversionResultDto(String result) {
        this.result = result;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
