package com.vehiculo.service.controller;

import com.vehiculo.service.model.ElectricVehicle;
import com.vehiculo.service.service.ElectricVehicleService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/electric-vehicles")
public class ElectricVehicleController {

    private final ElectricVehicleService electricVehicleService;

    public ElectricVehicleController(ElectricVehicleService electricVehicleService) {
        this.electricVehicleService = electricVehicleService;
    }

    @GetMapping
    public List<ElectricVehicle> listar() {
        return electricVehicleService.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ElectricVehicle> obtenerPorId(@PathVariable Long id) {
        return electricVehicleService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ElectricVehicle> crear(@Valid @RequestBody ElectricVehicle electricVehicle) {
        ElectricVehicle created = electricVehicleService.crear(electricVehicle);
        return ResponseEntity.created(URI.create("/api/electric-vehicles/" + created.getId())).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ElectricVehicle> actualizar(@PathVariable Long id, @Valid @RequestBody ElectricVehicle electricVehicle) {
        return electricVehicleService.actualizar(id, electricVehicle)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        if (electricVehicleService.eliminar(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
