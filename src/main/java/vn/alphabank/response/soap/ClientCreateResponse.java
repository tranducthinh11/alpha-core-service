package vn.alphabank.response.soap;

import javax.xml.soap.SOAPMessage;

public class ClientCreateResponse extends XmlResponseObject implements SymbolApiResponseInterface {
    public static final String NodeName_ClientCreateResult = "Client_createResult";
    //<editor-fold desc="Properties">
    private String response_code;
    private String description;
    //</editor-fold>

    //<editor-fold desc="Getter and Setter">

    public String getResponse_code() {
        return response_code;
    }

    public void setResponse_code(String response_code) {
        this.response_code = response_code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    //</editor-fold>

    public ClientCreateResponse(SOAPMessage message){
        super();
        mapData(message, NodeName_ClientCreateResult);
    }
}
