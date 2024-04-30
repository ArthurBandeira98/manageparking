package com.arthurbandeira.manageparking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arthurbandeira.manageparking.model.Company;
import com.arthurbandeira.manageparking.repository.CompanyRepository;

@RestController
@RequestMapping("/company")
public class CompanyController {

	@Autowired
	private CompanyRepository companyRepository;
	
	@GetMapping("/{cnpj}")
	List<Company> findCompany(@PathVariable String cnpj) {
		return companyRepository.findByCnpj(cnpj);
	}
	
}
