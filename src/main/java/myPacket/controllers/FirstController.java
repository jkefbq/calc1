package myPacket.controllers;

import myPacket.dao.CalculationRequest;
import myPacket.RequestService;
import myPacket.dao.CalculationResponse;
import myPacket.dao.RequestDAO;
import myPacket.request.Request;
import org.springframework.web.bind.annotation.*;

@RestController
public class FirstController {

    private final RequestService requestService;
    private final RequestDAO requestDAO;

    public FirstController(RequestService requestService, RequestDAO requestDAO) {
        this.requestService = requestService;
        this.requestDAO = requestDAO;
    }


    @PostMapping("/create")
    public CalculationResponse returnRequest(
            @RequestBody CalculationRequest smth) {

        requestDAO.setSmth(smth);

        String res = requestService.calculateResult(smth);
        CalculationResponse response = new CalculationResponse(res);

        Request request = new Request(smth.getSymbol(), res);
        requestService.saveRequest(request);

        return response;
    }
}