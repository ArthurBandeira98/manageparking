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

import com.arthurbandeira.manageparking.model.Company;
import com.arthurbandeira.manageparking.repository.CompanyRepository;

@RestController
@RequestMapping("/company")
public class CompanyController {

	@Autowired
	private CompanyRepository companyRepository;

	@GetMapping
	List<Company> findAll() {
		return companyRepository.findAll();
	}

	@GetMapping("/{cnpj}")
	List<Company> findCompany(@PathVariable String cnpj) {
		return companyRepository.findByCnpj(cnpj);
	}
	
	@PostMapping
	Company create(@RequestBody Company company) {
		return companyRepository.save(company);
	}
	
	@DeleteMapping("/{id}")
	void delete(@PathVariable Long id) {
		companyRepository.deleteById(id);
	}

}
