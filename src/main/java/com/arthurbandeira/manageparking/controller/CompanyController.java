package com.arthurbandeira.manageparking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.arthurbandeira.manageparking.model.Company;
import com.arthurbandeira.manageparking.service.CompanyService;

@RestController
@RequestMapping("/company")
public class CompanyController {

	@Autowired
	private CompanyService companyService;

	@GetMapping
	public List<Company> findAll() {
		return companyService.findAll();
	}

	@GetMapping("/{cnpj}")
	public List<Company> findCompany(@PathVariable String cnpj) {
		return companyService.findByCnpj(cnpj);
	}

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public Company create(@RequestBody Company company) {
		return companyService.create(company);
	}
	
	@PutMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public Company update(@RequestBody Company company) {
		return companyService.update(company);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		companyService.delete(id);
	}

}
