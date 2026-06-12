public class Main {
	public static void main(String[] args) {
		Flota flota = new Flota();

		Vehiculo auto = new Auto("Renault", "Captur", 2022, 0.08, 1.30);
		Vehiculo moto = new Moto("Yamaha", "MT-03", 2021, 0.04, 1.30);
		Vehiculo autoElectrico = new AutoElectrico("BYD", "Yuan UP", 2024, 60.0, 80.0, 0.15, 0.22);

		flota.agregarVehiculo(auto);
		flota.agregarVehiculo(moto);
		flota.agregarVehiculo(autoElectrico);

		System.out.println();
		Vehiculo encontrado = flota.buscarVehiculo("BYD", "Yuan UP");
		if (encontrado != null) {
			System.out.println("Vehiculo encontrado: " + encontrado);
		} else {
			System.out.println("Vehiculo no encontrado.");
		}
	}
}
