package Java_8.services.Impl;

import Java_8.classes.Car;
import Java_8.classes.Person;
import Java_8.services.CarService;

import java.util.LinkedList;
import java.util.List;

public class CarServiceImpl implements CarService {
    List<Car>cars = new LinkedList<>();
    @Override
    public String createCar(List<Car> cars) {
        this.cars.addAll(cars);
        return "Cars are successfully created!";
    }

    @Override
    public String removeCar(String name, List<Car> cars) {
        for (Car car : cars) {
            if(car.getName().equals(name))
                cars.remove(car);
        }return "Car is successfully removed!";
    }

    @Override
    public List<Car> getAll() {
        return this.cars;
    }

    @Override
    public List<Person> findByName(String name, List<Person> people) {
        List<Person>people1=new LinkedList<>();
        for (Person person : people) {
            if(person.getName().equals(name))
                people1.add(person);
        }return people1;
    }

    @Override
    public List<Car> findByCountry(String name, List<Person> persons) {
        List<Car>cars1=new LinkedList<>();
        for (Person person : persons) {
            for (Car car : person.getCars()) {
               if(car.getCountryOfOrigin().name().equals(name.toUpperCase()))
                   cars1.add(car);
            }
        }return cars1;
    }
}
