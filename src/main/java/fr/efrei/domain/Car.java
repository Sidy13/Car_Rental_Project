package fr.efrei.domain;

import javax.swing.text.html.Option;
import java.util.ArrayList;


public class Car {
    private int carId;
    private String model;
    private String brand;
    private String color;
    private String licensePlate;
    private double length;
    private double width;
    private double height;
    private double kilometers;
    private String insurance;
    private int year;
    private double dayPrice;
    private ArrayList<String> options = new ArrayList<>();

    public Car() {
    }

    public double getLength() {
        return length;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public double getKilometers() {
        return kilometers;
    }

    public String getInsurance() {
        return insurance;
    }

    public ArrayList<String> getOptions() {
        return options;
    }

    public int getCarId() {
        return carId;
    }

    public String getModel() {
        return model;
    }

    public String getBrand() {
        return brand;
    }

    public String getColor() {
        return color;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public int getYear() {
        return year;
    }

    public double getDayPrice() {
        return dayPrice;
    }

    public Car (Builder builder) {
        this.carId = builder.carId;
        this.model = builder.model;
        this.brand = builder.brand;
        this.color = builder.color;
        this.licensePlate = builder.licensePlate;
        this.length = builder.length;
        this.width = builder.width;
        this.height = builder.height;
        this.kilometers = builder.kilometers;
        this.insurance = builder.insurance;
        this.year = builder.year;
        this.dayPrice = builder.dayPrice;
        this.options = builder.options;
    }

    @Override
    public String toString() {
        return "Car{" +
                "carId=" + carId +
                ", model='" + model + '\'' +
                ", brand='" + brand + '\'' +
                ", color='" + color + '\'' +
                ", licensePlate='" + licensePlate + '\'' +
                ", length=" + length +
                ", width=" + width +
                ", height=" + height +
                ", kilometers=" + kilometers +
                ", year=" + year +
                ", insurance='" + insurance + '\'' +
                ", options=" + options +
                '}';
    }

    public boolean isRented(Car c, ArrayList<Car> cars) {
        for (Car car : cars){
            if (c.getCarId() == car.getCarId()){
                return true;
            }
        }
        return false;
    }

    public static Car createCar(int carId, String model, String brand, String color, String licensePlate, double length, double width, double height, double kilometers, int year, double dayPrice, String insurance, ArrayList<String> options) {
        return new Car.Builder().setCarId(carId).
                setModel(model).
                setBrand(brand).
                setColor(color).
                setLicensePlate(licensePlate)
                .setLength(length)
                .setWidth(width)
                .setHeight(height)
                .setKilometers(kilometers)
                .setInsurance(insurance)
                .setYear(year)
                .setDayPrice(dayPrice)
                .setOptions(options)
                .build();
    }
    public static class Builder {
        private int carId;
        private String model;
        private String brand;
        private String color;
        private String licensePlate;
        private double length;
        private double width;
        private double height;
        private double kilometers;
        private String insurance;
        private int year;
        private double dayPrice;
        private ArrayList<String> options;
        public Builder setCarId(int carId) {
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
        public Builder setLength(double length) {
            this.length = length;
            return this;
        }
        public Builder setWidth(double width) {
            this.width = width;
            return this;
        }
        public Builder setHeight(double height) {
            this.height = height;
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

        public Car build() {
            return new Car(this);
        }
    }
}
