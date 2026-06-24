package com.flota.service.client;

import com.flota.service.dto.CotizacionRequestDTO;
import com.flota.service.dto.CotizacionResponseDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class CotizadorClient {

    private final RestTemplate restTemplate;

    @Value("${cotizador-service.url}")
    private String cotizadorServiceUrl;

    public CotizadorClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public CotizacionResponseDTO calcularCosto(Double distanciaKm, String tipoVehiculo) {
        CotizacionRequestDTO request = new CotizacionRequestDTO(distanciaKm, tipoVehiculo);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<CotizacionRequestDTO> entity = new HttpEntity<>(request, headers);

        return restTemplate.postForObject(
                cotizadorServiceUrl + "/api/cotizador/calcular",
                entity,
                CotizacionResponseDTO.class
        );
    }
}
