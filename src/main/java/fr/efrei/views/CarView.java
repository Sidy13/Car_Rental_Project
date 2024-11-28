package fr.efrei.views;

import fr.efrei.domain.Car;
import fr.efrei.domain.Customer;
import fr.efrei.domain.Rental;
import fr.efrei.factory.CarFactory;
import fr.efrei.repository.CarRepository;
import fr.efrei.repository.CustomerRepository;
import fr.efrei.repository.ICarRepository;
import fr.efrei.repository.ICustomerRepository;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CarView {
    private ICarRepository carRepository;
    public CarView(ICarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public static void carMenu(){
        Scanner scanner = new Scanner(System.in);
        ICarRepository carRepository = CarRepository.getRepository();
        String choice;
        Rental rental = null;
        List<Rental> rentals = new ArrayList<>();
        do {
            System.out.println("Car Menu");
            System.out.println("1. Create a car");
            System.out.println("2. Search a car");
            System.out.println("3. Update a car");
            System.out.println("4. Delete a car");
            System.out.println("5. Show all car");
            System.out.println("6. Mark a car as rented");
            System.out.println("7. Show all rented cars");
            System.out.println("8. Exit");
            System.out.println("Enter your choice: ");
            choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    System.out.println("Enter the car Id: ");
                    int carId = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Enter the brand of the car: ");
                    String brand = scanner.nextLine();

                    System.out.println("Enter the model of the car: ");
                    String model = scanner.nextLine();

                    System.out.println("Enter the color of the car: ");
                    String color = scanner.nextLine();

                    System.out.println("Enter the license plate of the car: ");
                    String licensePlate = scanner.nextLine();

                    System.out.println("Enter the length of the car: ");
                    double length = scanner.nextDouble();
                    scanner.nextLine();

                    System.out.println("Enter the width of the car: ");
                    double width = scanner.nextDouble();
                    scanner.nextLine();

                    System.out.println("Enter the height of the car: ");
                    double height = scanner.nextDouble();
                    scanner.nextLine();

                    System.out.println("Enter the number of kilometers of the car: ");
                    double kilometers = scanner.nextDouble();
                    scanner.nextLine();

                    System.out.println("Enter the insurance of the car: ");
                    String carInsurance = scanner.nextLine();

                    System.out.println("Enter the year of the car: ");
                    int year = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Enter the price of the car for a day: ");
                    double dayPrice = scanner.nextDouble();
                    scanner.nextLine();

                    System.out.println("How many options do you want to add?");
                    int optionsNumber = scanner.nextInt();
                    scanner.nextLine();
                    ArrayList<String> options = new ArrayList<>();
                    for (int i = 0; i < optionsNumber; i++) {
                        System.out.println("Enter option " + (i + 1) + ": ");
                        String option = scanner.nextLine();
                        options.add(option);
                    }
                    Car car = CarFactory.createCar(carId, model, brand, color, licensePlate, length, width, height, kilometers, year, dayPrice, carInsurance, options);
//                    rental.addCar(car);
                    if (car != null) {
                        carRepository.create(car);
                        System.out.println("Car created successfully");
                    }
                    else {
                        System.out.println("Car could not be created");
                    }
                    break;

                case "2":
                    System.out.println("Enter the car Id: ");
                    int searchCarId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println(carRepository.read(searchCarId));
                    break;

                case "3":
                    System.out.println("Enter the Id of the car you want to update: ");
                    int updateCarId = scanner.nextInt();
                    scanner.nextLine();
                    List<Car> cars = carRepository.getAll();
                    boolean carExists = false;
                    for (Car c : cars) {
                        if (c.getCarId() == updateCarId) {
                            carExists = true;
                            break;
                        }
                    }
                    if (carExists) {
                        System.out.println("Enter the new informations :");
                        System.out.println("Enter the model of the car: ");
                        String newModel = scanner.nextLine();
                        System.out.println("Enter the brand of the car: ");
                        String newBrand = scanner.nextLine();
                        System.out.println("Enter the color of the car: ");
                        String newColor = scanner.nextLine();
                        System.out.println("Enter the license plate of the car: ");
                        String newLicensePlate = scanner.nextLine();
                        System.out.println("Enter the length of the car: ");
                        double newLength = scanner.nextDouble();
                        System.out.println("Enter the width of the car: ");
                        double newWidth = scanner.nextDouble();
                        System.out.println("Enter the height of the car: ");
                        double newHeight = scanner.nextDouble();
                        System.out.println("Enter the number of kilometers of the car: ");
                        double newKilometers = scanner.nextDouble();
                        System.out.println("Enter the insurance of the car: ");
                        String newCarInsurance = scanner.nextLine();
                        System.out.println("Enter the year of the car: ");
                        int newYear = scanner.nextInt();
                        scanner.nextLine();
                        System.out.println("Enter the price of the car for a day: ");
                        double newPrice = scanner.nextDouble();
                        scanner.nextLine();
                        System.out.println("How many options do you want to add?");
                        int newOptionsNumber = scanner.nextInt();
                        scanner.nextLine();
                        ArrayList <String> newOptions = new ArrayList<>();
                        for (int i = 0; i < newOptionsNumber; i++) {
                            System.out.println("Enter option " + (i + 1) + ": ");
                            String newOption = scanner.nextLine();
                            newOptions.add(newOption);
                        }
                        Car updatedCar = CarFactory.createCar(updateCarId, newModel, newBrand, newColor, newLicensePlate, newLength, newWidth, newHeight, newKilometers, newYear, newPrice, newCarInsurance, newOptions);
                        carRepository.update(updatedCar);
//                        rental.removeCar(updateCarId);
//                        rental.addCar(updatedCar);
                        System.out.println("Car updated successfully");
                    }
                    else {
                        System.out.println("Car does not exist");
                        break;
                    }
                    break;
                case "4":
                    System.out.println("Enter the id of the car you want to delete: ");
                    int deleteCarId = scanner.nextInt();
                    scanner.nextLine();
                    if (carRepository.delete(deleteCarId)) {
                        System.out.println("Car deleted successfully");
                    }
                    else {
                        System.out.println("Car does not exist");
                    }
                    break;
                case "5":
                    List<Car> cars1 = carRepository.getAll();
                    for (Car c : cars1) {
                        System.out.println(c);
                    }
                    break;
                case "6":
                    System.out.println("Enter the Id of the car you want to mark as rented: ");
                    int markCarId = scanner.nextInt();
                    scanner.nextLine();
                    List<Car> markedCars = carRepository.getAll();
                    Car markedCar = null;
                    boolean markedCarExists = false;
                    for (Car c : markedCars) {
                        if (c.getCarId() == markCarId) {
                            markedCar = c;
                            markedCarExists = true;
                            break;
                        }
                    }
                    if (markedCarExists){
                        System.out.println(markedCar.getBrand() +" "+ markedCar.getModel() );
                        System.out.println("Enter the rental start date");
                        LocalDate startDate = LocalDate.parse(scanner.nextLine());
                        System.out.println("Enter the rental end date");
                        LocalDate endDate = LocalDate.parse(scanner.nextLine());
                        System.out.println("Enter the id of the customer");
                        String customerId = scanner.nextLine();
                        scanner.nextLine();
                        ICustomerRepository customerRepository = CustomerRepository.getRepository();
                        List<Customer> customers = customerRepository.getAll();
                        boolean customerExists = false;
                        Customer customer = null;
                        for (Customer c: customers) {
                            if (customerId.equals(c.getCustomerId())) {
                                customer = c;
                                customerExists = true;
                                break;
                            }
                        }
                        if (customerExists){
                            if (markedCar.isAvailable(startDate, endDate)){
                                long rentPeriod = ChronoUnit.DAYS.between(startDate, endDate);
                                rental = new Rental();
                                rental.rentACar(markedCar, customer, startDate, endDate, rentPeriod);
                                rentals.add(rental);
                            }
                        }
                        else {
                            System.out.println("Customer does not exist");
                            break;
                        }
                    }

                case "7":
                    System.out.println(rentals);
                    break;
                default:
                    System.out.println("Invalid option");
                    break;

            }
        }while (!choice.equals("8"));
    }
}
