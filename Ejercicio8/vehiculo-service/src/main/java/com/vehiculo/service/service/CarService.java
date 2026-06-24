package com.vehiculo.service.service;

import com.vehiculo.service.model.Car;
import com.vehiculo.service.repository.CarRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarService {

    private final CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public List<Car> listar() {
        return carRepository.findAll();
    }

    public Optional<Car> obtenerPorId(Long id) {
        return carRepository.findById(id);
    }

    public Car crear(Car car) {
        return carRepository.save(car);
    }

    public Optional<Car> actualizar(Long id, Car car) {
        return carRepository.findById(id)
                .map(actual -> {
                    actual.setBrand(car.getBrand());
                    actual.setModel(car.getModel());
                    actual.setYear(car.getYear());
                    actual.setPrice(car.getPrice());
                    actual.setDoors(car.getDoors());
                    return carRepository.save(actual);
                });
    }

    public boolean eliminar(Long id) {
        if (!carRepository.existsById(id)) {
            return false;
        }
        carRepository.deleteById(id);
        return true;
    }
}
