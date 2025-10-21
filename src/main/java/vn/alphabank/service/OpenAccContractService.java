package vn.alphabank.service;

import lombok.SneakyThrows;
import org.apache.logging.log4j.util.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import vn.alphabank.request.OpenAccContractRequestDTO;
import vn.alphabank.response.OpenAccContractResponseDTO;
import vn.alphabank.response.soap.ClientCreateResponse;
import vn.alphabank.symbolapi.AccountBackend;
import vn.alphabank.util.StringUtils;

@Component
public class OpenAccContractService {
    private static final Logger logger = LoggerFactory.getLogger(BankService.class);

    @Autowired
    AccountBackend accountWebService;

    @SneakyThrows
    public OpenAccContractResponseDTO openAccContract(OpenAccContractRequestDTO oacRequestDTO) {
        OpenAccContractResponseDTO oacResponseDTO = new OpenAccContractResponseDTO();

        String cif = oacRequestDTO.getCif();
        oacRequestDTO.setLastName(StringUtils.removeAccent(oacRequestDTO.getLastName().trim()));   // remove accent

        //region Create client if new customer
        if (Strings.isBlank(cif)) {
            // Create client
            ClientCreateResponse clientCreateResponse = accountWebService.clientCreate(oacRequestDTO);
            clientCreateResponse.checkError(true);

            cif = clientCreateResponse.getDescription();
            oacRequestDTO.setCif(cif);
        }

        oacResponseDTO.setCif(cif);
        return oacResponseDTO;
    }
}