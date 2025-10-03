package myPacket.sevice;

import myPacket.dto.CalculationRequestDTO;
import myPacket.dto.RequestDTO;
import myPacket.request.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FirstService {

    private RequestDTO requestDTO;

    @Autowired
    public FirstService(RequestDTO requestDTO) {
        this.requestDTO = requestDTO;
    }

    public FirstService() {}

    public void saveRequest(Request request) {
        requestDTO.save(request);
    }

    public Request findRequest(int id) {
        return requestDTO.findById(id);
    }

    public void deleteRequest(Request request) {
        requestDTO.delete(request);
    }

    public void updateRequest(Request request) {
        requestDTO.update(request);
    }

    public RequestDTO getRequestDTO() {
        return requestDTO;
    }

    public String calculateResult(CalculationRequestDTO smth) {
        String result;
        int a = smth.getA();
        int b = smth.getB();
        String symbol = smth.getSymbol();

        if (symbol.equals("-")) {
            result = Integer.toString(a - b);
        } else if (symbol.equals("+")) {
            result = Integer.toString(a + b);
        } else if (symbol.equals("/")) {
            result = Integer.toString(a / b);
        } else if (symbol.equals("*")) {
            result = Integer.toString(a * b);
        } else {
            result = "0";
        }
        return result;
    }
}
