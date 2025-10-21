package vn.alphabank.symbolapi;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import vn.alphabank.request.soap.GetCustomerDetailByCifRequest;
import vn.alphabank.request.soap.GetCustomerDetailByNICRequest;
import vn.alphabank.response.soap.GetCustomerDetailByCifResponse;
import vn.alphabank.response.soap.GetCustomerDetailByNICResponse;
import vn.alphabank.symbolapi.soap.XmlSoapService;

import javax.xml.soap.SOAPMessage;
import java.util.List;
import java.util.Objects;

@Component
public class CustomerInformationFileBackend extends XmlSoapService {

    public GetCustomerDetailByNICResponse getCustomerDetailByNIC(String idNumber, String cbsIdType){
        GetCustomerDetailByNICRequest request = new GetCustomerDetailByNICRequest();
        request.setGlobal_id(idNumber);
        request.setGlobal_id_type(cbsIdType);

        SOAPMessage message = callService(request);
        List<GetCustomerDetailByNICResponse> list = GetCustomerDetailByNICResponse.mapListData(message);
        return list.stream().filter(item -> Objects.equals(item.getGLOBAL_ID(), idNumber)).findFirst().orElse(list.get(0));
    }

    public GetCustomerDetailByCifResponse getCustomerDetailByCif(String cif) {
        GetCustomerDetailByCifRequest request = new GetCustomerDetailByCifRequest();
        request.setCif(cif);

        SOAPMessage message = callService(request);
        return GetCustomerDetailByCifResponse.getData(message);
    }
}
