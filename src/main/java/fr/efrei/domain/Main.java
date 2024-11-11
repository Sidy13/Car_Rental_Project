package fr.efrei.domain;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Boolean connected = false;
        Profile profile = new Profile();
        Scanner scanner = new Scanner(System.in);
        while (!connected) {
            int choice = 0;
            System.out.println("Hello, type 1 if you have an account or 2 if you want to sign up ?");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consomme la nouvelle ligne restante
            switch (choice) {
                case 1:
                    profile.checkCustomer();
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
                    scanner.nextLine(); // Consomme la nouvelle ligne restante

                    System.out.println("Enter your street name: ");
                    String streetName = scanner.nextLine();

                    System.out.println("Enter your city: ");
                    String city = scanner.nextLine();

                    System.out.println("Enter your state: ");
                    String state = scanner.nextLine();

                    System.out.println("Enter your zip code: ");
                    int zipCode = scanner.nextInt();
                    scanner.nextLine(); // Consomme la nouvelle ligne restante

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
                    scanner.nextLine(); // Consomme la nouvelle ligne restante

                    System.out.println("Create a password: ");
                    String password = scanner.nextLine();

                    Random random = new Random();
                    int min = 10000;
                    int max = 100000;
                    int customerId = random.nextInt(max - min) + min;

                    System.out.println("Type 1 if you have a driver license or 2 if you don't ?");
                    int driverChoice = scanner.nextInt();
                    scanner.nextLine(); // Consomme la nouvelle ligne restante
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
                    break;
                default:
                    System.out.println("Invalid choice. Please type 1 or 2.");
                    break;
            }
            connected = true;
        }
        scanner.close();
    }
}
