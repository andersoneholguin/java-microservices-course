package com.vehiculo.service.controller;

import com.vehiculo.service.model.Motorcycle;
import com.vehiculo.service.service.MotorcycleService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/motorcycles")
public class MotorcycleController {

    private final MotorcycleService motorcycleService;

    public MotorcycleController(MotorcycleService motorcycleService) {
        this.motorcycleService = motorcycleService;
    }

    @GetMapping
    public List<Motorcycle> listar() {
        return motorcycleService.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Motorcycle> obtenerPorId(@PathVariable Long id) {
        return motorcycleService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Motorcycle> crear(@Valid @RequestBody Motorcycle motorcycle) {
        Motorcycle created = motorcycleService.crear(motorcycle);
        return ResponseEntity.created(URI.create("/api/motorcycles/" + created.getId())).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Motorcycle> actualizar(@PathVariable Long id, @Valid @RequestBody Motorcycle motorcycle) {
        return motorcycleService.actualizar(id, motorcycle)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        if (motorcycleService.eliminar(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
