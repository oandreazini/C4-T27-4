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

import mainApp.dto.Reservas;
import mainApp.service.ReservasServiceImpl;

@RestController
@RequestMapping("/api")
public class ReservasController {
	
	@Autowired
	ReservasServiceImpl reservasServiceImpl;
	
	@GetMapping("/reservas")
	public List<Reservas> listReservas() {
		return reservasServiceImpl.listReservas();
	}

	@PostMapping("/reservas")
	public Reservas saveReservas(@RequestBody Reservas reservas) {

		return reservasServiceImpl.saveReservas(reservas);
	}

	@GetMapping("/reservas/{id}")
	public Reservas reservasXID(@PathVariable(name = "id") Integer id) {

		return reservasServiceImpl.reservasXID(id);

	}

	@PutMapping("/reservas/{id}")
	public Reservas updateReservas(@PathVariable(name = "id") Integer id, @RequestBody Reservas reservas) {

		Reservas reservas_select;
		Reservas reservas_update;

		reservas_select = reservasServiceImpl.reservasXID(id);
		
		reservas_select.setInvestigadores(reservas.getInvestigadores());
		reservas_select.setEquipos(reservas.getEquipos());
		reservas_select.setComienzo(reservas.getComienzo());
		reservas_select.setFin(reservas.getFin());
		
		reservas_update = reservasServiceImpl.updateReservas(reservas_select);

		System.out.println("El reservas actualizado es: " + reservas_select);

		return reservas_update;
	}

	@DeleteMapping("/reservas/{id}")
	public void deleteReservas(@PathVariable(name = "id") Integer id) {
		reservasServiceImpl.deleteReservas(id);
	}

}
