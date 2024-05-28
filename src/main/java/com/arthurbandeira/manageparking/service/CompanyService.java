package com.arthurbandeira.manageparking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.arthurbandeira.manageparking.model.Company;
import com.arthurbandeira.manageparking.model.Vehicle;
import com.arthurbandeira.manageparking.repository.CompanyRepository;
import com.arthurbandeira.manageparking.repository.VehicleRepository;

@Service
public class CompanyService {

	@Autowired
	private CompanyRepository companyRepository;
	
	@Autowired
	private VehicleRepository vehicleRepository;

	public List<Company> findAll() {
		return companyRepository.findAll();
	}

	public List<Company> findByCnpj(String cnpj) {
		return companyRepository.findByCnpj(cnpj);
	}

	public Company create(Company company) {
		return companyRepository.save(company);
	}

	public Company update(Company company) {
		return companyRepository.saveAndFlush(company);
	}

	public void delete(@PathVariable Long id) {
		companyRepository.deleteById(id);
	}

}
