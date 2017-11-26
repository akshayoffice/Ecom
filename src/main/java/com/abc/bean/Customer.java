package com.abc.bean;

public class Customer {
	
	private String Email;
	private String Password;
	private String FirstName;
	private String LastName;
	// Address1 Address2 City State PostalCode Country Phone Email Password
	// BillingAddress BillingCity BillingCountry

	private String Address1;
	private String Address2;
	private String city;
	private String state;
	private int PostalCode;
	private String country;
	private String Phone;
	
	
	private String BillingAddress;
	private String BillingCity;
	private String BillingCountry;

	public Customer(String FirstName, String LastName, String Address1, String Address2, String city,
			String state, int PostalCode, String country, String Phone, String Email, String Password,
			String BillingAddress, String BillingCity, String BillingCountry) {
		this.FirstName = FirstName;
		this.LastName = LastName;
		this.Address1 = Address1;
		this.Address2 = Address2;
		this.city = city;
		this.state = state;
		this.PostalCode = PostalCode;
		this.country = country;
		this.Phone = Phone;
		this.Email = Email;
		this.Password = Password;
		this.BillingAddress = BillingAddress;
		this.BillingCity = BillingCity;
		this.BillingCountry = BillingCountry;
		

	}

	public Customer() {}

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public String getAddress1() {
		return Address1;
	}

	public void setAddress1(String address1) {
		Address1 = address1;
	}

	public String getAddress2() {
		return Address2;
	}

	public void setAddress2(String address2) {
		Address2 = address2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getPostalCode() {
		return PostalCode;
	}

	public void setPostalCode(int postalCode) {
		PostalCode = postalCode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPhone() {
		return Phone;
	}

	public void setPhone(String phone) {
		Phone = phone;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getBillingAddress() {
		return BillingAddress;
	}

	public void setBillingAddress(String billingAddress) {
		BillingAddress = billingAddress;
	}

	public String getBillingCity() {
		return BillingCity;
	}

	public void setBillingCity(String billingCity) {
		BillingCity = billingCity;
	}

	public String getBillingCountry() {
		return BillingCountry;
	}

	public void setBillingCountry(String billingCountry) {
		BillingCountry = billingCountry;
	}

}
