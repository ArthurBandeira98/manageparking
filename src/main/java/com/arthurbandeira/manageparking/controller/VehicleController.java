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
import com.arthurbandeira.manageparking.service.VehicleService;

@RestController
@RequestMapping("/vehicle")
public class VehicleController {

	@Autowired
	private VehicleService vehicleService;

	@GetMapping
	public List<Vehicle> find() {
		return vehicleService.find();
	}

	@PostMapping
	public Vehicle create(@RequestBody Vehicle vehicle) {
		return vehicleService.create(vehicle);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		vehicleService.delete(id);
	}

}
