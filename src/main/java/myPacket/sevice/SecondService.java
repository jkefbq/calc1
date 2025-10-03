package myPacket.sevice;

import myPacket.dto.CalculationResponseDTO;
import myPacket.dto.RequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SecondService {
    private CalculationResponseDTO calculationResponseDTO;
    private RequestDTO requestDTO;
    private FirstService firstService;

    public SecondService() {}

    @Autowired
    public SecondService(RequestDTO requestDTO,
                         FirstService firstService) {
        this.requestDTO = requestDTO;
        this.firstService = firstService;
    }

    public RequestDTO getRequestDTO() {
        return getFirstService().getRequestDTO();
    }

    public FirstService getFirstService() {
        return firstService;
    }

    public CalculationResponseDTO getCalculationResponseDTO() {
        return calculationResponseDTO;
    }
    public void setCalculationResponseDTO(CalculationResponseDTO calculationResponseDTO) {
        this.calculationResponseDTO = calculationResponseDTO;
    }
}
