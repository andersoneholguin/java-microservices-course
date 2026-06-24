package com.flota.service.dto;

import java.util.List;

public class FlotaCotizacionResponse {
    private Double distanciaKm;
    private List<VehiculoCotizadoDTO> cotizaciones;

    public FlotaCotizacionResponse(Double distanciaKm, List<VehiculoCotizadoDTO> cotizaciones) {
        this.distanciaKm = distanciaKm;
        this.cotizaciones = cotizaciones;
    }

    public Double getDistanciaKm() { return distanciaKm; }
    public void setDistanciaKm(Double distanciaKm) { this.distanciaKm = distanciaKm; }

    public List<VehiculoCotizadoDTO> getCotizaciones() { return cotizaciones; }
    public void setCotizaciones(List<VehiculoCotizadoDTO> cotizaciones) { this.cotizaciones = cotizaciones; }
}
