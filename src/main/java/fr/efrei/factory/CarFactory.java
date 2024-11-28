package fr.efrei.factory;

import fr.efrei.domain.Address;
import fr.efrei.domain.Car;
import fr.efrei.domain.Employee;
import fr.efrei.util.Helper;

import java.util.ArrayList;

public class CarFactory {
    public static Car createCar(int carId, String model, String brand, String color, String licensePlate, double length, double width, double height, double kilometers, int year, double dayPrice, String insurance, ArrayList<String> options) {
        if (Helper.isNullOrEmpty(model) || Helper.isNullOrEmpty(brand) || Helper.isNullOrEmpty(color) || Helper.isNullOrEmpty(licensePlate) || Helper.isNullOrEmpty(insurance)) {
            return null;
        }
        if (carId <= 0 || length <= 0 || width <= 0 || height <= 0 || kilometers < 0 || dayPrice < 0  || year<1900) {
            return null;
        }
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
}