package fr.efrei.views;

import fr.efrei.domain.Address;
import fr.efrei.domain.Customer;
import fr.efrei.factory.CustomerFactory;
import fr.efrei.repository.CustomerRepository;
import fr.efrei.repository.ICustomerRepository;
import fr.efrei.util.Helper;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;

public class CustomerView {
    private ICustomerRepository customerRepository;

    public CustomerView(ICustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public static void customerMenu() {
        Scanner scanner = new Scanner(System.in);
        ICustomerRepository customerRepository = CustomerRepository.getRepository();
        String choice;
        do {
            System.out.println("\nCustomer Menu");
            System.out.println("1. Create a customer");
            System.out.println("2. Search a customer");
            System.out.println("3. Update a customer");
            System.out.println("4. Delete a customer");
            System.out.println("5. Show all customers");
            System.out.println("6. Exit");
            System.out.println("Enter your choice: ");
            choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    System.out.println("Enter the client first name: ");
                    String firstName = scanner.nextLine();

                    System.out.println("Enter the client last name: ");
                    String lastName = scanner.nextLine();

                    System.out.println("Enter the client passport number: ");
                    String passport = scanner.nextLine();

                    String email;
                    do {
                        System.out.println("Enter the client email: ");
                        email = scanner.nextLine();
                        if (!Helper.isValidEmail(email)) {
                            System.out.println("Invalid email format. Please try again.");
                        }
                    } while (!Helper.isValidEmail(email));

                    String phone;
                    do {
                        System.out.println("Enter the client phone number: ");
                        phone = scanner.nextLine();
                        if (!Helper.isValidPhone(phone)) {
                            System.out.println("Invalid phone number format. Please try again.");
                        }
                    } while (!Helper.isValidPhone(phone));

                    // Address Details
                    int streetNumber = 0;
                    boolean validStreetNumber = false;
                    while (!validStreetNumber) {
                        System.out.println("Enter the client street number: ");
                        try {
                            streetNumber = Integer.parseInt(scanner.nextLine());
                            validStreetNumber = true;
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid input. Please enter a valid street number.");
                        }
                    }

                    System.out.println("Enter the client street name: ");
                    String streetName = scanner.nextLine();

                    System.out.println("Enter the client city: ");
                    String city = scanner.nextLine();

                    System.out.println("Enter the client state: ");
                    String state = scanner.nextLine();

                    int zipCode = 0;
                    boolean validZipCode = false;
                    while (!validZipCode) {
                        System.out.println("Enter the client zip code: ");
                        try {
                            zipCode = Integer.parseInt(scanner.nextLine());
                            validZipCode = true;
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid input. Please enter a valid zip code.");
                        }
                    }

                    System.out.println("Enter the client country: ");
                    String country = scanner.nextLine();

                    Address address = new Address.Builder()
                            .setNumber(streetNumber)
                            .setStreet(streetName)
                            .setCity(city)
                            .setState(state)
                            .setZip(zipCode)
                            .setCountry(country)
                            .build();

                    LocalDate customerDateOfBirth = null;
                    boolean validCustomerDateOfBirth = false;
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

                    while (!validCustomerDateOfBirth) {
                        System.out.println("Enter the client date of birth (dd/MM/yyyy): ");
                        try {
                            customerDateOfBirth = LocalDate.parse(scanner.nextLine(), formatter);
                            validCustomerDateOfBirth = true;
                        } catch (DateTimeParseException e) {
                            System.out.println("Invalid date of birth. Please enter the date in dd/MM/yyyy format.");
                        }
                    }

                    int customerAge = Period.between(customerDateOfBirth, LocalDate.now()).getYears();

                    String password;
                    do {
                        System.out.println("Create a password: ");
                        password = scanner.nextLine();
                        if (!Helper.isValidPassword(password)) {
                            System.out.println("Invalid password format. Please try again.");
                        }
                    } while (!Helper.isValidPassword(password));

                    System.out.println("Confirm password: ");
                    String confirmPassword = scanner.nextLine();
                    while (!confirmPassword.equals(password)) {
                        System.out.println("Confirm password does not match, please try again");
                        confirmPassword = scanner.nextLine();
                    }


                    int driverChoice = 0;
                    boolean validDriverChoice = false;
                    while (!validDriverChoice) {
                        System.out.println("Type 1 if you have a driver license or 2 if you don't?");
                        try {
                            driverChoice = Integer.parseInt(scanner.nextLine());
                            if (driverChoice == 1 || driverChoice == 2) {
                                validDriverChoice = true;
                            } else {
                                System.out.println("Invalid choice. Please enter 1 or 2.");
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid input. Please enter a valid choice (1 or 2).");
                        }
                    }

                    boolean driverLicense = driverChoice == 1;

                    System.out.println("Type in the name of the client insurance: ");
                    String insurance = scanner.nextLine();

                    Customer customer = CustomerFactory.createCustomer(firstName, lastName, email, phone, address, customerAge, passport, driverLicense, insurance, password);
                    if (customer != null) {
                        customerRepository.create(customer);
                        System.out.println("Customer " +firstName+ " " + lastName+ " with passport number " + passport + " created successfully.");
                    } else {
                        System.out.println("Customer creation failed");
                    }
                    break;

                case "2":
                    System.out.println("Enter the passport number of the Customer you want to search: ");
                    String id = scanner.nextLine();
                    if (customerRepository.read(id) != null) {
                        System.out.println(customerRepository.read(id));
                    }
                    else {
                        System.out.println("Customer not found");
                    }
                    break;

                case "3":
                    System.out.println("Enter the passport number of the Customer you want to update: ");
                    String updatePassportNumber = scanner.nextLine();
                    List<Customer> customers = customerRepository.getAll();
                    boolean customerExists = false;
                    for (Customer c : customers) {
                        if (c.getPassportNumber().equals(updatePassportNumber)) {
                            customerExists = true;
                            break;
                        }
                    }
                    if (customerExists) {
                        System.out.println("Enter the new information");

                        // First and last name
                        System.out.println("Enter the first name: ");
                        String newFirstName = scanner.nextLine();
                        System.out.println("Enter the last name: ");
                        String newLastName = scanner.nextLine();

                        String newEmail;
                        do {
                            System.out.println("Enter the email: ");
                            newEmail = scanner.nextLine();
                            if (!Helper.isValidEmail(newEmail)) {
                                System.out.println("Invalid email format. Please try again.");
                            }
                        } while (!Helper.isValidEmail(newEmail));

                        String newPhone;
                        do {
                            System.out.println("Enter the phone number: ");
                            newPhone = scanner.nextLine();
                            if (!Helper.isValidPhone(newPhone)) {
                                System.out.println("Invalid phone number format. Please try again.");
                            }
                        } while (!Helper.isValidPhone(newPhone));

                        // Address
                        int newStreetNumber = 0;
                        boolean validNewStreetNumber = false;
                        while (!validNewStreetNumber) {
                            System.out.println("Enter the street number: ");
                            try {
                                newStreetNumber = Integer.parseInt(scanner.nextLine());
                                validNewStreetNumber = true;
                            } catch (NumberFormatException e) {
                                System.out.println("Invalid input. Please enter a valid street number.");
                            }
                        }

                        System.out.println("Enter the street name: ");
                        String newStreetName = scanner.nextLine();

                        System.out.println("Enter the city: ");
                        String newCity = scanner.nextLine();

                        System.out.println("Enter the state: ");
                        String newState = scanner.nextLine();

                        int newZipCode = 0;
                        boolean validNewZipCode = false;
                        while (!validNewZipCode) {
                            System.out.println("Enter the zip code: ");
                            try {
                                newZipCode = Integer.parseInt(scanner.nextLine());
                                validNewZipCode = true;
                            } catch (NumberFormatException e) {
                                System.out.println("Invalid input. Please enter a valid zip code.");
                            }
                        }

                        System.out.println("Enter the country: ");
                        String newCountry = scanner.nextLine();

                        LocalDate newCustomerDateOfBirth = null;
                        boolean newValidCustomerDateOfBirth = false;
                        DateTimeFormatter newFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

                        while (!newValidCustomerDateOfBirth) {
                            System.out.println("Enter the client date of birth (dd/MM/yyyy): ");
                            try {
                                newCustomerDateOfBirth = LocalDate.parse(scanner.nextLine(), newFormatter);
                                newValidCustomerDateOfBirth = true;
                            } catch (DateTimeParseException e) {
                                System.out.println("Invalid date of birth. Please enter the date in dd/MM/yyyy format.");
                            }
                        }

                        int newCustomerAge = Period.between(newCustomerDateOfBirth, LocalDate.now()).getYears();

                        System.out.println("Does the customer have a driver license? (yes/no): ");
                        String newDriverLicense = scanner.nextLine();
                        boolean newDriverLicenseStatus = newDriverLicense.equalsIgnoreCase("yes");

                        System.out.println("Enter the insurance: ");
                        String newInsurance = scanner.nextLine();

                        String newPassword;
                        do {
                            System.out.println("Create a password: ");
                            newPassword = scanner.nextLine();
                            if (!Helper.isValidPassword(newPassword)) {
                                System.out.println("Invalid password format. Please try again.");
                            }
                        } while (!Helper.isValidPassword(newPassword));

                        System.out.println("Confirm password: ");
                        String newConfirmPassword = scanner.nextLine();
                        while (!newConfirmPassword.equals(newPassword)) {
                            System.out.println("Confirm password does not match, please try again");
                            newConfirmPassword = scanner.nextLine();
                        }

                        Address newAddress = new Address.Builder()
                                .setNumber(newStreetNumber)
                                .setStreet(newStreetName)
                                .setCity(newCity)
                                .setState(newState)
                                .setZip(newZipCode)
                                .setCountry(newCountry)
                                .build();

                        Customer updatedCustomer = CustomerFactory.createCustomer(newFirstName, newLastName, newEmail, newPhone, newAddress, newCustomerAge, updatePassportNumber, newDriverLicenseStatus, newInsurance, newPassword);

                        customerRepository.update(updatedCustomer);
                        System.out.println("Customer updated successfully");
                    } else {
                        System.out.println("Customer not found!");
                    }
                    break;

                case "4":
                    List<Customer> allCustomers2 = customerRepository.getAll();
                    System.out.println("Enter the Passport Number of the Customer you want to delete: ");
                    String deleteId = scanner.nextLine();

                    boolean customerFound = false;

                    for (Customer c : allCustomers2) {
                        if (c.getPassportNumber().equals(deleteId)) {
                            customerRepository.delete(deleteId);
                            System.out.println("Customer deleted successfully.");
                            customerFound = true;
                            break;
                        }
                    }

                    if (!customerFound) {
                        System.out.println("No customer with this passport number found.");
                    }
                    break;


                case "5":
                    List<Customer> allCustomers = customerRepository.getAll();
                    if (allCustomers.isEmpty()) {
                        System.out.println("No customers found");
                    }
                    else {
                        for (Customer c : allCustomers) {
                            System.out.println(c);
                        }
                    }
                    break;
                case "6":
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (!choice.equals("6"));
    }
}
