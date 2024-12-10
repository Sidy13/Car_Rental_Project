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
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CarView {
    private ICarRepository carRepository;

    public CarView(ICarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public void carMenu() {
        Scanner scanner = new Scanner(System.in);
        String choice;
        Rental rental = new Rental();
        List<Rental> rentals = new ArrayList<>();

        do {
            System.out.println("\nCar Menu");
            System.out.println("1. Create a car");
            System.out.println("2. Search a car");
            System.out.println("3. Update a car");
            System.out.println("4. Delete a car");
            System.out.println("5. Show all cars");
            System.out.println("6. Mark a car as rented");
            System.out.println("7. Show all rented cars");
            System.out.println("8. Exit");
            System.out.println("Enter your choice: ");
            choice = scanner.nextLine();

            switch (choice) {
                case "1":

                    System.out.println("Enter the brand of the car: ");
                    String brand = scanner.nextLine();

                    System.out.println("Enter the model of the car: ");
                    String model = scanner.nextLine();

                    System.out.println("Enter the color of the car: ");
                    String color = scanner.nextLine();

                    // Génération de l'ID de la voiture
                    String brandPrefix = "";
                    if (brand.length() >= 2) {
                        brandPrefix = brand.substring(0, 2);
                    } else {
                        brandPrefix = brand;
                    }

                    String modelPrefix = "";
                    if (model.length() >= 2) {
                        modelPrefix = model.substring(0, 2);
                    } else {
                        modelPrefix = model;
                    }

                    int count = 1;
                    List<Car> cars = carRepository.getAll();
                    for (Car car : cars) {
                        if (car.getBrand().startsWith(brandPrefix) && car.getModel().startsWith(modelPrefix)) {
                            count++;
                        }
                    }

                    String carId = brandPrefix + modelPrefix + count;

                    System.out.println("Enter the license plate of the car: ");
                    String licensePlate = scanner.nextLine();


                    double kilometers = 0;
                    boolean validKilometers = false;
                    while (!validKilometers) {
                        System.out.println("Enter the number of kilometers of the car: ");
                        try {
                            kilometers = Double.parseDouble(scanner.nextLine());
                            validKilometers = true;
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid input. Please enter valid kilometers.");
                        }
                    }

                    System.out.println("Enter the insurance of the car: ");
                    String carInsurance = scanner.nextLine();

                    int year = 0;
                    boolean validYear = false;
                    while (!validYear) {
                        System.out.println("Enter the year of the car: ");
                        try {
                            year = Integer.parseInt(scanner.nextLine());
                            validYear = true;
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid input. Please enter a valid year.");
                        }
                    }

                    double dayPrice = 0;
                    boolean validPrice = false;
                    while (!validPrice) {
                        System.out.println("Enter the price of the car for a day: ");
                        try {
                            dayPrice = Double.parseDouble(scanner.nextLine());
                            validPrice = true;
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid input. Please enter a valid price.");
                        }
                    }

                    int optionsNumber = 0;
                    boolean validOptionsNumber = false;
                    while (!validOptionsNumber) {
                        System.out.println("How many options do you want to add?");
                        try {
                            optionsNumber = Integer.parseInt(scanner.nextLine());
                            validOptionsNumber = true;
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid input. Please enter a valid number of options.");
                        }
                    }

                    ArrayList<String> options = new ArrayList<>();
                    for (int i = 0; i < optionsNumber; i++) {
                        System.out.println("Enter option " + (i + 1) + ": ");
                        String option = scanner.nextLine();
                        options.add(option);
                    }

                    System.out.println("Creating car with ID: " + carId);
                    Car car = CarFactory.createCar(carId, model, brand, color, licensePlate, kilometers, year, dayPrice, carInsurance, options);
                    rental.addCar(car);

                    if (car != null) {
                        carRepository.create(car);
                        System.out.println("Car created successfully");
                    } else {
                        System.out.println("Car could not be created");
                    }
                    break;

                case "2":
//                    int searchCarId = 0;
//                    boolean validSearchCarId = false;
//                    while (!validSearchCarId) {
//                        System.out.println("Enter the car ID: ");
//                        try {
//                            searchCarId = Integer.parseInt(scanner.nextLine());
//                            validSearchCarId = true;
//                        } catch (NumberFormatException e) {
//                            System.out.println("Invalid input. Please enter a valid ID.");
//                        }
//                    }
                    System.out.println("Enter the ID of the car you want to search: ");
                    String searchCarId = scanner.nextLine();
                    Car foundCar = carRepository.read(searchCarId);
                    if (foundCar != null) {
                        System.out.println(foundCar);
                    } else {
                        System.out.println("Car not found!");
                    }
                    break;

                case "3":
//                    boolean validUpdateCarId = false;
//                    while (!validUpdateCarId) {
//                        System.out.println("Enter the ID of the car you want to update: ");
//                        try {
//                            updateCarId = Integer.parseInt(scanner.nextLine());
//                            validUpdateCarId = true;
//                        } catch (NumberFormatException e) {
//                            System.out.println("Invalid input. Please enter a valid ID.");
//                        }
//                    }
                    System.out.println("Enter the ID of the car you want to update: ");
                    String updateCarId = scanner.nextLine();

                    Car carToUpdate = carRepository.read(updateCarId);
                    if (carToUpdate != null) {
                        System.out.println("Enter the new information:");
                        System.out.println("Enter the model of the car: ");
                        String newModel = scanner.nextLine();
                        System.out.println("Enter the brand of the car: ");
                        String newBrand = scanner.nextLine();
                        System.out.println("Enter the color of the car: ");
                        String newColor = scanner.nextLine();
                        System.out.println("Enter the license plate of the car: ");
                        String newLicensePlate = scanner.nextLine();





                        double newKilometers = 0;
                        boolean validNewKilometers = false;
                        while (!validNewKilometers) {
                            System.out.println("Enter the number of kilometers of the car: ");
                            try {
                                newKilometers = Double.parseDouble(scanner.nextLine());
                                validNewKilometers = true;
                            } catch (NumberFormatException e) {
                                System.out.println("Invalid input. Please enter valid kilometers.");
                            }
                        }

                        System.out.println("Enter the insurance of the car: ");
                        String newCarInsurance = scanner.nextLine();

                        int newYear = 0;
                        boolean validNewYear = false;
                        while (!validNewYear) {
                            System.out.println("Enter the year of the car: ");
                            try {
                                newYear = Integer.parseInt(scanner.nextLine());
                                validNewYear = true;
                            } catch (NumberFormatException e) {
                                System.out.println("Invalid input. Please enter a valid year.");
                            }
                        }

                        double newDayPrice = 0;
                        boolean validNewPrice = false;
                        while (!validNewPrice) {
                            System.out.println("Enter the price of the car for a day: ");
                            try {
                                newDayPrice = Double.parseDouble(scanner.nextLine());
                                validNewPrice = true;
                            } catch (NumberFormatException e) {
                                System.out.println("Invalid input. Please enter a valid price.");
                            }
                        }

                        ArrayList<String> newOptions = new ArrayList<>();
                        System.out.println("Enter how many options you want to add:");
                        int newOptionsNumber = Integer.parseInt(scanner.nextLine());
                        for (int i = 0; i < newOptionsNumber; i++) {
                            System.out.println("Enter option " + (i + 1) + ": ");
                            newOptions.add(scanner.nextLine());
                        }

                        // Update the car
                        Car updatedCar = CarFactory.createCar(updateCarId, newModel, newBrand, newColor, newLicensePlate, newKilometers, newYear, newDayPrice, newCarInsurance, newOptions);
                        carRepository.update(updatedCar);
                        System.out.println("Car updated successfully.");
                    } else {
                        System.out.println("Car not found.");
                    }
                    break;

                case "4":
                    System.out.println("Enter the ID of the car you want to delete: ");
                    String deleteCarId = scanner.nextLine();
                    if (carRepository.delete(deleteCarId)) {
                        rental.removeCar(deleteCarId);
                        rentals.remove(rental);
                    }
                    break;




                case "5":
                    List<Car> allCars = carRepository.getAll();
                    if (allCars.isEmpty()) {
                        System.out.println("No cars found.");
                    }
                    else {
                        for (Car c : allCars) {
                            System.out.println(c);
                        }
                    }
                    break;

                case "6":
                    System.out.println("Enter the ID of the car you want to mark as rented: ");
                    String markCarId = scanner.nextLine();
                    Car carToMark = carRepository.read(markCarId);

                    if (carToMark != null) {
                        LocalDate startDate = null;
                        LocalDate endDate = null;
                        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                        boolean validDates = false;

                        while (!validDates) {
                            try {
                                System.out.println("Enter the rental start date (dd/MM/yyyy): ");
                                startDate = LocalDate.parse(scanner.nextLine(), dateFormatter);

                                System.out.println("Enter the rental end date (dd/MM/yyyy): ");
                                endDate = LocalDate.parse(scanner.nextLine(), dateFormatter);

                                if (endDate.isBefore(startDate)) {
                                    System.out.println("The end date cannot be before the start date. Please enter the dates again.");
                                } else {
                                    validDates = true;
                                }
                            } catch (DateTimeParseException e) {
                                System.out.println("Invalid date format. Please enter the date in dd/MM/yyyy format.");
                            }
                        }

                        if (carToMark.isAvailable(startDate, endDate)) {
                            System.out.println("Enter the ID of the customer: ");
                            String customerId = scanner.nextLine();
                            ICustomerRepository customerRepository = CustomerRepository.getRepository();
                            Customer customer = customerRepository.read(customerId);

                            if (customer != null) {
                                System.out.println("Enter pick up location: ");
                                String pickUpLocation = scanner.nextLine();
                                long rentPeriod = ChronoUnit.DAYS.between(startDate, endDate);
                                rental.rentACar(carToMark, customer, startDate, endDate, rentPeriod, pickUpLocation);
                                rentals.add(rental);
                            } else {
                                System.out.println("Customer does not exist.");
                            }
                        } else {
                            System.out.println("Car is not available for the selected period.");
                        }
                    } else {
                        System.out.println("Car does not exist.");
                    }
                    break;


                case "7":
                    System.out.println("Rented cars:");
                    if (rentals.isEmpty()) {
                        System.out.println("No cars found.");
                    }
                    else {
                        for (Rental r : rentals) {
                            System.out.println(r);
                        }
                    }
                    break;

                case "8":
                    System.out.println("Exiting");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (!choice.equals("8"));
    }
}
