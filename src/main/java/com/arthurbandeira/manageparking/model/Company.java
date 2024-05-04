package com.arthurbandeira.manageparking.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "EMPRESA")
public class Company {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "NOME")
	private String name;

	@Column(name = "CNPJ")
	private String cnpj;

	@Column(name = "ENDERECO")
	private String address;

	@Column(name = "TELEFONE")
	private String phoneNumber;
	
//	@OneToMany
//	@JoinColumn(name = "ID_VEICULO")
//	private List<Vehicle> vehicles;

	@Column(name = "QNT_CARRO")
	private Long quantityForCar;

	@Column(name = "QNT_MOTO")
	private Long quantityForMotorcycle;

	public Company() {
	}

	public Company(Long id, String name, String cnpj, String address, String phoneNumber, Long quantityForCar,
			Long quantityForMotorcycle) {
		this.id = id;
		this.name = name;
		this.cnpj = cnpj;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.quantityForCar = quantityForCar;
		this.quantityForMotorcycle = quantityForMotorcycle;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Long getQuantityForCar() {
		return quantityForCar;
	}

	public void setQuantityForCar(Long quantityForCar) {
		this.quantityForCar = quantityForCar;
	}

	public Long getQuantityForMotorcycle() {
		return quantityForMotorcycle;
	}

	public void setQuantityForMotorcycle(Long quantityForMotorcycle) {
		this.quantityForMotorcycle = quantityForMotorcycle;
	}

}
