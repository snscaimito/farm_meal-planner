package net.caimito.membership;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class MembershipInformation {

	private String uuid ;
	private String email ;
	private boolean isActiveMember ;
	
	public MembershipInformation() {
	}
	
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	
	public String getUuid() {
		return uuid;
	}
	
	public boolean isActiveMember() {
		return isActiveMember;
	}
	
	public void setActiveMember(boolean isMember) {
		this.isActiveMember = isMember;
	}

	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this) ;
	}
}
