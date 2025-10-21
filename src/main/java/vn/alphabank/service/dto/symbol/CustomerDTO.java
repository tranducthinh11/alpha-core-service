package vn.alphabank.service.dto.symbol;

import com.fasterxml.jackson.annotation.JsonFormat;
import vn.alphabank.service.dto.entity.EBank;
import vn.alphabank.service.dto.entity.IdDoc;
import vn.alphabank.service.dto.entity.Location;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class CustomerDTO implements Serializable {
    public static final String OCCUPATION_CODE_OTHER = "000009";
    public static final String OCCUPATION_OTHER = "KHÁC";

    private String cif;
    private String status;
    @JsonFormat(pattern = "dd/MM/yyyy", timezone = "Asia/Ho_Chi_Minh")
    private Date openDate;
    private String fullName;
    private String gender;
    private String residentialStatus;
    private String occupation;
    private String occupationCode;
    private String position;
    private String phone;
    private String email;
    private String branchCode;
    private String branchName;
    private Boolean employee;
    private String cbs;
    private IdDoc idDoc;
    private Location currentAddress;
    private EBank eBank;
    private boolean isForeigner;

    public boolean isForeigner() {
        return isForeigner;
    }

    public void setForeigner(boolean foreigner) {
        isForeigner = foreigner;
    }

    public String getCif() {
        return cif;
    }

    public void setCif(String cif) {
        this.cif = cif;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getOpenDate() {
        return openDate;
    }

    public void setOpenDate(Date openDate) {
        this.openDate = openDate;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getResidentialStatus() {
        return residentialStatus;
    }

    public void setResidentialStatus(String residentialStatus) {
        this.residentialStatus = residentialStatus;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public String getPriorityEmail(){
        return Objects.nonNull(eBank) ? eBank.getEmail() : this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBranchCode() {
        return branchCode;
    }

    public void setBranchCode(String branchCode) {
        this.branchCode = branchCode;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public Boolean getEmployee() {
        return employee;
    }

    public void setEmployee(Boolean employee) {
        this.employee = employee;
    }

    public String getCbs() {
        return cbs;
    }

    public void setCbs(String cbs) {
        this.cbs = cbs;
    }

    public String getOccupationCode() {
        return occupationCode;
    }

    public void setOccupationCode(String occupationCode) {
        this.occupationCode = occupationCode;
    }

    public IdDoc getIdDoc() {
		return idDoc;
	}

	public void setIdDoc(IdDoc idDoc) {
		this.idDoc = idDoc;
	}

	public Location getCurrentAddress() {
		return currentAddress;
	}

	public void setCurrentAddress(Location currentAddress) {
		this.currentAddress = currentAddress;
	}

	public EBank geteBank() {
        return eBank;
    }

    public void seteBank(EBank eBank) {
        this.eBank = eBank;
    }
}
