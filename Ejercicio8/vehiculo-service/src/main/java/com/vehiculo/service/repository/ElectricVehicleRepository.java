package com.vehiculo.service.repository;

import com.vehiculo.service.model.ElectricVehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ElectricVehicleRepository extends JpaRepository<ElectricVehicle, Long> {}
