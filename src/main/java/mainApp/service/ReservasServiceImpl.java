package mainApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mainApp.dao.IReservasDAO;
import mainApp.dto.Reservas;

@Service
public class ReservasServiceImpl implements IReservasService {
	
	// Utilizamos los metodos de la interface IReservasDAO, es como si instaciaramos.
	@Autowired
	IReservasDAO iReservasDAO;

	@Override
	public List<Reservas> listReservas() {
		
		return iReservasDAO.findAll();
	}

	@Override
	public Reservas saveReservas(Reservas reservas) {
	
		return iReservasDAO.save(reservas);
	}

	@Override
	public Reservas reservasXID(Integer id) {

		return  iReservasDAO.findById(id).get();
	}

	@Override
	public Reservas updateReservas(Reservas reservas) {

		return iReservasDAO.save(reservas);
	}

	@Override
	public void deleteReservas(Integer id) {
		iReservasDAO.deleteById(id);
		
	}

}
