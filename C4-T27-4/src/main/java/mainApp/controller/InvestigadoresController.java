package mainApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mainApp.dto.Investigadores;
import mainApp.service.InvestigadoresServiceImpl;

@RestController
@RequestMapping("/api")
public class InvestigadoresController {
	
	@Autowired
	InvestigadoresServiceImpl investigadoresServiceImpl;
	
	@GetMapping("/investigadores")
	public List<Investigadores> listInvestigadores() {
		return investigadoresServiceImpl.listInvestigadores();
	}

	@PostMapping("/investigadores")
	public Investigadores saveInvestigadores(@RequestBody Investigadores investigadores) {

		return investigadoresServiceImpl.saveInvestigadores(investigadores);
	}

	@GetMapping("/investigadores/{id}")
	public Investigadores investigadoresXID(@PathVariable(name = "id") Integer id) {

		return investigadoresServiceImpl.investigadoresXID(id);

	}

	@PutMapping("/investigadores/{id}")
	public Investigadores updateInvestigadores(@PathVariable(name = "id") Integer id, @RequestBody Investigadores investigadores) {

		Investigadores investigadores_select;
		Investigadores investigadores_update;

		investigadores_select = investigadoresServiceImpl.investigadoresXID(id);

		investigadores_select.setDni(investigadores.getDni());
		investigadores_select.setNombre_apellidos(investigadores.getNombre_apellidos());
		investigadores_select.setFacultades(investigadores.getFacultades());
		investigadores_select.setReservas(investigadores.getReservas());
		
		investigadores_update = investigadoresServiceImpl.updateInvestigadores(investigadores_select);

		System.out.println("El investigadores actualizado es: " + investigadores_select);

		return investigadores_update;
	}

	@DeleteMapping("/investigadores/{id}")
	public void deleteInvestigadores(@PathVariable(name = "id") Integer id) {
		investigadoresServiceImpl.deleteInvestigadores(id);
	}

}
