package com.flota.service.dto;

public class CotizacionRequestDTO {
    private Double distanciaKm;
    private String tipoVehiculo;

    public CotizacionRequestDTO(Double distanciaKm, String tipoVehiculo) {
        this.distanciaKm = distanciaKm;
        this.tipoVehiculo = tipoVehiculo;
    }

    public Double getDistanciaKm() { return distanciaKm; }
    public void setDistanciaKm(Double distanciaKm) { this.distanciaKm = distanciaKm; }

    public String getTipoVehiculo() { return tipoVehiculo; }
    public void setTipoVehiculo(String tipoVehiculo) { this.tipoVehiculo = tipoVehiculo; }
}
