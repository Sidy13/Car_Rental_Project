package fr.efrei.domain;

import fr.efrei.factory.EmployeeFactory;
import fr.efrei.repository.EmployeeRepository;

import java.util.Iterator;
import java.util.List;

public class Employee extends Person {
    private String employeeId;
    private double salary;
    public Employee() {}
    public Employee(String firstName, String lastName, String email, String phone, Address address, int age, String employeeId, double salary, String password) {
        super(firstName, lastName, email, phone, address, age, password);
        this.employeeId = employeeId;
        this.salary = salary;
    }

    public Employee(Builder builder) {
        super(builder);
        this.employeeId = builder.employeeId;
        this.salary = builder.salary;
    }
    @Override
    public String toString() {
        return "Employee{" + super.toString() + ", employeeId=" + employeeId + ", salary=" + salary + "}";
    }

    public String getEmployeeId() {
        return employeeId;
    }


    public double getSalary() {
        return salary;
    }

    public Employee login(String email, String password, EmployeeRepository employeeRepository) {
        List<Employee> employees = employeeRepository.getAll();
        for (Employee employee : employees) {
            if (employee.getEmail().equals(email) && employee.getPassword().equals(password)) {
                System.out.println("Login successful for: " + email);
                return employee;
            }
        }
        System.out.println("Incorrect email or password");
        return null;
    }


    public void adminCreation(EmployeeRepository employeeRepository) {
        String defaultEmail = "admin@rental.com";
        String defaultPassword = "Admin123@";

        Address defaultAddress = new Address.Builder()
                .setNumber(1)
                .setStreet("Main Street")
                .setCity("City")
                .setState("State")
                .setZip(12345)
                .setCountry("Country")
                .build();

        Employee admin = EmployeeFactory.createEmployee("Admin", "User", defaultEmail, "0000000000", defaultAddress, 30, "0", 1, defaultPassword);
        Employee createdAdmin = employeeRepository.create(admin);

    }






    public static class Builder extends Person.Builder {
        private String employeeId;
        private double salary;
        public Builder setEmployeeId(String employeeId) {
            this.employeeId = employeeId;
            return this;
        }
        public Builder setSalary(double salary) {
            this.salary = salary;
            return this;
        }
        public Employee build() {
            return new Employee(this);
        }
    }
}
