package mainApp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import mainApp.dto.Investigadores;

public interface IInvestigadoresDAO extends JpaRepository<Investigadores, Integer>{

}
