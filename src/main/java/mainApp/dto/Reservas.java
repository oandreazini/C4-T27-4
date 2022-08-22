package mainApp.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="reservas")
public class Reservas {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer id;


	@ManyToOne
	@JoinColumn(name="id_investigadores")
	private Investigadores investigadores;

	@ManyToOne
	@JoinColumn(name="id_equipos")
	private Equipos equipos;

	@Column(name="comienzo")
	private String comienzo;

	@Column(name="fin")
	private String fin;

	//Constructores

	public Reservas() {

	}
	
	/**
	 * 
	 * @param id
	 * @param investigadores
	 * @param equipos
	 * @param comienzo
	 * @param fin
	 */
	public Reservas(Integer id, Investigadores investigadores, Equipos equipos, String comienzo, String fin) {
		this.id = id;
		this.investigadores = investigadores;
		this.equipos = equipos;
		this.comienzo = comienzo;
		this.fin = fin;
	}
	
	
	// Getters & Setters
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Investigadores getInvestigadores() {
		return investigadores;
	}

	public void setInvestigadores(Investigadores investigadores) {
		this.investigadores = investigadores;
	}

	public Equipos getEquipos() {
		return equipos;
	}

	public void setEquipos(Equipos equipos) {
		this.equipos = equipos;
	}

	public String getComienzo() {
		return comienzo;
	}

	public void setComienzo(String comienzo) {
		this.comienzo = comienzo;
	}

	public String getFin() {
		return fin;
	}

	public void setFin(String fin) {
		this.fin = fin;
	}


	//Metodo toString
	
	@Override
	public String toString() {
		return "Reservas [id=" + id + ", investigadores=" + investigadores + ", equipos=" + equipos + ", comienzo="
				+ comienzo + ", fin=" + fin + "]";
	}

}
