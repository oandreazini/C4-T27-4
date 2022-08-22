package mainApp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import mainApp.dto.Equipos;

public interface IEquiposDAO extends JpaRepository<Equipos, Integer>{

}
