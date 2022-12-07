package Java_8.services.Impl;

import Java_8.classes.Car;
import Java_8.classes.Person;
import Java_8.services.PersonService;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;
import java.util.*;

public class PersonServiceImpl implements PersonService {
    List<Person>people=new LinkedList<>();
    List<Car>cars = new LinkedList<>();
    @Override
    public String createPerson(List<Person> people) {
        this.people.addAll(people);
        return "People are successfully created!";
    }

    @Override
    public String removePerson(String name, List<Person> people) {
        for (Person person : people) {
            if(person.getName().equals(name))
                this.people.remove(person);
        }
        return "Person is successfully removed!";
    }

    @Override
    public List<Person> getAll() {
        return this.people;
    }

    @Override
    public List<Person> findByName(String name, List<Person> people) {
        List<Person>people1=new LinkedList<>();
        for (Person person : people1) {
            if(person.getName().equals(name))
                people1.add(person);
        }
        return people1;
    }

    @Override
    public List<Person> findByCarName(String name, List<Person> people) {
        List<Person>people1=new LinkedList<>();
        for (Person person : people1) {
            for (Car car : person.getCars()) {
                if(car.getName().equals(name))
                    people1.add(person);
            }
        }return people1;
    }
    @Override
    public String payCars(String name, List<Person> people, String carName, List<Car> cars) {
        for (Person person : people) {
            if(person.getName().contains(name)){
                for (Car car : cars) {
                    if (car.getName().contains(carName)){
                        int value = person.getMoney().subtract(car.getPrice()).intValue();
                        if (value >= 0){
                            if(person.getCars()==null){
                                person.setCars(List.of(car));
                                this.cars.add(car);
                                person.setMoney(person.getMoney().subtract(car.getPrice()));
                            }else{
                                person.setCars(this.cars);
                                this.cars.add(car);
                                person.setMoney(person.getMoney().subtract(car.getPrice()));
                            }
                            return "Successfully paid car!";
                        }else{
                            return "Not enough your money!";
                        }
                    }
                }
            }
        }
            return "Car is successfully bought!";
    }
    public static Comparator<Person> sortPersonDateOfBirth = new Comparator<Person>() {
        @Override
        public int compare(Person o1, Person o2) {
            return o1.getDateOfBirth().compareTo(o2.getDateOfBirth());
        }
    };

    public static Comparator<Person> sortPersonName = new Comparator<Person>() {
        @Override
        public int compare(Person o1, Person o2) {
            return o1.getName().compareTo(o2.getName());
        }
    };
    public static Comparator<Person>sortGender = new Comparator<Person>() {
        @Override
        public int compare(Person o1, Person o2) {
            return o1.getGender().name().compareTo(o2.getGender().name());
        }
    };
    @Override
    public List<Person> sortPersonDateOfBirth(List<Person> people) {
        people.sort(sortPersonDateOfBirth);
        return people;
    }

    @Override
    public List<Person> sortPersonName(List<Person> people) {
        people.sort(sortPersonName);
        return people;
    }

    @Override
    public List<Person> sortGender(List<Person> people) {
        people.sort(sortGender);
        return people;
    }

    @Override
    public int getAge(Person person) {
        return Period.between(person.getDateOfBirth(), LocalDate.now()).getYears();
    }
}
