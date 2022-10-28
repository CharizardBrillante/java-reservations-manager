package com.danieleterracciano.reservationmanager.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.danieleterracciano.reservationmanager.entities.Building;
import com.danieleterracciano.reservationmanager.entities.Workstation;
import com.danieleterracciano.reservationmanager.entities.WorkstationType;
import com.danieleterracciano.reservationmanager.repositories.WorkstationRepository;

@Service
public class WorkstationService {

	@Autowired
	WorkstationRepository wr;
	
	@Autowired
	BuildingService bs;
	
	public void saveWorkstation(Workstation w) {
		wr.save(w);
	}
	
	public void deleteWorkstationById(int id) {
		wr.deleteById(id);
	}
	
	public Optional<Workstation> getWorkstationById(int id) {
		return wr.findById(id);
	}
	
	public List<Workstation> getAllWorkstations(){
		return wr.findAll();
	}
	
	
	public List<Workstation> getWorkstationByType(WorkstationType t){
		return wr.findWorkstationByType(t);
	}
	
//	public List<Workstation> getWorkstationsByCityAndType(String city, WorkstationType type){
//		List<Workstation> res = new ArrayList<Workstation>();
//		for(Workstation w : getWorkstationByType(type)) {
//			for(Building b : bs.getBuildingByCity(city)) {
//				if (w.getBuilding().getId() == b.getId()) {
//					res.add(w);
//				}
//			}
//		}
//		return res;
//	}
	
	public List<Workstation> getWorkstationsByCityAndType(String city, WorkstationType t){
		return wr.findWorkstationsByCityAndType(city, t);
	}
}
