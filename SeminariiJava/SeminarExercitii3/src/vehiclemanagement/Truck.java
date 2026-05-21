package vehiclemanagement;

public class Truck extends Vehicle {

    private double loadCapacity;

    public Truck() {}

    public Truck(String id, String brand, double speed, double loadCapacity) {
        super(id, brand, speed);
        this.loadCapacity = loadCapacity;
    }

    public double getLoadCapacity() { return loadCapacity; }
    public void setLoadCapacity(double loadCapacity) { this.loadCapacity = loadCapacity; }

    @Override
    public void move() {
        System.out.println("Truck " + getBrand() + " is moving.");
    }

    @Override
    public boolean needsService() {

        return getMileage() >= 15000;
    }

    @Override
    public double rentalPrice(int days) {

        return (80.0 + 0.02 * loadCapacity) * days;
    }

    @Override
    public String toString() {
        return "Truck{id='" + getId() + "', brand='" + getBrand() + "', speed=" + getSpeed() +
                ", loadCapacity=" + loadCapacity + ", mileage=" + getMileage() + ", rented=" + isRented() + "}";
    }
}
