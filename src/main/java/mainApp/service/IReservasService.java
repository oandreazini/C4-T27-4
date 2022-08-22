package mainApp.service;

import java.util.List;

import mainApp.dto.Reservas;

public interface IReservasService {

	//Metodos del CRUD

	public List<Reservas> listReservas(); //Listar All 

	public Reservas saveReservas(Reservas reservas);	//Guarda un Reservas CREATE

	public Reservas reservasXID(Integer id); //Leer datos de un Reservas READ

	public Reservas updateReservas(Reservas reservas); //Actualiza datos del Reservas UPDATE

	public void deleteReservas(Integer id);// Elimina el Reservas DELETE

}
