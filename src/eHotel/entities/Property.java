package eHotel.entities;

import java.sql.Date;

public class Property {

	private int IDP;
	private String Address;
	private String PropertyType;
	private int Roomnumber;
	private String Title;
	private String Country;
	
	public Property(int iDP, String address, String propertyType, int roomnumber, String title,
			String country) {
		this.IDP = iDP;
		this.Address = address;
		this.PropertyType = propertyType;
		this.Roomnumber = roomnumber;
		this.Title = title;
		this.Country = country;
	}
	
	public int getIDP() {
		return IDP;
	}
	public void setIDP(int iDP) {
		IDP = iDP;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getPropertyType() {
		return PropertyType;
	}
	public void setPropertyType(String propertyType) {
		PropertyType = propertyType;
	}
	public int getRoomnumber() {
		return Roomnumber;
	}
	public void setRoomnumber(int roomnumber) {
		Roomnumber = roomnumber;
	}
	
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public String getCountry() {
		return Country;
	}
	public void setCountry(String country) {
		Country = country;
	}
	
	

}
