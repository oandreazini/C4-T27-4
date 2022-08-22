package mainApp.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="equipos")
public class Equipos {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "nombre")
	private String nombre;

	@ManyToOne
	@JoinColumn(name="facultad")
	private Facultades facultad;

	@OneToMany
	@JoinColumn(name="id")
	private List<Reservas> reservas;

	//Constructores

	public Equipos() {

	}

	/**
	 * 
	 * @param id
	 * @param nombre
	 * @param facultad
	 * @param reservas
	 */
	public Equipos(Integer id, String nombre, Facultades facultad, List<Reservas> reservas) {
		this.id = id;
		this.nombre = nombre;
		this.facultad = facultad;
		this.reservas = reservas;
	}
	
	// Getters & Setters
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Facultades getFacultad() {
		return facultad;
	}

	public void setFacultad(Facultades facultad) {
		this.facultad = facultad;
	}
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "reservas")
	public List<Reservas> getReservas() {
		return reservas;
	}

	public void setReservas(List<Reservas> reservas) {
		this.reservas = reservas;
	}


	//Metodo toString
	
	
	@Override
	public String toString() {
		return "Equipos [id=" + id + ", nombre=" + nombre + ", facultad=" + facultad + ", reservas=" + reservas + "]";
	}
	
}
