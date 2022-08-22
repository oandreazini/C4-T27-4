package mainApp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import mainApp.dto.Facultades;

public interface IFacultadesDAO extends JpaRepository<Facultades, Integer> {

}
