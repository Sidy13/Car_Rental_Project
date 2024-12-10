package fr.efrei.views;

import fr.efrei.domain.*;
import fr.efrei.factory.EmployeeFactory;
import fr.efrei.repository.EmployeeRepository;
import fr.efrei.repository.IEmployeeRepository;
import fr.efrei.util.Helper;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class EmployeeView {
    private IEmployeeRepository employeeRepository;

    public EmployeeView() {}

    public EmployeeView(IEmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    private static boolean verifyAdminInformations() {
        System.out.println("To do this action you have to enter the admin informations: ");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter admin email: ");
        String email = scanner.nextLine();
        System.out.println("Enter admin password: ");
        String password = scanner.nextLine();
        return email.equals("admin@rental.com") && password.equals("Admin123@");
    }

    public static void employeeMenu() {
        Scanner scanner = new Scanner(System.in);
        IEmployeeRepository employeeRepository = EmployeeRepository.getRepository();
        String choice;

        do {
            System.out.println("\nEmployee Menu");
            System.out.println("1. Create an employee");
            System.out.println("2. Search an employee");
            System.out.println("3. Update an employee");
            System.out.println("4. Delete an employee");
            System.out.println("5. Show all employees");
            System.out.println("6. Exit");
            System.out.println("Enter your choice: ");
            choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    if (!verifyAdminInformations()){
                        System.out.println("Invalid Admin Informations");
                        return;
                    }
                    System.out.println("Enter the employee first name: ");
                    String employeeFirstName = scanner.nextLine();

                    System.out.println("Enter the employee last name: ");
                    String employeeLastName = scanner.nextLine();

                    String employeeEmail;
                    do {
                        System.out.println("Enter the employee email: ");
                        employeeEmail = scanner.nextLine();
                        if (!Helper.isValidEmail(employeeEmail)) {
                            System.out.println("Invalid email format. Please try again.");
                        }
                    } while (!Helper.isValidEmail(employeeEmail));

                    String employeePhone;
                    do {
                        System.out.println("Enter the employee phone number: ");
                        employeePhone = scanner.nextLine();
                        if (!Helper.isValidPhone(employeePhone)) {
                            System.out.println("Invalid phone format. Please try again.");
                        }
                    } while (!Helper.isValidPhone(employeePhone));

                    int employeeStreetNumber = 0;
                    boolean validEmployeeStreetNumber = false;
                    while (!validEmployeeStreetNumber) {
                        System.out.println("Enter the employee street number: ");
                        try {
                            employeeStreetNumber = Integer.parseInt(scanner.nextLine());
                            validEmployeeStreetNumber = true;
                        }
                        catch (NumberFormatException e) {
                            System.out.println("Invalid street number");
                        }
                    }

                    System.out.println("Enter the employee street name: ");
                    String employeeStreetName = scanner.nextLine();

                    System.out.println("Enter the employee city: ");
                    String employeeCity = scanner.nextLine();

                    System.out.println("Enter the employee state: ");
                    String employeeState = scanner.nextLine();

//                    System.out.println("Enter the employee zip code: ");
//                    int employeeZipCode = scanner.nextInt();
//                    scanner.nextLine();
                    int employeeZipCode = 0;
                    boolean validEmployeeZipCode = false;
                    while (!validEmployeeZipCode) {
                        System.out.println("Enter the employee zip code: ");
                        try {
                            employeeZipCode = Integer.parseInt(scanner.nextLine());
                            validEmployeeZipCode = true;
                        }
                        catch (NumberFormatException e) {
                            System.out.println("Invalid zip code");
                        }
                    }


                    System.out.println("Enter the employee country: ");
                    String employeeCountry = scanner.nextLine();

                    Address employeeAddress = new Address.Builder()
                            .setNumber(employeeStreetNumber)
                            .setStreet(employeeStreetName)
                            .setCity(employeeCity)
                            .setState(employeeState)
                            .setZip(employeeZipCode)
                            .setCountry(employeeCountry)
                            .build();

                    // Age calculation
                    LocalDate employeeDateOfBirth = null;
                    boolean validEmployeeDateOfBirth = false;
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

                    while (!validEmployeeDateOfBirth) {
                        System.out.println("Enter the employee date of birth (dd/MM/yyyy): ");
                        try {
                            employeeDateOfBirth = LocalDate.parse(scanner.nextLine(), formatter);
                            validEmployeeDateOfBirth = true;
                        } catch (DateTimeParseException e) {
                            System.out.println("Invalid date of birth. Please enter the date in dd/MM/yyyy format.");
                        }
                    }

                    int employeeAge = Period.between(employeeDateOfBirth, LocalDate.now()).getYears();


                    // Password check
                    String employeePassword;
                    do {
                        System.out.println("Enter the employee password: ");
                        employeePassword = scanner.nextLine();
                        if (!Helper.isValidPassword(employeePassword)) {
                            System.out.println("Invalid password format. Please try again.");
                        }
                    } while (!Helper.isValidPassword(employeePassword));

                    System.out.println("Confirm password: ");
                    String employeeConfirmPassword = scanner.nextLine();
                    while (!employeeConfirmPassword.equals(employeePassword)) {
                        System.out.println("Password does not match. Please try again.");
                        employeeConfirmPassword = scanner.nextLine();
                    }

                    int salary = 0;
                    boolean validEmployeeSalary = false;
                    while (!validEmployeeSalary) {
                        System.out.println("Enter the employee salary: ");
                        try {
                            salary = Integer.parseInt(scanner.nextLine());
                            validEmployeeSalary = true;
                        }
                        catch (NumberFormatException e) {
                            System.out.println("Invalid salary format. Please try again.");
                        }
                    }

                    String employeeId = "";
                    if (employeeLastName.length() >= 2) {
                        employeeId += employeeLastName.substring(0, 2);
                    } else {
                        employeeId += employeeLastName;
                    }

                    if (employeeFirstName.length() >= 2) {
                        employeeId += employeeFirstName.substring(0, 2);
                    } else {
                        employeeId += employeeFirstName;
                    }

                    employeeId += (int)(Math.random() * 10);

                    Employee employee = EmployeeFactory.createEmployee(employeeFirstName, employeeLastName, employeeEmail, employeePhone, employeeAddress, employeeAge, employeeId, salary, employeePassword);
                    if (employee != null) {
                        employeeRepository.create(employee);
                        System.out.println("Employee "+ employeeFirstName + " "+ employeeLastName+ " with ID " + employeeId+ " created successfully");
                    } else {
                        System.out.println("Employee creation failed");
                    }
                    break;

                case "2":
                    System.out.println("Enter the ID of the employee you want to see: ");
                    String searchEmployeeId = scanner.nextLine();
                    Employee foundEmployee = employeeRepository.read(searchEmployeeId);
                    if (foundEmployee != null) {
                        System.out.println(foundEmployee);
                    } else {
                        System.out.println("Employee not found!");
                    }
                    break;

                case "3":
                    if (!verifyAdminInformations()) {
                        System.out.println("Invalid Admin Informations");
                        return;
                    }
                    System.out.println("Enter the ID of the employee you want to update: ");
                    String updateEmployeeId = scanner.nextLine();
                    Employee employeeToUpdate = employeeRepository.read(updateEmployeeId);
                    if (employeeToUpdate != null) {
                        System.out.println("Enter the new information:");
                        System.out.println("First name: ");
                        String newFirstName = scanner.nextLine();
                        System.out.println("Last name: ");
                        String newLastName = scanner.nextLine();

                        String newEmail;
                        do {
                            System.out.println("Enter the employee email: ");
                            newEmail = scanner.nextLine();
                            if (!Helper.isValidEmail(newEmail)) {
                                System.out.println("Invalid email format. Please try again.");
                            }
                        } while (!Helper.isValidEmail(newEmail));

                        String newPhone;
                        do {
                            System.out.println("Enter the employee phone number: ");
                            newPhone = scanner.nextLine();
                            if (!Helper.isValidPhone(newPhone)) {
                                System.out.println("Invalid phone format. Please try again.");
                            }
                        } while (!Helper.isValidPhone(newPhone));

                        int newStreetNumber = 0;
                        boolean validNewStreetNumber = false;
                        while (!validNewStreetNumber) {
                            System.out.println("Enter the employee street number: ");
                            try {
                                newStreetNumber = Integer.parseInt(scanner.nextLine());
                                validNewStreetNumber = true;
                            }
                            catch (NumberFormatException e) {
                                System.out.println("Invalid street number");
                            }
                        }



                        System.out.println("Street name: ");
                        String newStreetName = scanner.nextLine();
                        System.out.println("City: ");
                        String newCity = scanner.nextLine();
                        System.out.println("State: ");
                        String newState = scanner.nextLine();

                        int newZipCode = 0;
                        boolean validNewZipCode = false;
                        while (!validNewZipCode) {
                            System.out.println("Enter the employee zip code: ");
                            try {
                                newZipCode = Integer.parseInt(scanner.nextLine());
                                validNewZipCode = true;
                            }
                            catch (NumberFormatException e) {
                                System.out.println("Invalid zip code");
                            }
                        }

                        System.out.println("Country: ");
                        String newCountry = scanner.nextLine();

                        // Age calculation
                        LocalDate newEmployeeDateOfBirth = null;
                        boolean newValidEmployeeDateOfBirth = false;
                        DateTimeFormatter newFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

                        while (!newValidEmployeeDateOfBirth) {
                            System.out.println("Enter the employee date of birth (dd/MM/yyyy): ");
                            try {
                                newEmployeeDateOfBirth = LocalDate.parse(scanner.nextLine(), newFormatter);
                                newValidEmployeeDateOfBirth = true;
                            } catch (DateTimeParseException e) {
                                System.out.println("Invalid date of birth. Please enter the date in dd/MM/yyyy format.");
                            }
                        }

                        int newAge = Period.between(newEmployeeDateOfBirth, LocalDate.now()).getYears();

                        int newSalary = 0;
                        boolean validNewSalary = false;
                        while (!validNewSalary) {
                            System.out.println("Enter the employee salary: ");
                            try {
                                newSalary = Integer.parseInt(scanner.nextLine());
                                validNewSalary = true;
                            }
                            catch (NumberFormatException e) {
                                System.out.println("Invalid salary format. Please try again.");
                            }
                        }

                        // Password check
                        String newPassword;
                        do {
                            System.out.println("Enter the employee password: ");
                            newPassword = scanner.nextLine();
                            if (!Helper.isValidPassword(newPassword)) {
                                System.out.println("Invalid password format. Please try again.");
                            }
                        } while (!Helper.isValidPassword(newPassword));

                        System.out.println("Confirm password: ");
                        String newConfirmPassword = scanner.nextLine();
                        while (!newConfirmPassword.equals(newPassword)) {
                            System.out.println("Confirm password does not match, please try again.");
                            newConfirmPassword = scanner.nextLine();
                        }

                        Address newEmployeeAddress = new Address.Builder()
                                .setNumber(newStreetNumber)
                                .setStreet(newStreetName)
                                .setCity(newCity)
                                .setState(newState)
                                .setZip(newZipCode)
                                .setCountry(newCountry)
                                .build();

                        Employee updatedEmployee = EmployeeFactory.createEmployee(newFirstName, newLastName, newEmail, newPhone, newEmployeeAddress, newAge, updateEmployeeId, newSalary, newPassword);
                        employeeRepository.update(updatedEmployee);
                        System.out.println("Employee updated successfully.");
                    } else {
                        System.out.println("Employee does not exist");
                    }
                    break;

                case "4":
                    if (!verifyAdminInformations()) {
                        System.out.println("Invalid Admin Informations");
                        return;
                    }
                    System.out.println("Enter the ID of the employee you want to delete: ");
                    String deleteEmployeeId = scanner.nextLine();
                    if (employeeRepository.delete(deleteEmployeeId)) {
                        System.out.println("Employee deleted successfully.");
                    } else {
                        System.out.println("Employee not found.");
                    }
                    break;

                case "5":
                    List<Employee> employees = employeeRepository.getAll();
                    for (Employee e : employees) {
                        System.out.println(e);
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
