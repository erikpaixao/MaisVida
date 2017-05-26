package desafio.maisvidas.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class City {
	
	@Id
	@GeneratedValue
	private Long id;
	@Enumerated
	private State state;
	private String name;
	@OneToMany(mappedBy="id")
	@JsonIgnore
	private List<Medic> medic;

	public City() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Medic> getMedic() {
		return medic;
	}

	public void setMedic(List<Medic> medic) {
		this.medic = medic;
	}

}
