public abstract class VehiculoElectrico extends Vehiculo {

	private double batteryCapacityKWh;
	private double chargeLevelPercent;

	public VehiculoElectrico(
			String brand,
			String model,
			int year,
			double batteryCapacityKWh,
			double chargeLevelPercent
	) {
		super(brand, model, year);
		this.batteryCapacityKWh = batteryCapacityKWh;
		setChargeLevelPercent(chargeLevelPercent);
	}

	public double getBatteryCapacityKWh() {
		return batteryCapacityKWh;
	}

	public double getChargeLevelPercent() {
		return chargeLevelPercent;
	}

	public void setChargeLevelPercent(double chargeLevelPercent) {
		if (chargeLevelPercent < 0) {
			this.chargeLevelPercent = 0;
		} else if (chargeLevelPercent >= 100) {
			this.chargeLevelPercent = 100;
		} else {
			this.chargeLevelPercent = chargeLevelPercent;
		}
	}

	public void charge(double percentage) {
		setChargeLevelPercent(this.chargeLevelPercent + percentage);
	}
}
