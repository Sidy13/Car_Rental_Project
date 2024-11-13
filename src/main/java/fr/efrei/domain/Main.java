package fr.efrei.domain;

import fr.efrei.factory.CustomerFactory;
import fr.efrei.factory.EmployeeFactory;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Profile profile = new Profile();
        Scanner scanner = new Scanner(System.in);
        Rental rental = new Rental();
        System.out.println("Hello, type 1 if you are a client or 2 if you are an employee");
        int role = scanner.nextInt();
        scanner.nextLine();

        boolean connected = false;
        while (!connected) {
            int choice;
            switch (role) {
                case 1:
                    System.out.println("Type 1 if you have an account or 2 if you want to sign up?");
                    choice = scanner.nextInt();
                    scanner.nextLine();
                    switch (choice) {
                        case 1:
                            if (profile.checkCustomer()) {
                                connected = true;
                            }
                            break;
                        case 2:
                            System.out.println("Enter your first name: ");
                            String firstName = scanner.nextLine();

                            System.out.println("Enter your last name: ");
                            String lastName = scanner.nextLine();

                            System.out.println("Enter your email: ");
                            String email = scanner.nextLine();

                            System.out.println("Enter your phone number: ");
                            String phone = scanner.nextLine();

                            System.out.println("Enter your street number: ");
                            int streetNumber = scanner.nextInt();
                            scanner.nextLine();

                            System.out.println("Enter your street name: ");
                            String streetName = scanner.nextLine();

                            System.out.println("Enter your city: ");
                            String city = scanner.nextLine();

                            System.out.println("Enter your state: ");
                            String state = scanner.nextLine();

                            System.out.println("Enter your zip code: ");
                            int zipCode = scanner.nextInt();
                            scanner.nextLine();

                            System.out.println("Enter your country: ");
                            String country = scanner.nextLine();

                            Address address = new Address.Builder()
                                    .setNumber(streetNumber)
                                    .setStreet(streetName)
                                    .setCity(city)
                                    .setState(state)
                                    .setZip(zipCode)
                                    .setCountry(country)
                                    .build();

                            System.out.println("Enter your age: ");
                            int age = scanner.nextInt();
                            scanner.nextLine();

                            System.out.println("Create a password: ");
                            String password = scanner.nextLine();

                            Random random = new Random();
                            int min = 10000;
                            int max = 100000;
                            int customerId = random.nextInt(max - min) + min;

                            System.out.println("Type 1 if you have a driver license or 2 if you don't?");
                            int driverChoice = scanner.nextInt();
                            scanner.nextLine();
                            boolean driverLicense = driverChoice == 1;

                            System.out.println("Type in the name of your insurance: ");
                            String insurance = scanner.nextLine();

                            Customer customer = CustomerFactory.createCustomer(firstName, lastName, email, phone, address, age, customerId, driverLicense, insurance, password);
                            profile.addCustomer(customer);
                            connected = true;
                            // The condition below doesn't work we need to understand why
//                            if (customer != null) {
//                                System.out.println(customer);
//                                profile.addCustomer(customer);
//                                connected = true;
//                            } else {
//                                System.out.println("Failed to create customer. Please try again.");
//                            }
                            break;
                        default:
                            System.out.println("Invalid choice. Please type 1 or 2.");
                            break;
                    }
                    break;
                case 2:
                    System.out.println("Enter your first name: ");
                    String employeeFirstName = scanner.nextLine();

                    System.out.println("Enter your last name: ");
                    String employeeLastName = scanner.nextLine();

                    System.out.println("Enter your email: ");
                    String employeeEmail = scanner.nextLine();

                    System.out.println("Enter your phone number: ");
                    String employeePhone = scanner.nextLine();

                    System.out.println("Enter your street number: ");
                    int employeeStreetNumber = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Enter your street name: ");
                    String employeeStreetName = scanner.nextLine();

                    System.out.println("Enter your city: ");
                    String employeeCity = scanner.nextLine();

                    System.out.println("Enter your state: ");
                    String employeeState = scanner.nextLine();

                    System.out.println("Enter your zip code: ");
                    int employeeZipCode = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Enter your country: ");
                    String employeeCountry = scanner.nextLine();

                    Address employeeAddress = new Address.Builder()
                            .setNumber(employeeStreetNumber)
                            .setStreet(employeeStreetName)
                            .setCity(employeeCity)
                            .setState(employeeState)
                            .setZip(employeeZipCode)
                            .setCountry(employeeCountry)
                            .build();

                    System.out.println("Enter your age: ");
                    int employeeAge = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Create a password: ");
                    String employeePassword = scanner.nextLine();

                    Random randomEmployee = new Random();
                    int minId = 100;
                    int maxId = 1000;
                    int minSal = 2000;
                    int maxSal = 5000;
                    int employeeId = randomEmployee.nextInt(maxId - minId) + minId;
                    int salary = randomEmployee.nextInt(maxSal - minSal) + minSal;
                    Employee employee = EmployeeFactory.createEmployee(employeeFirstName, employeeLastName, employeeEmail, employeePhone, employeeAddress, employeeAge, employeeId, salary, employeePassword);
                    profile.addEmployee(employee);
                    connected = true;
                    // The condition below doesn't work we need to understand why
//                    if (employee != null) {
//                        connected = true;
//                        profile.addEmployee(employee);
//                    }
//                    else {
//                        System.out.println("Failed to create employee. Please try again.");
//                    }
                    break;
                default:
                    System.out.println("Invalid role. Please type 1 or 2.");
                    break;
            }
        }

        while (connected) {
            switch (role) {
                case 1:
                    int clientAction;
                    System.out.println("What do you want to do?");
                    break;
                case 2:
                    int employeeAction;
                    System.out.println("What do you want to do?");
                    System.out.println("1. Add a car to the store");
                    System.out.println("2. Remove a car from the store");
                    System.out.println("3. See a car from the store");
                    employeeAction = scanner.nextInt();
                    scanner.nextLine();

                    switch (employeeAction) {
                        case 1:
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
                            Car car = Car.createCar(carId, model, brand, color, licensePlate, length, width, height, kilometers, year, dayPrice, carInsurance, options);
                            rental.addCar(car);
                            System.out.println(car);
                            break;
                        case 2:
                            System.out.println("Enter the car Id to remove: ");
                            int removeCarId = scanner.nextInt();
                            scanner.nextLine();
                            rental.removeCar(removeCarId);
                            break;
                        case 3:
                            System.out.println("Enter the car Id to see: ");
                            int seeCarId = scanner.nextInt();
                            scanner.nextLine();
                            rental.seeCar(seeCarId);
                            break;
                        default:
                            System.out.println("Invalid choice. Please type 1, 2 or 3.");
                            break;
                    }
                    break;
                default:
                    System.out.println("Invalid role. Please type 1 or 2.");
                    break;
            }
        }

        scanner.close(); // Close the scanner
    }
}
