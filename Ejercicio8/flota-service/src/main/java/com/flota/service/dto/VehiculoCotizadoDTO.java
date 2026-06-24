package com.flota.service.dto;

public class VehiculoCotizadoDTO {
    private String tipoVehiculo;
    private Object vehiculo;
    private Double tarifaPorKm;
    private Double costoTotal;

    public VehiculoCotizadoDTO(String tipoVehiculo, Object vehiculo, Double tarifaPorKm, Double costoTotal) {
        this.tipoVehiculo = tipoVehiculo;
        this.vehiculo = vehiculo;
        this.tarifaPorKm = tarifaPorKm;
        this.costoTotal = costoTotal;
    }

    public String getTipoVehiculo() { return tipoVehiculo; }
    public void setTipoVehiculo(String tipoVehiculo) { this.tipoVehiculo = tipoVehiculo; }

    public Object getVehiculo() { return vehiculo; }
    public void setVehiculo(Object vehiculo) { this.vehiculo = vehiculo; }

    public Double getTarifaPorKm() { return tarifaPorKm; }
    public void setTarifaPorKm(Double tarifaPorKm) { this.tarifaPorKm = tarifaPorKm; }

    public Double getCostoTotal() { return costoTotal; }
    public void setCostoTotal(Double costoTotal) { this.costoTotal = costoTotal; }
}
