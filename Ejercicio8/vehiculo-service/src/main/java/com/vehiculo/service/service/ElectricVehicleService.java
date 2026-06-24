package com.vehiculo.service.service;

import com.vehiculo.service.model.ElectricVehicle;
import com.vehiculo.service.repository.ElectricVehicleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ElectricVehicleService {

    private final ElectricVehicleRepository electricVehicleRepository;

    public ElectricVehicleService(ElectricVehicleRepository electricVehicleRepository) {
        this.electricVehicleRepository = electricVehicleRepository;
    }

    public List<ElectricVehicle> listar() {
        return electricVehicleRepository.findAll();
    }

    public Optional<ElectricVehicle> obtenerPorId(Long id) {
        return electricVehicleRepository.findById(id);
    }

    public ElectricVehicle crear(ElectricVehicle electricVehicle) {
        return electricVehicleRepository.save(electricVehicle);
    }

    public Optional<ElectricVehicle> actualizar(Long id, ElectricVehicle electricVehicle) {
        return electricVehicleRepository.findById(id)
                .map(actual -> {
                    actual.setBrand(electricVehicle.getBrand());
                    actual.setModel(electricVehicle.getModel());
                    actual.setYear(electricVehicle.getYear());
                    actual.setPrice(electricVehicle.getPrice());
                    actual.setRangeKm(electricVehicle.getRangeKm());
                    actual.setBatteryCapacityKWh(electricVehicle.getBatteryCapacityKWh());
                    return electricVehicleRepository.save(actual);
                });
    }

    public boolean eliminar(Long id) {
        if (!electricVehicleRepository.existsById(id)) {
            return false;
        }
        electricVehicleRepository.deleteById(id);
        return true;
    }
}
