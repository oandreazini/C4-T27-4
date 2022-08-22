package mainApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mainApp.dao.IEquiposDAO;
import mainApp.dto.Equipos;

@Service
public class EquiposServiceImpl implements IEquiposService{

	// Utilizamos los metodos de la interface IEquiposDAO, es como si instaciaramos.
	@Autowired
	IEquiposDAO iEquiposDAO;

	@Override
	public List<Equipos> listEquipos() {
		
		return iEquiposDAO.findAll();
	}

	@Override
	public Equipos saveEquipos(Equipos equipos) {
	
		return iEquiposDAO.save(equipos);
	}

	@Override
	public Equipos equiposXID(Integer id) {

		return iEquiposDAO.findById(id).get();
	}

	@Override
	public Equipos updateEquipos(Equipos equipos) {

		return  iEquiposDAO.save(equipos);
	}

	@Override
	public void deleteEquipos(Integer id) {
		iEquiposDAO.deleteById(id);
		
	}

}
