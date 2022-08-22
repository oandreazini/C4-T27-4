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

import mainApp.dto.Equipos;
import mainApp.service.EquiposServiceImpl;


@RestController
@RequestMapping("/api")
public class EquiposContoller {
	
	@Autowired
	EquiposServiceImpl equiposServiceImpl;
	
	@GetMapping("/equipos")
	public List<Equipos> listEquipos() {
		return equiposServiceImpl.listEquipos();
	}

	@PostMapping("/equipos")
	public Equipos saveEquipos(@RequestBody Equipos equipos) {

		return equiposServiceImpl.saveEquipos(equipos);
	}

	@GetMapping("/equipos/{id}")
	public Equipos equiposXID(@PathVariable(name = "id") Integer id) {

		return equiposServiceImpl.equiposXID(id);

	}

	@PutMapping("/equipos/{id}")
	public Equipos updateEquipos(@PathVariable(name = "id") Integer id, @RequestBody Equipos equipos) {

		Equipos equipos_select;
		Equipos equipos_update;

		equipos_select = equiposServiceImpl.equiposXID(id);

		equipos_select.setNombre(equipos.getNombre());
		equipos_select.setFacultad(equipos.getFacultad());
		equipos_select.setReservas(equipos.getReservas());
	
		equipos_update = equiposServiceImpl.updateEquipos(equipos_select);

		System.out.println("El Equipos actualizado es: " + equipos_select);

		return equipos_update;
	}

	@DeleteMapping("/equipos/{id}")
	public void deleteEquipos(@PathVariable(name = "id") Integer id) {
		equiposServiceImpl.deleteEquipos(id);
	}


}
