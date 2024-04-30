package com.arthurbandeira.manageparking.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.arthurbandeira.manageparking.model.Company;
import com.arthurbandeira.manageparking.repository.CompanyRepositoryCustom;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

public class CompanyRepositoryImpl implements CompanyRepositoryCustom {

	@Autowired
	private EntityManager manager;
	
	@Override
	public List<Company> findByCnpj(String cnpj) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Company> query = builder.createQuery(Company.class);
		Root<Company> root = query.from(Company.class);
		
		Predicate predicate = builder.and(builder.equal(root.get("cnpj"), cnpj));
		query.select(root).where(predicate);
		
		TypedQuery<Company> typedQuery = manager.createQuery(query);
		return typedQuery.getResultList();
	}

}
