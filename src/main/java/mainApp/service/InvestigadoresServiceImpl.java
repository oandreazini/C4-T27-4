package mainApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mainApp.dao.IInvestigadoresDAO;
import mainApp.dto.Investigadores;

@Service
public class InvestigadoresServiceImpl  implements IInvestigadoresService{

	// Utilizamos los metodos de la interface IInvestigadoresDAO, es como si instaciaramos.
	@Autowired
	IInvestigadoresDAO iInvestigadoresDAO;

	@Override
	public List<Investigadores> listInvestigadores() {

		return iInvestigadoresDAO.findAll();
	}

	@Override
	public Investigadores saveInvestigadores(Investigadores investigadores) {

		return iInvestigadoresDAO.save(investigadores);
	}

	@Override
	public Investigadores investigadoresXID(Integer id) {

		return iInvestigadoresDAO.findById(id).get();	
	}

	@Override
	public Investigadores updateInvestigadores(Investigadores investigadores) {

		return  iInvestigadoresDAO.save(investigadores);
	}

	@Override
	public void deleteInvestigadores(Integer id) {
		iInvestigadoresDAO.deleteById(id);
		
	}

}
