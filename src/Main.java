import Java_8.classes.Car;
import Java_8.classes.Person;
import Java_8.enums.Colour;
import Java_8.enums.Country;
import Java_8.enums.Gender;
import Java_8.services.Impl.CarServiceImpl;
import Java_8.services.Impl.PersonServiceImpl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Year;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Car car1 = new Car("MERS","S213",BigDecimal.valueOf(200000), Year.of(2000), Colour.BLACK, Country.GERMANY);
        Car car2 = new Car("BMW","500",BigDecimal.valueOf(150000),Year.of(2002),Colour.WHITE,Country.CHINA);
        Car car3 = new Car("Toyota","Camry",BigDecimal.valueOf(300000),Year.of(2012),Colour.PINK,Country.JAPAN);
        Car car4 = new Car("Lexus","470",BigDecimal.valueOf(400000),Year.of(2019),Colour.BLUE,Country.USA);
        Car car5 = new Car("Tiko","782",BigDecimal.valueOf(100000),Year.of(2022),Colour.BLACK,Country.INDIA);
        List<Car>cars=new LinkedList<>(List.of(car1,car2,car3,car4,car5));


        Person p1 = new Person("Nuriza", LocalDate.of(2005,12,4), Gender.FEMALE, BigDecimal.valueOf(1000000),"554488060",null);
        Person p2 = new Person("Adil",LocalDate.of(2004,2,17),Gender.MALE,BigDecimal.valueOf(1500000),"778346244",null);
        Person p3 = new Person("Nursultan",LocalDate.of(2004,5,3),Gender.MALE,BigDecimal.valueOf(200000),"552783443",null);
        List<Person>people=new LinkedList<>(Arrays.asList(p1,p2,p3));

        PersonServiceImpl person = new PersonServiceImpl();
        CarServiceImpl car = new CarServiceImpl();

        System.out.println("""
                1. Create people!
                2. Remove person!
                3. Get all people!
                4. Find by person's name!
                5. Find people by car's name!
                6. Buy the car!
                7. Sort by date of birth!
                8. Sort by people's name!
                9. Sort by gender!
                10. Get age!
                11. Create cars!
                12. Remove car!
                13. Get all cars!
                14. Find car by name!
                15. Find car by country!
                """);
        while (true){
        int number = new Scanner(System.in).nextInt();
        switch (number){
            case 1:   System.out.println(person.createPerson(people));          break;
            case 2:   System.out.print("Write the person name: ");
                      String name = new Scanner(System.in).next();
                      System.out.println(person.removePerson(name,people));     break;
            case 3:   System.out.println(person.getAll());                      break;
            case 4:   System.out.print("Write the person name: ");
                      String namme = new Scanner(System.in).next();
                      System.out.println(person.findByName(namme, people));     break;
            case 5:   System.out.print("Write the car name: ");
                      String nammme = new Scanner(System.in).next();
                      System.out.println(person.findByCarName(nammme, people)); break;
            case 6:   System.out.print("Write the person name: ");
                      String n = new Scanner(System.in).next();
                      System.out.print("Write the car name: ");
                      String c = new Scanner(System.in).next();
                      System.out.println(person.payCars(n, people, c, cars));   break;
            case 7:   System.out.println(person.sortPersonDateOfBirth(people)); break;
            case 8:   System.out.println(person.sortPersonName(people));        break;
            case 9:   System.out.println(person.sortGender(people));            break;
            case 10:  System.out.println(person.getAge(p2));                    break;
            case 11:  System.out.println(car.createCar(cars));                  break;
            case 12:  System.out.print("Write the car's name!");
                      String carName = new Scanner(System.in).next();
                      System.out.println(car.removeCar(carName, cars));         break;
            case 13:  System.out.println(car.getAll());                         break;
            case 14:  System.out.print("Write the car's name!");
                      String carNamme = new Scanner(System.in).next();
                      System.out.println(car.findByName(carNamme,people));      break;
            case 15: System.out.print("Write the Country of car! ");
                     String cname = new Scanner(System.in).next();
                     System.out.println(car.findByCountry(cname, people));      break;
        }
        }
    }
}
