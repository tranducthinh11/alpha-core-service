package vn.alphabank.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import vn.alphabank.response.soap.GetCustomerDetailByCifResponse;
import vn.alphabank.response.soap.GetCustomerDetailByNICResponse;
import vn.alphabank.service.dto.symbol.CustomerDTO;
import vn.alphabank.symbolapi.CustomerInformationFileBackend;

import java.util.Date;
import java.util.List;
import java.util.Objects;

@Component
public class CIFService {
    private static final Logger LOG = LoggerFactory.getLogger(CIFService.class);

    @Autowired
    CustomerInformationFileBackend cifBackend;

    public CustomerDTO searchCustomerByNIC(String idNumber, String cbsIdType){
        GetCustomerDetailByNICResponse response = cifBackend.getCustomerDetailByNIC(idNumber, cbsIdType);
        response.checkError(true);

        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setCif(response.getCLIENT_NO());
        customerDTO.setStatus(response.getCLIENT_STATUS());

        return customerDTO;
    }

    public CustomerDTO searchCustomerByCif(String cif){
        GetCustomerDetailByCifResponse response = cifBackend.getCustomerDetailByCif(cif);
        response.checkError(true);

        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setCif(response.getCLIENT_NO());
        customerDTO.setStatus(response.getCLIENT_STATUS());

        return customerDTO;
    }
}
