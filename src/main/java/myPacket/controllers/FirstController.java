package myPacket.controllers;

import myPacket.dto.CalculationRequestDTO;
import myPacket.dto.CalculationResponseDTO;
import myPacket.request.Request;
import myPacket.sevice.SecondService;
import org.springframework.web.bind.annotation.*;

@RestController
public class FirstController {
    private final SecondService secondService;

    public FirstController(SecondService secondService) {
        this.secondService = secondService;
    }


    @PostMapping("/create")
    public CalculationResponseDTO returnRequest(
            @RequestBody CalculationRequestDTO smth) {

        secondService.getRequestDTO().setSmth(smth);

        String res = secondService.getFirstService().calculateResult(smth);
        secondService.setCalculationResponseDTO(new CalculationResponseDTO(res));

        Request request = new Request(smth.getSymbol(), res);
        secondService.getFirstService().saveRequest(request);

        return secondService.getCalculationResponseDTO();
    }
}