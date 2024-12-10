package fr.efrei.domain;

import fr.efrei.util.Helper;

import java.util.Random;
import java.util.Scanner;

public class Customer extends Person {
    private String passportNumber;
    private boolean driverLicense;
    private String insurance;
    private BankingCard bankCard;

    @Override
    public String toString() {
        return "Customer{" + super.toString() + ", passport number =" + passportNumber + ", driverLicense=" + driverLicense + ", insurance = " + insurance + " }";

    }

    public Customer() {
    }

    public Customer(String firstName, String lastName, String passportNumber, String email, String phone, Address address, int age, boolean driverLicense, String insurance, String password) {
        super(firstName, lastName, email, phone, address, age, password);
        this.driverLicense = driverLicense;
        this.insurance = insurance;
        this.passportNumber = passportNumber;
    }
    protected Customer(Builder builder) {
        super(builder);
        this.passportNumber = builder.passportNumber;
        this.driverLicense = builder.driverLicense;
        this.insurance = builder.insurance;
    }


    public String getPassportNumber() {
        return passportNumber;
    }


    public boolean hasDriverLicense() {
        return driverLicense;
    }


    public String getInsurance() {
        return insurance;
    }

    public boolean pay() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the card number");
        String cardNumber = scanner.next();

        System.out.println("Enter the expiration date (MM/YY)");
        String expirationDate = scanner.next();

        System.out.println("Enter the CVV");
        String cvv = scanner.next();

        BankingCard card = new BankingCard(cardNumber, expirationDate, cvv);

        String validationErrors = Helper.validateCard(card);

        if (validationErrors == null) {
            System.out.println("Card informations are correct.");
            return true;
        } else {
            System.out.println("Card checking failed due to the following errors: \n" + validationErrors);
            return false;
        }
    }





    public static class Builder extends Person.Builder {
        private boolean driverLicense;
        private String insurance;
        private String passportNumber;
        private BankingCard bankCard;


        public Builder setDriverLicense(boolean driverLicense) {
            this.driverLicense = driverLicense;
            return this;
        }

        public Builder setInsurance(String insurance) {
            this.insurance = insurance;
            return this;
        }
        public Builder setPassportNumber(String passportNumber) {
            this.passportNumber = passportNumber;
            return this;
        }
        public Builder setBankCard(BankingCard bankCard) {
            this.bankCard = bankCard;
            return this;
        }
        @Override
        public Customer build() {
            return new Customer(this);
        }
    }
}