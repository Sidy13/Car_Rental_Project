package fr.efrei.domain;

import java.util.ArrayList;
import java.util.Scanner;

public class Profile extends Person{
    ArrayList<Customer> customers;
    ArrayList<Employee> employees;
    public Profile() {
        super();
    }


    // Client part

    public ArrayList<Customer> getCustomers() {
        return customers;
    }
    public void setCustomers(ArrayList<Customer> customers) {
        this.customers = customers;
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }
    public void removeCustomer(Customer customer) {
        customers.remove(customer);
    }
    public boolean checkCustomer() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your email :");
        String email = scanner.nextLine();
        System.out.println("Enter your password :");
        String password = scanner.nextLine();
        for (Customer c : customers) {
            if(c.getEmail().equals(email)) { // does not work with && I don't know why
                if(c.getPassword().equals(password)) {
                    return true;
                }
            }
        }
        System.out.println("Email or password incorrect, please try again");
        return false;
    }

    // Employee part

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(ArrayList<Employee> employees) {
        this.employees = employees;
    }
    public void addEmployee(Employee employee) {
        employees.add(employee);
    }
    public void removeEmployee(Employee employee) {
        employees.remove(employee);
    }
    public boolean checkEmployee() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your email :");
        String email = scanner.nextLine();
        System.out.println("Enter your password :");
        String password = scanner.nextLine();
        for (Employee e : employees) {
            if(e.getEmail().equals(email)) {
                if(e.getPassword().equals(password)) {
                    return true;
                }
            }
        }
        System.out.println("Email or password incorrect, please try again");
        return false;
    }
}
