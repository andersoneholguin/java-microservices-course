package com.cotizador.service.dto;

import com.cotizador.service.model.VehicleType;

public class CotizacionResponse {

    private Double distanciaKm;
    private VehicleType tipoVehiculo;
    private Double tarifaPorKm;
    private Double costoTotal;

    public CotizacionResponse(Double distanciaKm, VehicleType tipoVehiculo, Double tarifaPorKm, Double costoTotal) {
        this.distanciaKm = distanciaKm;
        this.tipoVehiculo = tipoVehiculo;
        this.tarifaPorKm = tarifaPorKm;
        this.costoTotal = costoTotal;
    }

    public Double getDistanciaKm() {
        return distanciaKm;
    }

    public void setDistanciaKm(Double distanciaKm) {
        this.distanciaKm = distanciaKm;
    }

    public VehicleType getTipoVehiculo() {
        return tipoVehiculo;
    }

    public void setTipoVehiculo(VehicleType tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }

    public Double getTarifaPorKm() {
        return tarifaPorKm;
    }

    public void setTarifaPorKm(Double tarifaPorKm) {
        this.tarifaPorKm = tarifaPorKm;
    }

    public Double getCostoTotal() {
        return costoTotal;
    }

    public void setCostoTotal(Double costoTotal) {
        this.costoTotal = costoTotal;
    }
}
