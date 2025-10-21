package vn.alphabank.request.soap;

import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPPart;


public class ClientCreateRequest extends SymbolCoreBankingRequestObject {
    //<editor-fold desc="Properties">
    private String p_global_id;
    private String p_global_id_type;
    private String p_dt_of_issuance;
    private String p_expire_date;
    private String p_place_of_issuance;
    private String p_issuing_authority;
    private String p_client_name;
    private String p_client_short;
    private String p_location;
    private String p_branch;
    private String p_phone;
    private String p_sex;
    private String p_birth_date;
    private String p_place_of_birth;
    private String p_email;
    private String p_tax_file_no;
    private String p_occupation_code;
    private String p_state;
    //</editor-fold>

    //<editor-fold desc="Getter and Setter">
    public String getP_global_id() {
        return p_global_id;
    }

    public void setP_global_id(String p_global_id) {
        this.p_global_id = p_global_id;
    }

    public String getP_global_id_type() {
        return p_global_id_type;
    }

    public void setP_global_id_type(String p_global_id_type) {
//        switch (p_global_id_type){
//            case "CCCDCHIP":
//            case "CCCD":
//            case "PASSPORT":
//            case "CMTND9":
//            case "CMTND12":
//                p_global_id_type = "NIC";
//        }

        this.p_global_id_type = p_global_id_type;
    }

    public String getP_dt_of_issuance() {
        return p_dt_of_issuance;
    }

    public void setP_dt_of_issuance(String p_dt_of_issuance) {
        this.p_dt_of_issuance = p_dt_of_issuance;
    }

    public String getP_expire_date() {
        return p_expire_date;
    }

    public void setP_expire_date(String p_expire_date) {
        this.p_expire_date = p_expire_date;
    }

    public String getP_place_of_issuance() {
        return p_place_of_issuance;
    }

    public void setP_place_of_issuance(String p_place_of_issuance) {
        this.p_place_of_issuance = p_place_of_issuance;
    }

    public String getP_issuing_authority() {
        return p_issuing_authority;
    }

    public void setP_issuing_authority(String p_issuing_authority) {
        this.p_issuing_authority = p_issuing_authority;
    }

    public String getP_client_name() {
        return p_client_name;
    }

    public void setP_client_name(String p_client_name) {
        this.p_client_name = p_client_name;
    }

    public String getP_client_short() {
        return p_client_short;
    }

    public void setP_client_short(String p_client_short) {
        this.p_client_short = p_client_short;
    }

    public String getP_location() {
        return p_location;
    }

    public void setP_location(String p_location) {
        this.p_location = p_location;
    }

    public String getP_branch() {
        return p_branch;
    }

    public void setP_branch(String p_branch) {
        this.p_branch = p_branch;
    }

    public String getP_phone() {
        return p_phone;
    }

    public void setP_phone(String p_phone) {
        this.p_phone = p_phone;
    }

    public String getP_sex() {
        return p_sex;
    }

    public void setP_sex(String p_sex) {
        this.p_sex = p_sex;
    }

    public String getP_birth_date() {
        return p_birth_date;
    }

    public void setP_birth_date(String p_birth_date) {
        this.p_birth_date = p_birth_date;
    }

    public String getP_place_of_birth() {
        return p_place_of_birth;
    }

    public void setP_place_of_birth(String p_place_of_birth) {
        this.p_place_of_birth = p_place_of_birth;
    }

    public String getP_email() {
        return p_email;
    }

    public void setP_email(String p_email) {
        this.p_email = p_email;
    }

    public String getP_tax_file_no() {
        return p_tax_file_no;
    }

    public void setP_tax_file_no(String p_tax_file_no) {
        this.p_tax_file_no = p_tax_file_no;
    }

    public String getP_occupation_code() {
        return p_occupation_code;
    }

    public void setP_occupation_code(String p_occupation_code) {
        this.p_occupation_code = p_occupation_code;
    }

    public String getP_state() {
        return p_state;
    }

    public void setP_state(String p_state) {
        this.p_state = p_state;
    }

    //</editor-fold>

    @Override
    public void createMessage() throws Throwable {
        super.createMessage();
        SOAPPart soapPart = reqMsg.getSOAPPart();
        SOAPEnvelope envelope = soapPart.getEnvelope();
        SOAPBody soapBody = envelope.getBody();
        soapBody.setPrefix("soap12");
        SOAPElement client = soapBody.addChildElement("Client_create", "", "GWCBS");
        SOAPElement cif = client.addChildElement("cif");

        createNodeElements(cif, "", new String[]{"p_global_id", "p_global_id_type", "p_dt_of_issuance",
                "p_expire_date", "p_place_of_issuance", "p_issuing_authority", "p_client_name", "p_client_short",
                "p_location", "p_branch", "p_phone", "p_sex", "p_birth_date", "p_place_of_birth", "p_email",
                "p_tax_file_no", "p_occupation_code", "p_state"
        });
    }
}
