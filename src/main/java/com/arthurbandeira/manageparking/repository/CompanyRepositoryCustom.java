package com.arthurbandeira.manageparking.repository;

import java.util.List;

import com.arthurbandeira.manageparking.model.Company;

public interface CompanyRepositoryCustom {

	List<Company> findByCnpj(String cnpj);
	
}
