package com.flota.service.controller;

import com.flota.service.dto.FlotaCotizacionResponse;
import com.flota.service.service.FlotaService;
import jakarta.validation.constraints.Positive;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/flota")
@Validated
public class FlotaController {

    private final FlotaService flotaService;

    public FlotaController(FlotaService flotaService) {
        this.flotaService = flotaService;
    }

    @GetMapping("/cotizar")
    public ResponseEntity<FlotaCotizacionResponse> cotizar(
            @RequestParam @Positive(message = "La distancia debe ser mayor a 0") Double distanciaKm) {
        FlotaCotizacionResponse response = flotaService.cotizarFlota(distanciaKm);
        return ResponseEntity.ok(response);
    }
}
