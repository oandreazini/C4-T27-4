package mainApp.service;

import java.util.List;

import mainApp.dto.Investigadores;

public interface IInvestigadoresService {
	
	//Metodos del CRUD
	
		public List<Investigadores> listInvestigadores(); //Listar All 

		public Investigadores saveInvestigadores(Investigadores investigadores);	//Guarda un Investigadores CREATE

		public Investigadores investigadoresXID(Integer id); //Leer datos de un Investigadores READ

		public Investigadores updateInvestigadores(Investigadores investigadores); //Actualiza datos del Investigadores UPDATE

		public void deleteInvestigadores(Integer id);// Elimina el Investigadores DELETE

}
