package vn.alphabank.request.soap;

import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPPart;


public class GetCustomerDetailByNICRequest extends SymbolCoreBankingRequestObject {
    //<editor-fold desc="Properties">
    private String global_id;
    private String global_id_type;
    //</editor-fold>

    //<editor-fold desc="Getter and Setter">
    public String getGlobal_id() {
        return global_id;
    }

    public void setGlobal_id(String global_id) {
        this.global_id = global_id;
    }

    public String getGlobal_id_type() {
        return global_id_type;
    }

    public void setGlobal_id_type(String global_id_type) {
        this.global_id_type = global_id_type;
    }
    //</editor-fold>

    @Override
    public void createMessage() throws Throwable {
        super.createMessage();
        SOAPPart soapPart = reqMsg.getSOAPPart();
        SOAPEnvelope envelope = soapPart.getEnvelope();
        SOAPBody soapBody = envelope.getBody();
        soapBody.setPrefix("soap12");
        SOAPElement getAccountListCif = soapBody.addChildElement("Get_Customer_Detail_byNIC", "", "GWCBS");

        SOAPElement global_id = getAccountListCif.addChildElement("global_id");
        global_id.setTextContent(this.getGlobal_id());
        SOAPElement global_id_type = getAccountListCif.addChildElement("global_id_type");
        global_id_type.setTextContent(this.getGlobal_id_type());
    }
}
