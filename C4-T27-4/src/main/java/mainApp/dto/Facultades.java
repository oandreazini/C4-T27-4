package mainApp.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "facultades")
public class Facultades {
	
		// Atributos de entidad facultades
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Integer id;
		@Column(name = "nombre")
		private String nombre;

		@OneToMany
		@JoinColumn(name="id")
		private List<Investigadores> investigadores;
		
		@OneToMany
		@JoinColumn(name="id")
		private List<Equipos> equipos;

		//Constructores
		
		public Facultades() {

		}
		
		/**
		 * 
		 * @param id
		 * @param nombre
		 * @param investigadores
		 * @param equipos
		 */
		public Facultades(int id, String nombre, List<Investigadores> investigadores, List<Equipos> equipos) {
			this.id = id;
			this.nombre = nombre;
			this.investigadores = investigadores;
			this.equipos = equipos;
		}
		
		// Getters & Setters
		
		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}
		
		@JsonIgnore
		@OneToMany(fetch = FetchType.LAZY, mappedBy = "Investigadores")
		public List<Investigadores> getInvestigadores() {
			return investigadores;
		}

		public void setInvestigadores(List<Investigadores> investigadores) {
			this.investigadores = investigadores;
		}
		
		@JsonIgnore
		@OneToMany(fetch = FetchType.LAZY, mappedBy = "Equipos")
		public List<Equipos> getEquipos() {
			return equipos;
		}

		public void setEquipos(List<Equipos> equipos) {
			this.equipos = equipos;
		}

		
		//Metodo toString
		
		@Override
		public String toString() {
			return "Facultades [id=" + id + ", nombre=" + nombre + ", investigadores=" + investigadores + ", equipos="
					+ equipos + "]";
		}
}
