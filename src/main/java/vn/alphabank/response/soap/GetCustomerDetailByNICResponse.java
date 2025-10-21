package vn.alphabank.response.soap;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.soap.SOAPMessage;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class GetCustomerDetailByNICResponse extends XmlResponseObject implements SymbolApiResponseInterface {
    public static final String NodeName_CUSTOMER_INFO = "CUSTOMER_INFO";
    //<editor-fold desc="Properties">
    private String response_code;
    private String description;
    private String cLIENT_NO;
    private String cLIENT_STATUS;
    private String oPEN_DATE;
    private String rESIDENT_STATUS;
    private String fULL_NAME;
    private String sHORT_NAME;
    private String sEX;
    private String pHONE;
    private String eMAIL;
    private String bRANCH;
    private String gLOBAL_ID;
    private String gLOBAL_ID_TYPE;
    private String gLOBAL_ID2;
    private String gLOBAL_ID_TYPE2;
    private String dT_OF_ISSUANCE;
    private String pLACE_OF_ISSUANCE;
    private String eXPIRY_DATE;
    private String bIRTH_DATE;
    private String pLACE_OF_BIRTH;
    private String lOCATION;
    private List<String> sms;
    private String eB_PHONE;
    private String eB_EMAIL;
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

    public String getCLIENT_NO() {
        return cLIENT_NO;
    }

    public void setCLIENT_NO(String cLIENT_NO) {
        this.cLIENT_NO = cLIENT_NO;
    }

    public String getCLIENT_STATUS() {
        return cLIENT_STATUS;
    }

    public void setCLIENT_STATUS(String cLIENT_STATUS) {
        this.cLIENT_STATUS = cLIENT_STATUS;
    }

    public String getOPEN_DATE() {
        return oPEN_DATE;
    }

    public void setOPEN_DATE(String oPEN_DATE) {
        this.oPEN_DATE = oPEN_DATE;
    }

    public String getRESIDENT_STATUS() {
        return rESIDENT_STATUS;
    }

    public void setRESIDENT_STATUS(String rESIDENT_STATUS) {
        this.rESIDENT_STATUS = rESIDENT_STATUS;
    }

    public String getFULL_NAME() {
        return fULL_NAME;
    }

    public void setFULL_NAME(String fULL_NAME) {
        this.fULL_NAME = fULL_NAME;
    }

    public String getSHORT_NAME() {
        return sHORT_NAME;
    }

    public void setSHORT_NAME(String sHORT_NAME) {
        this.sHORT_NAME = sHORT_NAME;
    }

    public String getSEX() {
        return sEX;
    }

    public void setSEX(String sEX) {
        this.sEX = sEX;
    }

    public String getPHONE() {
        return pHONE;
    }

    public void setPHONE(String pHONE) {
        this.pHONE = pHONE;
    }

    public String getEMAIL() {
        return eMAIL;
    }

    public void setEMAIL(String eMAIL) {
        this.eMAIL = eMAIL;
    }

    public String getBRANCH() {
        return bRANCH;
    }

    public void setBRANCH(String bRANCH) {
        this.bRANCH = bRANCH;
    }

    public String getGLOBAL_ID() {
        return gLOBAL_ID;
    }

    public void setGLOBAL_ID(String gLOBAL_ID) {
        this.gLOBAL_ID = gLOBAL_ID;
    }

    public String getGLOBAL_ID_TYPE() {
        return gLOBAL_ID_TYPE;
    }

    public void setGLOBAL_ID_TYPE(String gLOBAL_ID_TYPE) {
        this.gLOBAL_ID_TYPE = gLOBAL_ID_TYPE;
    }

    public String getGLOBAL_ID2() {
        return gLOBAL_ID2;
    }

    public void setGLOBAL_ID2(String gLOBAL_ID2) {
        this.gLOBAL_ID2 = gLOBAL_ID2;
    }

    public String getGLOBAL_ID_TYPE2() {
        return gLOBAL_ID_TYPE2;
    }

    public void setGLOBAL_ID_TYPE2(String gLOBAL_ID_TYPE2) {
        this.gLOBAL_ID_TYPE2 = gLOBAL_ID_TYPE2;
    }

    public String getDT_OF_ISSUANCE() {
        return dT_OF_ISSUANCE;
    }

    public void setDT_OF_ISSUANCE(String dT_OF_ISSUANCE) {
        this.dT_OF_ISSUANCE = dT_OF_ISSUANCE;
    }

    public String getPLACE_OF_ISSUANCE() {
        return pLACE_OF_ISSUANCE;
    }

    public void setPLACE_OF_ISSUANCE(String pLACE_OF_ISSUANCE) {
        this.pLACE_OF_ISSUANCE = pLACE_OF_ISSUANCE;
    }

    public String getEXPIRY_DATE() {
        return eXPIRY_DATE;
    }

    public void setEXPIRY_DATE(String eXPIRY_DATE) {
        this.eXPIRY_DATE = eXPIRY_DATE;
    }

    public String getBIRTH_DATE() {
        return bIRTH_DATE;
    }

    public void setBIRTH_DATE(String bIRTH_DATE) {
        this.bIRTH_DATE = bIRTH_DATE;
    }

    public String getPLACE_OF_BIRTH() {
        return pLACE_OF_BIRTH;
    }

    public void setPLACE_OF_BIRTH(String pLACE_OF_BIRTH) {
        this.pLACE_OF_BIRTH = pLACE_OF_BIRTH;
    }

    public String getLOCATION() {
        return lOCATION;
    }

    public void setLOCATION(String lOCATION) {
        this.lOCATION = lOCATION;
    }

    public String getEB_PHONE() {
//        return Strings.isNotBlank(eB_PHONE) ? eB_PHONE.replaceAll("[^0-9]","") : "0000000000";
        return this.eB_PHONE;
    }

    public void setEB_PHONE(String eB_PHONE) {
        this.eB_PHONE = eB_PHONE;
    }

    public String getEB_EMAIL() {
        return eB_EMAIL;
    }

    public void setEB_EMAIL(String eB_EMAIL) {
        this.eB_EMAIL = eB_EMAIL;
    }

    public List<String> getSms() {
        return sms;
    }

    public void setSms(NodeList children) {
        if(Objects.isNull(sms)){
            sms = new ArrayList<>();
        }
        for (int i = 0; i < children.getLength(); i++){
            Element item = (Element) children.item(i);
            String smsPhone = item.getElementsByTagName("SMS_PHONE").item(0).getTextContent();
            if(!smsPhone.isBlank()){
                sms.add(smsPhone);
            }
        }
    }

    //</editor-fold>
    public static List<GetCustomerDetailByNICResponse> mapListData(SOAPMessage message){
        int countRecords = countData(message, NodeName_CUSTOMER_INFO);
        List<GetCustomerDetailByNICResponse> records = new ArrayList<>();

        for (int i = 0; i < countRecords; i++){
            GetCustomerDetailByNICResponse record = new GetCustomerDetailByNICResponse();
            record.mapData(message, NodeName_CUSTOMER_INFO, i);
            record.setResponse_code("00");
            record.setDescription("Successful");
            records.add(record);
        }

        if(records.size() == 0){
            records.add(new GetCustomerDetailByNICResponse(){{
                setResponse_code("01");
                setDescription("Data not found");
            }});
        }
        return records;
    }

    public static GetCustomerDetailByNICResponse getData(SOAPMessage message){
        List<GetCustomerDetailByNICResponse> list = mapListData(message);
        GetCustomerDetailByNICResponse data;
        if(list.size() > 0)
            data = list.get(0);
        else{
            data = new GetCustomerDetailByNICResponse();
            data.setResponse_code("01");
            data.setDescription("Data not found");
        }

        return data;
    }
}
