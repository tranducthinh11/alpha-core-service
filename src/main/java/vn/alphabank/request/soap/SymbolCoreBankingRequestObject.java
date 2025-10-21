package vn.alphabank.request.soap;

import vn.alphabank.web.controller.BaseException;

import javax.xml.soap.*;

public class SymbolCoreBankingRequestObject extends XmlRequestObject {

    public void createMessage() throws Throwable {
        try {
            MessageFactory reqMsgFactory = MessageFactory.newInstance(SOAPConstants.SOAP_1_2_PROTOCOL);
            reqMsg = reqMsgFactory.createMessage();

            SOAPPart soapPart = reqMsg.getSOAPPart();
            SOAPEnvelope envelope = soapPart.getEnvelope();
            envelope.setPrefix("soap12");

            SOAPHeader header = reqMsg.getSOAPHeader();
            header.detachNode();
        } catch (Throwable e) {
            throw BaseException.setGenericError("Create message error", e);
        }
    }
}
