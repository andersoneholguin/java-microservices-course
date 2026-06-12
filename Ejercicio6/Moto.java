public class Moto extends Vehiculo {

	private double fuelConsumptionLitersPerKm;
	private double fuelPricePerLiter;

	public Moto(String brand, String model, int year, double fuelConsumptionLitersPerKm, double fuelPricePerLiter) {
		super(brand, model, year);
		this.fuelConsumptionLitersPerKm = fuelConsumptionLitersPerKm;
		this.fuelPricePerLiter = fuelPricePerLiter;
	}

	@Override
	public double calcularCostoViaje(double distanceKm) {
		return distanceKm * fuelConsumptionLitersPerKm * fuelPricePerLiter * 0.9;
	}
}
