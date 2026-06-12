public class AutoElectrico extends VehiculoElectrico {
    
	private double energyConsumptionKWhPerKm;
	private double electricityPricePerKWh;

	public AutoElectrico(
			String brand,
			String model,
			int year,
			double batteryCapacityKWh,
			double chargeLevelPercent,
			double energyConsumptionKWhPerKm,
			double electricityPricePerKWh
	) {
		super(brand, model, year, batteryCapacityKWh, chargeLevelPercent);
		this.energyConsumptionKWhPerKm = energyConsumptionKWhPerKm;
		this.electricityPricePerKWh = electricityPricePerKWh;
	}

	@Override
	public double calcularCostoViaje(double distanceKm) {
		return distanceKm * energyConsumptionKWhPerKm * electricityPricePerKWh;
	}
}
