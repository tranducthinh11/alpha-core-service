package vn.alphabank.request.soap;

import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPPart;


public class GetCustomerDetailByCifRequest extends SymbolCoreBankingRequestObject {
    //<editor-fold desc="Properties">
    private String cif;
    //</editor-fold>

    //<editor-fold desc="Getter and Setter">

    public String getCif() {
        return cif;
    }

    public void setCif(String cif) {
        this.cif = cif;
    }

    //</editor-fold>

    @Override
    public void createMessage() throws Throwable {
        super.createMessage();
        SOAPPart soapPart = reqMsg.getSOAPPart();
        SOAPEnvelope envelope = soapPart.getEnvelope();
        SOAPBody soapBody = envelope.getBody();
        soapBody.setPrefix("soap12");
        SOAPElement getAccountListCif = soapBody.addChildElement("Get_Customer_Detail_byCIF", "", "GWCBS");

        SOAPElement cif = getAccountListCif.addChildElement("cif");
        cif.setTextContent(this.cif);
    }
}
