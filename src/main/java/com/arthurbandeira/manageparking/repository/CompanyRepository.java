package com.arthurbandeira.manageparking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.arthurbandeira.manageparking.model.Company;

public interface CompanyRepository extends JpaRepository<Company, Long>, CompanyRepositoryCustom {

}
