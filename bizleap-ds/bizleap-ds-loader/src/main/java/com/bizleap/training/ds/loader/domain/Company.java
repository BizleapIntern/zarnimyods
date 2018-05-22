package com.bizleap.training.ds.loader.domain;
import org.apache.commons.lang3.builder.ToStringBuilder;
public class Company extends AbstractEntity{
	private String address,ceo;

	public Company(String boId) {
		super(boId);
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCeo() {
		return ceo;
	}

	public void setCeo(String ceo) {
		this.ceo = ceo;
	}
	
	public static Company parseCompany(String line) {
		String[] tokens=line.split(",");
		Company company=new Company(tokens[0]);
		company.setName(tokens[1]);
		company.setAddress(tokens[2]);
		company.setPhone(tokens[3]);
		company.setEmail(tokens[4]);
		company.setCeo(tokens[5]);
		return company;
	}
	
	public String toString() {
		return new ToStringBuilder(this).appendSuper(super.toString())
				.append("address", address)
				.append("ceo",ceo)
				.toString();

	}
}
