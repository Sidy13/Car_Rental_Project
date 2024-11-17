package fr.efrei.factory;

import fr.efrei.domain.Address;
import fr.efrei.domain.Employee;
import fr.efrei.util.Helper;

public class EmployeeFactory {
    public static Employee createEmployee(String firstName, String lastName) {
        if (Helper.isNullOrEmpty(firstName) || Helper.isNullOrEmpty(lastName)) {
            return null;
        }
        return (Employee) new Employee.Builder().setFirstName(firstName).setLastName(lastName).build();
    }

    public static Employee createEmployee(String firstName, String lastName, String email, String phone, Address address, int age, String employeeId, double salary, String password) {
        if (Helper.isNullOrEmpty(firstName) || Helper.isNullOrEmpty(lastName) || Helper.isNullOrEmpty(email) || Helper.isNullOrEmpty(phone) || Helper.isNullOrEmpty(employeeId) || Helper.isNullOrEmpty(password)) {
            return null;
        }

            if (Helper.isNullOrEmpty(address)) {
                return null;
            }
            if (age <= 18 || salary <= 0) {
                return null;
            }
            return (Employee) new Employee.Builder()
                    .setEmployeeId(employeeId)
                    .setSalary(salary)
                    .setFirstName(firstName)
                    .setLastName(lastName)
                    .setEmail(email)
                    .setPhone(phone)
                    .setAddress(address)
                    .setAge(age)
                    .setPassword(password)
                    .build();

        }
    }


