package mainApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mainApp.dao.IFacultadesDAO;
import mainApp.dto.Facultades;



@Service
public class FacultadesServiceImpl implements IFacultadesService {
	
	// Utilizamos los metodos de la interface IFacultadesDAO, es como si instaciaramos.
	@Autowired
	IFacultadesDAO iFacultadesDAO;

		@Override
		public List<Facultades> listFacultades() {
			
			return iFacultadesDAO.findAll();
		}

		@Override
		public Facultades saveFacultades(Facultades facultades) {

			return iFacultadesDAO.save(facultades);
		}

		@Override
		public Facultades facultadesXID(Integer id) {
		
			return iFacultadesDAO.findById(id).get();	
		}

		@Override
		public Facultades updateFacultades(Facultades facultades) {
			
			return  iFacultadesDAO.save(facultades);
		}

		@Override
		public void deleteFacultades(Integer id) {
			iFacultadesDAO.deleteById(id);
			
		}
		
}
