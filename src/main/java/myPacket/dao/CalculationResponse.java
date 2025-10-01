package myPacket.dao;

public class CalculationResponse {
    private String result;

    public CalculationResponse() {}
    public CalculationResponse(String result) {
        this.result = result;
    }

    public String getResult() {
        return result;
    }
    public void setResult(String result) {
        this.result = result;
    }
}
