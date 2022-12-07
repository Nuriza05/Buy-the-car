package Java_8.classes;

import Java_8.enums.Gender;
import Java_8.exceptions.MyException;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.InputMismatchException;
import java.util.List;

public class Person {
    private String name;
    private LocalDate dateOfBirth;
    private Gender gender;
    private BigDecimal money;
    private String phoneNumber;
    private List<Car> cars;

    public Person(String name, LocalDate dateOfBirth, Gender gender, BigDecimal money, String phoneNumber, List<Car> cars) {
        this.name=name;
        this.dateOfBirth=dateOfBirth;
        this.gender = gender;
        this.money = money;
        this.phoneNumber = phoneNumber;
        this.cars = cars;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", gender=" + gender +
                ", money=" + money +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", cars=" + cars +
                '}';
    }
    public static void newName(String name){
        try{
           if(!name.matches("[a-zA-Za-яА-Я]*"))
               throw new MyException("Name is wrong!");

        } catch (MyException e) {
            e.printStackTrace();
        }
    }

    public static void newDateOfBirth(LocalDate dateOfBirth){
        try{
            if(ChronoUnit.YEARS.between(dateOfBirth,LocalDate.now())<0)
                throw new MyException("Data of birth is wrong!");
        } catch (MyException e) {
            throw new InputMismatchException();
        }
    }
}
