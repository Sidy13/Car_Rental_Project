package fr.efrei.repository;

import fr.efrei.domain.Car;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CarRepository implements ICarRepository {
    private static ICarRepository repository = null;
    private List<Car> carList;


    private CarRepository() {
        carList = new ArrayList<>();
    }

    public static ICarRepository getRepository() {
        if (repository == null) {
            repository = new CarRepository();
        }
        return repository;
    }

    @Override
    public Car create(Car car) {
        boolean success = carList.add(car);
        if (success) {
            return car;
        }
        return null;
    }

    @Override
    public Car read(String id) {
        for (Car car : carList) {
            if (Objects.equals(car.getCarId(), id)) {
                return car;
            }
        }
        return null;
    }

    @Override
    public Car update(Car car) {
        String id = car.getCarId();
        Car existingCar = read(id);
        if (existingCar == null) {
            return null;
        }
        boolean success = delete(id);
        if (success) {
            carList.add(car);
            return car;
        }
        return null;
    }

    @Override
    public boolean delete(String id) {
        Car carToDelete = read(id);
        if (carToDelete == null) {
            return false;
        }
        return carList.remove(carToDelete);
    }

    @Override
    public List<Car> getAll() {
        return new ArrayList<>(carList);
    }
}
