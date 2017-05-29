package de.bonprix.dselect.model;

import de.bonprix.model.Entity;
import net.karneim.pojobuilder.GeneratePojoBuilder;

@GeneratePojoBuilder(intoPackage = "*.builder")
public class Country extends Entity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String india;
	private String germany;
	private String london;
	private String japan;

	public Country() {
		super();
	}

	public String getJapan() {
		return this.japan;
	}

	public void setJapan(String japan) {
		this.japan = japan;
	}

	public String getIndia() {
		return this.india;
	}

	public void setIndia(String india) {
		india = india;
	}

	public String getGermany() {
		return this.germany;
	}

	public void setGermany(String germany) {
		germany = germany;
	}

	public String getLondon() {
		return this.london;
	}

	public void setLondon(String london) {
		london = london;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
