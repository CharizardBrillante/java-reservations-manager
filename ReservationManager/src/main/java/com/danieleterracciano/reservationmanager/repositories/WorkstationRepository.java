package com.danieleterracciano.reservationmanager.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.danieleterracciano.reservationmanager.entities.Workstation;
import com.danieleterracciano.reservationmanager.entities.WorkstationType;

@Repository
public interface WorkstationRepository extends JpaRepository<Workstation, Integer>{

	@Query(
		nativeQuery = true,
		value = "SELECT * FROM workstations WHERE type LIKE :t AND EXISTS(SELECT * FROM buildings WHERE city LIKE :c)"
	)
	public List<Workstation> findWorkstationsByCityAndType(@Param("c") String city, @Param("t") WorkstationType t);
	
	@Query(
			nativeQuery = true,
			value = "SELECT * FROM workstations WHERE type = :t"
		)
		public List<Workstation> findWorkstationByType(@Param("t") WorkstationType t);
	
	
}
