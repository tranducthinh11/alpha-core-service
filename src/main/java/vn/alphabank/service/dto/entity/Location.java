package vn.alphabank.service.dto.entity;

public class Location {
	private String addressType;
	private String address;
	private String city;
	private String cityCode;
	private String district;
	private String province;
	private String country;
	
	public Location() {}

	public Location(String addressType, String address, String city, String cityCode,
                    String district, String province, String country) {
		this.addressType = addressType;
		this.address = address;
		this.city = city;
		this.cityCode = cityCode;
		this.district = district;
		this.province = province;
		this.country = country;
	}

	public String getAddressType() {
		return addressType;
	}

	public void setAddressType(String addressType) {
		this.addressType = addressType;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCityCode() {
		return cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}
	
	
	
}
