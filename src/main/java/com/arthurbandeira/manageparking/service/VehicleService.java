package com.arthurbandeira.manageparking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.arthurbandeira.manageparking.model.Vehicle;
import com.arthurbandeira.manageparking.repository.VehicleRepository;

public class VehicleService {

	@Autowired
	private VehicleRepository vehicleRepository;

	public List<Vehicle> find() {
		return vehicleRepository.findAll();
	}

	public Vehicle create(Vehicle vehicle) {
		return vehicleRepository.save(vehicle);
	}

	public void delete(Long id) {
		vehicleRepository.deleteById(id);
	}

}
