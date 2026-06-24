package com.vehiculo.service.controller;

import com.vehiculo.service.model.Car;
import com.vehiculo.service.service.CarService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/cars")
public class CarController {

    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping
    public List<Car> listar() {
        return carService.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Car> obtenerPorId(@PathVariable Long id) {
        return carService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Car> crear(@Valid @RequestBody Car car) {
        Car created = carService.crear(car);
        return ResponseEntity.created(URI.create("/api/cars/" + created.getId())).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Car> actualizar(@PathVariable Long id, @Valid @RequestBody Car car) {
        return carService.actualizar(id, car)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        if (carService.eliminar(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
