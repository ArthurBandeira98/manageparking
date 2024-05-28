package com.arthurbandeira.manageparking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arthurbandeira.manageparking.model.Vehicle;
import com.arthurbandeira.manageparking.repository.CompanyRepository;
import com.arthurbandeira.manageparking.repository.VehicleRepository;
import com.arthurbandeira.manageparking.request.VehicleRequest;

@Service
public class VehicleService {

	@Autowired
	private VehicleRepository vehicleRepository;
	
	@Autowired
	private CompanyRepository companyRepository;

	public List<Vehicle> find() {
		return vehicleRepository.findAll();
	}

	public Vehicle create(VehicleRequest vehicle) {
		return vehicleRepository.save(new Vehicle(null, vehicle.getBrand(), vehicle.getModel(), vehicle.getColor(), vehicle.getPlate(), vehicle.getType(), null));
	}
	
	public Vehicle updateCompany(Vehicle vehicleModel) {
		Vehicle vehicle = vehicleRepository.findById(vehicleModel.getId()).orElseThrow();
		vehicle.setCompany(companyRepository.findById(vehicleModel.getCompany().getId()).orElseThrow());
		return vehicleRepository.saveAndFlush(vehicle);
	}

	public void delete(Long id) {
		vehicleRepository.deleteById(id);
	}

}
