package com.flota.service.service;

import com.flota.service.client.CotizadorClient;
import com.flota.service.client.VehiculoClient;
import com.flota.service.dto.CotizacionResponseDTO;
import com.flota.service.dto.FlotaCotizacionResponse;
import com.flota.service.dto.VehiculoCotizadoDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FlotaService {

    private final VehiculoClient vehiculoClient;
    private final CotizadorClient cotizadorClient;

    public FlotaService(VehiculoClient vehiculoClient, CotizadorClient cotizadorClient) {
        this.vehiculoClient = vehiculoClient;
        this.cotizadorClient = cotizadorClient;
    }

    public FlotaCotizacionResponse cotizarFlota(Double distanciaKm) {
        List<VehiculoCotizadoDTO> cotizaciones = new ArrayList<>();

        // Cotizar autos
        vehiculoClient.obtenerAutos().forEach(car -> {
            CotizacionResponseDTO cotizacion = cotizadorClient.calcularCosto(distanciaKm, "CAR");
            cotizaciones.add(new VehiculoCotizadoDTO(
                    "CAR", car, cotizacion.getTarifaPorKm(), cotizacion.getCostoTotal()
            ));
        });

        // Cotizar motos
        vehiculoClient.obtenerMotos().forEach(moto -> {
            CotizacionResponseDTO cotizacion = cotizadorClient.calcularCosto(distanciaKm, "MOTORCYCLE");
            cotizaciones.add(new VehiculoCotizadoDTO(
                    "MOTORCYCLE", moto, cotizacion.getTarifaPorKm(), cotizacion.getCostoTotal()
            ));
        });

        // Cotizar vehiculos electricos
        vehiculoClient.obtenerElectricos().forEach(electrico -> {
            CotizacionResponseDTO cotizacion = cotizadorClient.calcularCosto(distanciaKm, "ELECTRIC_VEHICLE");
            cotizaciones.add(new VehiculoCotizadoDTO(
                    "ELECTRIC_VEHICLE", electrico, cotizacion.getTarifaPorKm(), cotizacion.getCostoTotal()
            ));
        });

        return new FlotaCotizacionResponse(distanciaKm, cotizaciones);
    }
}
