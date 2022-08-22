package mainApp.service;

import java.util.List;

import mainApp.dto.Equipos;


public interface IEquiposService {

	//Metodos del CRUD

	public List<Equipos> listEquipos(); //Listar All 

	public Equipos saveEquipos(Equipos equipos); //Guarda un Equipos CREATE

	public Equipos equiposXID(Integer id); //Leer datos de un Equipos READ

	public Equipos updateEquipos(Equipos equipos); //Actualiza datos del FacEquiposultades UPDATE

	public void deleteEquipos(Integer id);// Elimina el Equipos DELETE

}
