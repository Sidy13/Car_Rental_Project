package fr.efrei.domain;

public class Person {
    protected String firstName;
    protected String lastName;
    protected String email;
    protected String phone;
    protected String address;
    protected int age;
    protected String password;
    public Person(){};
    public Person(String firstName, String lastName, String email, String phone, String address, int age, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.age = age;
        this.password = password;
    }
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }
    public String getPassword(){
        return password;
    }

    @Override
    public String toString() {
        return
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phone number=" + phone +
                ", address='" + address + '\'' +
                ", age=" + age;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public int getAge() {
        return age;
    }

    private Person(Builder builder) {
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.email = builder.email;
        this.phone = builder.phone;
        this.address = builder.address;
        this.age = builder.age;
        this.password = password;
    }

    public static class Builder {
        protected String firstName;
        protected String lastName;
        protected String email;
        protected String phone;
        protected String address;
        protected int age;
        protected String password;


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

        @Override
        public String toString() {
            return "Builder{" +
                    "firstName='" + firstName + '\'' +
                    ", lastName='" + lastName + '\'' +
                    ", email='" + email + '\'' +
                    ", phone=" + phone +
                    ", address='" + address + '\'' +
                    ", age=" + age +
                    '}';
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
        public Builder setPassword(String password) {
            this.password = password;
            return this;
        }

        public Person build() {
            return new Person(this);
        }
    }
}

