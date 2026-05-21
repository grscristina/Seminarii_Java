package vehiclemanagement;

public class Motorcycle extends Vehicle {

    private boolean hasSidecar;

    public Motorcycle() {}

    public Motorcycle(String id, String brand, double speed, boolean hasSidecar) {
        super(id, brand, speed);
        this.hasSidecar = hasSidecar;
    }

    public boolean isHasSidecar() { return hasSidecar; }
    public void setHasSidecar(boolean hasSidecar) { this.hasSidecar = hasSidecar; }

    @Override
    public void move() {
        System.out.println("Motorcycle " + getBrand() + " is speeding on the highway.");
    }

    @Override
    public boolean needsService() {

        return getMileage() >= 6000;
    }

    @Override
    public double rentalPrice(int days) {

        double price = 30.0 * days;
        if (hasSidecar) {
            price += 15.0 * days;
        }
        return price;
    }

    @Override
    public String toString() {
        return "Motorcycle{id='" + getId() + "', brand='" + getBrand() + "', speed=" + getSpeed() +
                ", hasSidecar=" + hasSidecar + ", mileage=" + getMileage() + ", rented=" + isRented() + "}";
    }
}
