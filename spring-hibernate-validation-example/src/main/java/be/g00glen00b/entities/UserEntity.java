package be.g00glen00b.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import be.g00glen00b.validation.Email;


/**
 * The persistent class for the mail_users database table.
 * 
 */
@Entity
@Table(name="mail_users")
public class UserEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int id;
	
	@Size(min = 1, max = 32)
	@NotNull
	private String firstName;
	
	@Size(min = 1, max = 128)
	@Email
	private String mail;
	
	@Size(min = 1, max = 32)
	@NotNull
	private String name;

    public UserEntity() {
    }

    public UserEntity(String firstName, String name, String mail) {
    	setFirstName(firstName);
    	setName(name);
    	setMail(mail);
    }

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(insertable=false, updatable=false, unique=true, nullable=false)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}


	@Column(nullable=false, length=32)
	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	@Column(nullable=false)
	public String getMail() {
		return this.mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}


	@Column(nullable=false, length=32)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}