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
@Table(name="investigadores")
public class Investigadores {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="dni")
	private String dni;
		
	@Column(name="nombre_apellidos")
	private String nombre_apellidos;
	
	@ManyToOne
	@JoinColumn(name="facultad")
	private Facultades facultades;
	
	@OneToMany
	@JoinColumn(name="id")
	private List<Reservas> reservas;
	
	//Constructores
	
	public Investigadores() {

	}

	/**
	 * 
	 * @param id
	 * @param dni
	 * @param nombre_apellidos
	 * @param facultades
	 * @param reservas
	 */
	public Investigadores(Integer id, String dni, String nombre_apellidos, Facultades facultades,
			List<Reservas> reservas) {
		this.id = id;
		this.dni = dni;
		this.nombre_apellidos = nombre_apellidos;
		this.facultades = facultades;
		this.reservas = reservas;
	}
	
	// Getters & Setters

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre_apellidos() {
		return nombre_apellidos;
	}

	public void setNombre_apellidos(String nombre_apellidos) {
		this.nombre_apellidos = nombre_apellidos;
	}

	public Facultades getFacultades() {
		return facultades;
	}

	public void setFacultades(Facultades facultades) {
		this.facultades = facultades;
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
		return "Investigadores [id=" + id + ", dni=" + dni + ", nombre_apellidos=" + nombre_apellidos + ", facultades="
				+ facultades + ", reservas=" + reservas + "]";
	}

}
