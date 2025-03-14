package fr.efrei.domain;

import java.util.Random;
import java.util.Scanner;

public class Customer extends Person {
    private String customerId;
    private boolean driverLicense;
    private String insurance;

    @Override
    public String toString() {
        return "Customer{" + super.toString() + ", customerId=" + customerId + ", driverLicense=" + driverLicense + ", insurance = " + insurance + "}";

    }

    public Customer() {
    }

    public Customer(String firstName, String lastName, String email, String phone, Address address, int age, String customerId, boolean driverLicense, String insurance, String password) {
        super(firstName, lastName, email, phone, address, age, password);
        this.customerId = customerId;
        this.driverLicense = driverLicense;
        this.insurance = insurance;
    }
    protected Customer(Builder builder) {
//        super(builder.firstName, builder.lastName, builder.email, builder.phone, builder.address, builder.age, builder.password);
        super(builder);
        this.customerId = builder.customerId;
        this.driverLicense = builder.driverLicense;
        this.insurance = builder.insurance;
    }


    public String getCustomerId() {
        return customerId;
    }


    public boolean hasDriverLicense() {
        return driverLicense;
    }


    public String getInsurance() {
        return insurance;
    }




    public static class Builder extends Person.Builder {
        private String customerId;
        private boolean driverLicense;
        private String insurance;

        public Builder setCustomerId(String customerId) {
            this.customerId = customerId;
            return this;
        }

        public Builder setDriverLicense(boolean driverLicense) {
            this.driverLicense = driverLicense;
            return this;
        }

        public Builder setInsurance(String insurance) {
            this.insurance = insurance;
            return this;
        }
        @Override
        public Customer build() {
            return new Customer(this);
        }
    }
}