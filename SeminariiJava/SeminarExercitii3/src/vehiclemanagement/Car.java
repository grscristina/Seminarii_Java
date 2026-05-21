package vehiclemanagement;

import java.util.Objects;

public class Car extends Vehicle {

    private int doors;

    public Car() {}

    public Car(String id, String brand, double speed, int doors) {
        super(id, brand, speed);
        this.doors = doors;
    }

    public int getDoors() { return doors; }
    public void setDoors(int doors) { this.doors = doors; }

    @Override
    public void move() {
        System.out.println("Car " + getBrand() + " is driving.");
    }

    @Override
    public boolean needsService() {

        return getMileage() >= 10000;
    }

    @Override
    public double rentalPrice(int days) {
        // Car: 50 * days, +10% if doors >= 4
        double price = 50.0 * days;
        if (doors >= 4) {
            price *= 1.10;
        }
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return doors == car.doors && Objects.equals(getId(), car.getId()) &&
                Objects.equals(getBrand(), car.getBrand());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getBrand(), doors);
    }

    @Override
    public String toString() {
        return "Car{id='" + getId() + "', brand='" + getBrand() + "', speed=" + getSpeed() +
                ", doors=" + doors + ", mileage=" + getMileage() + ", rented=" + isRented() + "}";
    }
}
