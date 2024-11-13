package fr.efrei.domain;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Profile profile = new Profile();
        Scanner scanner = new Scanner(System.in);
        Rental rental = new Rental();
        int role = 0;
        System.out.println("Hello, type 1 if you are an client or 2 if you are an employee");
        role = scanner.nextInt();
        boolean connected = false;
        while (!connected) {
            int choice = 0;
            switch (role) {
                case 1:
                    System.out.println("Type 1 if you have an account or 2 if you want to sign up ?");
                    choice = scanner.nextInt();
                    scanner.nextLine(); 
                    switch (choice) {
                        case 1:
                            profile.checkCustomer();
                            if (profile.checkCustomer()){
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
                            scanner.nextLine(); // 

                            System.out.println("Enter your street name: ");
                            String streetName = scanner.nextLine();

                            System.out.println("Enter your city: ");
                            String city = scanner.nextLine();

                            System.out.println("Enter your state: ");
                            String state = scanner.nextLine();

                            System.out.println("Enter your zip code: ");
                            int zipCode = scanner.nextInt();
                            scanner.nextLine(); //  

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

                            System.out.println("Type 1 if you have a driver license or 2 if you don't ?");
                            int driverChoice = scanner.nextInt();
                            scanner.nextLine();  
                            boolean driverLicense = false;
                            switch (driverChoice) {
                                case 1:
                                    driverLicense = true;
                                    break;
                                case 2:
                                    driverLicense = false;
                                    break;
                                default:
                                    System.out.println("Invalid choice. Assuming no driver license.");
                                    driverLicense = false;
                                    break;
                            }

                            System.out.println("Type in the name of your insurance: ");
                            String insurance = scanner.nextLine();

                            Customer customer = Customer.createCustomer(firstName, lastName, email, phone, address, age, password, customerId, driverLicense, insurance);
                            System.out.println(customer);
                            profile.addCustomer(customer);
                            break;
                        default:
                            System.out.println("Invalid choice. Please type 1 or 2.");
                            break;
                    }
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
                    int minId = 100;
                    int maxId = 1000;
                    int minSal = 2000;
                    int maxSal = 5000;
                    int employeeId = random.nextInt(maxId - minId) + minId;
                    int salary = random.nextInt(maxSal-minSal) + minSal;
                    Employee employee = Employee.createEmployee(firstName, lastName, email, phone, address, age, employeeId, salary, password);

            }


            connected = true;
        }

        switch (role) {
            case 1:
                int employeeAction = 0;
                System.out.println("What do you want to do?");
                System.out.println("1. Add a car to the store");
                System.out.println("2. Remove a car of the store");
                employeeAction = scanner.nextInt();
                switch (employeeAction) {
                    case 1:
                        System.out.println("Enter the car Id :");
                        int carId = scanner.nextInt();
                        System.out.println("Enter the brand of the car");
                        String brand = scanner.nextLine();
                        System.out.println("Enter the model of the car");
                        String model = scanner.nextLine();
                        System.out.println("Enter the color of the car");
                        String color = scanner.nextLine();
                        System.out.println("Enter the license plate of the car");
                        String licensePlate = scanner.nextLine();
                        System.out.println("Enter the length of the car");
                        double length = scanner.nextInt();
                        System.out.println("Enter the width of the car");
                        double width = scanner.nextInt();
                        System.out.println("Enter the height of the car");
                        double height = scanner.nextInt();
                        System.out.println("Enter the number of kilometers of the car");
                        double kilometers = scanner.nextInt();
                        System.out.println("Enter the insurance of the car");
                        String insurance = scanner.nextLine();
                        System.out.println("Enter the year of the car");
                        int year = scanner.nextInt();
                        System.out.println("Enter the price of the car for a day");
                        double dayPrice = scanner.nextInt();
                        System.out.println("How many options do you want to add");
                        int optionsNumber = scanner.nextInt();
                        ArrayList<String> options = new ArrayList<>();
                        for (int i = 0; i < optionsNumber; i++) {
                            String option = scanner.nextLine();
                            options.add(option);
                        }
                        Car car = Car.createCar(carId, model, brand, color, licensePlate, length, width, height, kilometers, year, dayPrice, insurance, options);
                        rental.addCar(car);



                }

        }

    }

}
