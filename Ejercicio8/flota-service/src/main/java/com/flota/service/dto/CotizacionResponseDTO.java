package com.flota.service.dto;

public class CotizacionResponseDTO {
    private Double distanciaKm;
    private String tipoVehiculo;
    private Double tarifaPorKm;
    private Double costoTotal;

    public Double getDistanciaKm() { return distanciaKm; }
    public void setDistanciaKm(Double distanciaKm) { this.distanciaKm = distanciaKm; }

    public String getTipoVehiculo() { return tipoVehiculo; }
    public void setTipoVehiculo(String tipoVehiculo) { this.tipoVehiculo = tipoVehiculo; }

    public Double getTarifaPorKm() { return tarifaPorKm; }
    public void setTarifaPorKm(Double tarifaPorKm) { this.tarifaPorKm = tarifaPorKm; }

    public Double getCostoTotal() { return costoTotal; }
    public void setCostoTotal(Double costoTotal) { this.costoTotal = costoTotal; }
}
