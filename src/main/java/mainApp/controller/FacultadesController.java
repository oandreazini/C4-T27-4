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

import mainApp.dto.Facultades;
import mainApp.service.FacultadesServiceImpl;

@RestController
@RequestMapping("/api")
public class FacultadesController {
	
	@Autowired
	FacultadesServiceImpl facultadesServiceImpl;
	
	@GetMapping("/facultades")
	public List<Facultades> listFacultades() {
		return facultadesServiceImpl.listFacultades();
	}

	@PostMapping("/facultades")
	public Facultades saveFacultades(@RequestBody Facultades facultades) {

		return facultadesServiceImpl.saveFacultades(facultades);
	}

	@GetMapping("/facultades/{id}")
	public Facultades facultadesXID(@PathVariable(name = "id") Integer id) {

		return facultadesServiceImpl.facultadesXID(id);

	}

	@PutMapping("/facultades/{id}")
	public Facultades updateFacultades(@PathVariable(name = "id") Integer id, @RequestBody Facultades facultades) {

		Facultades facultades_select;
		Facultades facultades_update;

		facultades_select = facultadesServiceImpl.facultadesXID(id);

		facultades_select.setNombre(facultades.getNombre());
		facultades_select.setInvestigadores(facultades.getInvestigadores());
		facultades_select.setEquipos(facultades.getEquipos());

		facultades_update = facultadesServiceImpl.updateFacultades(facultades_select);

		System.out.println("El facultades actualizado es: " + facultades_select);

		return facultades_update;
	}

	@DeleteMapping("/facultades/{id}")
	public void deleteFacultades(@PathVariable(name = "id") Integer id) {
		facultadesServiceImpl.deleteFacultades(id);
	}

}
