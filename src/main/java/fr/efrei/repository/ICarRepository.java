package fr.efrei.repository;

import fr.efrei.domain.Car;
import java.util.List;

public interface ICarRepository extends IRepository<Car, String> {
    List<Car> getAll();
}

