package fr.efrei;

import fr.efrei.domain.Employee;
import fr.efrei.repository.CarRepository;
import fr.efrei.repository.CustomerRepository;
import fr.efrei.repository.EmployeeRepository;
import fr.efrei.repository.IEmployeeRepository;
import fr.efrei.views.CarView;
import fr.efrei.views.CustomerView;
import fr.efrei.views.EmployeeView;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Employee loggedInEmployee = null;
        Employee employee = new Employee();
        IEmployeeRepository employeeRepository = EmployeeRepository.getRepository();
        employee.adminCreation((EmployeeRepository) employeeRepository);
        while (true){
            while (loggedInEmployee == null) {
                System.out.println("\nPlease login to continue:");
                System.out.print("Enter your email: ");
                String email = scanner.nextLine();
                System.out.print("Enter your password: ");
                String password = scanner.nextLine();

                loggedInEmployee = employee.login(email, password, (EmployeeRepository) employeeRepository);
                if (loggedInEmployee == null) {
                    System.out.println("Invalid email or password. Please try again.");
                }
            }

            System.out.println("\nWelcome, " + loggedInEmployee.getFirstName() + " " + loggedInEmployee.getLastName());


            String choice;

            do {
                System.out.println("\nMain Menu");
                System.out.println("1. Car Menu");
                System.out.println("2. Customer Menu");
                System.out.println("3. Employee Menu");
                System.out.println("4. Log out");
                System.out.println("5. Exit");
                System.out.print("Enter your choice: ");
                choice = scanner.nextLine();

                switch (choice) {
                    case "1":
                        CarView carView = new CarView(CarRepository.getRepository());
                        carView.carMenu();
                        break;
                    case "2":
                        CustomerView customerView = new CustomerView(CustomerRepository.getRepository());
                        customerView.customerMenu();
                        break;
                    case "3":
                        EmployeeView employeeView = new EmployeeView(EmployeeRepository.getRepository());
                        employeeView.employeeMenu();
                        break;
                    case "4":
                        System.out.println("Logging out\n");
                        loggedInEmployee = null;
                        break;
                    case "5":
                        System.out.println("Exiting the program.");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid choice. Please enter a number between 1 and 4.");
                        break;
                }
            } while (loggedInEmployee != null);
        }
    }
}


