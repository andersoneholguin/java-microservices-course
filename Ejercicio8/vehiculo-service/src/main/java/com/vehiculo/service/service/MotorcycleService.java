package com.vehiculo.service.service;

import com.vehiculo.service.model.Motorcycle;
import com.vehiculo.service.repository.MotorcycleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MotorcycleService {

    private final MotorcycleRepository motorcycleRepository;

    public MotorcycleService(MotorcycleRepository motorcycleRepository) {
        this.motorcycleRepository = motorcycleRepository;
    }

    public List<Motorcycle> listar() {
        return motorcycleRepository.findAll();
    }

    public Optional<Motorcycle> obtenerPorId(Long id) {
        return motorcycleRepository.findById(id);
    }

    public Motorcycle crear(Motorcycle motorcycle) {
        return motorcycleRepository.save(motorcycle);
    }

    public Optional<Motorcycle> actualizar(Long id, Motorcycle motorcycle) {
        return motorcycleRepository.findById(id)
                .map(actual -> {
                    actual.setBrand(motorcycle.getBrand());
                    actual.setModel(motorcycle.getModel());
                    actual.setYear(motorcycle.getYear());
                    actual.setPrice(motorcycle.getPrice());
                    actual.setEngineCc(motorcycle.getEngineCc());
                    return motorcycleRepository.save(actual);
                });
    }

    public boolean eliminar(Long id) {
        if (!motorcycleRepository.existsById(id)) {
            return false;
        }
        motorcycleRepository.deleteById(id);
        return true;
    }
}
