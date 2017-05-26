package desafio.maisvidas.model;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.validator.constraints.Email;

@Entity
public class Medic {
	@Id
	@GeneratedValue
	private Long id;
	private String lastName;
	private String firstName;
	@Email(message = "campo e-mail não é válido")
	private String email;
	private Boolean isActive;
	private Boolean isOccupied;
	@Enumerated
	private Speciality speciality;
	@ManyToOne
	private City city;

	public Medic(Long id, String lastName, String firstName, String email, Boolean isActive, Boolean isOccupied,
			Speciality speciality, City city) {
		super();
		this.id = id;
		this.lastName = lastName;
		this.firstName = firstName;
		this.email = email;
		this.isActive = isActive;
		this.isOccupied = isOccupied;
		this.speciality = speciality;
		this.city = city;
	}

	public Medic() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public Boolean getIsOccupied() {
		return isOccupied;
	}

	public void setIsOccupied(Boolean isOccupied) {
		this.isOccupied = isOccupied;
	}

	public Speciality getSpeciality() {
		return speciality;
	}

	public void setSpeciality(Speciality speciality) {
		this.speciality = speciality;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

}
