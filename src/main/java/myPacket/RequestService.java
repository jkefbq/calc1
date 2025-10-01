package myPacket;

import myPacket.dao.CalculationRequest;
import myPacket.dao.RequestDAO;
import myPacket.request.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RequestService {

    private RequestDAO requestDAO;

    @Autowired
    public RequestService(RequestDAO requestDAO) {
        this.requestDAO = requestDAO;
    }

    public RequestService() {}

    public void saveRequest(Request request) {
        requestDAO.save(request);
    }

    public Request findRequest(int id) {
        return requestDAO.findById(id);
    }

    public void deleteRequest(Request request) {
        requestDAO.delete(request);
    }

    public void updateRequest(Request request) {
        requestDAO.update(request);
    }




    public String calculateResult(CalculationRequest smth) {
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
