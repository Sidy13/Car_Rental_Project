package fr.efrei.factory;

import fr.efrei.domain.Address;
import fr.efrei.domain.BankingCard;
import fr.efrei.domain.Customer;
import fr.efrei.domain.Employee;
import fr.efrei.util.Helper;

public class CustomerFactory {
    public static Customer createCustomer(String firstName, String lastName){
        if(Helper.isNullOrEmpty(firstName) || Helper.isNullOrEmpty(lastName)){
            return null;
        }
        return (Customer) new Customer.Builder().setFirstName(firstName).setLastName(lastName).build();
    }
    public static Customer createCustomer(String firstName, String lastName, String email, String phone, Address address, int age, String passportNumber, boolean driverLicense, String insurance, String password) {
        if (Helper.isNullOrEmpty(firstName) || Helper.isNullOrEmpty(lastName) || Helper.isNullOrEmpty(email) || Helper.isNullOrEmpty(phone) || Helper.isNullOrEmpty(passportNumber) || Helper.isNullOrEmpty(password)) {
            return null;
        }
        if (Helper.isNullOrEmpty(address)) {
            return null;
        }
        if (age < 18) {
            System.out.println("Age must be greater than 17");
            return null;
        }
        if (!driverLicense) {
            System.out.println("The client must have a driver license");
            return null;
        }

        return (Customer) new Customer.Builder()
                .setPassportNumber(passportNumber)
                .setDriverLicense(true)
                .setInsurance(insurance)
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setAddress(address)
                .setAge(age)
                .setPassword(password)
                .setPhone(phone)
                .build();
    }
}