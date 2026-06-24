package com.cotizador.service.controller;

import com.cotizador.service.dto.CotizacionRequest;
import com.cotizador.service.dto.CotizacionResponse;
import com.cotizador.service.service.CotizadorService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cotizador")
public class CotizadorController {

    private final CotizadorService cotizadorService;

    public CotizadorController(CotizadorService cotizadorService) {
        this.cotizadorService = cotizadorService;
    }

    @PostMapping("/calcular")
    public ResponseEntity<CotizacionResponse> calcularCosto(@Valid @RequestBody CotizacionRequest request) {
        CotizacionResponse response = cotizadorService.calcularCosto(request);
        return ResponseEntity.ok(response);
    }
}
