package mainApp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import mainApp.dto.Reservas;

public interface IReservasDAO extends JpaRepository<Reservas, Integer> {

}
