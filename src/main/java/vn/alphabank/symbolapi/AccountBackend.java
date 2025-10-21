package vn.alphabank.symbolapi;

import lombok.SneakyThrows;
import org.apache.logging.log4j.util.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import vn.alphabank.request.OpenAccContractRequestDTO;
import vn.alphabank.request.soap.ClientCreateRequest;
import vn.alphabank.response.soap.ClientCreateResponse;
import vn.alphabank.service.dto.entity.IdDoc;
import vn.alphabank.symbolapi.soap.XmlSoapService;
import vn.alphabank.util.DateTimeUtils;

import javax.xml.soap.SOAPMessage;

@Component
public class AccountBackend extends XmlSoapService {

    private static final Logger log = LoggerFactory.getLogger(AccountBackend.class);

    @SneakyThrows
    public ClientCreateResponse clientCreate(OpenAccContractRequestDTO oacRequestDTO){
        ClientCreateRequest request = new ClientCreateRequest();
        IdDoc idDoc = oacRequestDTO.getIdDoc();

        request.setP_global_id(idDoc.getIdNumber());
        request.setP_global_id_type(idDoc.getCbsIdType());
        request.setP_dt_of_issuance(DateTimeUtils.convertToDateFormat(idDoc.getIssuedDate(), "dd-MMM-yyyy"));
        request.setP_expire_date(DateTimeUtils.convertToDateFormat(idDoc.getExpireDate(), "dd-MMM-yyyy"));
        request.setP_place_of_issuance(idDoc.getIssuedPlace());
        request.setP_issuing_authority(idDoc.getIssuedPlace());
//        String fullName = oacRequestDTO.getLastName() + " " + oacRequestDTO.getMiddleName() + " " + oacRequestDTO.getFirstName();
        request.setP_client_name(oacRequestDTO.getLastName());
        request.setP_client_short(oacRequestDTO.getShortName());
        request.setP_location(oacRequestDTO.getCurrentAddress());
        request.setP_branch(oacRequestDTO.getBranchCode());
        request.setP_phone(oacRequestDTO.getPhone());
        request.setP_sex(oacRequestDTO.getGender());
        request.setP_birth_date(DateTimeUtils.convertToDateFormat(idDoc.getDob(), "dd-MMM-yyyy"));
        request.setP_place_of_birth(idDoc.getPob());
        request.setP_email(oacRequestDTO.getEmail());
        request.setP_occupation_code(oacRequestDTO.getOccupation());
        request.setP_state(oacRequestDTO.getCurrentCityCode());
        String taxCode = Strings.isNotBlank(oacRequestDTO.getTaxCode()) ? oacRequestDTO.getTaxCode() : "KH K CUNG CAP";
        request.setP_tax_file_no(taxCode);

        SOAPMessage data = callService(request);
        return new ClientCreateResponse(data);
    }
}
