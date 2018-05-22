package com.bizleap.training.ds.loader.domain;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class AbstractEntity {
	private String name;
	private String boId;
	private String email;
	private String phone;

	public AbstractEntity(String boId) {
		this.boId=boId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBoId() {
		return boId;
	}

	public void setBoId(String boId) {
		this.boId = boId;
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
	
	public boolean sameBoId(AbstractEntity entity) {
		if(entity==null)
			return false;
		if(getBoId()==null)
			return false;
		return this.getBoId().equals(entity.getBoId());
	}
	
	public boolean isSameBoId(AbstractEntity entity) {
		  if (entity == null)
		   return false;
		  if (!entity.getClass().equals(getClass()))
		   return false;
		  if(entity.getBoId()==null) return false;
		  return entity.getBoId().equals(getBoId());
	}
	
	public String toString() {
		return new ToStringBuilder(this)
				.append("boId",boId)
				.append("name",name)
				.append("email",email)
				.append("phone",phone)
				.toString();
	}

}
