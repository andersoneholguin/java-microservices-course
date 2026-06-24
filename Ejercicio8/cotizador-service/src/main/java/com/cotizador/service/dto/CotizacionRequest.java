package com.cotizador.service.dto;

import com.cotizador.service.model.VehicleType;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class CotizacionRequest {

    @NotNull(message = "La distancia es obligatoria")
    @Positive(message = "La distancia debe ser mayor a 0")
    private Double distanciaKm;

    @NotNull(message = "El tipo de vehiculo es obligatorio")
    private VehicleType tipoVehiculo;

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
}
