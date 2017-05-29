package de.bonprix.dselect.model;

import java.util.Date;

import de.bonprix.model.Entity;
import net.karneim.pojobuilder.GeneratePojoBuilder;

@GeneratePojoBuilder(intoPackage = "*.builder")
public class SeField extends Entity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String name;
	private String address;
	private Date dob;
	private String onFacebook;
	private String country;

	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getDob() {
		return this.dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getOnFacebook() {
		return this.onFacebook;
	}

	public void setOnFacebook(String onFacebook) {
		this.onFacebook = onFacebook;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
