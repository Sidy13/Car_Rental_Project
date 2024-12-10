package fr.efrei.domain;

import java.time.LocalDate;
import java.util.ArrayList;

public class Car {
    private String carId;
    private String model;
    private String brand;
    private String color;
    private String licensePlate;
    private double kilometers;
    private String insurance;
    private int year;
    private double dayPrice;
    private ArrayList<String> options = new ArrayList<>();
    private LocalDate startDate;
    private LocalDate endDate;
    private boolean isRented;
    private Customer currentCustomer;

    public Car (Builder builder) {
        this.carId = builder.carId;
        this.model = builder.model;
        this.brand = builder.brand;
        this.color = builder.color;
        this.licensePlate = builder.licensePlate;
        this.kilometers = builder.kilometers;
        this.insurance = builder.insurance;
        this.year = builder.year;
        this.dayPrice = builder.dayPrice;
        this.options = builder.options;
        this.startDate = builder.startDate;
        this.endDate = builder.endDate;
    }

    public String getCarId() {
        return carId;
    }

    public String getModel() {
        return model;
    }

    public String getColor() {
        return color;
    }

    public String getBrand() {
        return brand;
    }

    public String getLicensePlate() {
        return licensePlate;
    }


    public double getKilometers() {
        return kilometers;
    }

    public String getInsurance() {
        return insurance;
    }

    public int getYear() {
        return year;
    }

    public double getDayPrice() {
        return dayPrice;
    }

    public ArrayList<String> getOptions() {
        return options;
    }

    // Getters and setters for the new attributes
    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public boolean isRented() {
        return isRented;
    }

    public void setRented(boolean rented) {
        isRented = rented;
    }

    public Customer getCurrentCustomer() {
        return currentCustomer;
    }

    public void setCurrentCustomer(Customer currentCustomer) {
        this.currentCustomer = currentCustomer;
    }




    public boolean isAvailable(LocalDate startDate, LocalDate endDate) {
        if (!isRented) {
            return true;
        }
        return startDate.isAfter(this.endDate) || endDate.isBefore(this.startDate);
    }

    @Override
    public String toString() {
        return "Car{" +
                "carId=" + carId +
                ", model='" + model + '\'' +
                ", brand='" + brand + '\'' +
                ", color='" + color + '\'' +
                ", licensePlate='" + licensePlate + '\'' +
                ", kilometers=" + kilometers +
                ", insurance='" + insurance + '\'' +
                ", year=" + year +
                ", dayPrice=" + dayPrice +
                "€, options=" + options +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", isRented=" + isRented +
                ", currentCustomer=" + currentCustomer +
                '}';
    }

//    public static Car createCar(int carId, String model, String brand, String color, String licensePlate, double length, double width, double height, double kilometers, int year, double dayPrice, String insurance, ArrayList<String> options) {
//        return new Car.Builder().setCarId(carId).
//                setModel(model).
//                setBrand(brand).
//                setColor(color).
//                setLicensePlate(licensePlate)
//                .setLength(length)
//                .setWidth(width)
//                .setHeight(height)
//                .setKilometers(kilometers)
//                .setInsurance(insurance)
//                .setYear(year)
//                .setDayPrice(dayPrice)
//                .setOptions(options)
//                .build();
//    }

    public static class Builder {
        private String carId;
        private String model;
        private String brand;
        private String color;
        private String licensePlate;
        private double kilometers;
        private String insurance;
        private int year;
        private double dayPrice;
        private ArrayList<String> options;
        LocalDate startDate;
        LocalDate endDate;


        public Builder setCarId(String carId) {
            this.carId = carId;
            return this;
        }

        public Builder setModel(String model) {
            this.model = model;
            return this;
        }

        public Builder setBrand(String brand) {
            this.brand = brand;
            return this;
        }

        public Builder setColor(String color) {
            this.color = color;
            return this;
        }

        public Builder setLicensePlate(String licensePlate) {
            this.licensePlate = licensePlate;
            return this;
        }


        public Builder setKilometers(double kilometers) {
            this.kilometers = kilometers;
            return this;
        }

        public Builder setInsurance(String insurance) {
            this.insurance = insurance;
            return this;
        }

        public Builder setOptions(ArrayList<String> options) {
            this.options = options;
            return this;
        }

        public Builder setYear(int year) {
            this.year = year;
            return this;
        }

        public Builder setDayPrice(double dayPrice) {
            this.dayPrice = dayPrice;
            return this;
        }

        public Builder setOptions(String options) {
            this.options = new ArrayList<>();
            this.options.add(options);
            return this;
        }
        public Builder setStartDate(LocalDate startDate) {
            this.startDate = startDate;
            return this;
        }
        public Builder setEndDate(LocalDate endDate) {
            this.endDate = endDate;
            return this;
        }

        public Car build() {
            return new Car(this);
        }
    }
}
