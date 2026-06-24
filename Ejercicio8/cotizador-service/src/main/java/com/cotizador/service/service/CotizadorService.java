package com.cotizador.service.service;

import com.cotizador.service.dto.CotizacionRequest;
import com.cotizador.service.dto.CotizacionResponse;
import com.cotizador.service.model.VehicleType;
import org.springframework.stereotype.Service;

@Service
public class CotizadorService {

    // Tarifas base por km (en USD)
    private static final double TARIFA_AUTO = 2.50;
    private static final double TARIFA_MOTO = 1.50;
    private static final double TARIFA_ELECTRICO = 1.00;

    public CotizacionResponse calcularCosto(CotizacionRequest request) {
        double tarifa = obtenerTarifa(request.getTipoVehiculo());
        double costoTotal = Math.round(tarifa * request.getDistanciaKm() * 100.0) / 100.0;

        return new CotizacionResponse(
                request.getDistanciaKm(),
                request.getTipoVehiculo(),
                tarifa,
                costoTotal
        );
    }

    private double obtenerTarifa(VehicleType tipoVehiculo) {
        return switch (tipoVehiculo) {
            case CAR -> TARIFA_AUTO;
            case MOTORCYCLE -> TARIFA_MOTO;
            case ELECTRIC_VEHICLE -> TARIFA_ELECTRICO;
        };
    }
}
