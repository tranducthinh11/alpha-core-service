package vn.alphabank.service;

import lombok.SneakyThrows;
import org.apache.logging.log4j.util.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import vn.alphabank.request.OpenAccContractRequestDTO;
import vn.alphabank.response.BaseResponse;
import vn.alphabank.response.OpenAccContractResponseDTO;
import vn.alphabank.service.dto.symbol.CustomerDTO;
import vn.alphabank.web.controller.BaseException;

import java.util.HashMap;
import java.util.Objects;

@Service
public class BankService {
    private static final Logger LOG = LoggerFactory.getLogger(BankService.class);

    @Autowired
    private CIFService cifService;
    @Autowired
    private OpenAccContractService oacService;

    @SneakyThrows
    public ResponseEntity<?> searchCif(String stmId, String idType, String cbsIdType, String idNumber, String fullName, String flowCode) throws Exception {
        BaseResponse<CustomerDTO> response = new BaseResponse<>();
        CustomerDTO customerDTO = cifService.searchCustomerByNIC(idNumber, cbsIdType);

        return getResponseEntity(response, customerDTO);
    }

    @SneakyThrows
    public ResponseEntity<?> searchCustomer(String stmId, String cif, String cbs) {
        BaseResponse<CustomerDTO> response = new BaseResponse<>();
        CustomerDTO customerDTO = cifService.searchCustomerByCif(cif);
        return getResponseEntity(response, customerDTO);
    }

    public ResponseEntity<?> submitContract(OpenAccContractRequestDTO oacRequestDTO) {
        //TODO: move all method OpenAccContractService to this class
        BaseResponse<OpenAccContractResponseDTO> response = new BaseResponse<>();
        OpenAccContractResponseDTO data = oacService.openAccContract(oacRequestDTO);
        response.setData(data);
        return ResponseEntity.ok().body(response);
    }

    @SneakyThrows
    private ResponseEntity<?> getResponseEntity(BaseResponse<CustomerDTO> response, CustomerDTO customerDTO) {
        if (Objects.isNull(customerDTO))
            throw BaseException.setErrorDataNotFound();
        else if (Strings.isBlank(customerDTO.getStatus()))
            throw BaseException.setErrorInvalidCustomer();
        else if (!Objects.equals("ACT", customerDTO.getStatus()) && !Objects.equals("A", customerDTO.getStatus())) {
            if (Objects.equals(customerDTO.getStatus(), "C"))
                throw BaseException.setErrorCanceledCustomerStatus();
            else
                throw BaseException.setErrorBlockCustomerStatus();
        }else
            response.setData(customerDTO);
        return ResponseEntity.ok().body(response);
    }
}
