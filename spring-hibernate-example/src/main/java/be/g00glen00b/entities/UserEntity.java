package be.g00glen00b.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the users database table.
 * 
 */
@Entity
@Table(name="users")
public class UserEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	private int userId;
	private Date birthDay;
	private String firstName;
	private boolean male;
	private String name;

    public UserEntity() {
    }


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id", unique=true, nullable=false)
	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}


    @Temporal( TemporalType.DATE)
	@Column(nullable=false)
	public Date getBirthDay() {
		return this.birthDay;
	}

	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}


	@Column(nullable=false, length=32)
	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	@Column(nullable=false)
	public boolean getMale() {
		return this.male;
	}

	public void setMale(boolean male) {
		this.male = male;
	}


	@Column(nullable=false, length=32)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}