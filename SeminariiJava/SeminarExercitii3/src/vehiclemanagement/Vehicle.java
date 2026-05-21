package vehiclemanagement;

import java.util.Objects;

public abstract class Vehicle {

    private String id;
    private String brand;
    private double speed;
    private int mileage;
    private boolean rented;

    public Vehicle() {}

    public Vehicle(String id, String brand, double speed) {
        this.id = id;
        this.brand = brand;
        this.speed = speed;
        this.mileage = 0;
        this.rented = false;
    }


    public String getId() { return id; }
    public String getBrand() { return brand; }
    public double getSpeed() { return speed; }
    public int getMileage() { return mileage; }
    public boolean isRented() { return rented; }


    public void setId(String id) { this.id = id; }
    public void setBrand(String brand) { this.brand = brand; }
    public void setSpeed(double speed) { this.speed = speed; }
    public void setMileage(int mileage) { this.mileage = mileage; }
    public void setRented(boolean rented) { this.rented = rented; }


    public abstract void move();


    public abstract boolean needsService();
    public abstract double rentalPrice(int days);

    public void rent() {
        if (this.rented) {
            System.out.println("Vehicle " + id + " is already rented!");
        }
        this.rented = true;
        System.out.println("Vehicle " + id + " (" + brand + ") has been rented.");
    }

    public void returnVehicle(int drivenKm) {
        if (!this.rented) {
            System.out.println("Vehicle " + id + " is not currently rented!");
        }
        if (drivenKm <= 0) {
            System.out.println("Driven kilometers must be greater than 0!");
        }
        this.mileage += drivenKm;
        this.rented = false;
        System.out.println("Vehicle " + id + " returned. Total mileage: " + mileage + " km.");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehicle vehicle = (Vehicle) o;
        return Objects.equals(id, vehicle.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Vehicle{id='" + id + "', brand='" + brand + "', speed=" + speed +
                ", mileage=" + mileage + ", rented=" + rented + "}";
    }
}
