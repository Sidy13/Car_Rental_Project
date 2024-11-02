package fr.efrei.domain;

public class Customer extends Person {
    private int customerId;
    private boolean driverLicense;
    private String insurance;

    @Override
    public String toString() {
        return "Customer{" + super.toString() + ", customerId=" + customerId + ", driverLicense=" + driverLicense + "insurance" + insurance + "}";

    }

    public Customer() {}
    public Customer(String firstName, String lastName,String email, String phone, String address, int age, int customerId, boolean driverLicense, String insurance) {
        super(firstName, lastName, email, phone, address, age);
        this.customerId = customerId;
        this.driverLicense = driverLicense;
        this.insurance = insurance;
    }

    public int getCustomerId() {
        return customerId;
    }



    public boolean hasDriverLicense() {
        return driverLicense;
    }

    public String getInsurance() {
        return insurance;
    }


    /*private Customer(Builder builder) {
        this.customerId = builder.customerId;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.email = builder.email;
        this.phone = builder.phone;
        this.address = builder.address;
        this.age = builder.age;
        this.driverLicense = builder.driverLicense;
        this.insurance = builder.insurance;
    }

    public static class Builder {
        private int customerId;
        private String firstName;
        private String lastName;
        private String email;
        private String phone;
        private String address;
        private int age;
        private boolean driverLicense;
        private String insurance;

        public Builder setCustomerId(int customerId) {
            this.customerId = customerId;
            return this;
        }
        public Builder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }
        public Builder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }
        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }
        public Builder setPhone(String phone) {
            this.phone = phone;
            return this;
        }
        public Builder setAddress(String address) {
            this.address = address;
            return this;
        }
        public Builder setAge(int age) {
            this.age = age;
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
        public Customer build() {
            return new Customer(this);
        }
    }*/
}
