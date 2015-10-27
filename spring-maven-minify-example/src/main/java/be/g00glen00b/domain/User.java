package be.g00glen00b.domain;

import java.util.Calendar;

import org.apache.commons.lang3.StringUtils;

public class User {

	private String name;
	private String firstName;
	private Calendar birthDay;
	private boolean isMale;
	
	public User(String name, String firstName, Calendar birthDay, boolean isMale) {
		setName(name);
		setFirstName(firstName);
		setBirthDay(birthDay);
		setMale(isMale);
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public Calendar getBirthDay() {
		return birthDay;
	}
	
	public void setBirthDay(Calendar birthDay) {
		this.birthDay = birthDay;
	}
	
	public boolean isMale() {
		return isMale;
	}
	
	public void setMale(boolean isMale) {
		this.isMale = isMale;
	}
	
	@Override
	public String toString() {
		return StringUtils.join(getFirstName(), " ", getName());
	}
}
