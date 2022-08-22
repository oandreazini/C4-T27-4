package mainApp.service;

import java.util.List;

import mainApp.dto.Facultades;

public interface IFacultadesService {
	
	//Metodos del CRUD
	
	public List<Facultades> listFacultades(); //Listar All 

	public Facultades saveFacultades(Facultades facultades);	//Guarda un Facultades CREATE

	public Facultades facultadesXID(Integer id); //Leer datos de un Facultades READ

	public Facultades updateFacultades(Facultades facultades); //Actualiza datos del Facultades UPDATE

	public void deleteFacultades(Integer id);// Elimina el Facultades DELETE

}
