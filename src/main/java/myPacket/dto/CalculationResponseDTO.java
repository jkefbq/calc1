package myPacket.dto;

public class CalculationResponseDTO {
    private String result;

    public CalculationResponseDTO() {}
    public CalculationResponseDTO(String result) {
        this.result = result;
    }

    public String getResult() {
        return result;
    }
    public void setResult(String result) {
        this.result = result;
    }
}
