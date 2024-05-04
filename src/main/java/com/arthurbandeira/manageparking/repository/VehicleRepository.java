package com.arthurbandeira.manageparking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.arthurbandeira.manageparking.model.Vehicle;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

}
