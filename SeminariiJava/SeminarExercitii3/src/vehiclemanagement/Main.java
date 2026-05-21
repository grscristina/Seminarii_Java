package vehiclemanagement;

public class Main {

    public static void main(String[] args) {



        Vehicle[] vehicles = new Vehicle[3];
        vehicles[0] = new Car("C1", "Toyota", 180, 4);
        vehicles[1] = new Motorcycle("M1", "Yamaha", 200, false);
        vehicles[2] = new Truck("T1", "Volvo", 120, 5000);

        for (Vehicle v : vehicles) {
            v.move();
        }


        System.out.println("\n=== equals() Demo ===");
        Car car1 = new Car("C10", "BMW", 220, 4);
        Car car2 = new Car("C10", "BMW", 220, 4);
        Car car3 = new Car("C11", "Audi", 210, 2);

        System.out.println("car1.equals(car2): " + car1.equals(car2));
        System.out.println("car1.equals(car3): " + car1.equals(car3));


        Garage garage = new Garage(10);

        garage.add(new Car("C1", "Toyota", 180, 4));
        garage.add(new Car("C2", "BMW", 220, 4));
        garage.add(new Motorcycle("M1", "Yamaha", 200, true));
        garage.add(new Motorcycle("M2", "Honda", 190, false));
        garage.add(new Truck("T1", "Volvo", 120, 8000));


        garage.add(new Car("C1", "Ford", 160, 2));

        System.out.println();
        garage.printRentalEstimate("C1", 5);
        garage.printRentalEstimate("M1", 3);
        garage.printRentalEstimate("T1", 7);


        System.out.println();
        garage.rentById("C1");
        garage.rentById("M1");


        try {
            garage.rentById("C1");
        } catch (IllegalStateException e) {
            System.out.println("Error: " + e.getMessage());
        }


        garage.printAvailable();

        // Return a vehicle
        System.out.println();
        garage.returnById("C1", 350);


        garage.printAvailable();


        Car highMileageCar = new Car("C99", "Ford", 160, 2);
        highMileageCar.setMileage(11000);
        garage.add(highMileageCar);
        garage.printNeedsService();


        System.out.println();
        try {
            garage.returnById("C2", 100);
        } catch (IllegalStateException e) {
            System.out.println("Error: " + e.getMessage());
        }


        garage.rentById("C2");
        try {
            garage.returnById("C2", -50);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
