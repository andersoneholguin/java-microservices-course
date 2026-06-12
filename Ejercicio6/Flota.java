import java.util.ArrayList;
import java.util.List;

public class Flota {
	private List<Vehiculo> vehiculos;

	public Flota() {
		this.vehiculos = new ArrayList<>();
	}

	public void agregarVehiculo(Vehiculo vehiculo) {
		vehiculos.add(vehiculo);
	}

	public Vehiculo buscarVehiculo(String marca, String modelo) {
		for (Vehiculo vehiculo : vehiculos) {
			if (vehiculo.getBrand().equalsIgnoreCase(marca)
					&& vehiculo.getModel().equalsIgnoreCase(modelo)) {
				return vehiculo;
			}
		}
		return null;
	}

	public void mostrarCostosViaje(double distanceKm) {
		for (Vehiculo vehiculo : vehiculos) {
			double costo = vehiculo.calcularCostoViaje(distanceKm);
			System.out.printf("%s -> Costo para %.2f km: $%.2f%n", vehiculo, distanceKm, costo);
		}
	}

	public List<Vehiculo> getVehiculos() {
		return vehiculos;
	}
}
