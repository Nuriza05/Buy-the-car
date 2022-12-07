package Java_8.services;

import Java_8.classes.Car;
import Java_8.classes.Person;

import java.util.List;

public interface CarService {
    String createCar(List<Car> cars);

    String removeCar(String name,List<Car>cars);

    List<Car>getAll();

    List<Car>findByName(String name, List<Person>people);

    List<Car>findByCountry(String name,List<Person>persons);
}
