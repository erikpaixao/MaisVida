package desafio.maisvidas.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User {
	
	@Id
	@GeneratedValue
	private Long id;
	@Column(nullable = false, unique = true)
	private String username;
	private String password;
	private Boolean isAdmin;
	private Boolean isActive;

	public User(Long id, String username, String password, Boolean isAdmin, Boolean isActive) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.isAdmin = isAdmin;
		this.isActive = isActive;
	}
	
	public User(){}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(Boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

}
