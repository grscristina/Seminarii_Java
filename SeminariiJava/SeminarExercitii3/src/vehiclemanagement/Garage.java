package vehiclemanagement;

public class Garage {

    private Vehicle[] fleet;
    private int size;

    public Garage(int capacity) {
        this.fleet = new Vehicle[capacity];
        this.size = 0;
    }

    public void add(Vehicle v) {
        if (size >= fleet.length) {
            System.out.println("Garage is full! Cannot add " + v.getId());
            return;
        }
        if (findById(v.getId()) != null) {
            System.out.println("Duplicate ID! Vehicle " + v.getId() + " already exists.");
            return;
        }
        fleet[size] = v;
        size++;
        System.out.println("Added: " + v);
    }

    public Vehicle findById(String id) {
        for (int i = 0; i < size; i++) {
            if (fleet[i].getId().equals(id)) {
                return fleet[i];
            }
        }
        return null;
    }

    public void rentById(String id) {
        Vehicle v = findById(id);
        if (v == null) {
            System.out.println("Vehicle with id " + id + " not found.");
            return;
        }
        v.rent();
    }

    public void returnById(String id, int drivenKm) {
        Vehicle v = findById(id);
        if (v == null) {
            System.out.println("Vehicle with id " + id + " not found.");
            return;
        }
        v.returnVehicle(drivenKm);
    }

    public void printAvailable() {
        System.out.println("\nAvailable Vehicles:");
        boolean found = false;
        for (int i = 0; i < size; i++) {
            if (!fleet[i].isRented()) {
                System.out.println(fleet[i]);
                found = true;
            }
        }
        if (!found) System.out.println("No available vehicles.");
    }

    public void printNeedsService() {
        System.out.println("\nVehicles Needing Service");
        boolean found = false;
        for (int i = 0; i < size; i++) {
            if (fleet[i].needsService()) {
                System.out.println(fleet[i]);
                found = true;
            }
        }
        if (!found) System.out.println("All vehicles are in good shape.");
    }

    public void printRentalEstimate(String id, int days) {
        Vehicle v = findById(id);
        if (v == null) {
            System.out.println("Vehicle with id " + id + " not found.");
            return;
        }
        double estimate = v.rentalPrice(days);
        System.out.println("Rental estimate for " + v.getBrand() + " (" + id + ") for " + days + " days: $" + estimate);
    }
}
