package fr.efrei.domain;

public class Address {
    private int number;
    private String street;
    private String city;
    private String state;
    private int zip;
    private String country;
    public Address(int number, String street, String city, String state, int zip, String country) {
        this.number = number;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.country = country;
    }
    public Address(Builder builder) {
        this.number = builder.number;
        this.street = builder.street;
        this.city = builder.city;
        this.state = builder.state;
        this.zip = builder.zip;
        this.country = builder.country;
    }

    public int getNumber() {
        return number;
    }



    public String getStreet() {
        return street;
    }



    public String getCity() {
        return city;
    }



    public String getState() {
        return state;
    }



    public int getZip() {
        return zip;
    }



    public String getCountry() {
        return country;
    }

    @Override
    public String toString() {
        return "Address{" +
                "number=" + number +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zip=" + zip +
                ", country='" + country + '\'' +
                '}';
    }

    public static class Builder {
        public int number;
        public String street;
        public String city;
        public String state;
        public int zip;
        public String country;
        public Builder setNumber(int number) {
            this.number = number;
            return this;
        }
        public Builder setStreet(String street) {
            this.street = street;
            return this;
        }
        public Builder setCity(String city) {
            this.city = city;
            return this;
        }
        public Builder setState(String state) {
            this.state = state;
            return this;
        }
        public Builder setZip(int zip) {
            this.zip = zip;
            return this;
        }
        public Builder setCountry(String country) {
            this.country = country;
            return this;
        }
        public Address build() {
            return new Address(this);
        }

    }
}
