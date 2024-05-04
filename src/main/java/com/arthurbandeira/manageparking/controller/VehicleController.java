package com.arthurbandeira.manageparking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arthurbandeira.manageparking.model.Vehicle;
import com.arthurbandeira.manageparking.repository.VehicleRepository;

@RestController
@RequestMapping("/vehicle")
public class VehicleController {

	@Autowired
	private VehicleRepository vehicleRepository;

	@GetMapping
	List<Vehicle> find() {
		return vehicleRepository.findAll();
	}

	@PostMapping
	Vehicle create(@RequestBody Vehicle vehicle) {
		return vehicleRepository.save(vehicle);
	}

	@DeleteMapping("/{id}")
	void delete(@PathVariable Long id) {
		vehicleRepository.deleteById(id);
	}

}
