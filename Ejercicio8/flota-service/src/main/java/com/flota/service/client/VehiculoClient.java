package com.flota.service.client;

import com.flota.service.dto.CarDTO;
import com.flota.service.dto.ElectricVehicleDTO;
import com.flota.service.dto.MotorcycleDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class VehiculoClient {

    private final RestTemplate restTemplate;

    @Value("${vehiculo-service.url}")
    private String vehiculoServiceUrl;

    public VehiculoClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<CarDTO> obtenerAutos() {
        return restTemplate.exchange(
                vehiculoServiceUrl + "/api/cars",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<CarDTO>>() {}
        ).getBody();
    }

    public List<MotorcycleDTO> obtenerMotos() {
        return restTemplate.exchange(
                vehiculoServiceUrl + "/api/motorcycles",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<MotorcycleDTO>>() {}
        ).getBody();
    }

    public List<ElectricVehicleDTO> obtenerElectricos() {
        return restTemplate.exchange(
                vehiculoServiceUrl + "/api/electric-vehicles",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<ElectricVehicleDTO>>() {}
        ).getBody();
    }
}
