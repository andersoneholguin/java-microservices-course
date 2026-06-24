package com.flota.service.dto;

public class ElectricVehicleDTO {
    private Long id;
    private String brand;
    private String model;
    private Integer year;
    private Double price;
    private Integer rangeKm;
    private Integer batteryCapacityKWh;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getBrand() { return brand; }
    public void setBrand(String brand) { this.brand = brand; }

    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }

    public Integer getYear() { return year; }
    public void setYear(Integer year) { this.year = year; }

    public Double getPrice() { return price; }
    public void setPrice(Double price) { this.price = price; }

    public Integer getRangeKm() { return rangeKm; }
    public void setRangeKm(Integer rangeKm) { this.rangeKm = rangeKm; }

    public Integer getBatteryCapacityKWh() { return batteryCapacityKWh; }
    public void setBatteryCapacityKWh(Integer batteryCapacityKWh) { this.batteryCapacityKWh = batteryCapacityKWh; }
}
