package coregio.marcus.numberconverterapi.dto;

import java.io.Serializable;

public class ConversionResultDto implements Serializable {

    private static final long serialVersionUID = 1L;

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
