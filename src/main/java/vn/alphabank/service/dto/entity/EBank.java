package vn.alphabank.service.dto.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EBank {
	private String cif;
	private String email;
	private String phone;
	private BOService service;

	public String getCif() {
		return cif;
	}
	public void setCif(String cif) {
		this.cif = cif;
	}
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}

	public BOService getService() {
		return service;
	}

	public void setService(BOService service) {
		this.service = service;
	}

	public static boolean isValidEmail(String email) {
		boolean res = false;
		if (email != null && !email.isEmpty()) {
			String regex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
			Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
			Matcher matcher = pattern.matcher(email);
			res = matcher.find();
		}
		return res;
	}

	@JsonIgnore
	public boolean isEmptyField() {
		if(Objects.isNull(cif) || Objects.isNull(email) || Objects.isNull(phone) || Objects.isNull(service)) {
			return true;
		}
		return false;
	}
}//end if EBanking class
