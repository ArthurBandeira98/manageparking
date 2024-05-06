package com.arthurbandeira.manageparking.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.arthurbandeira.manageparking.model.Company;
import com.arthurbandeira.manageparking.repository.impl.CompanyRepositoryImpl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

@SpringBootTest
public class CompanyRepositoryTest {

	@Mock
	private EntityManager entityManager;

	@Mock
	private CriteriaBuilder criteriaBuilder;

	@Mock
	private CriteriaQuery<Company> criteriaQuery;

	@Mock
	private Root<Company> root;

	@Mock
	private TypedQuery<Company> typedQuery;

	@InjectMocks
	private CompanyRepositoryImpl companyRepository;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	@DisplayName("Should find Company by CNPJ and return success")
	void findByCnpjSuccess() {
		String cnpj = "123456789";

		Company company = new Company();
		company.setCnpj(cnpj);

		List<Company> companies = new ArrayList<>();
		companies.add(company);

		when(entityManager.getCriteriaBuilder()).thenReturn(criteriaBuilder);
		when(criteriaBuilder.createQuery(Company.class)).thenReturn(criteriaQuery);
		when(criteriaQuery.from(Company.class)).thenReturn(root);
		when(criteriaQuery.select(root)).thenReturn(criteriaQuery);
		when(entityManager.createQuery(criteriaQuery)).thenReturn(typedQuery);
		when(typedQuery.getResultList()).thenReturn(companies);

		List<Company> result = companyRepository.findByCnpj(cnpj);

		assertEquals(1, result.size());
		assertEquals(cnpj, result.get(0).getCnpj());

		verify(entityManager).getCriteriaBuilder();
		verify(criteriaBuilder).createQuery(Company.class);
		verify(criteriaQuery).from(Company.class);
		verify(criteriaBuilder).equal(root.get("cnpj"), cnpj);
		verify(entityManager).createQuery(criteriaQuery);
		verify(typedQuery).getResultList();
	}

}
